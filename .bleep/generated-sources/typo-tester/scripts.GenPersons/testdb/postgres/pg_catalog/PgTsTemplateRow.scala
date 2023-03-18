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

case class PgTsTemplateRow(
  oid: Long,
  tmplname: String,
  tmplnamespace: Long,
  tmplinit: String,
  tmpllexize: String
)

object PgTsTemplateRow {
  implicit val rowParser: RowParser[PgTsTemplateRow] = { row =>
    Success(
      PgTsTemplateRow(
        oid = row[Long]("oid"),
        tmplname = row[String]("tmplname"),
        tmplnamespace = row[Long]("tmplnamespace"),
        tmplinit = row[String]("tmplinit"),
        tmpllexize = row[String]("tmpllexize")
      )
    )
  }

  implicit val oFormat: OFormat[PgTsTemplateRow] = new OFormat[PgTsTemplateRow]{
    override def writes(o: PgTsTemplateRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "tmplname" -> o.tmplname,
      "tmplnamespace" -> o.tmplnamespace,
      "tmplinit" -> o.tmplinit,
      "tmpllexize" -> o.tmpllexize
      )

    override def reads(json: JsValue): JsResult[PgTsTemplateRow] = {
      JsResult.fromTry(
        Try(
          PgTsTemplateRow(
            oid = json.\("oid").as[Long],
            tmplname = json.\("tmplname").as[String],
            tmplnamespace = json.\("tmplnamespace").as[Long],
            tmplinit = json.\("tmplinit").as[String],
            tmpllexize = json.\("tmpllexize").as[String]
          )
        )
      )
    }
  }
}