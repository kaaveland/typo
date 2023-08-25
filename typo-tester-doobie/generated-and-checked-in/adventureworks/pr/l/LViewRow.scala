/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package l

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class LViewRow(
  id: Int,
  /** Points to [[production.location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Points to [[production.location.LocationRow.name]] */
  name: Name,
  /** Points to [[production.location.LocationRow.costrate]] */
  costrate: BigDecimal,
  /** Points to [[production.location.LocationRow.availability]] */
  availability: BigDecimal,
  /** Points to [[production.location.LocationRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object LViewRow {
  implicit lazy val decoder: Decoder[LViewRow] = Decoder.forProduct6[LViewRow, Int, LocationId, Name, BigDecimal, BigDecimal, TypoLocalDateTime]("id", "locationid", "name", "costrate", "availability", "modifieddate")(LViewRow.apply)(Decoder.decodeInt, LocationId.decoder, Name.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[LViewRow] = Encoder.forProduct6[LViewRow, Int, LocationId, Name, BigDecimal, BigDecimal, TypoLocalDateTime]("id", "locationid", "name", "costrate", "availability", "modifieddate")(x => (x.id, x.locationid, x.name, x.costrate, x.availability, x.modifieddate))(Encoder.encodeInt, LocationId.encoder, Name.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[LViewRow] = new Read[LViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (LocationId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => LViewRow(
      id = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      locationid = LocationId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      costrate = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 3),
      availability = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
}
