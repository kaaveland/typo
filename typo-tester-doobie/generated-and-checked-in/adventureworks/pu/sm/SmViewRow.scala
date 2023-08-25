/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.purchasing.shipmethod.ShipmethodId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class SmViewRow(
  id: Int,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.name]] */
  name: Name,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shipbase]] */
  shipbase: BigDecimal,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.shiprate]] */
  shiprate: BigDecimal,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[purchasing.shipmethod.ShipmethodRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SmViewRow {
  implicit lazy val decoder: Decoder[SmViewRow] = Decoder.forProduct7[SmViewRow, Int, ShipmethodId, Name, BigDecimal, BigDecimal, UUID, TypoLocalDateTime]("id", "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")(SmViewRow.apply)(Decoder.decodeInt, ShipmethodId.decoder, Name.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SmViewRow] = Encoder.forProduct7[SmViewRow, Int, ShipmethodId, Name, BigDecimal, BigDecimal, UUID, TypoLocalDateTime]("id", "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")(x => (x.id, x.shipmethodid, x.name, x.shipbase, x.shiprate, x.rowguid, x.modifieddate))(Encoder.encodeInt, ShipmethodId.encoder, Name.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SmViewRow] = new Read[SmViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (ShipmethodId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SmViewRow(
      id = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      shipmethodid = ShipmethodId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      shipbase = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 3),
      shiprate = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 4),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6)
    )
  )
}
