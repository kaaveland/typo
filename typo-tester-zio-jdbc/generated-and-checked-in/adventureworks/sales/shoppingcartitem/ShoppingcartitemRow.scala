/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class ShoppingcartitemRow(
  /** Primary key for ShoppingCartItem records. */
  shoppingcartitemid: ShoppingcartitemId,
  /** Shopping cart identification number. */
  shoppingcartid: /* max 50 chars */ String,
  /** Product quantity ordered.
      Constraint CK_ShoppingCartItem_Quantity affecting columns "quantity":  ((quantity >= 1)) */
  quantity: Int,
  /** Product ordered. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Date the time the record was created. */
  datecreated: TypoLocalDateTime,
  modifieddate: TypoLocalDateTime
)

object ShoppingcartitemRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ShoppingcartitemRow] = new JdbcDecoder[ShoppingcartitemRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ShoppingcartitemRow) =
      columIndex + 5 ->
        ShoppingcartitemRow(
          shoppingcartitemid = ShoppingcartitemId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          shoppingcartid = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          quantity = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 2, rs)._2,
          productid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          datecreated = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ShoppingcartitemRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val shoppingcartitemid = jsonObj.get("shoppingcartitemid").toRight("Missing field 'shoppingcartitemid'").flatMap(_.as(ShoppingcartitemId.jsonDecoder))
    val shoppingcartid = jsonObj.get("shoppingcartid").toRight("Missing field 'shoppingcartid'").flatMap(_.as(JsonDecoder.string))
    val quantity = jsonObj.get("quantity").toRight("Missing field 'quantity'").flatMap(_.as(JsonDecoder.int))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(ProductId.jsonDecoder))
    val datecreated = jsonObj.get("datecreated").toRight("Missing field 'datecreated'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (shoppingcartitemid.isRight && shoppingcartid.isRight && quantity.isRight && productid.isRight && datecreated.isRight && modifieddate.isRight)
      Right(ShoppingcartitemRow(shoppingcartitemid = shoppingcartitemid.toOption.get, shoppingcartid = shoppingcartid.toOption.get, quantity = quantity.toOption.get, productid = productid.toOption.get, datecreated = datecreated.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ShoppingcartitemRow] = new JsonEncoder[ShoppingcartitemRow] {
    override def unsafeEncode(a: ShoppingcartitemRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""shoppingcartitemid":""")
      ShoppingcartitemId.jsonEncoder.unsafeEncode(a.shoppingcartitemid, indent, out)
      out.write(",")
      out.write(""""shoppingcartid":""")
      JsonEncoder.string.unsafeEncode(a.shoppingcartid, indent, out)
      out.write(",")
      out.write(""""quantity":""")
      JsonEncoder.int.unsafeEncode(a.quantity, indent, out)
      out.write(",")
      out.write(""""productid":""")
      ProductId.jsonEncoder.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""datecreated":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.datecreated, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}