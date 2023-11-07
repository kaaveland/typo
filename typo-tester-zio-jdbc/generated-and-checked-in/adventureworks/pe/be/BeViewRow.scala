/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class BeViewRow(
  /** Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.businessentity.BusinessentityRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[person.businessentity.BusinessentityRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object BeViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[BeViewRow] = new JdbcDecoder[BeViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, BeViewRow) =
      columIndex + 3 ->
        BeViewRow(
          id = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[BeViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && businessentityid.isRight && rowguid.isRight && modifieddate.isRight)
      Right(BeViewRow(id = id.toOption.get, businessentityid = businessentityid.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, businessentityid, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[BeViewRow] = new JsonEncoder[BeViewRow] {
    override def unsafeEncode(a: BeViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
