/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package plph

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: pr.plph */
case class PlphViewRow(
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.productid]] */
  id: ProductId,
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.productid]] */
  productid: ProductId,
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.startdate]] */
  startdate: TypoLocalDateTime,
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.enddate]] */
  enddate: Option[TypoLocalDateTime],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.listprice]] */
  listprice: BigDecimal,
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PlphViewRow {
  implicit lazy val decoder: Decoder[PlphViewRow] = Decoder.forProduct6[PlphViewRow, ProductId, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, TypoLocalDateTime]("id", "productid", "startdate", "enddate", "listprice", "modifieddate")(PlphViewRow.apply)(ProductId.decoder, ProductId.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PlphViewRow] = Encoder.forProduct6[PlphViewRow, ProductId, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, TypoLocalDateTime]("id", "productid", "startdate", "enddate", "listprice", "modifieddate")(x => (x.id, x.productid, x.startdate, x.enddate, x.listprice, x.modifieddate))(ProductId.encoder, ProductId.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PlphViewRow] = new Read[PlphViewRow](
    gets = List(
      (ProductId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PlphViewRow(
      id = ProductId.get.unsafeGetNonNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 1),
      startdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2),
      enddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 3),
      listprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
}
