/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package sr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.scrapreason.ScrapreasonId
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class SrViewRow(
  /** Points to [[production.scrapreason.ScrapreasonRow.scrapreasonid]] */
  id: ScrapreasonId,
  /** Points to [[production.scrapreason.ScrapreasonRow.scrapreasonid]] */
  scrapreasonid: ScrapreasonId,
  /** Points to [[production.scrapreason.ScrapreasonRow.name]] */
  name: Name,
  /** Points to [[production.scrapreason.ScrapreasonRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SrViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SrViewRow] = new JdbcDecoder[SrViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SrViewRow) =
      columIndex + 3 ->
        SrViewRow(
          id = ScrapreasonId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          scrapreasonid = ScrapreasonId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SrViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(ScrapreasonId.jsonDecoder))
    val scrapreasonid = jsonObj.get("scrapreasonid").toRight("Missing field 'scrapreasonid'").flatMap(_.as(ScrapreasonId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && scrapreasonid.isRight && name.isRight && modifieddate.isRight)
      Right(SrViewRow(id = id.toOption.get, scrapreasonid = scrapreasonid.toOption.get, name = name.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, scrapreasonid, name, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SrViewRow] = new JsonEncoder[SrViewRow] {
    override def unsafeEncode(a: SrViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      ScrapreasonId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""scrapreasonid":""")
      ScrapreasonId.jsonEncoder.unsafeEncode(a.scrapreasonid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
