/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ShipmethodRow(
  /** Primary key for ShipMethod records. */
  shipmethodid: ShipmethodId,
  /** Shipping company name. */
  name: Name,
  /** Minimum shipping charge.
      Constraint CK_ShipMethod_ShipBase affecting columns shipbase: ((shipbase > 0.00)) */
  shipbase: BigDecimal,
  /** Shipping charge per pound.
      Constraint CK_ShipMethod_ShipRate affecting columns shiprate: ((shiprate > 0.00)) */
  shiprate: BigDecimal,
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
)

object ShipmethodRow {
  implicit lazy val decoder: Decoder[ShipmethodRow] = Decoder.forProduct6[ShipmethodRow, ShipmethodId, Name, BigDecimal, BigDecimal, TypoUUID, TypoLocalDateTime]("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")(ShipmethodRow.apply)(ShipmethodId.decoder, Name.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ShipmethodRow] = Encoder.forProduct6[ShipmethodRow, ShipmethodId, Name, BigDecimal, BigDecimal, TypoUUID, TypoLocalDateTime]("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")(x => (x.shipmethodid, x.name, x.shipbase, x.shiprate, x.rowguid, x.modifieddate))(ShipmethodId.encoder, Name.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ShipmethodRow] = new Read[ShipmethodRow](
    gets = List(
      (ShipmethodId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ShipmethodRow(
      shipmethodid = ShipmethodId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      shipbase = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 2),
      shiprate = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 3),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
  implicit lazy val text: Text[ShipmethodRow] = Text.instance[ShipmethodRow]{ (row, sb) =>
    ShipmethodId.text.unsafeEncode(row.shipmethodid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.shipbase, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.shiprate, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
