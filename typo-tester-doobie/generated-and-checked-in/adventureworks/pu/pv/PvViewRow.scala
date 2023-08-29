/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pv

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PvViewRow(
  /** Points to [[purchasing.productvendor.ProductvendorRow.productid]] */
  id: ProductId,
  /** Points to [[purchasing.productvendor.ProductvendorRow.productid]] */
  productid: ProductId,
  /** Points to [[purchasing.productvendor.ProductvendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[purchasing.productvendor.ProductvendorRow.averageleadtime]] */
  averageleadtime: Int,
  /** Points to [[purchasing.productvendor.ProductvendorRow.standardprice]] */
  standardprice: BigDecimal,
  /** Points to [[purchasing.productvendor.ProductvendorRow.lastreceiptcost]] */
  lastreceiptcost: Option[BigDecimal],
  /** Points to [[purchasing.productvendor.ProductvendorRow.lastreceiptdate]] */
  lastreceiptdate: Option[TypoLocalDateTime],
  /** Points to [[purchasing.productvendor.ProductvendorRow.minorderqty]] */
  minorderqty: Int,
  /** Points to [[purchasing.productvendor.ProductvendorRow.maxorderqty]] */
  maxorderqty: Int,
  /** Points to [[purchasing.productvendor.ProductvendorRow.onorderqty]] */
  onorderqty: Option[Int],
  /** Points to [[purchasing.productvendor.ProductvendorRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Points to [[purchasing.productvendor.ProductvendorRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PvViewRow {
  implicit lazy val decoder: Decoder[PvViewRow] = Decoder.forProduct12[PvViewRow, ProductId, ProductId, BusinessentityId, Int, BigDecimal, Option[BigDecimal], Option[TypoLocalDateTime], Int, Int, Option[Int], UnitmeasureId, TypoLocalDateTime]("id", "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")(PvViewRow.apply)(ProductId.decoder, ProductId.decoder, BusinessentityId.decoder, Decoder.decodeInt, Decoder.decodeBigDecimal, Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeInt, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeInt), UnitmeasureId.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PvViewRow] = Encoder.forProduct12[PvViewRow, ProductId, ProductId, BusinessentityId, Int, BigDecimal, Option[BigDecimal], Option[TypoLocalDateTime], Int, Int, Option[Int], UnitmeasureId, TypoLocalDateTime]("id", "productid", "businessentityid", "averageleadtime", "standardprice", "lastreceiptcost", "lastreceiptdate", "minorderqty", "maxorderqty", "onorderqty", "unitmeasurecode", "modifieddate")(x => (x.id, x.productid, x.businessentityid, x.averageleadtime, x.standardprice, x.lastreceiptcost, x.lastreceiptdate, x.minorderqty, x.maxorderqty, x.onorderqty, x.unitmeasurecode, x.modifieddate))(ProductId.encoder, ProductId.encoder, BusinessentityId.encoder, Encoder.encodeInt, Encoder.encodeBigDecimal, Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeInt, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeInt), UnitmeasureId.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PvViewRow] = new Read[PvViewRow](
    gets = List(
      (ProductId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.Nullable),
      (UnitmeasureId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PvViewRow(
      id = ProductId.get.unsafeGetNonNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 1),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 2),
      averageleadtime = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      standardprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 4),
      lastreceiptcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 5),
      lastreceiptdate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 6),
      minorderqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 7),
      maxorderqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 8),
      onorderqty = Meta.IntMeta.get.unsafeGetNullable(rs, i + 9),
      unitmeasurecode = UnitmeasureId.get.unsafeGetNonNullable(rs, i + 10),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 11)
    )
  )
}
