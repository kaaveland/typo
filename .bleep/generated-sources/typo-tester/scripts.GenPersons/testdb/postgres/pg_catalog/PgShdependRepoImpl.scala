package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgShdependRepoImpl extends PgShdependRepo {
  override def selectAll(implicit c: Connection): List[PgShdependRow] = {
    SQL"""select dbid, classid, objid, objsubid, refclassid, refobjid, deptype from pg_catalog.pg_shdepend""".as(PgShdependRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgShdependFieldValue[_]])(implicit c: Connection): List[PgShdependRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgShdependFieldValue.dbid(value) => NamedParameter("dbid", ParameterValue.from(value))
          case PgShdependFieldValue.classid(value) => NamedParameter("classid", ParameterValue.from(value))
          case PgShdependFieldValue.objid(value) => NamedParameter("objid", ParameterValue.from(value))
          case PgShdependFieldValue.objsubid(value) => NamedParameter("objsubid", ParameterValue.from(value))
          case PgShdependFieldValue.refclassid(value) => NamedParameter("refclassid", ParameterValue.from(value))
          case PgShdependFieldValue.refobjid(value) => NamedParameter("refobjid", ParameterValue.from(value))
          case PgShdependFieldValue.deptype(value) => NamedParameter("deptype", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_shdepend where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgShdependRow.rowParser.*)
    }

  }
}
