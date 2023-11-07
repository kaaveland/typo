/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_database

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgStatDatabaseViewRepoImpl extends PgStatDatabaseViewRepo {
  override def select: SelectBuilder[PgStatDatabaseViewFields, PgStatDatabaseViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_database", PgStatDatabaseViewFields, PgStatDatabaseViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgStatDatabaseViewRow] = {
    sql"""select "datid", "datname", "numbackends", "xact_commit", "xact_rollback", "blks_read", "blks_hit", "tup_returned", "tup_fetched", "tup_inserted", "tup_updated", "tup_deleted", "conflicts", "temp_files", "temp_bytes", "deadlocks", "checksum_failures", "checksum_last_failure"::text, "blk_read_time", "blk_write_time", "session_time", "active_time", "idle_in_transaction_time", "sessions", "sessions_abandoned", "sessions_fatal", "sessions_killed", "stats_reset"::text from pg_catalog.pg_stat_database""".query(PgStatDatabaseViewRow.jdbcDecoder).selectStream
  }
}
