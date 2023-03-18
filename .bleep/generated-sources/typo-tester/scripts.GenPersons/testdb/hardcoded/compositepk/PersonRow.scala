package testdb
package hardcoded
package compositepk

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PersonRow(
  one: Long,
  two: Option[String],
  name: Option[String]
){
  val oneAndTwo: PersonId = PersonId(one, two)
}

object PersonRow {
  implicit val rowParser: RowParser[PersonRow] = { row =>
    Success(
      PersonRow(
        one = row[Long]("one"),
        two = row[Option[String]]("two"),
        name = row[Option[String]]("name")
      )
    )
  }

  implicit val oFormat: OFormat[PersonRow] = new OFormat[PersonRow]{
    override def writes(o: PersonRow): JsObject =
      Json.obj(
        "one" -> o.one,
      "two" -> o.two,
      "name" -> o.name
      )

    override def reads(json: JsValue): JsResult[PersonRow] = {
      JsResult.fromTry(
        Try(
          PersonRow(
            one = json.\("one").as[Long],
            two = json.\("two").toOption.map(_.as[String]),
            name = json.\("name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}