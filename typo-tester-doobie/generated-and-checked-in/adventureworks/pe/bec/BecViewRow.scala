/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bec

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class BecViewRow(
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.personid]] */
  personid: BusinessentityId,
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.contacttypeid]] */
  contacttypeid: ContacttypeId,
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object BecViewRow {
  implicit lazy val decoder: Decoder[BecViewRow] = Decoder.forProduct6[BecViewRow, BusinessentityId, BusinessentityId, BusinessentityId, ContacttypeId, UUID, TypoLocalDateTime]("id", "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")(BecViewRow.apply)(BusinessentityId.decoder, BusinessentityId.decoder, BusinessentityId.decoder, ContacttypeId.decoder, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[BecViewRow] = Encoder.forProduct6[BecViewRow, BusinessentityId, BusinessentityId, BusinessentityId, ContacttypeId, UUID, TypoLocalDateTime]("id", "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")(x => (x.id, x.businessentityid, x.personid, x.contacttypeid, x.rowguid, x.modifieddate))(BusinessentityId.encoder, BusinessentityId.encoder, BusinessentityId.encoder, ContacttypeId.encoder, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[BecViewRow] = new Read[BecViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (ContacttypeId.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => BecViewRow(
      id = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
      personid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 2),
      contacttypeid = ContacttypeId.get.unsafeGetNonNullable(rs, i + 3),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
}
