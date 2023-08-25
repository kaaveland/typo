/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats_ext_exprs

import adventureworks.TypoAnyArray
import typo.dsl.SqlExpr.OptField

trait PgStatsExtExprsViewFields[Row] {
  val schemaname: OptField[String, Row]
  val tablename: OptField[String, Row]
  val statisticsSchemaname: OptField[String, Row]
  val statisticsName: OptField[String, Row]
  val statisticsOwner: OptField[String, Row]
  val expr: OptField[String, Row]
  val nullFrac: OptField[Float, Row]
  val avgWidth: OptField[Int, Row]
  val nDistinct: OptField[Float, Row]
  val mostCommonVals: OptField[TypoAnyArray, Row]
  val mostCommonFreqs: OptField[Array[Float], Row]
  val histogramBounds: OptField[TypoAnyArray, Row]
  val correlation: OptField[Float, Row]
  val mostCommonElems: OptField[TypoAnyArray, Row]
  val mostCommonElemFreqs: OptField[Array[Float], Row]
  val elemCountHistogram: OptField[Array[Float], Row]
}
object PgStatsExtExprsViewFields extends PgStatsExtExprsViewStructure[PgStatsExtExprsViewRow](None, identity, (_, x) => x)
