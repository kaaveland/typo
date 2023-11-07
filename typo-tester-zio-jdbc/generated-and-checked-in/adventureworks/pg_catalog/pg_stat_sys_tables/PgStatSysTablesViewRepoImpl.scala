/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_sys_tables

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgStatSysTablesViewRepoImpl extends PgStatSysTablesViewRepo {
  override def select: SelectBuilder[PgStatSysTablesViewFields, PgStatSysTablesViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_sys_tables", PgStatSysTablesViewFields, PgStatSysTablesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgStatSysTablesViewRow] = {
    sql"""select "relid", "schemaname", "relname", "seq_scan", "seq_tup_read", "idx_scan", "idx_tup_fetch", "n_tup_ins", "n_tup_upd", "n_tup_del", "n_tup_hot_upd", "n_live_tup", "n_dead_tup", "n_mod_since_analyze", "n_ins_since_vacuum", "last_vacuum"::text, "last_autovacuum"::text, "last_analyze"::text, "last_autoanalyze"::text, "vacuum_count", "autovacuum_count", "analyze_count", "autoanalyze_count" from pg_catalog.pg_stat_sys_tables""".query(PgStatSysTablesViewRow.jdbcDecoder).selectStream
  }
}
