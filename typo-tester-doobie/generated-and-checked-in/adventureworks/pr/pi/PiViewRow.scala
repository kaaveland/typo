/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pi

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class PiViewRow(
  /** Points to [[production.productinventory.ProductinventoryRow.productid]] */
  id: ProductId,
  /** Points to [[production.productinventory.ProductinventoryRow.productid]] */
  productid: ProductId,
  /** Points to [[production.productinventory.ProductinventoryRow.locationid]] */
  locationid: LocationId,
  /** Points to [[production.productinventory.ProductinventoryRow.shelf]] */
  shelf: /* max 10 chars */ String,
  /** Points to [[production.productinventory.ProductinventoryRow.bin]] */
  bin: Int,
  /** Points to [[production.productinventory.ProductinventoryRow.quantity]] */
  quantity: Int,
  /** Points to [[production.productinventory.ProductinventoryRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[production.productinventory.ProductinventoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PiViewRow {
  implicit lazy val decoder: Decoder[PiViewRow] = Decoder.forProduct8[PiViewRow, ProductId, ProductId, LocationId, /* max 10 chars */ String, Int, Int, UUID, TypoLocalDateTime]("id", "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")(PiViewRow.apply)(ProductId.decoder, ProductId.decoder, LocationId.decoder, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeInt, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PiViewRow] = Encoder.forProduct8[PiViewRow, ProductId, ProductId, LocationId, /* max 10 chars */ String, Int, Int, UUID, TypoLocalDateTime]("id", "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")(x => (x.id, x.productid, x.locationid, x.shelf, x.bin, x.quantity, x.rowguid, x.modifieddate))(ProductId.encoder, ProductId.encoder, LocationId.encoder, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeInt, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PiViewRow] = new Read[PiViewRow](
    gets = List(
      (ProductId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (LocationId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PiViewRow(
      id = ProductId.get.unsafeGetNonNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 1),
      locationid = LocationId.get.unsafeGetNonNullable(rs, i + 2),
      shelf = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      bin = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 4),
      quantity = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 5),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 6),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 7)
    )
  )
}
