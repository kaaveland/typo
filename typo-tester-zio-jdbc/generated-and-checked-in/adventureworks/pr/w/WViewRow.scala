/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package w

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import adventureworks.production.workorder.WorkorderId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: pr.w */
case class WViewRow(
  /** Points to [[production.workorder.WorkorderRow.workorderid]] */
  id: WorkorderId,
  /** Points to [[production.workorder.WorkorderRow.workorderid]] */
  workorderid: WorkorderId,
  /** Points to [[production.workorder.WorkorderRow.productid]] */
  productid: ProductId,
  /** Points to [[production.workorder.WorkorderRow.orderqty]] */
  orderqty: Int,
  /** Points to [[production.workorder.WorkorderRow.scrappedqty]] */
  scrappedqty: TypoShort,
  /** Points to [[production.workorder.WorkorderRow.startdate]] */
  startdate: TypoLocalDateTime,
  /** Points to [[production.workorder.WorkorderRow.enddate]] */
  enddate: Option[TypoLocalDateTime],
  /** Points to [[production.workorder.WorkorderRow.duedate]] */
  duedate: TypoLocalDateTime,
  /** Points to [[production.workorder.WorkorderRow.scrapreasonid]] */
  scrapreasonid: Option[ScrapreasonId],
  /** Points to [[production.workorder.WorkorderRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object WViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[WViewRow] = new JdbcDecoder[WViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, WViewRow) =
      columIndex + 9 ->
        WViewRow(
          id = WorkorderId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          workorderid = WorkorderId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          productid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          orderqty = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 3, rs)._2,
          scrappedqty = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          startdate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          enddate = JdbcDecoder.optionDecoder(TypoLocalDateTime.jdbcDecoder).unsafeDecode(columIndex + 6, rs)._2,
          duedate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 7, rs)._2,
          scrapreasonid = JdbcDecoder.optionDecoder(ScrapreasonId.jdbcDecoder).unsafeDecode(columIndex + 8, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 9, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[WViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(WorkorderId.jsonDecoder))
    val workorderid = jsonObj.get("workorderid").toRight("Missing field 'workorderid'").flatMap(_.as(WorkorderId.jsonDecoder))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val orderqty = jsonObj.get("orderqty").toRight("Missing field 'orderqty'").flatMap(_.as(JsonDecoder.int))
    val scrappedqty = jsonObj.get("scrappedqty").toRight("Missing field 'scrappedqty'").flatMap(_.as(TypoShort.jsonDecoder))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val enddate = jsonObj.get("enddate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDateTime.jsonDecoder)))
    val duedate = jsonObj.get("duedate").toRight("Missing field 'duedate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val scrapreasonid = jsonObj.get("scrapreasonid").fold[Either[String, Option[ScrapreasonId]]](Right(None))(_.as(JsonDecoder.option(using ScrapreasonId.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && workorderid.isRight && productid.isRight && orderqty.isRight && scrappedqty.isRight && startdate.isRight && enddate.isRight && duedate.isRight && scrapreasonid.isRight && modifieddate.isRight)
      Right(WViewRow(id = id.toOption.get, workorderid = workorderid.toOption.get, productid = productid.toOption.get, orderqty = orderqty.toOption.get, scrappedqty = scrappedqty.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, duedate = duedate.toOption.get, scrapreasonid = scrapreasonid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[WViewRow] = new JsonEncoder[WViewRow] {
    override def unsafeEncode(a: WViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      WorkorderId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""workorderid":""")
      WorkorderId.jsonEncoder.unsafeEncode(a.workorderid, indent, out)
      out.write(",")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""orderqty":""")
      JsonEncoder.int.unsafeEncode(a.orderqty, indent, out)
      out.write(",")
      out.write(""""scrappedqty":""")
      TypoShort.jsonEncoder.unsafeEncode(a.scrappedqty, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""enddate":""")
      JsonEncoder.option(using TypoLocalDateTime.jsonEncoder).unsafeEncode(a.enddate, indent, out)
      out.write(",")
      out.write(""""duedate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.duedate, indent, out)
      out.write(",")
      out.write(""""scrapreasonid":""")
      JsonEncoder.option(using ScrapreasonId.jsonEncoder).unsafeEncode(a.scrapreasonid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
