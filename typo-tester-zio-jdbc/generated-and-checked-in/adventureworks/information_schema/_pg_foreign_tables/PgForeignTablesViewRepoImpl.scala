/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_tables`

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgForeignTablesViewRepoImpl extends PgForeignTablesViewRepo {
  override def select: SelectBuilder[PgForeignTablesViewFields, PgForeignTablesViewRow] = {
    SelectBuilderSql("information_schema._pg_foreign_tables", PgForeignTablesViewFields, PgForeignTablesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgForeignTablesViewRow] = {
    sql"""select "foreign_table_catalog", "foreign_table_schema", "foreign_table_name", "ftoptions", "foreign_server_catalog", "foreign_server_name", "authorization_identifier" from information_schema._pg_foreign_tables""".query(PgForeignTablesViewRow.jdbcDecoder).selectStream
  }
}
