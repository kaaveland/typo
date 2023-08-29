/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sop

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class SopViewRow(
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.specialofferid]] */
  id: SpecialofferId,
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.productid]] */
  productid: ProductId,
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SopViewRow {
  implicit lazy val decoder: Decoder[SopViewRow] = Decoder.forProduct5[SopViewRow, SpecialofferId, SpecialofferId, ProductId, UUID, TypoLocalDateTime]("id", "specialofferid", "productid", "rowguid", "modifieddate")(SopViewRow.apply)(SpecialofferId.decoder, SpecialofferId.decoder, ProductId.decoder, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SopViewRow] = Encoder.forProduct5[SopViewRow, SpecialofferId, SpecialofferId, ProductId, UUID, TypoLocalDateTime]("id", "specialofferid", "productid", "rowguid", "modifieddate")(x => (x.id, x.specialofferid, x.productid, x.rowguid, x.modifieddate))(SpecialofferId.encoder, SpecialofferId.encoder, ProductId.encoder, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SopViewRow] = new Read[SopViewRow](
    gets = List(
      (SpecialofferId.get, Nullability.NoNulls),
      (SpecialofferId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SopViewRow(
      id = SpecialofferId.get.unsafeGetNonNullable(rs, i + 0),
      specialofferid = SpecialofferId.get.unsafeGetNonNullable(rs, i + 1),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 2),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
