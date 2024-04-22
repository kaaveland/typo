/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

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

/** Table: production.productcosthistory
    Changes in the cost of a product over time.
    Composite primary key: productid, startdate */
case class ProductcosthistoryRow(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product cost start date.
      Constraint CK_ProductCostHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Product cost end date.
      Constraint CK_ProductCostHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Standard cost of the product.
      Constraint CK_ProductCostHistory_StandardCost affecting columns standardcost: ((standardcost >= 0.00)) */
  standardcost: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductcosthistoryId = ProductcosthistoryId(productid, startdate)
 }

object ProductcosthistoryRow {
  implicit lazy val reads: Reads[ProductcosthistoryRow] = Reads[ProductcosthistoryRow](json => JsResult.fromTry(
      Try(
        ProductcosthistoryRow(
          productid = json.\("productid").as(ProductId.reads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          standardcost = json.\("standardcost").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductcosthistoryRow] = RowParser[ProductcosthistoryRow] { row =>
    Success(
      ProductcosthistoryRow(
        productid = row(idx + 0)(ProductId.column),
        startdate = row(idx + 1)(TypoLocalDateTime.column),
        enddate = row(idx + 2)(Column.columnToOption(TypoLocalDateTime.column)),
        standardcost = row(idx + 3)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 4)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[ProductcosthistoryRow] = Text.instance[ProductcosthistoryRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.standardcost, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ProductcosthistoryRow] = OWrites[ProductcosthistoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "standardcost" -> Writes.BigDecimalWrites.writes(o.standardcost),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
