/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package title

import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: public.title
    Primary key: code */
case class TitleRow(
  code: TitleId
){
   val id = code
 }

object TitleRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[TitleRow] = TitleId.jdbcDecoder.map(v => TitleRow(code = v))
  implicit lazy val jsonDecoder: JsonDecoder[TitleRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val code = jsonObj.get("code").toRight("Missing field 'code'").flatMap(_.as(TitleId.jsonDecoder))
    if (code.isRight)
      Right(TitleRow(code = code.toOption.get))
    else Left(List[Either[String, Any]](code).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[TitleRow] = new JsonEncoder[TitleRow] {
    override def unsafeEncode(a: TitleRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""code":""")
      TitleId.jsonEncoder.unsafeEncode(a.code, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[TitleRow] = Text.instance[TitleRow]{ (row, sb) =>
    TitleId.text.unsafeEncode(row.code, sb)
  }
}
