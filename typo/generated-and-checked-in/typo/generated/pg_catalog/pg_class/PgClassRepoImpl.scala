/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_class

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgClassRepoImpl extends PgClassRepo {
  override def selectAll(implicit c: Connection): List[PgClassRow] = {
    SQL"""select oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound from pg_catalog.pg_class""".as(PgClassRow.rowParser("").*)
  }
  override def selectById(oid: PgClassId)(implicit c: Connection): Option[PgClassRow] = {
    SQL"""select oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound from pg_catalog.pg_class where oid = $oid""".as(PgClassRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgClassId])(implicit c: Connection): List[PgClassRow] = {
    SQL"""select oid, relname, relnamespace, reltype, reloftype, relowner, relam, relfilenode, reltablespace, relpages, reltuples, relallvisible, reltoastrelid, relhasindex, relisshared, relpersistence, relkind, relnatts, relchecks, relhasrules, relhastriggers, relhassubclass, relrowsecurity, relforcerowsecurity, relispopulated, relreplident, relispartition, relrewrite, relfrozenxid, relminmxid, relacl, reloptions, relpartbound from pg_catalog.pg_class where oid in $oids""".as(PgClassRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgClassFieldOrIdValue[_]])(implicit c: Connection): List[PgClassRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgClassFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgClassFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgClassFieldValue.relnamespace(value) => NamedParameter("relnamespace", ParameterValue.from(value))
          case PgClassFieldValue.reltype(value) => NamedParameter("reltype", ParameterValue.from(value))
          case PgClassFieldValue.reloftype(value) => NamedParameter("reloftype", ParameterValue.from(value))
          case PgClassFieldValue.relowner(value) => NamedParameter("relowner", ParameterValue.from(value))
          case PgClassFieldValue.relam(value) => NamedParameter("relam", ParameterValue.from(value))
          case PgClassFieldValue.relfilenode(value) => NamedParameter("relfilenode", ParameterValue.from(value))
          case PgClassFieldValue.reltablespace(value) => NamedParameter("reltablespace", ParameterValue.from(value))
          case PgClassFieldValue.relpages(value) => NamedParameter("relpages", ParameterValue.from(value))
          case PgClassFieldValue.reltuples(value) => NamedParameter("reltuples", ParameterValue.from(value))
          case PgClassFieldValue.relallvisible(value) => NamedParameter("relallvisible", ParameterValue.from(value))
          case PgClassFieldValue.reltoastrelid(value) => NamedParameter("reltoastrelid", ParameterValue.from(value))
          case PgClassFieldValue.relhasindex(value) => NamedParameter("relhasindex", ParameterValue.from(value))
          case PgClassFieldValue.relisshared(value) => NamedParameter("relisshared", ParameterValue.from(value))
          case PgClassFieldValue.relpersistence(value) => NamedParameter("relpersistence", ParameterValue.from(value))
          case PgClassFieldValue.relkind(value) => NamedParameter("relkind", ParameterValue.from(value))
          case PgClassFieldValue.relnatts(value) => NamedParameter("relnatts", ParameterValue.from(value))
          case PgClassFieldValue.relchecks(value) => NamedParameter("relchecks", ParameterValue.from(value))
          case PgClassFieldValue.relhasrules(value) => NamedParameter("relhasrules", ParameterValue.from(value))
          case PgClassFieldValue.relhastriggers(value) => NamedParameter("relhastriggers", ParameterValue.from(value))
          case PgClassFieldValue.relhassubclass(value) => NamedParameter("relhassubclass", ParameterValue.from(value))
          case PgClassFieldValue.relrowsecurity(value) => NamedParameter("relrowsecurity", ParameterValue.from(value))
          case PgClassFieldValue.relforcerowsecurity(value) => NamedParameter("relforcerowsecurity", ParameterValue.from(value))
          case PgClassFieldValue.relispopulated(value) => NamedParameter("relispopulated", ParameterValue.from(value))
          case PgClassFieldValue.relreplident(value) => NamedParameter("relreplident", ParameterValue.from(value))
          case PgClassFieldValue.relispartition(value) => NamedParameter("relispartition", ParameterValue.from(value))
          case PgClassFieldValue.relrewrite(value) => NamedParameter("relrewrite", ParameterValue.from(value))
          case PgClassFieldValue.relfrozenxid(value) => NamedParameter("relfrozenxid", ParameterValue.from(value))
          case PgClassFieldValue.relminmxid(value) => NamedParameter("relminmxid", ParameterValue.from(value))
          case PgClassFieldValue.relacl(value) => NamedParameter("relacl", ParameterValue.from(value))
          case PgClassFieldValue.reloptions(value) => NamedParameter("reloptions", ParameterValue.from(value))
          case PgClassFieldValue.relpartbound(value) => NamedParameter("relpartbound", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_class where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PgClassRow.rowParser("").*)
    }
  
  }
  override def updateFieldValues(oid: PgClassId, fieldValues: List[PgClassFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgClassFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgClassFieldValue.relnamespace(value) => NamedParameter("relnamespace", ParameterValue.from(value))
          case PgClassFieldValue.reltype(value) => NamedParameter("reltype", ParameterValue.from(value))
          case PgClassFieldValue.reloftype(value) => NamedParameter("reloftype", ParameterValue.from(value))
          case PgClassFieldValue.relowner(value) => NamedParameter("relowner", ParameterValue.from(value))
          case PgClassFieldValue.relam(value) => NamedParameter("relam", ParameterValue.from(value))
          case PgClassFieldValue.relfilenode(value) => NamedParameter("relfilenode", ParameterValue.from(value))
          case PgClassFieldValue.reltablespace(value) => NamedParameter("reltablespace", ParameterValue.from(value))
          case PgClassFieldValue.relpages(value) => NamedParameter("relpages", ParameterValue.from(value))
          case PgClassFieldValue.reltuples(value) => NamedParameter("reltuples", ParameterValue.from(value))
          case PgClassFieldValue.relallvisible(value) => NamedParameter("relallvisible", ParameterValue.from(value))
          case PgClassFieldValue.reltoastrelid(value) => NamedParameter("reltoastrelid", ParameterValue.from(value))
          case PgClassFieldValue.relhasindex(value) => NamedParameter("relhasindex", ParameterValue.from(value))
          case PgClassFieldValue.relisshared(value) => NamedParameter("relisshared", ParameterValue.from(value))
          case PgClassFieldValue.relpersistence(value) => NamedParameter("relpersistence", ParameterValue.from(value))
          case PgClassFieldValue.relkind(value) => NamedParameter("relkind", ParameterValue.from(value))
          case PgClassFieldValue.relnatts(value) => NamedParameter("relnatts", ParameterValue.from(value))
          case PgClassFieldValue.relchecks(value) => NamedParameter("relchecks", ParameterValue.from(value))
          case PgClassFieldValue.relhasrules(value) => NamedParameter("relhasrules", ParameterValue.from(value))
          case PgClassFieldValue.relhastriggers(value) => NamedParameter("relhastriggers", ParameterValue.from(value))
          case PgClassFieldValue.relhassubclass(value) => NamedParameter("relhassubclass", ParameterValue.from(value))
          case PgClassFieldValue.relrowsecurity(value) => NamedParameter("relrowsecurity", ParameterValue.from(value))
          case PgClassFieldValue.relforcerowsecurity(value) => NamedParameter("relforcerowsecurity", ParameterValue.from(value))
          case PgClassFieldValue.relispopulated(value) => NamedParameter("relispopulated", ParameterValue.from(value))
          case PgClassFieldValue.relreplident(value) => NamedParameter("relreplident", ParameterValue.from(value))
          case PgClassFieldValue.relispartition(value) => NamedParameter("relispartition", ParameterValue.from(value))
          case PgClassFieldValue.relrewrite(value) => NamedParameter("relrewrite", ParameterValue.from(value))
          case PgClassFieldValue.relfrozenxid(value) => NamedParameter("relfrozenxid", ParameterValue.from(value))
          case PgClassFieldValue.relminmxid(value) => NamedParameter("relminmxid", ParameterValue.from(value))
          case PgClassFieldValue.relacl(value) => NamedParameter("relacl", ParameterValue.from(value))
          case PgClassFieldValue.reloptions(value) => NamedParameter("reloptions", ParameterValue.from(value))
          case PgClassFieldValue.relpartbound(value) => NamedParameter("relpartbound", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_class
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where oid = $oid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  override def update(oid: PgClassId, row: PgClassRow)(implicit c: Connection): Boolean = {
    SQL"""update pg_catalog.pg_class
          set relname = ${row.relname},
              relnamespace = ${row.relnamespace},
              reltype = ${row.reltype},
              reloftype = ${row.reloftype},
              relowner = ${row.relowner},
              relam = ${row.relam},
              relfilenode = ${row.relfilenode},
              reltablespace = ${row.reltablespace},
              relpages = ${row.relpages},
              reltuples = ${row.reltuples},
              relallvisible = ${row.relallvisible},
              reltoastrelid = ${row.reltoastrelid},
              relhasindex = ${row.relhasindex},
              relisshared = ${row.relisshared},
              relpersistence = ${row.relpersistence},
              relkind = ${row.relkind},
              relnatts = ${row.relnatts},
              relchecks = ${row.relchecks},
              relhasrules = ${row.relhasrules},
              relhastriggers = ${row.relhastriggers},
              relhassubclass = ${row.relhassubclass},
              relrowsecurity = ${row.relrowsecurity},
              relforcerowsecurity = ${row.relforcerowsecurity},
              relispopulated = ${row.relispopulated},
              relreplident = ${row.relreplident},
              relispartition = ${row.relispartition},
              relrewrite = ${row.relrewrite},
              relfrozenxid = ${row.relfrozenxid},
              relminmxid = ${row.relminmxid},
              relacl = ${row.relacl},
              reloptions = ${row.reloptions},
              relpartbound = ${row.relpartbound}
          where oid = $oid""".executeUpdate() > 0
  }
  override def insert(oid: PgClassId, unsaved: PgClassRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("relname", ParameterValue.from(unsaved.relname))),
      Some(NamedParameter("relnamespace", ParameterValue.from(unsaved.relnamespace))),
      Some(NamedParameter("reltype", ParameterValue.from(unsaved.reltype))),
      Some(NamedParameter("reloftype", ParameterValue.from(unsaved.reloftype))),
      Some(NamedParameter("relowner", ParameterValue.from(unsaved.relowner))),
      Some(NamedParameter("relam", ParameterValue.from(unsaved.relam))),
      Some(NamedParameter("relfilenode", ParameterValue.from(unsaved.relfilenode))),
      Some(NamedParameter("reltablespace", ParameterValue.from(unsaved.reltablespace))),
      Some(NamedParameter("relpages", ParameterValue.from(unsaved.relpages))),
      Some(NamedParameter("reltuples", ParameterValue.from(unsaved.reltuples))),
      Some(NamedParameter("relallvisible", ParameterValue.from(unsaved.relallvisible))),
      Some(NamedParameter("reltoastrelid", ParameterValue.from(unsaved.reltoastrelid))),
      Some(NamedParameter("relhasindex", ParameterValue.from(unsaved.relhasindex))),
      Some(NamedParameter("relisshared", ParameterValue.from(unsaved.relisshared))),
      Some(NamedParameter("relpersistence", ParameterValue.from(unsaved.relpersistence))),
      Some(NamedParameter("relkind", ParameterValue.from(unsaved.relkind))),
      Some(NamedParameter("relnatts", ParameterValue.from(unsaved.relnatts))),
      Some(NamedParameter("relchecks", ParameterValue.from(unsaved.relchecks))),
      Some(NamedParameter("relhasrules", ParameterValue.from(unsaved.relhasrules))),
      Some(NamedParameter("relhastriggers", ParameterValue.from(unsaved.relhastriggers))),
      Some(NamedParameter("relhassubclass", ParameterValue.from(unsaved.relhassubclass))),
      Some(NamedParameter("relrowsecurity", ParameterValue.from(unsaved.relrowsecurity))),
      Some(NamedParameter("relforcerowsecurity", ParameterValue.from(unsaved.relforcerowsecurity))),
      Some(NamedParameter("relispopulated", ParameterValue.from(unsaved.relispopulated))),
      Some(NamedParameter("relreplident", ParameterValue.from(unsaved.relreplident))),
      Some(NamedParameter("relispartition", ParameterValue.from(unsaved.relispartition))),
      Some(NamedParameter("relrewrite", ParameterValue.from(unsaved.relrewrite))),
      Some(NamedParameter("relfrozenxid", ParameterValue.from(unsaved.relfrozenxid))),
      Some(NamedParameter("relminmxid", ParameterValue.from(unsaved.relminmxid))),
      Some(NamedParameter("relacl", ParameterValue.from(unsaved.relacl))),
      Some(NamedParameter("reloptions", ParameterValue.from(unsaved.reloptions))),
      Some(NamedParameter("relpartbound", ParameterValue.from(unsaved.relpartbound)))
    ).flatten
    
    SQL"""insert into pg_catalog.pg_class(oid, ${namedParameters.map(_.name).mkString(", ")})
          values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def delete(oid: PgClassId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_class where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUniqueRelnameRelnamespace(relname: String, relnamespace: /* oid */ Long)(implicit c: Connection): Option[PgClassRow] = {
    selectByFieldValues(List(PgClassFieldValue.relname(relname), PgClassFieldValue.relnamespace(relnamespace))).headOption
  }
}
