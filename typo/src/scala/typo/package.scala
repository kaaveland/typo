import typo.internal.*
import typo.internal.codegen.*
import typo.internal.metadb.MetaDb
import typo.internal.sqlfiles.SqlFile

import java.nio.file.Path
import java.sql.Connection
import scala.collection.immutable.SortedMap

package object typo {
  def fromDbAndScripts(options: Options, scriptsPath: Path, selector: Selector)(implicit c: Connection): Generated = {
    val metadb = MetaDb(MetaDb.Input.fromDb)
    val sqlScripts = sqlfiles.Load(scriptsPath, metadb.typeMapperDb)
    fromData(options, metadb.relations, metadb.enums, metadb.domains, sqlScripts, selector)
  }

  def fromDb(options: Options, selector: Selector)(implicit c: Connection): Generated = {
    val metadb = MetaDb(MetaDb.Input.fromDb)
    fromData(options, metadb.relations, metadb.enums, metadb.domains, sqlScripts = Nil, selector)
  }

  def fromData(
      publicOptions: Options,
      relations: List[db.Relation],
      enums: List[db.StringEnum],
      domains: List[db.Domain],
      sqlScripts: List[SqlFile],
      selector: Selector
  ): Generated = {
    val options = InternalOptions(
      pkg = sc.Type.Qualified(publicOptions.pkg).value,
      jsonLib = publicOptions.jsonLib match {
        case JsonLibName.PlayJson => JsonLibPlay
        case JsonLibName.None     => JsonLib.None
      },
      dbLib = publicOptions.dbLib match {
        case DbLibName.Anorm => DbLibAnorm
      },
      naming = publicOptions.naming,
      typeOverride = publicOptions.typeOverride,
      header = publicOptions.header,
      debugTypes = publicOptions.debugTypes
    )
    val naming = options.naming(options.pkg)
    val scalaTypeMapper = TypeMapperScala(options.typeOverride, publicOptions.nullabilityOverride, naming)

    val default: DefaultComputed =
      DefaultComputed(naming)

    val computeds: SortedMap[db.RelationName, Lazy[Either[ViewComputed, TableComputed]]] =
      rewriteDependentData(relations.map(rel => rel.name -> rel).toMap).apply[Either[ViewComputed, TableComputed]] {
        case (_, dbTable: db.Table, eval) =>
          Right(TableComputed(options, default, dbTable, naming, scalaTypeMapper, eval))
        case (_, dbView: db.View, eval) =>
          Left(ViewComputed(dbView, naming, scalaTypeMapper, eval))
      }

    // note, these statements will force the evaluation of some of the lazy values
    val computedScripts = sqlScripts.map(sqlScript => SqlFileComputed(sqlScript, options.pkg, options.naming, scalaTypeMapper, computeds.apply))
    computeds.foreach { case (relName, lazyValue) =>
      if (selector.include(relName)) lazyValue.forceGet
    }
    // here we keep only the values which have been evaluated. as such, the selector pattern should be safe
    val computedRelations = computeds.flatMap { case (_, lazyValue) => lazyValue.getIfEvaluated }

    val mostFiles: List[sc.File] =
      List(
        List(DefaultFile(default, options.jsonLib).file),
        enums.map(StringEnumFile(naming, options)),
        domains.map(DomainFile(naming, options, scalaTypeMapper)),
        computedRelations.flatMap {
          case Left(viewComputed)   => ViewFiles(viewComputed, options).all
          case Right(tableComputed) => TableFiles(tableComputed, options).all
        },
        computedScripts.flatMap(x => SqlFileFiles(x, naming, options).all)
      ).flatten

    val knownNamesByPkg: Map[sc.QIdent, Map[sc.Ident, sc.Type.Qualified]] =
      mostFiles.groupBy(_.pkg).map { case (pkg, files) =>
        (pkg, files.flatMap(f => (f.name, f.tpe) :: f.secondaryTypes.map(tpe => (tpe.value.name, tpe))).toMap)
      }

    // package objects have weird scoping, so don't attempt to automatically write imports for them.
    // this should be a stop-gap solution anyway
    val pkgObject = List(PackageObjectFile.packageObject(options))

    val allFiles = mostFiles.map(file => addPackageAndImports(knownNamesByPkg, file)) ++ pkgObject
    Generated(allFiles.map(file => file.copy(contents = options.header.code ++ file.contents)))
  }

}
