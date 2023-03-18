package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgPreparedXactsRepoImpl extends PgPreparedXactsRepo {
  override def selectAll(implicit c: Connection): List[PgPreparedXactsRow] = {
    SQL"""select transaction, gid, prepared, owner, database from pg_catalog.pg_prepared_xacts""".as(PgPreparedXactsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgPreparedXactsFieldValue[_]])(implicit c: Connection): List[PgPreparedXactsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPreparedXactsFieldValue.transaction(value) => NamedParameter("transaction", ParameterValue.from(value))
          case PgPreparedXactsFieldValue.gid(value) => NamedParameter("gid", ParameterValue.from(value))
          case PgPreparedXactsFieldValue.prepared(value) => NamedParameter("prepared", ParameterValue.from(value))
          case PgPreparedXactsFieldValue.owner(value) => NamedParameter("owner", ParameterValue.from(value))
          case PgPreparedXactsFieldValue.database(value) => NamedParameter("database", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_prepared_xacts where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgPreparedXactsRow.rowParser.*)
    }

  }
}