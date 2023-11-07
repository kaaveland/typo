/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sohsr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class SohsrViewRow(
  /** Points to [[sales.salesorderheadersalesreason.SalesorderheadersalesreasonRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Points to [[sales.salesorderheadersalesreason.SalesorderheadersalesreasonRow.salesreasonid]] */
  salesreasonid: SalesreasonId,
  /** Points to [[sales.salesorderheadersalesreason.SalesorderheadersalesreasonRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SohsrViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SohsrViewRow] = new JdbcDecoder[SohsrViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SohsrViewRow) =
      columIndex + 2 ->
        SohsrViewRow(
          salesorderid = SalesorderheaderId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          salesreasonid = SalesreasonId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SohsrViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val salesorderid = jsonObj.get("salesorderid").toRight("Missing field 'salesorderid'").flatMap(_.as(SalesorderheaderId.jsonDecoder))
    val salesreasonid = jsonObj.get("salesreasonid").toRight("Missing field 'salesreasonid'").flatMap(_.as(SalesreasonId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (salesorderid.isRight && salesreasonid.isRight && modifieddate.isRight)
      Right(SohsrViewRow(salesorderid = salesorderid.toOption.get, salesreasonid = salesreasonid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](salesorderid, salesreasonid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SohsrViewRow] = new JsonEncoder[SohsrViewRow] {
    override def unsafeEncode(a: SohsrViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""salesorderid":""")
      SalesorderheaderId.jsonEncoder.unsafeEncode(a.salesorderid, indent, out)
      out.write(",")
      out.write(""""salesreasonid":""")
      SalesreasonId.jsonEncoder.unsafeEncode(a.salesreasonid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
