/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats_ext

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

case class PgStatsExtViewRow(
  /** Points to [[pg_namespace.PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[pg_class.PgClassRow.relname]] */
  tablename: String,
  /** Points to [[pg_namespace.PgNamespaceRow.nspname]] */
  statisticsSchemaname: Option[String],
  /** Points to [[pg_statistic_ext.PgStatisticExtRow.stxname]] */
  statisticsName: String,
  statisticsOwner: /* nullability unknown */ Option[String],
  attnames: /* nullability unknown */ Option[Array[String]],
  exprs: /* nullability unknown */ Option[Array[String]],
  /** Points to [[pg_statistic_ext.PgStatisticExtRow.stxkind]] */
  kinds: Array[String],
  /** Points to [[pg_statistic_ext_data.PgStatisticExtDataRow.stxdndistinct]] */
  nDistinct: Option[String],
  /** Points to [[pg_statistic_ext_data.PgStatisticExtDataRow.stxddependencies]] */
  dependencies: Option[String],
  mostCommonVals: /* nullability unknown */ Option[Array[String]],
  mostCommonValNulls: /* nullability unknown */ Option[Array[Boolean]],
  mostCommonFreqs: /* nullability unknown */ Option[Array[Double]],
  mostCommonBaseFreqs: /* nullability unknown */ Option[Array[Double]]
)

object PgStatsExtViewRow {
  implicit lazy val reads: Reads[PgStatsExtViewRow] = Reads[PgStatsExtViewRow](json => JsResult.fromTry(
      Try(
        PgStatsExtViewRow(
          schemaname = json.\("schemaname").as(Reads.StringReads),
          tablename = json.\("tablename").as(Reads.StringReads),
          statisticsSchemaname = json.\("statistics_schemaname").toOption.map(_.as(Reads.StringReads)),
          statisticsName = json.\("statistics_name").as(Reads.StringReads),
          statisticsOwner = json.\("statistics_owner").toOption.map(_.as(Reads.StringReads)),
          attnames = json.\("attnames").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          exprs = json.\("exprs").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          kinds = json.\("kinds").as(Reads.ArrayReads[String](Reads.StringReads, implicitly)),
          nDistinct = json.\("n_distinct").toOption.map(_.as(Reads.StringReads)),
          dependencies = json.\("dependencies").toOption.map(_.as(Reads.StringReads)),
          mostCommonVals = json.\("most_common_vals").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly))),
          mostCommonValNulls = json.\("most_common_val_nulls").toOption.map(_.as(Reads.ArrayReads[Boolean](Reads.BooleanReads, implicitly))),
          mostCommonFreqs = json.\("most_common_freqs").toOption.map(_.as(Reads.ArrayReads[Double](Reads.DoubleReads, implicitly))),
          mostCommonBaseFreqs = json.\("most_common_base_freqs").toOption.map(_.as(Reads.ArrayReads[Double](Reads.DoubleReads, implicitly)))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatsExtViewRow] = RowParser[PgStatsExtViewRow] { row =>
    Success(
      PgStatsExtViewRow(
        schemaname = row(idx + 0)(Column.columnToString),
        tablename = row(idx + 1)(Column.columnToString),
        statisticsSchemaname = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        statisticsName = row(idx + 3)(Column.columnToString),
        statisticsOwner = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        attnames = row(idx + 5)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        exprs = row(idx + 6)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        kinds = row(idx + 7)(Column.columnToArray[String](Column.columnToString, implicitly)),
        nDistinct = row(idx + 8)(Column.columnToOption(Column.columnToString)),
        dependencies = row(idx + 9)(Column.columnToOption(Column.columnToString)),
        mostCommonVals = row(idx + 10)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly))),
        mostCommonValNulls = row(idx + 11)(Column.columnToOption(Column.columnToArray[Boolean](Column.columnToBoolean, implicitly))),
        mostCommonFreqs = row(idx + 12)(Column.columnToOption(Column.columnToArray[Double](Column.columnToDouble, implicitly))),
        mostCommonBaseFreqs = row(idx + 13)(Column.columnToOption(Column.columnToArray[Double](Column.columnToDouble, implicitly)))
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatsExtViewRow] = OWrites[PgStatsExtViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "schemaname" -> Writes.StringWrites.writes(o.schemaname),
      "tablename" -> Writes.StringWrites.writes(o.tablename),
      "statistics_schemaname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.statisticsSchemaname),
      "statistics_name" -> Writes.StringWrites.writes(o.statisticsName),
      "statistics_owner" -> Writes.OptionWrites(Writes.StringWrites).writes(o.statisticsOwner),
      "attnames" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.attnames),
      "exprs" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.exprs),
      "kinds" -> Writes.arrayWrites[String](implicitly, Writes.StringWrites).writes(o.kinds),
      "n_distinct" -> Writes.OptionWrites(Writes.StringWrites).writes(o.nDistinct),
      "dependencies" -> Writes.OptionWrites(Writes.StringWrites).writes(o.dependencies),
      "most_common_vals" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.mostCommonVals),
      "most_common_val_nulls" -> Writes.OptionWrites(Writes.arrayWrites[Boolean](implicitly, Writes.BooleanWrites)).writes(o.mostCommonValNulls),
      "most_common_freqs" -> Writes.OptionWrites(Writes.arrayWrites[Double](implicitly, Writes.DoubleWrites)).writes(o.mostCommonFreqs),
      "most_common_base_freqs" -> Writes.OptionWrites(Writes.arrayWrites[Double](implicitly, Writes.DoubleWrites)).writes(o.mostCommonBaseFreqs)
    ))
  )
}
