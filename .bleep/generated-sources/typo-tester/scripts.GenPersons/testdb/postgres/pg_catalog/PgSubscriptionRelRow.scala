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

case class PgSubscriptionRelRow(
  srsubid: Long,
  srrelid: Long,
  srsubstate: String,
  srsublsn: Option[String]
)

object PgSubscriptionRelRow {
  implicit val rowParser: RowParser[PgSubscriptionRelRow] = { row =>
    Success(
      PgSubscriptionRelRow(
        srsubid = row[Long]("srsubid"),
        srrelid = row[Long]("srrelid"),
        srsubstate = row[String]("srsubstate"),
        srsublsn = row[Option[String]]("srsublsn")
      )
    )
  }

  implicit val oFormat: OFormat[PgSubscriptionRelRow] = new OFormat[PgSubscriptionRelRow]{
    override def writes(o: PgSubscriptionRelRow): JsObject =
      Json.obj(
        "srsubid" -> o.srsubid,
      "srrelid" -> o.srrelid,
      "srsubstate" -> o.srsubstate,
      "srsublsn" -> o.srsublsn
      )

    override def reads(json: JsValue): JsResult[PgSubscriptionRelRow] = {
      JsResult.fromTry(
        Try(
          PgSubscriptionRelRow(
            srsubid = json.\("srsubid").as[Long],
            srrelid = json.\("srrelid").as[Long],
            srsubstate = json.\("srsubstate").as[String],
            srsublsn = json.\("srsublsn").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}