/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** Table: sales.shoppingcartitem
    Contains online customer orders until the order is submitted or cancelled.
    Primary key: shoppingcartitemid */
case class ShoppingcartitemRow(
  /** Primary key for ShoppingCartItem records.
      Default: nextval('sales.shoppingcartitem_shoppingcartitemid_seq'::regclass) */
  shoppingcartitemid: ShoppingcartitemId,
  /** Shopping cart identification number. */
  shoppingcartid: /* max 50 chars */ String,
  /** Product quantity ordered.
      Default: 1
      Constraint CK_ShoppingCartItem_Quantity affecting columns quantity: ((quantity >= 1)) */
  quantity: Int,
  /** Product ordered. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Date the time the record was created.
      Default: now() */
  datecreated: TypoLocalDateTime,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object ShoppingcartitemRow {
  implicit lazy val reads: Reads[ShoppingcartitemRow] = Reads[ShoppingcartitemRow](json => JsResult.fromTry(
      Try(
        ShoppingcartitemRow(
          shoppingcartitemid = json.\("shoppingcartitemid").as(ShoppingcartitemId.reads),
          shoppingcartid = json.\("shoppingcartid").as(Reads.StringReads),
          quantity = json.\("quantity").as(Reads.IntReads),
          productid = json.\("productid").as(ProductId.reads),
          datecreated = json.\("datecreated").as(TypoLocalDateTime.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ShoppingcartitemRow] = RowParser[ShoppingcartitemRow] { row =>
    Success(
      ShoppingcartitemRow(
        shoppingcartitemid = row(idx + 0)(ShoppingcartitemId.column),
        shoppingcartid = row(idx + 1)(Column.columnToString),
        quantity = row(idx + 2)(Column.columnToInt),
        productid = row(idx + 3)(ProductId.column),
        datecreated = row(idx + 4)(TypoLocalDateTime.column),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[ShoppingcartitemRow] = Text.instance[ShoppingcartitemRow]{ (row, sb) =>
    ShoppingcartitemId.text.unsafeEncode(row.shoppingcartitemid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.shoppingcartid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.quantity, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.datecreated, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ShoppingcartitemRow] = OWrites[ShoppingcartitemRow](o =>
    new JsObject(ListMap[String, JsValue](
      "shoppingcartitemid" -> ShoppingcartitemId.writes.writes(o.shoppingcartitemid),
      "shoppingcartid" -> Writes.StringWrites.writes(o.shoppingcartid),
      "quantity" -> Writes.IntWrites.writes(o.quantity),
      "productid" -> ProductId.writes.writes(o.productid),
      "datecreated" -> TypoLocalDateTime.writes.writes(o.datecreated),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
