/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_bgwriter

import adventureworks.customtypes.TypoInstant
import typo.dsl.SqlExpr.OptField

trait PgStatBgwriterViewFields[Row] {
  val checkpointsTimed: OptField[Long, Row]
  val checkpointsReq: OptField[Long, Row]
  val checkpointWriteTime: OptField[Double, Row]
  val checkpointSyncTime: OptField[Double, Row]
  val buffersCheckpoint: OptField[Long, Row]
  val buffersClean: OptField[Long, Row]
  val maxwrittenClean: OptField[Long, Row]
  val buffersBackend: OptField[Long, Row]
  val buffersBackendFsync: OptField[Long, Row]
  val buffersAlloc: OptField[Long, Row]
  val statsReset: OptField[TypoInstant, Row]
}
object PgStatBgwriterViewFields extends PgStatBgwriterViewStructure[PgStatBgwriterViewRow](None, identity, (_, x) => x)

