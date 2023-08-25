/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package um

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class UmViewRow(
  id: /* bpchar, max 3 chars */ String,
  /** Points to [[production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Points to [[production.unitmeasure.UnitmeasureRow.name]] */
  name: Name,
  /** Points to [[production.unitmeasure.UnitmeasureRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object UmViewRow {
  implicit lazy val decoder: Decoder[UmViewRow] = Decoder.forProduct4[UmViewRow, /* bpchar, max 3 chars */ String, UnitmeasureId, Name, TypoLocalDateTime]("id", "unitmeasurecode", "name", "modifieddate")(UmViewRow.apply)(Decoder.decodeString, UnitmeasureId.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[UmViewRow] = Encoder.forProduct4[UmViewRow, /* bpchar, max 3 chars */ String, UnitmeasureId, Name, TypoLocalDateTime]("id", "unitmeasurecode", "name", "modifieddate")(x => (x.id, x.unitmeasurecode, x.name, x.modifieddate))(Encoder.encodeString, UnitmeasureId.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[UmViewRow] = new Read[UmViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.NoNulls),
      (UnitmeasureId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => UmViewRow(
      id = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 0),
      unitmeasurecode = UnitmeasureId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
