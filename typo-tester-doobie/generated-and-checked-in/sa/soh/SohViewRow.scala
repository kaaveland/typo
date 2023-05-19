/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package soh

import adventureworks.person.address.AddressId
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.OrderNumber
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.sales.creditcard.CreditcardId
import adventureworks.sales.currencyrate.CurrencyrateId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesterritory.SalesterritoryId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

case class SohViewRow(
  id: Option[Int],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: Option[SalesorderheaderId],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.revisionnumber]] */
  revisionnumber: Option[Int],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.orderdate]] */
  orderdate: Option[LocalDateTime],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.duedate]] */
  duedate: Option[LocalDateTime],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.shipdate]] */
  shipdate: Option[LocalDateTime],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.status]] */
  status: Option[Int],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.onlineorderflag]] */
  onlineorderflag: Flag,
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.purchaseordernumber]] */
  purchaseordernumber: Option[OrderNumber],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.accountnumber]] */
  accountnumber: Option[AccountNumber],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.customerid]] */
  customerid: Option[CustomerId],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.salespersonid]] */
  salespersonid: Option[BusinessentityId],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.billtoaddressid]] */
  billtoaddressid: Option[AddressId],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.shiptoaddressid]] */
  shiptoaddressid: Option[AddressId],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.shipmethodid]] */
  shipmethodid: Option[ShipmethodId],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.creditcardid]] */
  creditcardid: Option[CreditcardId],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.creditcardapprovalcode]] */
  creditcardapprovalcode: Option[String],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.currencyrateid]] */
  currencyrateid: Option[CurrencyrateId],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.subtotal]] */
  subtotal: Option[BigDecimal],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.taxamt]] */
  taxamt: Option[BigDecimal],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.freight]] */
  freight: Option[BigDecimal],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.totaldue]] */
  totaldue: Option[BigDecimal],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.comment]] */
  comment: Option[String],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.salesorderheader.SalesorderheaderRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object SohViewRow {
  implicit val decoder: Decoder[SohViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        salesorderid <- c.downField("salesorderid").as[Option[SalesorderheaderId]]
        revisionnumber <- c.downField("revisionnumber").as[Option[Int]]
        orderdate <- c.downField("orderdate").as[Option[LocalDateTime]]
        duedate <- c.downField("duedate").as[Option[LocalDateTime]]
        shipdate <- c.downField("shipdate").as[Option[LocalDateTime]]
        status <- c.downField("status").as[Option[Int]]
        onlineorderflag <- c.downField("onlineorderflag").as[Flag]
        purchaseordernumber <- c.downField("purchaseordernumber").as[Option[OrderNumber]]
        accountnumber <- c.downField("accountnumber").as[Option[AccountNumber]]
        customerid <- c.downField("customerid").as[Option[CustomerId]]
        salespersonid <- c.downField("salespersonid").as[Option[BusinessentityId]]
        territoryid <- c.downField("territoryid").as[Option[SalesterritoryId]]
        billtoaddressid <- c.downField("billtoaddressid").as[Option[AddressId]]
        shiptoaddressid <- c.downField("shiptoaddressid").as[Option[AddressId]]
        shipmethodid <- c.downField("shipmethodid").as[Option[ShipmethodId]]
        creditcardid <- c.downField("creditcardid").as[Option[CreditcardId]]
        creditcardapprovalcode <- c.downField("creditcardapprovalcode").as[Option[String]]
        currencyrateid <- c.downField("currencyrateid").as[Option[CurrencyrateId]]
        subtotal <- c.downField("subtotal").as[Option[BigDecimal]]
        taxamt <- c.downField("taxamt").as[Option[BigDecimal]]
        freight <- c.downField("freight").as[Option[BigDecimal]]
        totaldue <- c.downField("totaldue").as[Option[BigDecimal]]
        comment <- c.downField("comment").as[Option[String]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield SohViewRow(id, salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, comment, rowguid, modifieddate)
  implicit val encoder: Encoder[SohViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "salesorderid" := row.salesorderid,
        "revisionnumber" := row.revisionnumber,
        "orderdate" := row.orderdate,
        "duedate" := row.duedate,
        "shipdate" := row.shipdate,
        "status" := row.status,
        "onlineorderflag" := row.onlineorderflag,
        "purchaseordernumber" := row.purchaseordernumber,
        "accountnumber" := row.accountnumber,
        "customerid" := row.customerid,
        "salespersonid" := row.salespersonid,
        "territoryid" := row.territoryid,
        "billtoaddressid" := row.billtoaddressid,
        "shiptoaddressid" := row.shiptoaddressid,
        "shipmethodid" := row.shipmethodid,
        "creditcardid" := row.creditcardid,
        "creditcardapprovalcode" := row.creditcardapprovalcode,
        "currencyrateid" := row.currencyrateid,
        "subtotal" := row.subtotal,
        "taxamt" := row.taxamt,
        "freight" := row.freight,
        "totaldue" := row.totaldue,
        "comment" := row.comment,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}
