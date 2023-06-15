/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package tha

import adventureworks.production.transactionhistoryarchive.TransactionhistoryarchiveId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

case class ThaViewRow(
  id: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.transactionid]] */
  transactionid: Option[TransactionhistoryarchiveId],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.productid]] */
  productid: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.referenceorderid]] */
  referenceorderid: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.referenceorderlineid]] */
  referenceorderlineid: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.transactiondate]] */
  transactiondate: Option[LocalDateTime],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.transactiontype]] */
  transactiontype: Option[/* bpchar */ String],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.quantity]] */
  quantity: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.actualcost]] */
  actualcost: Option[BigDecimal],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object ThaViewRow {
  implicit val decoder: Decoder[ThaViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        transactionid <- c.downField("transactionid").as[Option[TransactionhistoryarchiveId]]
        productid <- c.downField("productid").as[Option[Int]]
        referenceorderid <- c.downField("referenceorderid").as[Option[Int]]
        referenceorderlineid <- c.downField("referenceorderlineid").as[Option[Int]]
        transactiondate <- c.downField("transactiondate").as[Option[LocalDateTime]]
        transactiontype <- c.downField("transactiontype").as[Option[/* bpchar */ String]]
        quantity <- c.downField("quantity").as[Option[Int]]
        actualcost <- c.downField("actualcost").as[Option[BigDecimal]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield ThaViewRow(id, transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)
  implicit val encoder: Encoder[ThaViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "transactionid" := row.transactionid,
        "productid" := row.productid,
        "referenceorderid" := row.referenceorderid,
        "referenceorderlineid" := row.referenceorderlineid,
        "transactiondate" := row.transactiondate,
        "transactiontype" := row.transactiontype,
        "quantity" := row.quantity,
        "actualcost" := row.actualcost,
        "modifieddate" := row.modifieddate
      )}
}