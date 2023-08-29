/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class BeViewRow(
  /** Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.businessentity.BusinessentityRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[person.businessentity.BusinessentityRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object BeViewRow {
  implicit lazy val decoder: Decoder[BeViewRow] = Decoder.forProduct4[BeViewRow, BusinessentityId, BusinessentityId, UUID, TypoLocalDateTime]("id", "businessentityid", "rowguid", "modifieddate")(BeViewRow.apply)(BusinessentityId.decoder, BusinessentityId.decoder, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[BeViewRow] = Encoder.forProduct4[BeViewRow, BusinessentityId, BusinessentityId, UUID, TypoLocalDateTime]("id", "businessentityid", "rowguid", "modifieddate")(x => (x.id, x.businessentityid, x.rowguid, x.modifieddate))(BusinessentityId.encoder, BusinessentityId.encoder, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[BeViewRow] = new Read[BeViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => BeViewRow(
      id = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
