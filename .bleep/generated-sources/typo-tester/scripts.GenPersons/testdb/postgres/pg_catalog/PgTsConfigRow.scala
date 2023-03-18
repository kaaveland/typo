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

case class PgTsConfigRow(
  oid: Long,
  cfgname: String,
  cfgnamespace: Long,
  cfgowner: Long,
  cfgparser: Long
)

object PgTsConfigRow {
  implicit val rowParser: RowParser[PgTsConfigRow] = { row =>
    Success(
      PgTsConfigRow(
        oid = row[Long]("oid"),
        cfgname = row[String]("cfgname"),
        cfgnamespace = row[Long]("cfgnamespace"),
        cfgowner = row[Long]("cfgowner"),
        cfgparser = row[Long]("cfgparser")
      )
    )
  }

  implicit val oFormat: OFormat[PgTsConfigRow] = new OFormat[PgTsConfigRow]{
    override def writes(o: PgTsConfigRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "cfgname" -> o.cfgname,
      "cfgnamespace" -> o.cfgnamespace,
      "cfgowner" -> o.cfgowner,
      "cfgparser" -> o.cfgparser
      )

    override def reads(json: JsValue): JsResult[PgTsConfigRow] = {
      JsResult.fromTry(
        Try(
          PgTsConfigRow(
            oid = json.\("oid").as[Long],
            cfgname = json.\("cfgname").as[String],
            cfgnamespace = json.\("cfgnamespace").as[Long],
            cfgowner = json.\("cfgowner").as[Long],
            cfgparser = json.\("cfgparser").as[Long]
          )
        )
      )
    }
  }
}
