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

case class PgConversionRow(
  oid: Long,
  conname: String,
  connamespace: Long,
  conowner: Long,
  conforencoding: Int,
  contoencoding: Int,
  conproc: String,
  condefault: Boolean
)

object PgConversionRow {
  implicit val rowParser: RowParser[PgConversionRow] = { row =>
    Success(
      PgConversionRow(
        oid = row[Long]("oid"),
        conname = row[String]("conname"),
        connamespace = row[Long]("connamespace"),
        conowner = row[Long]("conowner"),
        conforencoding = row[Int]("conforencoding"),
        contoencoding = row[Int]("contoencoding"),
        conproc = row[String]("conproc"),
        condefault = row[Boolean]("condefault")
      )
    )
  }

  implicit val oFormat: OFormat[PgConversionRow] = new OFormat[PgConversionRow]{
    override def writes(o: PgConversionRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "conname" -> o.conname,
      "connamespace" -> o.connamespace,
      "conowner" -> o.conowner,
      "conforencoding" -> o.conforencoding,
      "contoencoding" -> o.contoencoding,
      "conproc" -> o.conproc,
      "condefault" -> o.condefault
      )

    override def reads(json: JsValue): JsResult[PgConversionRow] = {
      JsResult.fromTry(
        Try(
          PgConversionRow(
            oid = json.\("oid").as[Long],
            conname = json.\("conname").as[String],
            connamespace = json.\("connamespace").as[Long],
            conowner = json.\("conowner").as[Long],
            conforencoding = json.\("conforencoding").as[Int],
            contoencoding = json.\("contoencoding").as[Int],
            conproc = json.\("conproc").as[String],
            condefault = json.\("condefault").as[Boolean]
          )
        )
      )
    }
  }
}
