/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package so

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.specialoffer.SpecialofferId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class SoViewRow(
  id: Int,
  /** Points to [[sales.specialoffer.SpecialofferRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Points to [[sales.specialoffer.SpecialofferRow.description]] */
  description: /* max 255 chars */ String,
  /** Points to [[sales.specialoffer.SpecialofferRow.discountpct]] */
  discountpct: BigDecimal,
  /** Points to [[sales.specialoffer.SpecialofferRow.type]] */
  `type`: /* max 50 chars */ String,
  /** Points to [[sales.specialoffer.SpecialofferRow.category]] */
  category: /* max 50 chars */ String,
  /** Points to [[sales.specialoffer.SpecialofferRow.startdate]] */
  startdate: TypoLocalDateTime,
  /** Points to [[sales.specialoffer.SpecialofferRow.enddate]] */
  enddate: TypoLocalDateTime,
  /** Points to [[sales.specialoffer.SpecialofferRow.minqty]] */
  minqty: Int,
  /** Points to [[sales.specialoffer.SpecialofferRow.maxqty]] */
  maxqty: Int,
  /** Points to [[sales.specialoffer.SpecialofferRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[sales.specialoffer.SpecialofferRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SoViewRow {
  implicit lazy val decoder: Decoder[SoViewRow] = Decoder.forProduct12[SoViewRow, Int, SpecialofferId, /* max 255 chars */ String, BigDecimal, /* max 50 chars */ String, /* max 50 chars */ String, TypoLocalDateTime, TypoLocalDateTime, Int, Int, UUID, TypoLocalDateTime]("id", "specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")(SoViewRow.apply)(Decoder.decodeInt, SpecialofferId.decoder, Decoder.decodeString, Decoder.decodeBigDecimal, Decoder.decodeString, Decoder.decodeString, TypoLocalDateTime.decoder, TypoLocalDateTime.decoder, Decoder.decodeInt, Decoder.decodeInt, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SoViewRow] = Encoder.forProduct12[SoViewRow, Int, SpecialofferId, /* max 255 chars */ String, BigDecimal, /* max 50 chars */ String, /* max 50 chars */ String, TypoLocalDateTime, TypoLocalDateTime, Int, Int, UUID, TypoLocalDateTime]("id", "specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")(x => (x.id, x.specialofferid, x.description, x.discountpct, x.`type`, x.category, x.startdate, x.enddate, x.minqty, x.maxqty, x.rowguid, x.modifieddate))(Encoder.encodeInt, SpecialofferId.encoder, Encoder.encodeString, Encoder.encodeBigDecimal, Encoder.encodeString, Encoder.encodeString, TypoLocalDateTime.encoder, TypoLocalDateTime.encoder, Encoder.encodeInt, Encoder.encodeInt, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SoViewRow] = new Read[SoViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (SpecialofferId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SoViewRow(
      id = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      specialofferid = SpecialofferId.get.unsafeGetNonNullable(rs, i + 1),
      description = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      discountpct = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 3),
      `type` = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4),
      category = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      startdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6),
      enddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 7),
      minqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 8),
      maxqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 9),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 10),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 11)
    )
  )
}
