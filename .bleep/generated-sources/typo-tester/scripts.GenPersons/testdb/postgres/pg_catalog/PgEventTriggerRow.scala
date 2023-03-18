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

case class PgEventTriggerRow(
  oid: Long,
  evtname: String,
  evtevent: String,
  evtowner: Long,
  evtfoid: Long,
  evtenabled: String,
  evttags: Option[Array[String]]
)

object PgEventTriggerRow {
  implicit val rowParser: RowParser[PgEventTriggerRow] = { row =>
    Success(
      PgEventTriggerRow(
        oid = row[Long]("oid"),
        evtname = row[String]("evtname"),
        evtevent = row[String]("evtevent"),
        evtowner = row[Long]("evtowner"),
        evtfoid = row[Long]("evtfoid"),
        evtenabled = row[String]("evtenabled"),
        evttags = row[Option[Array[String]]]("evttags")
      )
    )
  }

  implicit val oFormat: OFormat[PgEventTriggerRow] = new OFormat[PgEventTriggerRow]{
    override def writes(o: PgEventTriggerRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "evtname" -> o.evtname,
      "evtevent" -> o.evtevent,
      "evtowner" -> o.evtowner,
      "evtfoid" -> o.evtfoid,
      "evtenabled" -> o.evtenabled,
      "evttags" -> o.evttags
      )

    override def reads(json: JsValue): JsResult[PgEventTriggerRow] = {
      JsResult.fromTry(
        Try(
          PgEventTriggerRow(
            oid = json.\("oid").as[Long],
            evtname = json.\("evtname").as[String],
            evtevent = json.\("evtevent").as[String],
            evtowner = json.\("evtowner").as[Long],
            evtfoid = json.\("evtfoid").as[Long],
            evtenabled = json.\("evtenabled").as[String],
            evttags = json.\("evttags").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}
