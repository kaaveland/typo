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

case class PgAmprocRow(
  oid: Long,
  amprocfamily: Long,
  amproclefttype: Long,
  amprocrighttype: Long,
  amprocnum: Short,
  amproc: String
)

object PgAmprocRow {
  implicit val rowParser: RowParser[PgAmprocRow] = { row =>
    Success(
      PgAmprocRow(
        oid = row[Long]("oid"),
        amprocfamily = row[Long]("amprocfamily"),
        amproclefttype = row[Long]("amproclefttype"),
        amprocrighttype = row[Long]("amprocrighttype"),
        amprocnum = row[Short]("amprocnum"),
        amproc = row[String]("amproc")
      )
    )
  }

  implicit val oFormat: OFormat[PgAmprocRow] = new OFormat[PgAmprocRow]{
    override def writes(o: PgAmprocRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "amprocfamily" -> o.amprocfamily,
      "amproclefttype" -> o.amproclefttype,
      "amprocrighttype" -> o.amprocrighttype,
      "amprocnum" -> o.amprocnum,
      "amproc" -> o.amproc
      )

    override def reads(json: JsValue): JsResult[PgAmprocRow] = {
      JsResult.fromTry(
        Try(
          PgAmprocRow(
            oid = json.\("oid").as[Long],
            amprocfamily = json.\("amprocfamily").as[Long],
            amproclefttype = json.\("amproclefttype").as[Long],
            amprocrighttype = json.\("amprocrighttype").as[Long],
            amprocnum = json.\("amprocnum").as[Short],
            amproc = json.\("amproc").as[String]
          )
        )
      )
    }
  }
}
