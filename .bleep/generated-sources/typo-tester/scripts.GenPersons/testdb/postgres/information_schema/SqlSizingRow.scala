package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SqlSizingRow(
  sizingId: Option[Int],
  sizingName: Option[String],
  supportedValue: Option[Int],
  comments: Option[String]
)

object SqlSizingRow {
  implicit val rowParser: RowParser[SqlSizingRow] = { row =>
    Success(
      SqlSizingRow(
        sizingId = row[Option[Int]]("sizing_id"),
        sizingName = row[Option[String]]("sizing_name"),
        supportedValue = row[Option[Int]]("supported_value"),
        comments = row[Option[String]]("comments")
      )
    )
  }

  implicit val oFormat: OFormat[SqlSizingRow] = new OFormat[SqlSizingRow]{
    override def writes(o: SqlSizingRow): JsObject =
      Json.obj(
        "sizing_id" -> o.sizingId,
      "sizing_name" -> o.sizingName,
      "supported_value" -> o.supportedValue,
      "comments" -> o.comments
      )

    override def reads(json: JsValue): JsResult[SqlSizingRow] = {
      JsResult.fromTry(
        Try(
          SqlSizingRow(
            sizingId = json.\("sizing_id").toOption.map(_.as[Int]),
            sizingName = json.\("sizing_name").toOption.map(_.as[String]),
            supportedValue = json.\("supported_value").toOption.map(_.as[Int]),
            comments = json.\("comments").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
