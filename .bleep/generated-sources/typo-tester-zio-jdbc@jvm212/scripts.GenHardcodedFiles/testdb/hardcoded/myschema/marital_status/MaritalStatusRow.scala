/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import testdb.hardcoded.Text
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: myschema.marital_status
    Primary key: id */
case class MaritalStatusRow(
  id: MaritalStatusId
)

object MaritalStatusRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[MaritalStatusRow] = MaritalStatusId.jdbcDecoder.map(v => MaritalStatusRow(id = v))
  implicit lazy val jsonDecoder: JsonDecoder[MaritalStatusRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(MaritalStatusId.jsonDecoder))
    if (id.isRight)
      Right(MaritalStatusRow(id = id.toOption.get))
    else Left(List[Either[String, Any]](id).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[MaritalStatusRow] = new JsonEncoder[MaritalStatusRow] {
    override def unsafeEncode(a: MaritalStatusRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      MaritalStatusId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[MaritalStatusRow] = Text.instance[MaritalStatusRow]{ (row, sb) =>
    MaritalStatusId.text.unsafeEncode(row.id, sb)
  }
}
