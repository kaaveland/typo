/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_tables

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgStatioAllTablesViewRepoImpl extends PgStatioAllTablesViewRepo {
  override def select: SelectBuilder[PgStatioAllTablesViewFields, PgStatioAllTablesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_statio_all_tables", PgStatioAllTablesViewFields, PgStatioAllTablesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgStatioAllTablesViewRow] = {
    sql"""select "relid", "schemaname", "relname", "heap_blks_read", "heap_blks_hit", "idx_blks_read", "idx_blks_hit", "toast_blks_read", "toast_blks_hit", "tidx_blks_read", "tidx_blks_hit" from pg_catalog.pg_statio_all_tables""".query(PgStatioAllTablesViewRow.jdbcDecoder).selectStream
  }
}
