/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats_ext_exprs

import adventureworks.customtypes.TypoAnyArray
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait PgStatsExtExprsViewFields[Row] {
  val schemaname: OptField[String, Row]
  val tablename: Field[String, Row]
  val statisticsSchemaname: OptField[String, Row]
  val statisticsName: Field[String, Row]
  val statisticsOwner: Field[String, Row]
  val expr: Field[String, Row]
  val nullFrac: Field[Float, Row]
  val avgWidth: Field[Int, Row]
  val nDistinct: Field[Float, Row]
  val mostCommonVals: Field[TypoAnyArray, Row]
  val mostCommonFreqs: Field[Array[Float], Row]
  val histogramBounds: Field[TypoAnyArray, Row]
  val correlation: Field[Float, Row]
  val mostCommonElems: Field[TypoAnyArray, Row]
  val mostCommonElemFreqs: Field[Array[Float], Row]
  val elemCountHistogram: Field[Array[Float], Row]
}
object PgStatsExtExprsViewFields extends PgStatsExtExprsViewStructure[PgStatsExtExprsViewRow](None, identity, (_, x) => x)

