/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_database

import adventureworks.customtypes.TypoInstant
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatDatabaseViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatDatabaseViewRow, val merge: (Row, PgStatDatabaseViewRow) => Row)
  extends Relation[PgStatDatabaseViewFields, PgStatDatabaseViewRow, Row]
    with PgStatDatabaseViewFields[Row] { outer =>

  override val datid = new OptField[/* oid */ Long, Row](prefix, "datid", None, None)(x => extract(x).datid, (row, value) => merge(row, extract(row).copy(datid = value)))
  override val datname = new OptField[String, Row](prefix, "datname", None, None)(x => extract(x).datname, (row, value) => merge(row, extract(row).copy(datname = value)))
  override val numbackends = new OptField[Int, Row](prefix, "numbackends", None, None)(x => extract(x).numbackends, (row, value) => merge(row, extract(row).copy(numbackends = value)))
  override val xactCommit = new OptField[Long, Row](prefix, "xact_commit", None, None)(x => extract(x).xactCommit, (row, value) => merge(row, extract(row).copy(xactCommit = value)))
  override val xactRollback = new OptField[Long, Row](prefix, "xact_rollback", None, None)(x => extract(x).xactRollback, (row, value) => merge(row, extract(row).copy(xactRollback = value)))
  override val blksRead = new OptField[Long, Row](prefix, "blks_read", None, None)(x => extract(x).blksRead, (row, value) => merge(row, extract(row).copy(blksRead = value)))
  override val blksHit = new OptField[Long, Row](prefix, "blks_hit", None, None)(x => extract(x).blksHit, (row, value) => merge(row, extract(row).copy(blksHit = value)))
  override val tupReturned = new OptField[Long, Row](prefix, "tup_returned", None, None)(x => extract(x).tupReturned, (row, value) => merge(row, extract(row).copy(tupReturned = value)))
  override val tupFetched = new OptField[Long, Row](prefix, "tup_fetched", None, None)(x => extract(x).tupFetched, (row, value) => merge(row, extract(row).copy(tupFetched = value)))
  override val tupInserted = new OptField[Long, Row](prefix, "tup_inserted", None, None)(x => extract(x).tupInserted, (row, value) => merge(row, extract(row).copy(tupInserted = value)))
  override val tupUpdated = new OptField[Long, Row](prefix, "tup_updated", None, None)(x => extract(x).tupUpdated, (row, value) => merge(row, extract(row).copy(tupUpdated = value)))
  override val tupDeleted = new OptField[Long, Row](prefix, "tup_deleted", None, None)(x => extract(x).tupDeleted, (row, value) => merge(row, extract(row).copy(tupDeleted = value)))
  override val conflicts = new OptField[Long, Row](prefix, "conflicts", None, None)(x => extract(x).conflicts, (row, value) => merge(row, extract(row).copy(conflicts = value)))
  override val tempFiles = new OptField[Long, Row](prefix, "temp_files", None, None)(x => extract(x).tempFiles, (row, value) => merge(row, extract(row).copy(tempFiles = value)))
  override val tempBytes = new OptField[Long, Row](prefix, "temp_bytes", None, None)(x => extract(x).tempBytes, (row, value) => merge(row, extract(row).copy(tempBytes = value)))
  override val deadlocks = new OptField[Long, Row](prefix, "deadlocks", None, None)(x => extract(x).deadlocks, (row, value) => merge(row, extract(row).copy(deadlocks = value)))
  override val checksumFailures = new OptField[Long, Row](prefix, "checksum_failures", None, None)(x => extract(x).checksumFailures, (row, value) => merge(row, extract(row).copy(checksumFailures = value)))
  override val checksumLastFailure = new OptField[TypoInstant, Row](prefix, "checksum_last_failure", Some("text"), None)(x => extract(x).checksumLastFailure, (row, value) => merge(row, extract(row).copy(checksumLastFailure = value)))
  override val blkReadTime = new OptField[Double, Row](prefix, "blk_read_time", None, None)(x => extract(x).blkReadTime, (row, value) => merge(row, extract(row).copy(blkReadTime = value)))
  override val blkWriteTime = new OptField[Double, Row](prefix, "blk_write_time", None, None)(x => extract(x).blkWriteTime, (row, value) => merge(row, extract(row).copy(blkWriteTime = value)))
  override val sessionTime = new OptField[Double, Row](prefix, "session_time", None, None)(x => extract(x).sessionTime, (row, value) => merge(row, extract(row).copy(sessionTime = value)))
  override val activeTime = new OptField[Double, Row](prefix, "active_time", None, None)(x => extract(x).activeTime, (row, value) => merge(row, extract(row).copy(activeTime = value)))
  override val idleInTransactionTime = new OptField[Double, Row](prefix, "idle_in_transaction_time", None, None)(x => extract(x).idleInTransactionTime, (row, value) => merge(row, extract(row).copy(idleInTransactionTime = value)))
  override val sessions = new OptField[Long, Row](prefix, "sessions", None, None)(x => extract(x).sessions, (row, value) => merge(row, extract(row).copy(sessions = value)))
  override val sessionsAbandoned = new OptField[Long, Row](prefix, "sessions_abandoned", None, None)(x => extract(x).sessionsAbandoned, (row, value) => merge(row, extract(row).copy(sessionsAbandoned = value)))
  override val sessionsFatal = new OptField[Long, Row](prefix, "sessions_fatal", None, None)(x => extract(x).sessionsFatal, (row, value) => merge(row, extract(row).copy(sessionsFatal = value)))
  override val sessionsKilled = new OptField[Long, Row](prefix, "sessions_killed", None, None)(x => extract(x).sessionsKilled, (row, value) => merge(row, extract(row).copy(sessionsKilled = value)))
  override val statsReset = new OptField[TypoInstant, Row](prefix, "stats_reset", Some("text"), None)(x => extract(x).statsReset, (row, value) => merge(row, extract(row).copy(statsReset = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](datid, datname, numbackends, xactCommit, xactRollback, blksRead, blksHit, tupReturned, tupFetched, tupInserted, tupUpdated, tupDeleted, conflicts, tempFiles, tempBytes, deadlocks, checksumFailures, checksumLastFailure, blkReadTime, blkWriteTime, sessionTime, activeTime, idleInTransactionTime, sessions, sessionsAbandoned, sessionsFatal, sessionsKilled, statsReset)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatDatabaseViewRow, merge: (NewRow, PgStatDatabaseViewRow) => NewRow): PgStatDatabaseViewStructure[NewRow] =
    new PgStatDatabaseViewStructure(prefix, extract, merge)
}
