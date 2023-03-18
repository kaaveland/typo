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

case class PgSequencesRow(
  /** Points to [[PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[PgClassRow.relname]] */
  sequencename: String,
  sequenceowner: /* unknown nullability */ Option[String],
  dataType: /* unknown nullability */ Option[/* regtype */ String],
  /** Points to [[PgSequenceRow.seqstart]] */
  startValue: Long,
  /** Points to [[PgSequenceRow.seqmin]] */
  minValue: Long,
  /** Points to [[PgSequenceRow.seqmax]] */
  maxValue: Long,
  /** Points to [[PgSequenceRow.seqincrement]] */
  incrementBy: Long,
  /** Points to [[PgSequenceRow.seqcycle]] */
  cycle: Boolean,
  /** Points to [[PgSequenceRow.seqcache]] */
  cacheSize: Long,
  lastValue: /* unknown nullability */ Option[Long]
)

object PgSequencesRow {
  implicit val rowParser: RowParser[PgSequencesRow] = { row =>
    Success(
      PgSequencesRow(
        schemaname = row[String]("schemaname"),
        sequencename = row[String]("sequencename"),
        sequenceowner = row[/* unknown nullability */ Option[String]]("sequenceowner"),
        dataType = row[/* unknown nullability */ Option[/* regtype */ String]]("data_type"),
        startValue = row[Long]("start_value"),
        minValue = row[Long]("min_value"),
        maxValue = row[Long]("max_value"),
        incrementBy = row[Long]("increment_by"),
        cycle = row[Boolean]("cycle"),
        cacheSize = row[Long]("cache_size"),
        lastValue = row[/* unknown nullability */ Option[Long]]("last_value")
      )
    )
  }

  implicit val oFormat: OFormat[PgSequencesRow] = new OFormat[PgSequencesRow]{
    override def writes(o: PgSequencesRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "sequencename" -> o.sequencename,
      "sequenceowner" -> o.sequenceowner,
      "data_type" -> o.dataType,
      "start_value" -> o.startValue,
      "min_value" -> o.minValue,
      "max_value" -> o.maxValue,
      "increment_by" -> o.incrementBy,
      "cycle" -> o.cycle,
      "cache_size" -> o.cacheSize,
      "last_value" -> o.lastValue
      )

    override def reads(json: JsValue): JsResult[PgSequencesRow] = {
      JsResult.fromTry(
        Try(
          PgSequencesRow(
            schemaname = json.\("schemaname").as[String],
            sequencename = json.\("sequencename").as[String],
            sequenceowner = json.\("sequenceowner").toOption.map(_.as[String]),
            dataType = json.\("data_type").toOption.map(_.as[/* regtype */ String]),
            startValue = json.\("start_value").as[Long],
            minValue = json.\("min_value").as[Long],
            maxValue = json.\("max_value").as[Long],
            incrementBy = json.\("increment_by").as[Long],
            cycle = json.\("cycle").as[Boolean],
            cacheSize = json.\("cache_size").as[Long],
            lastValue = json.\("last_value").toOption.map(_.as[Long])
          )
        )
      )
    }
  }
}