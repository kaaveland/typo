/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class SpecialofferproductRow(
  /** Primary key for SpecialOfferProduct records.
      Points to [[specialoffer.SpecialofferRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: SpecialofferproductId = SpecialofferproductId(specialofferid, productid)
 }

object SpecialofferproductRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SpecialofferproductRow] = new JdbcDecoder[SpecialofferproductRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SpecialofferproductRow) =
      columIndex + 3 ->
        SpecialofferproductRow(
          specialofferid = SpecialofferId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          productid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SpecialofferproductRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val specialofferid = jsonObj.get("specialofferid").toRight("Missing field 'specialofferid'").flatMap(_.as(SpecialofferId.jsonDecoder))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (specialofferid.isRight && productid.isRight && rowguid.isRight && modifieddate.isRight)
      Right(SpecialofferproductRow(specialofferid = specialofferid.toOption.get, productid = productid.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](specialofferid, productid, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SpecialofferproductRow] = new JsonEncoder[SpecialofferproductRow] {
    override def unsafeEncode(a: SpecialofferproductRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""specialofferid":""")
      SpecialofferId.jsonEncoder.unsafeEncode(a.specialofferid, indent, out)
      out.write(",")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[SpecialofferproductRow] = Text.instance[SpecialofferproductRow]{ (row, sb) =>
    SpecialofferId.text.unsafeEncode(row.specialofferid, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
