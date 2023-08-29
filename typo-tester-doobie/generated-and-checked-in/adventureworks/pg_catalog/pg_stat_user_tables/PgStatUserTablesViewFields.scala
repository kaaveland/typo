/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_tables

import adventureworks.customtypes.TypoOffsetDateTime
import adventureworks.pg_catalog.pg_class.PgClassId
import typo.dsl.SqlExpr.OptField

trait PgStatUserTablesViewFields[Row] {
  val relid: OptField[PgClassId, Row]
  val schemaname: OptField[String, Row]
  val relname: OptField[String, Row]
  val seqScan: OptField[/* nullability unknown */ Long, Row]
  val seqTupRead: OptField[/* nullability unknown */ Long, Row]
  val idxScan: OptField[/* nullability unknown */ Long, Row]
  val idxTupFetch: OptField[/* nullability unknown */ Long, Row]
  val nTupIns: OptField[/* nullability unknown */ Long, Row]
  val nTupUpd: OptField[/* nullability unknown */ Long, Row]
  val nTupDel: OptField[/* nullability unknown */ Long, Row]
  val nTupHotUpd: OptField[/* nullability unknown */ Long, Row]
  val nLiveTup: OptField[/* nullability unknown */ Long, Row]
  val nDeadTup: OptField[/* nullability unknown */ Long, Row]
  val nModSinceAnalyze: OptField[/* nullability unknown */ Long, Row]
  val nInsSinceVacuum: OptField[/* nullability unknown */ Long, Row]
  val lastVacuum: OptField[/* nullability unknown */ TypoOffsetDateTime, Row]
  val lastAutovacuum: OptField[/* nullability unknown */ TypoOffsetDateTime, Row]
  val lastAnalyze: OptField[/* nullability unknown */ TypoOffsetDateTime, Row]
  val lastAutoanalyze: OptField[/* nullability unknown */ TypoOffsetDateTime, Row]
  val vacuumCount: OptField[/* nullability unknown */ Long, Row]
  val autovacuumCount: OptField[/* nullability unknown */ Long, Row]
  val analyzeCount: OptField[/* nullability unknown */ Long, Row]
  val autoanalyzeCount: OptField[/* nullability unknown */ Long, Row]
}
object PgStatUserTablesViewFields extends PgStatUserTablesViewStructure[PgStatUserTablesViewRow](None, identity, (_, x) => x)

