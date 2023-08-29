/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productreview.ProductreviewId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PrViewRow(
  /** Points to [[production.productreview.ProductreviewRow.productreviewid]] */
  id: ProductreviewId,
  /** Points to [[production.productreview.ProductreviewRow.productreviewid]] */
  productreviewid: ProductreviewId,
  /** Points to [[production.productreview.ProductreviewRow.productid]] */
  productid: ProductId,
  /** Points to [[production.productreview.ProductreviewRow.reviewername]] */
  reviewername: Name,
  /** Points to [[production.productreview.ProductreviewRow.reviewdate]] */
  reviewdate: TypoLocalDateTime,
  /** Points to [[production.productreview.ProductreviewRow.emailaddress]] */
  emailaddress: /* max 50 chars */ String,
  /** Points to [[production.productreview.ProductreviewRow.rating]] */
  rating: Int,
  /** Points to [[production.productreview.ProductreviewRow.comments]] */
  comments: Option[/* max 3850 chars */ String],
  /** Points to [[production.productreview.ProductreviewRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PrViewRow {
  implicit lazy val decoder: Decoder[PrViewRow] = Decoder.forProduct9[PrViewRow, ProductreviewId, ProductreviewId, ProductId, Name, TypoLocalDateTime, /* max 50 chars */ String, Int, Option[/* max 3850 chars */ String], TypoLocalDateTime]("id", "productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")(PrViewRow.apply)(ProductreviewId.decoder, ProductreviewId.decoder, ProductId.decoder, Name.decoder, TypoLocalDateTime.decoder, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeString), TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PrViewRow] = Encoder.forProduct9[PrViewRow, ProductreviewId, ProductreviewId, ProductId, Name, TypoLocalDateTime, /* max 50 chars */ String, Int, Option[/* max 3850 chars */ String], TypoLocalDateTime]("id", "productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")(x => (x.id, x.productreviewid, x.productid, x.reviewername, x.reviewdate, x.emailaddress, x.rating, x.comments, x.modifieddate))(ProductreviewId.encoder, ProductreviewId.encoder, ProductId.encoder, Name.encoder, TypoLocalDateTime.encoder, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeString), TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PrViewRow] = new Read[PrViewRow](
    gets = List(
      (ProductreviewId.get, Nullability.NoNulls),
      (ProductreviewId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PrViewRow(
      id = ProductreviewId.get.unsafeGetNonNullable(rs, i + 0),
      productreviewid = ProductreviewId.get.unsafeGetNonNullable(rs, i + 1),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 2),
      reviewername = Name.get.unsafeGetNonNullable(rs, i + 3),
      reviewdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4),
      emailaddress = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      rating = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      comments = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}
