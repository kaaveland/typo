package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgDependRepoImpl extends PgDependRepo {
  override def selectAll(implicit c: Connection): List[PgDependRow] = {
    SQL"""select classid, objid, objsubid, refclassid, refobjid, refobjsubid, deptype from pg_catalog.pg_depend""".as(PgDependRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgDependFieldValue[_]])(implicit c: Connection): List[PgDependRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgDependFieldValue.classid(value) => NamedParameter("classid", ParameterValue.from(value))
          case PgDependFieldValue.objid(value) => NamedParameter("objid", ParameterValue.from(value))
          case PgDependFieldValue.objsubid(value) => NamedParameter("objsubid", ParameterValue.from(value))
          case PgDependFieldValue.refclassid(value) => NamedParameter("refclassid", ParameterValue.from(value))
          case PgDependFieldValue.refobjid(value) => NamedParameter("refobjid", ParameterValue.from(value))
          case PgDependFieldValue.refobjsubid(value) => NamedParameter("refobjsubid", ParameterValue.from(value))
          case PgDependFieldValue.deptype(value) => NamedParameter("deptype", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_depend where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgDependRow.rowParser.*)
    }

  }
}
