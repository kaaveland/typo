/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgStatGssapiRepoImpl extends PgStatGssapiRepo {
  override def selectAll(implicit c: Connection): List[PgStatGssapiRow] = {
    SQL"""select pid, gss_authenticated, principal, encrypted from pg_catalog.pg_stat_gssapi""".as(PgStatGssapiRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatGssapiFieldValue[_]])(implicit c: Connection): List[PgStatGssapiRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatGssapiFieldValue.pid(value) => NamedParameter("pid", ParameterValue.from(value))
          case PgStatGssapiFieldValue.gssAuthenticated(value) => NamedParameter("gss_authenticated", ParameterValue.from(value))
          case PgStatGssapiFieldValue.principal(value) => NamedParameter("principal", ParameterValue.from(value))
          case PgStatGssapiFieldValue.encrypted(value) => NamedParameter("encrypted", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_stat_gssapi where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgStatGssapiRow.rowParser.*)
    }

  }
}
