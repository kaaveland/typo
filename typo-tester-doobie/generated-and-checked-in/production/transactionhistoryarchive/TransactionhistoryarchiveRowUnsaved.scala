/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import adventureworks.Defaulted
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

/** This class corresponds to a row in table `production.transactionhistoryarchive` which has not been persisted yet */
case class TransactionhistoryarchiveRowUnsaved(
  /** Primary key for TransactionHistoryArchive records. */
  transactionid: TransactionhistoryarchiveId,
  /** Product identification number. Foreign key to Product.ProductID. */
  productid: Int,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** W = Work Order, S = Sales Order, P = Purchase Order */
  transactiontype: /* bpchar */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  /** Default: 0
      Line number associated with the purchase order, sales order, or work order. */
  referenceorderlineid: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date and time of the transaction. */
  transactiondate: Defaulted[LocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(referenceorderlineidDefault: => Int, transactiondateDefault: => LocalDateTime, modifieddateDefault: => LocalDateTime): TransactionhistoryarchiveRow =
    TransactionhistoryarchiveRow(
      transactionid = transactionid,
      productid = productid,
      referenceorderid = referenceorderid,
      transactiontype = transactiontype,
      quantity = quantity,
      actualcost = actualcost,
      referenceorderlineid = referenceorderlineid match {
                               case Defaulted.UseDefault => referenceorderlineidDefault
                               case Defaulted.Provided(value) => value
                             },
      transactiondate = transactiondate match {
                          case Defaulted.UseDefault => transactiondateDefault
                          case Defaulted.Provided(value) => value
                        },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object TransactionhistoryarchiveRowUnsaved {
  implicit val decoder: Decoder[TransactionhistoryarchiveRowUnsaved] =
    (c: HCursor) =>
      for {
        transactionid <- c.downField("transactionid").as[TransactionhistoryarchiveId]
        productid <- c.downField("productid").as[Int]
        referenceorderid <- c.downField("referenceorderid").as[Int]
        transactiontype <- c.downField("transactiontype").as[/* bpchar */ String]
        quantity <- c.downField("quantity").as[Int]
        actualcost <- c.downField("actualcost").as[BigDecimal]
        referenceorderlineid <- c.downField("referenceorderlineid").as[Defaulted[Int]]
        transactiondate <- c.downField("transactiondate").as[Defaulted[LocalDateTime]]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield TransactionhistoryarchiveRowUnsaved(transactionid, productid, referenceorderid, transactiontype, quantity, actualcost, referenceorderlineid, transactiondate, modifieddate)
  implicit val encoder: Encoder[TransactionhistoryarchiveRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "transactionid" := row.transactionid,
        "productid" := row.productid,
        "referenceorderid" := row.referenceorderid,
        "transactiontype" := row.transactiontype,
        "quantity" := row.quantity,
        "actualcost" := row.actualcost,
        "referenceorderlineid" := row.referenceorderlineid,
        "transactiondate" := row.transactiondate,
        "modifieddate" := row.modifieddate
      )}
}
