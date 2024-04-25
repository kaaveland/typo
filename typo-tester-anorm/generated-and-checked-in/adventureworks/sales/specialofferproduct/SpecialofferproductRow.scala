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
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Table: sales.specialofferproduct
    Cross-reference table mapping products to special offer discounts.
    Composite primary key: specialofferid, productid */
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
  def apply(compositeId: SpecialofferproductId, rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new SpecialofferproductRow(compositeId.specialofferid, compositeId.productid, rowguid, modifieddate)
  implicit lazy val reads: Reads[SpecialofferproductRow] = Reads[SpecialofferproductRow](json => JsResult.fromTry(
      Try(
        SpecialofferproductRow(
          specialofferid = json.\("specialofferid").as(SpecialofferId.reads),
          productid = json.\("productid").as(ProductId.reads),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SpecialofferproductRow] = RowParser[SpecialofferproductRow] { row =>
    Success(
      SpecialofferproductRow(
        specialofferid = row(idx + 0)(SpecialofferId.column),
        productid = row(idx + 1)(ProductId.column),
        rowguid = row(idx + 2)(TypoUUID.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
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
  implicit lazy val writes: OWrites[SpecialofferproductRow] = OWrites[SpecialofferproductRow](o =>
    new JsObject(ListMap[String, JsValue](
      "specialofferid" -> SpecialofferId.writes.writes(o.specialofferid),
      "productid" -> ProductId.writes.writes(o.productid),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
