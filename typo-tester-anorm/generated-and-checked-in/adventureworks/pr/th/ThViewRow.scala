/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package th

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.transactionhistory.TransactionhistoryId
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

/** View: pr.th */
case class ThViewRow(
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactionid]] */
  id: TransactionhistoryId,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactionid]] */
  transactionid: TransactionhistoryId,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.productid]] */
  productid: ProductId,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.referenceorderid]] */
  referenceorderid: Int,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.referenceorderlineid]] */
  referenceorderlineid: Int,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactiondate]] */
  transactiondate: TypoLocalDateTime,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactiontype]] */
  transactiontype: /* bpchar, max 1 chars */ String,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.quantity]] */
  quantity: Int,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.actualcost]] */
  actualcost: BigDecimal,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object ThViewRow {
  implicit lazy val reads: Reads[ThViewRow] = Reads[ThViewRow](json => JsResult.fromTry(
      Try(
        ThViewRow(
          id = json.\("id").as(TransactionhistoryId.reads),
          transactionid = json.\("transactionid").as(TransactionhistoryId.reads),
          productid = json.\("productid").as(ProductId.reads),
          referenceorderid = json.\("referenceorderid").as(Reads.IntReads),
          referenceorderlineid = json.\("referenceorderlineid").as(Reads.IntReads),
          transactiondate = json.\("transactiondate").as(TypoLocalDateTime.reads),
          transactiontype = json.\("transactiontype").as(Reads.StringReads),
          quantity = json.\("quantity").as(Reads.IntReads),
          actualcost = json.\("actualcost").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ThViewRow] = RowParser[ThViewRow] { row =>
    Success(
      ThViewRow(
        id = row(idx + 0)(TransactionhistoryId.column),
        transactionid = row(idx + 1)(TransactionhistoryId.column),
        productid = row(idx + 2)(ProductId.column),
        referenceorderid = row(idx + 3)(Column.columnToInt),
        referenceorderlineid = row(idx + 4)(Column.columnToInt),
        transactiondate = row(idx + 5)(TypoLocalDateTime.column),
        transactiontype = row(idx + 6)(Column.columnToString),
        quantity = row(idx + 7)(Column.columnToInt),
        actualcost = row(idx + 8)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 9)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ThViewRow] = OWrites[ThViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> TransactionhistoryId.writes.writes(o.id),
      "transactionid" -> TransactionhistoryId.writes.writes(o.transactionid),
      "productid" -> ProductId.writes.writes(o.productid),
      "referenceorderid" -> Writes.IntWrites.writes(o.referenceorderid),
      "referenceorderlineid" -> Writes.IntWrites.writes(o.referenceorderlineid),
      "transactiondate" -> TypoLocalDateTime.writes.writes(o.transactiondate),
      "transactiontype" -> Writes.StringWrites.writes(o.transactiontype),
      "quantity" -> Writes.IntWrites.writes(o.quantity),
      "actualcost" -> Writes.BigDecimalWrites.writes(o.actualcost),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
