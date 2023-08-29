/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class StViewRow(
  /** Points to [[sales.salesterritory.SalesterritoryRow.territoryid]] */
  id: SalesterritoryId,
  /** Points to [[sales.salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Points to [[sales.salesterritory.SalesterritoryRow.name]] */
  name: Name,
  /** Points to [[sales.salesterritory.SalesterritoryRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Points to [[sales.salesterritory.SalesterritoryRow.group]] */
  group: /* max 50 chars */ String,
  /** Points to [[sales.salesterritory.SalesterritoryRow.salesytd]] */
  salesytd: BigDecimal,
  /** Points to [[sales.salesterritory.SalesterritoryRow.saleslastyear]] */
  saleslastyear: BigDecimal,
  /** Points to [[sales.salesterritory.SalesterritoryRow.costytd]] */
  costytd: BigDecimal,
  /** Points to [[sales.salesterritory.SalesterritoryRow.costlastyear]] */
  costlastyear: BigDecimal,
  /** Points to [[sales.salesterritory.SalesterritoryRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[sales.salesterritory.SalesterritoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object StViewRow {
  implicit lazy val decoder: Decoder[StViewRow] = Decoder.forProduct11[StViewRow, SalesterritoryId, SalesterritoryId, Name, CountryregionId, /* max 50 chars */ String, BigDecimal, BigDecimal, BigDecimal, BigDecimal, UUID, TypoLocalDateTime]("id", "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")(StViewRow.apply)(SalesterritoryId.decoder, SalesterritoryId.decoder, Name.decoder, CountryregionId.decoder, Decoder.decodeString, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[StViewRow] = Encoder.forProduct11[StViewRow, SalesterritoryId, SalesterritoryId, Name, CountryregionId, /* max 50 chars */ String, BigDecimal, BigDecimal, BigDecimal, BigDecimal, UUID, TypoLocalDateTime]("id", "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")(x => (x.id, x.territoryid, x.name, x.countryregioncode, x.group, x.salesytd, x.saleslastyear, x.costytd, x.costlastyear, x.rowguid, x.modifieddate))(SalesterritoryId.encoder, SalesterritoryId.encoder, Name.encoder, CountryregionId.encoder, Encoder.encodeString, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[StViewRow] = new Read[StViewRow](
    gets = List(
      (SalesterritoryId.get, Nullability.NoNulls),
      (SalesterritoryId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (CountryregionId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => StViewRow(
      id = SalesterritoryId.get.unsafeGetNonNullable(rs, i + 0),
      territoryid = SalesterritoryId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      countryregioncode = CountryregionId.get.unsafeGetNonNullable(rs, i + 3),
      group = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4),
      salesytd = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 5),
      saleslastyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 6),
      costytd = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      costlastyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 8),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 9),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 10)
    )
  )
}
