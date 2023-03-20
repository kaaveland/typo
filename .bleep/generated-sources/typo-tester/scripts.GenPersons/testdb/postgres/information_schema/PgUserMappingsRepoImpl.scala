/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgUserMappingsRepoImpl extends PgUserMappingsRepo {
  override def selectAll(implicit c: Connection): List[PgUserMappingsRow] = {
    SQL"""select oid, umoptions, umuser, authorization_identifier, foreign_server_catalog, foreign_server_name, srvowner from information_schema._pg_user_mappings""".as(PgUserMappingsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgUserMappingsFieldValue[_]])(implicit c: Connection): List[PgUserMappingsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgUserMappingsFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgUserMappingsFieldValue.umoptions(value) => NamedParameter("umoptions", ParameterValue.from(value))
          case PgUserMappingsFieldValue.umuser(value) => NamedParameter("umuser", ParameterValue.from(value))
          case PgUserMappingsFieldValue.authorizationIdentifier(value) => NamedParameter("authorization_identifier", ParameterValue.from(value))
          case PgUserMappingsFieldValue.foreignServerCatalog(value) => NamedParameter("foreign_server_catalog", ParameterValue.from(value))
          case PgUserMappingsFieldValue.foreignServerName(value) => NamedParameter("foreign_server_name", ParameterValue.from(value))
          case PgUserMappingsFieldValue.srvowner(value) => NamedParameter("srvowner", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema._pg_user_mappings where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgUserMappingsRow.rowParser.*)
    }

  }
}
