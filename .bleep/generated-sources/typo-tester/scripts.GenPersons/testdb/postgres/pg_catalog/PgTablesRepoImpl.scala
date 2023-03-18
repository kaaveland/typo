package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgTablesRepoImpl extends PgTablesRepo {
  override def selectAll(implicit c: Connection): List[PgTablesRow] = {
    SQL"""select schemaname, tablename, tableowner, tablespace, hasindexes, hasrules, hastriggers, rowsecurity from pg_catalog.pg_tables""".as(PgTablesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgTablesFieldValue[_]])(implicit c: Connection): List[PgTablesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgTablesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgTablesFieldValue.tablename(value) => NamedParameter("tablename", ParameterValue.from(value))
          case PgTablesFieldValue.tableowner(value) => NamedParameter("tableowner", ParameterValue.from(value))
          case PgTablesFieldValue.tablespace(value) => NamedParameter("tablespace", ParameterValue.from(value))
          case PgTablesFieldValue.hasindexes(value) => NamedParameter("hasindexes", ParameterValue.from(value))
          case PgTablesFieldValue.hasrules(value) => NamedParameter("hasrules", ParameterValue.from(value))
          case PgTablesFieldValue.hastriggers(value) => NamedParameter("hastriggers", ParameterValue.from(value))
          case PgTablesFieldValue.rowsecurity(value) => NamedParameter("rowsecurity", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_tables where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgTablesRow.rowParser.*)
    }

  }
}