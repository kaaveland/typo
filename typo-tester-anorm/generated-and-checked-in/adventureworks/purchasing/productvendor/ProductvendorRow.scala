/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
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

case class ProductvendorRow(
  /** Primary key. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Primary key. Foreign key to Vendor.BusinessEntityID.
      Points to [[vendor.VendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** The average span of time (in days) between placing an order with the vendor and receiving the purchased product.
      Constraint CK_ProductVendor_AverageLeadTime affecting columns averageleadtime: ((averageleadtime >= 1)) */
  averageleadtime: Int,
  /** The vendor's usual selling price.
      Constraint CK_ProductVendor_StandardPrice affecting columns standardprice: ((standardprice > 0.00)) */
  standardprice: BigDecimal,
  /** The selling price when last purchased.
      Constraint CK_ProductVendor_LastReceiptCost affecting columns lastreceiptcost: ((lastreceiptcost > 0.00)) */
  lastreceiptcost: Option[BigDecimal],
  /** Date the product was last received by the vendor. */
  lastreceiptdate: Option[TypoLocalDateTime],
  /** The maximum quantity that should be ordered.
      Constraint CK_ProductVendor_MinOrderQty affecting columns minorderqty: ((minorderqty >= 1)) */
  minorderqty: Int,
  /** The minimum quantity that should be ordered.
      Constraint CK_ProductVendor_MaxOrderQty affecting columns maxorderqty: ((maxorderqty >= 1)) */
  maxorderqty: Int,
  /** The quantity currently on order.
      Constraint CK_ProductVendor_OnOrderQty affecting columns onorderqty: ((onorderqty >= 0)) */
  onorderqty: Option[Int],
  /** The product's unit of measure.
      Points to [[production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductvendorId = ProductvendorId(productid, businessentityid)
 }

object ProductvendorRow {
  implicit lazy val reads: Reads[ProductvendorRow] = Reads[ProductvendorRow](json => JsResult.fromTry(
      Try(
        ProductvendorRow(
          productid = json.\("productid").as(ProductId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          averageleadtime = json.\("averageleadtime").as(Reads.IntReads),
          standardprice = json.\("standardprice").as(Reads.bigDecReads),
          lastreceiptcost = json.\("lastreceiptcost").toOption.map(_.as(Reads.bigDecReads)),
          lastreceiptdate = json.\("lastreceiptdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          minorderqty = json.\("minorderqty").as(Reads.IntReads),
          maxorderqty = json.\("maxorderqty").as(Reads.IntReads),
          onorderqty = json.\("onorderqty").toOption.map(_.as(Reads.IntReads)),
          unitmeasurecode = json.\("unitmeasurecode").as(UnitmeasureId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductvendorRow] = RowParser[ProductvendorRow] { row =>
    Success(
      ProductvendorRow(
        productid = row(idx + 0)(ProductId.column),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        averageleadtime = row(idx + 2)(Column.columnToInt),
        standardprice = row(idx + 3)(Column.columnToScalaBigDecimal),
        lastreceiptcost = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        lastreceiptdate = row(idx + 5)(Column.columnToOption(TypoLocalDateTime.column)),
        minorderqty = row(idx + 6)(Column.columnToInt),
        maxorderqty = row(idx + 7)(Column.columnToInt),
        onorderqty = row(idx + 8)(Column.columnToOption(Column.columnToInt)),
        unitmeasurecode = row(idx + 9)(UnitmeasureId.column),
        modifieddate = row(idx + 10)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[ProductvendorRow] = Text.instance[ProductvendorRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.averageleadtime, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.standardprice, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.bigDecimalInstance).unsafeEncode(row.lastreceiptcost, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.lastreceiptdate, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.minorderqty, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.maxorderqty, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.intInstance).unsafeEncode(row.onorderqty, sb)
    sb.append(Text.DELIMETER)
    UnitmeasureId.text.unsafeEncode(row.unitmeasurecode, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ProductvendorRow] = OWrites[ProductvendorRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "averageleadtime" -> Writes.IntWrites.writes(o.averageleadtime),
      "standardprice" -> Writes.BigDecimalWrites.writes(o.standardprice),
      "lastreceiptcost" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.lastreceiptcost),
      "lastreceiptdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.lastreceiptdate),
      "minorderqty" -> Writes.IntWrites.writes(o.minorderqty),
      "maxorderqty" -> Writes.IntWrites.writes(o.maxorderqty),
      "onorderqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.onorderqty),
      "unitmeasurecode" -> UnitmeasureId.writes.writes(o.unitmeasurecode),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
