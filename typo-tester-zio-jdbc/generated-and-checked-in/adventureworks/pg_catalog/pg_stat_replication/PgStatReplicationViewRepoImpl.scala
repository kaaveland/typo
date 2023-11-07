/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_replication

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgStatReplicationViewRepoImpl extends PgStatReplicationViewRepo {
  override def select: SelectBuilder[PgStatReplicationViewFields, PgStatReplicationViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_replication", PgStatReplicationViewFields, PgStatReplicationViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgStatReplicationViewRow] = {
    sql"""select "pid", "usesysid", "usename", "application_name", "client_addr", "client_hostname", "client_port", "backend_start"::text, "backend_xmin", "state", "sent_lsn", "write_lsn", "flush_lsn", "replay_lsn", "write_lag", "flush_lag", "replay_lag", "sync_priority", "sync_state", "reply_time"::text from pg_catalog.pg_stat_replication""".query(PgStatReplicationViewRow.jdbcDecoder).selectStream
  }
}
