package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatsExtExprsRow(
  /** Points to [[PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[PgClassRow.relname]] */
  tablename: String,
  /** Points to [[PgNamespaceRow.nspname]] */
  statisticsSchemaname: String,
  /** Points to [[PgStatisticExtRow.stxname]] */
  statisticsName: String,
  statisticsOwner: /* unknown nullability */ Option[String],
  expr: /* unknown nullability */ Option[String],
  nullFrac: /* unknown nullability */ Option[Float],
  avgWidth: /* unknown nullability */ Option[Int],
  nDistinct: /* unknown nullability */ Option[Float],
  mostCommonVals: /* unknown nullability */ Option[/* anyarray */ String],
  mostCommonFreqs: /* unknown nullability */ Option[Array[Float]],
  histogramBounds: /* unknown nullability */ Option[/* anyarray */ String],
  correlation: /* unknown nullability */ Option[Float],
  mostCommonElems: /* unknown nullability */ Option[/* anyarray */ String],
  mostCommonElemFreqs: /* unknown nullability */ Option[Array[Float]],
  elemCountHistogram: /* unknown nullability */ Option[Array[Float]]
)

object PgStatsExtExprsRow {
  implicit val rowParser: RowParser[PgStatsExtExprsRow] = { row =>
    Success(
      PgStatsExtExprsRow(
        schemaname = row[String]("schemaname"),
        tablename = row[String]("tablename"),
        statisticsSchemaname = row[String]("statistics_schemaname"),
        statisticsName = row[String]("statistics_name"),
        statisticsOwner = row[/* unknown nullability */ Option[String]]("statistics_owner"),
        expr = row[/* unknown nullability */ Option[String]]("expr"),
        nullFrac = row[/* unknown nullability */ Option[Float]]("null_frac"),
        avgWidth = row[/* unknown nullability */ Option[Int]]("avg_width"),
        nDistinct = row[/* unknown nullability */ Option[Float]]("n_distinct"),
        mostCommonVals = row[/* unknown nullability */ Option[/* anyarray */ String]]("most_common_vals"),
        mostCommonFreqs = row[/* unknown nullability */ Option[Array[Float]]]("most_common_freqs"),
        histogramBounds = row[/* unknown nullability */ Option[/* anyarray */ String]]("histogram_bounds"),
        correlation = row[/* unknown nullability */ Option[Float]]("correlation"),
        mostCommonElems = row[/* unknown nullability */ Option[/* anyarray */ String]]("most_common_elems"),
        mostCommonElemFreqs = row[/* unknown nullability */ Option[Array[Float]]]("most_common_elem_freqs"),
        elemCountHistogram = row[/* unknown nullability */ Option[Array[Float]]]("elem_count_histogram")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatsExtExprsRow] = new OFormat[PgStatsExtExprsRow]{
    override def writes(o: PgStatsExtExprsRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "tablename" -> o.tablename,
      "statistics_schemaname" -> o.statisticsSchemaname,
      "statistics_name" -> o.statisticsName,
      "statistics_owner" -> o.statisticsOwner,
      "expr" -> o.expr,
      "null_frac" -> o.nullFrac,
      "avg_width" -> o.avgWidth,
      "n_distinct" -> o.nDistinct,
      "most_common_vals" -> o.mostCommonVals,
      "most_common_freqs" -> o.mostCommonFreqs,
      "histogram_bounds" -> o.histogramBounds,
      "correlation" -> o.correlation,
      "most_common_elems" -> o.mostCommonElems,
      "most_common_elem_freqs" -> o.mostCommonElemFreqs,
      "elem_count_histogram" -> o.elemCountHistogram
      )

    override def reads(json: JsValue): JsResult[PgStatsExtExprsRow] = {
      JsResult.fromTry(
        Try(
          PgStatsExtExprsRow(
            schemaname = json.\("schemaname").as[String],
            tablename = json.\("tablename").as[String],
            statisticsSchemaname = json.\("statistics_schemaname").as[String],
            statisticsName = json.\("statistics_name").as[String],
            statisticsOwner = json.\("statistics_owner").toOption.map(_.as[String]),
            expr = json.\("expr").toOption.map(_.as[String]),
            nullFrac = json.\("null_frac").toOption.map(_.as[Float]),
            avgWidth = json.\("avg_width").toOption.map(_.as[Int]),
            nDistinct = json.\("n_distinct").toOption.map(_.as[Float]),
            mostCommonVals = json.\("most_common_vals").toOption.map(_.as[/* anyarray */ String]),
            mostCommonFreqs = json.\("most_common_freqs").toOption.map(_.as[Array[Float]]),
            histogramBounds = json.\("histogram_bounds").toOption.map(_.as[/* anyarray */ String]),
            correlation = json.\("correlation").toOption.map(_.as[Float]),
            mostCommonElems = json.\("most_common_elems").toOption.map(_.as[/* anyarray */ String]),
            mostCommonElemFreqs = json.\("most_common_elem_freqs").toOption.map(_.as[Array[Float]]),
            elemCountHistogram = json.\("elem_count_histogram").toOption.map(_.as[Array[Float]])
          )
        )
      )
    }
  }
}