/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class BusinessentityRow(
  /** Primary key for all customers, vendors, and employees. */
  businessentityid: BusinessentityId,
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
)

object BusinessentityRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[BusinessentityRow] = new JdbcDecoder[BusinessentityRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, BusinessentityRow) =
      columIndex + 2 ->
        BusinessentityRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[BusinessentityRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && rowguid.isRight && modifieddate.isRight)
      Right(BusinessentityRow(businessentityid = businessentityid.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[BusinessentityRow] = new JsonEncoder[BusinessentityRow] {
    override def unsafeEncode(a: BusinessentityRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
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