/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bec

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

case class BecViewRow(
  id: Option[Int],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.personid]] */
  personid: Option[BusinessentityId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.contacttypeid]] */
  contacttypeid: Option[ContacttypeId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object BecViewRow {
  implicit val decoder: Decoder[BecViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        businessentityid <- c.downField("businessentityid").as[Option[BusinessentityId]]
        personid <- c.downField("personid").as[Option[BusinessentityId]]
        contacttypeid <- c.downField("contacttypeid").as[Option[ContacttypeId]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield BecViewRow(id, businessentityid, personid, contacttypeid, rowguid, modifieddate)
  implicit val encoder: Encoder[BecViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "businessentityid" := row.businessentityid,
        "personid" := row.personid,
        "contacttypeid" := row.contacttypeid,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}
