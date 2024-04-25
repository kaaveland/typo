/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: sales.salesorderheadersalesreason
    Cross-reference table mapping sales orders to sales reason codes.
    Composite primary key: salesorderid, salesreasonid */
case class SalesorderheadersalesreasonRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. Foreign key to SalesReason.SalesReasonID.
      Points to [[salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: SalesreasonId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesorderheadersalesreasonId = SalesorderheadersalesreasonId(salesorderid, salesreasonid)
 }

object SalesorderheadersalesreasonRow {
  def apply(compositeId: SalesorderheadersalesreasonId, modifieddate: TypoLocalDateTime) =
    new SalesorderheadersalesreasonRow(compositeId.salesorderid, compositeId.salesreasonid, modifieddate)
  implicit lazy val jdbcDecoder: JdbcDecoder[SalesorderheadersalesreasonRow] = new JdbcDecoder[SalesorderheadersalesreasonRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SalesorderheadersalesreasonRow) =
      columIndex + 2 ->
        SalesorderheadersalesreasonRow(
          salesorderid = SalesorderheaderId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          salesreasonid = SalesreasonId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SalesorderheadersalesreasonRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val salesorderid = jsonObj.get("salesorderid").toRight("Missing field 'salesorderid'").flatMap(_.as(SalesorderheaderId.jsonDecoder))
    val salesreasonid = jsonObj.get("salesreasonid").toRight("Missing field 'salesreasonid'").flatMap(_.as(SalesreasonId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (salesorderid.isRight && salesreasonid.isRight && modifieddate.isRight)
      Right(SalesorderheadersalesreasonRow(salesorderid = salesorderid.toOption.get, salesreasonid = salesreasonid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](salesorderid, salesreasonid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesorderheadersalesreasonRow] = new JsonEncoder[SalesorderheadersalesreasonRow] {
    override def unsafeEncode(a: SalesorderheadersalesreasonRow, indent: Option[Int], out: Write): Unit = {
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
  implicit lazy val text: Text[SalesorderheadersalesreasonRow] = Text.instance[SalesorderheadersalesreasonRow]{ (row, sb) =>
    SalesorderheaderId.text.unsafeEncode(row.salesorderid, sb)
    sb.append(Text.DELIMETER)
    SalesreasonId.text.unsafeEncode(row.salesreasonid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
