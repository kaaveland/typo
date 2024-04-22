/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: sa.sp */
case class SpViewRow(
  /** Points to [[sales.salesperson.SalespersonRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[sales.salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[sales.salesperson.SalespersonRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.salesperson.SalespersonRow.salesquota]] */
  salesquota: Option[BigDecimal],
  /** Points to [[sales.salesperson.SalespersonRow.bonus]] */
  bonus: BigDecimal,
  /** Points to [[sales.salesperson.SalespersonRow.commissionpct]] */
  commissionpct: BigDecimal,
  /** Points to [[sales.salesperson.SalespersonRow.salesytd]] */
  salesytd: BigDecimal,
  /** Points to [[sales.salesperson.SalespersonRow.saleslastyear]] */
  saleslastyear: BigDecimal,
  /** Points to [[sales.salesperson.SalespersonRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[sales.salesperson.SalespersonRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SpViewRow {
  implicit lazy val decoder: Decoder[SpViewRow] = Decoder.forProduct10[SpViewRow, BusinessentityId, BusinessentityId, Option[SalesterritoryId], Option[BigDecimal], BigDecimal, BigDecimal, BigDecimal, BigDecimal, TypoUUID, TypoLocalDateTime]("id", "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")(SpViewRow.apply)(BusinessentityId.decoder, BusinessentityId.decoder, Decoder.decodeOption(SalesterritoryId.decoder), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SpViewRow] = Encoder.forProduct10[SpViewRow, BusinessentityId, BusinessentityId, Option[SalesterritoryId], Option[BigDecimal], BigDecimal, BigDecimal, BigDecimal, BigDecimal, TypoUUID, TypoLocalDateTime]("id", "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")(x => (x.id, x.businessentityid, x.territoryid, x.salesquota, x.bonus, x.commissionpct, x.salesytd, x.saleslastyear, x.rowguid, x.modifieddate))(BusinessentityId.encoder, BusinessentityId.encoder, Encoder.encodeOption(SalesterritoryId.encoder), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SpViewRow] = new Read[SpViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (SalesterritoryId.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SpViewRow(
      id = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 1),
      territoryid = SalesterritoryId.get.unsafeGetNullable(rs, i + 2),
      salesquota = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 3),
      bonus = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 4),
      commissionpct = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 5),
      salesytd = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 6),
      saleslastyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 9)
    )
  )
}
