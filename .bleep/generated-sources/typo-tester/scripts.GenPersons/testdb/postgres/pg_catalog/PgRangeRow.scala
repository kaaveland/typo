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

case class PgRangeRow(
  rngtypid: Long,
  rngsubtype: Long,
  rngmultitypid: Long,
  rngcollation: Long,
  rngsubopc: Long,
  rngcanonical: String,
  rngsubdiff: String
)

object PgRangeRow {
  implicit val rowParser: RowParser[PgRangeRow] = { row =>
    Success(
      PgRangeRow(
        rngtypid = row[Long]("rngtypid"),
        rngsubtype = row[Long]("rngsubtype"),
        rngmultitypid = row[Long]("rngmultitypid"),
        rngcollation = row[Long]("rngcollation"),
        rngsubopc = row[Long]("rngsubopc"),
        rngcanonical = row[String]("rngcanonical"),
        rngsubdiff = row[String]("rngsubdiff")
      )
    )
  }

  implicit val oFormat: OFormat[PgRangeRow] = new OFormat[PgRangeRow]{
    override def writes(o: PgRangeRow): JsObject =
      Json.obj(
        "rngtypid" -> o.rngtypid,
      "rngsubtype" -> o.rngsubtype,
      "rngmultitypid" -> o.rngmultitypid,
      "rngcollation" -> o.rngcollation,
      "rngsubopc" -> o.rngsubopc,
      "rngcanonical" -> o.rngcanonical,
      "rngsubdiff" -> o.rngsubdiff
      )

    override def reads(json: JsValue): JsResult[PgRangeRow] = {
      JsResult.fromTry(
        Try(
          PgRangeRow(
            rngtypid = json.\("rngtypid").as[Long],
            rngsubtype = json.\("rngsubtype").as[Long],
            rngmultitypid = json.\("rngmultitypid").as[Long],
            rngcollation = json.\("rngcollation").as[Long],
            rngsubopc = json.\("rngsubopc").as[Long],
            rngcanonical = json.\("rngcanonical").as[String],
            rngsubdiff = json.\("rngsubdiff").as[String]
          )
        )
      )
    }
  }
}
