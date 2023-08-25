/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_analyze

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait PgStatProgressAnalyzeViewFields[Row] {
  val pid: Field[Int, Row]
  val datid: Field[/* oid */ Long, Row]
  val datname: OptField[String, Row]
  val relid: Field[/* oid */ Long, Row]
  val phase: Field[String, Row]
  val sampleBlksTotal: Field[Long, Row]
  val sampleBlksScanned: Field[Long, Row]
  val extStatsTotal: Field[Long, Row]
  val extStatsComputed: Field[Long, Row]
  val childTablesTotal: Field[Long, Row]
  val childTablesDone: Field[Long, Row]
  val currentChildTableRelid: Field[/* oid */ Long, Row]
}
object PgStatProgressAnalyzeViewFields extends PgStatProgressAnalyzeViewStructure[PgStatProgressAnalyzeViewRow](None, identity, (_, x) => x)

