/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package poh

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import adventureworks.purchasing.shipmethod.ShipmethodId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PohViewRow(
  id: Int,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.purchaseorderid]] */
  purchaseorderid: PurchaseorderheaderId,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.revisionnumber]] */
  revisionnumber: Int,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.status]] */
  status: Int,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.employeeid]] */
  employeeid: BusinessentityId,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.vendorid]] */
  vendorid: BusinessentityId,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.orderdate]] */
  orderdate: TypoLocalDateTime,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.shipdate]] */
  shipdate: TypoLocalDateTime,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.subtotal]] */
  subtotal: BigDecimal,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.taxamt]] */
  taxamt: BigDecimal,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.freight]] */
  freight: BigDecimal,
  /** Points to [[purchasing.purchaseorderheader.PurchaseorderheaderRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PohViewRow {
  implicit lazy val decoder: Decoder[PohViewRow] = Decoder.forProduct13[PohViewRow, Int, PurchaseorderheaderId, Int, Int, BusinessentityId, BusinessentityId, ShipmethodId, TypoLocalDateTime, TypoLocalDateTime, BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("id", "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")(PohViewRow.apply)(Decoder.decodeInt, PurchaseorderheaderId.decoder, Decoder.decodeInt, Decoder.decodeInt, BusinessentityId.decoder, BusinessentityId.decoder, ShipmethodId.decoder, TypoLocalDateTime.decoder, TypoLocalDateTime.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PohViewRow] = Encoder.forProduct13[PohViewRow, Int, PurchaseorderheaderId, Int, Int, BusinessentityId, BusinessentityId, ShipmethodId, TypoLocalDateTime, TypoLocalDateTime, BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("id", "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")(x => (x.id, x.purchaseorderid, x.revisionnumber, x.status, x.employeeid, x.vendorid, x.shipmethodid, x.orderdate, x.shipdate, x.subtotal, x.taxamt, x.freight, x.modifieddate))(Encoder.encodeInt, PurchaseorderheaderId.encoder, Encoder.encodeInt, Encoder.encodeInt, BusinessentityId.encoder, BusinessentityId.encoder, ShipmethodId.encoder, TypoLocalDateTime.encoder, TypoLocalDateTime.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PohViewRow] = new Read[PohViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (PurchaseorderheaderId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (ShipmethodId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PohViewRow(
      id = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      purchaseorderid = PurchaseorderheaderId.get.unsafeGetNonNullable(rs, i + 1),
      revisionnumber = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      status = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      employeeid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 4),
      vendorid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 5),
      shipmethodid = ShipmethodId.get.unsafeGetNonNullable(rs, i + 6),
      orderdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 7),
      shipdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8),
      subtotal = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 9),
      taxamt = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 10),
      freight = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 11),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 12)
    )
  )
}
