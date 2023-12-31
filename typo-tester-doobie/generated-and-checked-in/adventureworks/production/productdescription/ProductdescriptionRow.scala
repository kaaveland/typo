/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ProductdescriptionRow(
  /** Primary key for ProductDescription records.
      Default: nextval('production.productdescription_productdescriptionid_seq'::regclass) */
  productdescriptionid: ProductdescriptionId,
  /** Description of the product. */
  description: /* max 400 chars */ String,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object ProductdescriptionRow {
  implicit lazy val decoder: Decoder[ProductdescriptionRow] = Decoder.forProduct4[ProductdescriptionRow, ProductdescriptionId, /* max 400 chars */ String, TypoUUID, TypoLocalDateTime]("productdescriptionid", "description", "rowguid", "modifieddate")(ProductdescriptionRow.apply)(ProductdescriptionId.decoder, Decoder.decodeString, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ProductdescriptionRow] = Encoder.forProduct4[ProductdescriptionRow, ProductdescriptionId, /* max 400 chars */ String, TypoUUID, TypoLocalDateTime]("productdescriptionid", "description", "rowguid", "modifieddate")(x => (x.productdescriptionid, x.description, x.rowguid, x.modifieddate))(ProductdescriptionId.encoder, Encoder.encodeString, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ProductdescriptionRow] = new Read[ProductdescriptionRow](
    gets = List(
      (ProductdescriptionId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductdescriptionRow(
      productdescriptionid = ProductdescriptionId.get.unsafeGetNonNullable(rs, i + 0),
      description = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
  implicit lazy val text: Text[ProductdescriptionRow] = Text.instance[ProductdescriptionRow]{ (row, sb) =>
    ProductdescriptionId.text.unsafeEncode(row.productdescriptionid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.description, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
