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
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatsExtExprsViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatsExtExprsViewRow, val merge: (Row, PgStatsExtExprsViewRow) => Row)
  extends Relation[PgStatsExtExprsViewFields, PgStatsExtExprsViewRow, Row]
    with PgStatsExtExprsViewFields[Row] { outer =>

  override val schemaname = new OptField[String, Row](prefix, "schemaname", None, None)(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val tablename = new Field[String, Row](prefix, "tablename", None, None)(x => extract(x).tablename, (row, value) => merge(row, extract(row).copy(tablename = value)))
  override val statisticsSchemaname = new OptField[String, Row](prefix, "statistics_schemaname", None, None)(x => extract(x).statisticsSchemaname, (row, value) => merge(row, extract(row).copy(statisticsSchemaname = value)))
  override val statisticsName = new Field[String, Row](prefix, "statistics_name", None, None)(x => extract(x).statisticsName, (row, value) => merge(row, extract(row).copy(statisticsName = value)))
  override val statisticsOwner = new OptField[String, Row](prefix, "statistics_owner", None, None)(x => extract(x).statisticsOwner, (row, value) => merge(row, extract(row).copy(statisticsOwner = value)))
  override val expr = new OptField[String, Row](prefix, "expr", None, None)(x => extract(x).expr, (row, value) => merge(row, extract(row).copy(expr = value)))
  override val nullFrac = new OptField[Float, Row](prefix, "null_frac", None, None)(x => extract(x).nullFrac, (row, value) => merge(row, extract(row).copy(nullFrac = value)))
  override val avgWidth = new OptField[Int, Row](prefix, "avg_width", None, None)(x => extract(x).avgWidth, (row, value) => merge(row, extract(row).copy(avgWidth = value)))
  override val nDistinct = new OptField[Float, Row](prefix, "n_distinct", None, None)(x => extract(x).nDistinct, (row, value) => merge(row, extract(row).copy(nDistinct = value)))
  override val mostCommonVals = new OptField[TypoAnyArray, Row](prefix, "most_common_vals", None, None)(x => extract(x).mostCommonVals, (row, value) => merge(row, extract(row).copy(mostCommonVals = value)))
  override val mostCommonFreqs = new OptField[Array[Float], Row](prefix, "most_common_freqs", None, None)(x => extract(x).mostCommonFreqs, (row, value) => merge(row, extract(row).copy(mostCommonFreqs = value)))
  override val histogramBounds = new OptField[TypoAnyArray, Row](prefix, "histogram_bounds", None, None)(x => extract(x).histogramBounds, (row, value) => merge(row, extract(row).copy(histogramBounds = value)))
  override val correlation = new OptField[Float, Row](prefix, "correlation", None, None)(x => extract(x).correlation, (row, value) => merge(row, extract(row).copy(correlation = value)))
  override val mostCommonElems = new OptField[TypoAnyArray, Row](prefix, "most_common_elems", None, None)(x => extract(x).mostCommonElems, (row, value) => merge(row, extract(row).copy(mostCommonElems = value)))
  override val mostCommonElemFreqs = new OptField[Array[Float], Row](prefix, "most_common_elem_freqs", None, None)(x => extract(x).mostCommonElemFreqs, (row, value) => merge(row, extract(row).copy(mostCommonElemFreqs = value)))
  override val elemCountHistogram = new OptField[Array[Float], Row](prefix, "elem_count_histogram", None, None)(x => extract(x).elemCountHistogram, (row, value) => merge(row, extract(row).copy(elemCountHistogram = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](schemaname, tablename, statisticsSchemaname, statisticsName, statisticsOwner, expr, nullFrac, avgWidth, nDistinct, mostCommonVals, mostCommonFreqs, histogramBounds, correlation, mostCommonElems, mostCommonElemFreqs, elemCountHistogram)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatsExtExprsViewRow, merge: (NewRow, PgStatsExtExprsViewRow) => NewRow): PgStatsExtExprsViewStructure[NewRow] =
    new PgStatsExtExprsViewStructure(prefix, extract, merge)
}
