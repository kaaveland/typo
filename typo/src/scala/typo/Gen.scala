package typo

import typo.sc.syntax._

object Gen {

  def stringEnumClass(pkg: sc.QIdent, `enum`: db.StringEnum, dbLib: DbLib, jsonLib: JsonLib): sc.File = {
    val qident = names.EnumName(pkg, `enum`.name)
    val EnumType = sc.Type.Qualified(qident)

    val members = `enum`.values.map { value =>
      val name = names.enumValue(value)
      name -> code"case object $name extends ${qident.name}(${sc.StrLit(value)})"
    }
    val ByName = sc.Ident("ByName")
    val str =
      code"""sealed abstract class ${qident.name}(val value: ${sc.Type.String})
            |object ${qident.name} {
            |  ${members.map { case (_, definition) => definition }.mkCode("\n  ")}
            |
            |  val All: ${sc.Type.List(EnumType)} = ${sc.Type.ListName}(${members.map { case (ident, _) => ident.code }.mkCode(", ")})
            |  val Names: ${sc.Type.String} = All.map(_.value).mkString(", ")
            |  val ByName: ${sc.Type.Map(sc.Type.String, EnumType)} = All.map(x => (x.value, x)).toMap
            |
            |  ${dbLib.stringEnumInstances(EnumType, sc.Type.String, lookup = ByName).mkCode("\n  ")}
            |  ${jsonLib.stringEnumInstances(EnumType, sc.Type.String, lookup = ByName).mkCode("\n  ")}
            |}
            |""".stripMargin

    sc.File(EnumType, str)
  }

  def allTables(pkg: sc.QIdent, tables: List[db.Table], enums: List[db.StringEnum], jsonLib: JsonLib, dbLib: DbLib): List[sc.File] = {
    val default = DefaultComputed(pkg)
    val enumFiles: List[sc.File] =
      enums.map(stringEnumClass(pkg, _, dbLib, jsonLib))
    val tableFiles: List[sc.File] =
      tables.flatMap(table => TableFiles(TableComputed(pkg, default, table), dbLib, jsonLib).all)
    val allFiles: List[sc.File] =
      List(DefaultFile(default, jsonLib).file) ++ enumFiles ++ tableFiles

    val knownNamesByPkg: Map[sc.QIdent, Map[sc.Ident, sc.QIdent]] =
      allFiles.groupBy { _.pkg }.map { case (pkg, files) =>
        (pkg, files.map { f => (f.name, f.tpe.value) }.toMap)
      }

    allFiles.map(file => addPackageAndImports(knownNamesByPkg, file))
  }
}
