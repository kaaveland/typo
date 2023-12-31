/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

import adventureworks.Text
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class IdentityTestRow(
  /** Identity ALWAYS, identityStart: 1, identityIncrement: 1, identityMaximum: 2147483647, identityMinimum: 1 */
  alwaysGenerated: Int,
  /** Identity BY DEFAULT, identityStart: 1, identityIncrement: 1, identityMaximum: 2147483647, identityMinimum: 1 */
  defaultGenerated: Int,
  name: IdentityTestId
)

object IdentityTestRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[IdentityTestRow] = new JdbcDecoder[IdentityTestRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, IdentityTestRow) =
      columIndex + 2 ->
        IdentityTestRow(
          alwaysGenerated = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 0, rs)._2,
          defaultGenerated = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 1, rs)._2,
          name = IdentityTestId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[IdentityTestRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val alwaysGenerated = jsonObj.get("always_generated").toRight("Missing field 'always_generated'").flatMap(_.as(JsonDecoder.int))
    val defaultGenerated = jsonObj.get("default_generated").toRight("Missing field 'default_generated'").flatMap(_.as(JsonDecoder.int))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(IdentityTestId.jsonDecoder))
    if (alwaysGenerated.isRight && defaultGenerated.isRight && name.isRight)
      Right(IdentityTestRow(alwaysGenerated = alwaysGenerated.toOption.get, defaultGenerated = defaultGenerated.toOption.get, name = name.toOption.get))
    else Left(List[Either[String, Any]](alwaysGenerated, defaultGenerated, name).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[IdentityTestRow] = new JsonEncoder[IdentityTestRow] {
    override def unsafeEncode(a: IdentityTestRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""always_generated":""")
      JsonEncoder.int.unsafeEncode(a.alwaysGenerated, indent, out)
      out.write(",")
      out.write(""""default_generated":""")
      JsonEncoder.int.unsafeEncode(a.defaultGenerated, indent, out)
      out.write(",")
      out.write(""""name":""")
      IdentityTestId.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[IdentityTestRow] = Text.instance[IdentityTestRow]{ (row, sb) =>
    Text.intInstance.unsafeEncode(row.alwaysGenerated, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.defaultGenerated, sb)
    sb.append(Text.DELIMETER)
    IdentityTestId.text.unsafeEncode(row.name, sb)
  }
}
