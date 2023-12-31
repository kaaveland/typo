/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import java.sql.ResultSet
import testdb.hardcoded.Text
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PersonRow(
  /** Default: auto-increment */
  one: Long,
  /** Default: auto-increment */
  two: Option[String],
  name: Option[String]
){
   val compositeId: PersonId = PersonId(one, two)
 }

object PersonRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PersonRow] = new JdbcDecoder[PersonRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PersonRow) =
      columIndex + 2 ->
        PersonRow(
          one = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 0, rs)._2,
          two = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          name = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PersonRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val one = jsonObj.get("one").toRight("Missing field 'one'").flatMap(_.as(JsonDecoder.long))
    val two = jsonObj.get("two").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val name = jsonObj.get("name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (one.isRight && two.isRight && name.isRight)
      Right(PersonRow(one = one.toOption.get, two = two.toOption.get, name = name.toOption.get))
    else Left(List[Either[String, Any]](one, two, name).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersonRow] = new JsonEncoder[PersonRow] {
    override def unsafeEncode(a: PersonRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""one":""")
      JsonEncoder.long.unsafeEncode(a.one, indent, out)
      out.write(",")
      out.write(""""two":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.two, indent, out)
      out.write(",")
      out.write(""""name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.name, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[PersonRow] = Text.instance[PersonRow]{ (row, sb) =>
    Text.longInstance.unsafeEncode(row.one, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.two, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.name, sb)
  }
}
