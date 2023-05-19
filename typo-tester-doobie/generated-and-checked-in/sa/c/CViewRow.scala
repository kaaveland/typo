/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package c

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

case class CViewRow(
  id: Option[Int],
  /** Points to [[sales.customer.CustomerRow.customerid]] */
  customerid: Option[CustomerId],
  /** Points to [[sales.customer.CustomerRow.personid]] */
  personid: Option[BusinessentityId],
  /** Points to [[sales.customer.CustomerRow.storeid]] */
  storeid: Option[BusinessentityId],
  /** Points to [[sales.customer.CustomerRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.customer.CustomerRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.customer.CustomerRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object CViewRow {
  implicit val decoder: Decoder[CViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        customerid <- c.downField("customerid").as[Option[CustomerId]]
        personid <- c.downField("personid").as[Option[BusinessentityId]]
        storeid <- c.downField("storeid").as[Option[BusinessentityId]]
        territoryid <- c.downField("territoryid").as[Option[SalesterritoryId]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield CViewRow(id, customerid, personid, storeid, territoryid, rowguid, modifieddate)
  implicit val encoder: Encoder[CViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "customerid" := row.customerid,
        "personid" := row.personid,
        "storeid" := row.storeid,
        "territoryid" := row.territoryid,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}
