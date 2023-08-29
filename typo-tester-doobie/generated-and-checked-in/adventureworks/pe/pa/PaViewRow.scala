/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class PaViewRow(
  /** Points to [[person.password.PasswordRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[person.password.PasswordRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.password.PasswordRow.passwordhash]] */
  passwordhash: /* max 128 chars */ String,
  /** Points to [[person.password.PasswordRow.passwordsalt]] */
  passwordsalt: /* max 10 chars */ String,
  /** Points to [[person.password.PasswordRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[person.password.PasswordRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PaViewRow {
  implicit lazy val decoder: Decoder[PaViewRow] = Decoder.forProduct6[PaViewRow, BusinessentityId, BusinessentityId, /* max 128 chars */ String, /* max 10 chars */ String, UUID, TypoLocalDateTime]("id", "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")(PaViewRow.apply)(BusinessentityId.decoder, BusinessentityId.decoder, Decoder.decodeString, Decoder.decodeString, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PaViewRow] = Encoder.forProduct6[PaViewRow, BusinessentityId, BusinessentityId, /* max 128 chars */ String, /* max 10 chars */ String, UUID, TypoLocalDateTime]("id", "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")(x => (x.id, x.businessentityid, x.passwordhash, x.passwordsalt, x.rowguid, x.modifieddate))(BusinessentityId.encoder, BusinessentityId.encoder, Encoder.encodeString, Encoder.encodeString, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PaViewRow] = new Read[PaViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PaViewRow(
      id = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
      passwordhash = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      passwordsalt = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
}
