/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats

import adventureworks.customtypes.TypoAnyArray
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgStatsViewRow(
  schemaname: Option[String],
  tablename: String,
  attname: String,
  inherited: Boolean,
  nullFrac: Float,
  avgWidth: Int,
  nDistinct: Float,
  mostCommonVals: TypoAnyArray,
  mostCommonFreqs: Array[Float],
  histogramBounds: TypoAnyArray,
  correlation: Float,
  mostCommonElems: TypoAnyArray,
  mostCommonElemFreqs: Array[Float],
  elemCountHistogram: Array[Float]
)

object PgStatsViewRow {
  implicit lazy val reads: Reads[PgStatsViewRow] = Reads[PgStatsViewRow](json => JsResult.fromTry(
      Try(
        PgStatsViewRow(
          schemaname = json.\("schemaname").toOption.map(_.as(Reads.StringReads)),
          tablename = json.\("tablename").as(Reads.StringReads),
          attname = json.\("attname").as(Reads.StringReads),
          inherited = json.\("inherited").as(Reads.BooleanReads),
          nullFrac = json.\("null_frac").as(Reads.FloatReads),
          avgWidth = json.\("avg_width").as(Reads.IntReads),
          nDistinct = json.\("n_distinct").as(Reads.FloatReads),
          mostCommonVals = json.\("most_common_vals").as(TypoAnyArray.reads),
          mostCommonFreqs = json.\("most_common_freqs").as(Reads.ArrayReads[Float](Reads.FloatReads, implicitly)),
          histogramBounds = json.\("histogram_bounds").as(TypoAnyArray.reads),
          correlation = json.\("correlation").as(Reads.FloatReads),
          mostCommonElems = json.\("most_common_elems").as(TypoAnyArray.reads),
          mostCommonElemFreqs = json.\("most_common_elem_freqs").as(Reads.ArrayReads[Float](Reads.FloatReads, implicitly)),
          elemCountHistogram = json.\("elem_count_histogram").as(Reads.ArrayReads[Float](Reads.FloatReads, implicitly))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatsViewRow] = RowParser[PgStatsViewRow] { row =>
    Success(
      PgStatsViewRow(
        schemaname = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        tablename = row(idx + 1)(Column.columnToString),
        attname = row(idx + 2)(Column.columnToString),
        inherited = row(idx + 3)(Column.columnToBoolean),
        nullFrac = row(idx + 4)(Column.columnToFloat),
        avgWidth = row(idx + 5)(Column.columnToInt),
        nDistinct = row(idx + 6)(Column.columnToFloat),
        mostCommonVals = row(idx + 7)(TypoAnyArray.column),
        mostCommonFreqs = row(idx + 8)(Column.columnToArray[Float](Column.columnToFloat, implicitly)),
        histogramBounds = row(idx + 9)(TypoAnyArray.column),
        correlation = row(idx + 10)(Column.columnToFloat),
        mostCommonElems = row(idx + 11)(TypoAnyArray.column),
        mostCommonElemFreqs = row(idx + 12)(Column.columnToArray[Float](Column.columnToFloat, implicitly)),
        elemCountHistogram = row(idx + 13)(Column.columnToArray[Float](Column.columnToFloat, implicitly))
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatsViewRow] = OWrites[PgStatsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "schemaname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.schemaname),
      "tablename" -> Writes.StringWrites.writes(o.tablename),
      "attname" -> Writes.StringWrites.writes(o.attname),
      "inherited" -> Writes.BooleanWrites.writes(o.inherited),
      "null_frac" -> Writes.FloatWrites.writes(o.nullFrac),
      "avg_width" -> Writes.IntWrites.writes(o.avgWidth),
      "n_distinct" -> Writes.FloatWrites.writes(o.nDistinct),
      "most_common_vals" -> TypoAnyArray.writes.writes(o.mostCommonVals),
      "most_common_freqs" -> Writes.arrayWrites[Float](implicitly, Writes.FloatWrites).writes(o.mostCommonFreqs),
      "histogram_bounds" -> TypoAnyArray.writes.writes(o.histogramBounds),
      "correlation" -> Writes.FloatWrites.writes(o.correlation),
      "most_common_elems" -> TypoAnyArray.writes.writes(o.mostCommonElems),
      "most_common_elem_freqs" -> Writes.arrayWrites[Float](implicitly, Writes.FloatWrites).writes(o.mostCommonElemFreqs),
      "elem_count_histogram" -> Writes.arrayWrites[Float](implicitly, Writes.FloatWrites).writes(o.elemCountHistogram)
    ))
  )
}
