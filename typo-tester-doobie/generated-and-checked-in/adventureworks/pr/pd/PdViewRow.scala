/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pd

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productdescription.ProductdescriptionId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: pr.pd */
case class PdViewRow(
  /** Points to [[production.productdescription.ProductdescriptionRow.productdescriptionid]] */
  id: ProductdescriptionId,
  /** Points to [[production.productdescription.ProductdescriptionRow.productdescriptionid]] */
  productdescriptionid: ProductdescriptionId,
  /** Points to [[production.productdescription.ProductdescriptionRow.description]] */
  description: /* max 400 chars */ String,
  /** Points to [[production.productdescription.ProductdescriptionRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[production.productdescription.ProductdescriptionRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PdViewRow {
  implicit lazy val decoder: Decoder[PdViewRow] = Decoder.forProduct5[PdViewRow, ProductdescriptionId, ProductdescriptionId, /* max 400 chars */ String, TypoUUID, TypoLocalDateTime]("id", "productdescriptionid", "description", "rowguid", "modifieddate")(PdViewRow.apply)(ProductdescriptionId.decoder, ProductdescriptionId.decoder, Decoder.decodeString, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PdViewRow] = Encoder.forProduct5[PdViewRow, ProductdescriptionId, ProductdescriptionId, /* max 400 chars */ String, TypoUUID, TypoLocalDateTime]("id", "productdescriptionid", "description", "rowguid", "modifieddate")(x => (x.id, x.productdescriptionid, x.description, x.rowguid, x.modifieddate))(ProductdescriptionId.encoder, ProductdescriptionId.encoder, Encoder.encodeString, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PdViewRow] = new Read[PdViewRow](
    gets = List(
      (ProductdescriptionId.get, Nullability.NoNulls),
      (ProductdescriptionId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PdViewRow(
      id = ProductdescriptionId.get.unsafeGetNonNullable(rs, i + 0),
      productdescriptionid = ProductdescriptionId.get.unsafeGetNonNullable(rs, i + 1),
      description = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
