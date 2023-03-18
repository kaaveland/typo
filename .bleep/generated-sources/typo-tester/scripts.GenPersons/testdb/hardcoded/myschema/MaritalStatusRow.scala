package testdb
package hardcoded
package myschema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class MaritalStatusRow(
  id: MaritalStatusId
)

object MaritalStatusRow {
  implicit val rowParser: RowParser[MaritalStatusRow] = { row =>
    Success(
      MaritalStatusRow(
        id = row[MaritalStatusId]("id")
      )
    )
  }

  implicit val oFormat: OFormat[MaritalStatusRow] = new OFormat[MaritalStatusRow]{
    override def writes(o: MaritalStatusRow): JsObject =
      Json.obj(
        "id" -> o.id
      )

    override def reads(json: JsValue): JsResult[MaritalStatusRow] = {
      JsResult.fromTry(
        Try(
          MaritalStatusRow(
            id = json.\("id").as[MaritalStatusId]
          )
        )
      )
    }
  }
}