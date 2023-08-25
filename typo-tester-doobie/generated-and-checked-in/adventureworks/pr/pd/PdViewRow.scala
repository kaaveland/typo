/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pd

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.productdescription.ProductdescriptionId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class PdViewRow(
  id: Int,
  /** Points to [[production.productdescription.ProductdescriptionRow.productdescriptionid]] */
  productdescriptionid: ProductdescriptionId,
  /** Points to [[production.productdescription.ProductdescriptionRow.description]] */
  description: /* max 400 chars */ String,
  /** Points to [[production.productdescription.ProductdescriptionRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[production.productdescription.ProductdescriptionRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PdViewRow {
  implicit lazy val decoder: Decoder[PdViewRow] = Decoder.forProduct5[PdViewRow, Int, ProductdescriptionId, /* max 400 chars */ String, UUID, TypoLocalDateTime]("id", "productdescriptionid", "description", "rowguid", "modifieddate")(PdViewRow.apply)(Decoder.decodeInt, ProductdescriptionId.decoder, Decoder.decodeString, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PdViewRow] = Encoder.forProduct5[PdViewRow, Int, ProductdescriptionId, /* max 400 chars */ String, UUID, TypoLocalDateTime]("id", "productdescriptionid", "description", "rowguid", "modifieddate")(x => (x.id, x.productdescriptionid, x.description, x.rowguid, x.modifieddate))(Encoder.encodeInt, ProductdescriptionId.encoder, Encoder.encodeString, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PdViewRow] = new Read[PdViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (ProductdescriptionId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PdViewRow(
      id = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      productdescriptionid = ProductdescriptionId.get.unsafeGetNonNullable(rs, i + 1),
      description = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
