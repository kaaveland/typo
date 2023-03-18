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

case class PgLanguageRow(
  oid: Long,
  lanname: String,
  lanowner: Long,
  lanispl: Boolean,
  lanpltrusted: Boolean,
  lanplcallfoid: Long,
  laninline: Long,
  lanvalidator: Long,
  lanacl: Option[Array[String]]
)

object PgLanguageRow {
  implicit val rowParser: RowParser[PgLanguageRow] = { row =>
    Success(
      PgLanguageRow(
        oid = row[Long]("oid"),
        lanname = row[String]("lanname"),
        lanowner = row[Long]("lanowner"),
        lanispl = row[Boolean]("lanispl"),
        lanpltrusted = row[Boolean]("lanpltrusted"),
        lanplcallfoid = row[Long]("lanplcallfoid"),
        laninline = row[Long]("laninline"),
        lanvalidator = row[Long]("lanvalidator"),
        lanacl = row[Option[Array[String]]]("lanacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgLanguageRow] = new OFormat[PgLanguageRow]{
    override def writes(o: PgLanguageRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "lanname" -> o.lanname,
      "lanowner" -> o.lanowner,
      "lanispl" -> o.lanispl,
      "lanpltrusted" -> o.lanpltrusted,
      "lanplcallfoid" -> o.lanplcallfoid,
      "laninline" -> o.laninline,
      "lanvalidator" -> o.lanvalidator,
      "lanacl" -> o.lanacl
      )

    override def reads(json: JsValue): JsResult[PgLanguageRow] = {
      JsResult.fromTry(
        Try(
          PgLanguageRow(
            oid = json.\("oid").as[Long],
            lanname = json.\("lanname").as[String],
            lanowner = json.\("lanowner").as[Long],
            lanispl = json.\("lanispl").as[Boolean],
            lanpltrusted = json.\("lanpltrusted").as[Boolean],
            lanplcallfoid = json.\("lanplcallfoid").as[Long],
            laninline = json.\("laninline").as[Long],
            lanvalidator = json.\("lanvalidator").as[Long],
            lanacl = json.\("lanacl").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}