package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatUserFunctionsRepoImpl extends PgStatUserFunctionsRepo {
  override def selectAll(implicit c: Connection): List[PgStatUserFunctionsRow] = {
    SQL"""select funcid, schemaname, funcname, calls, total_time, self_time from pg_catalog.pg_stat_user_functions""".as(PgStatUserFunctionsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatUserFunctionsFieldValue[_]])(implicit c: Connection): List[PgStatUserFunctionsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatUserFunctionsFieldValue.funcid(value) => NamedParameter("funcid", ParameterValue.from(value))
          case PgStatUserFunctionsFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatUserFunctionsFieldValue.funcname(value) => NamedParameter("funcname", ParameterValue.from(value))
          case PgStatUserFunctionsFieldValue.calls(value) => NamedParameter("calls", ParameterValue.from(value))
          case PgStatUserFunctionsFieldValue.totalTime(value) => NamedParameter("total_time", ParameterValue.from(value))
          case PgStatUserFunctionsFieldValue.selfTime(value) => NamedParameter("self_time", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_user_functions where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatUserFunctionsRow.rowParser.*)
    }

  }
}