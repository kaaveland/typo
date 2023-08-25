/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pr

import adventureworks.TypoLocalDateTime
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
  id: Option[Int],
  /** Points to [[production.productreview.ProductreviewRow.productreviewid]] */
  productreviewid: Option[ProductreviewId],
  /** Points to [[production.productreview.ProductreviewRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productreview.ProductreviewRow.reviewername]] */
  reviewername: Option[Name],
  /** Points to [[production.productreview.ProductreviewRow.reviewdate]] */
  reviewdate: Option[TypoLocalDateTime],
  /** Points to [[production.productreview.ProductreviewRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[production.productreview.ProductreviewRow.rating]] */
  rating: Option[Int],
  /** Points to [[production.productreview.ProductreviewRow.comments]] */
  comments: Option[/* max 3850 chars */ String],
  /** Points to [[production.productreview.ProductreviewRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PrViewRow {
  implicit lazy val decoder: Decoder[PrViewRow] = Decoder.forProduct9[PrViewRow, Option[Int], Option[ProductreviewId], Option[ProductId], Option[Name], Option[TypoLocalDateTime], Option[/* max 50 chars */ String], Option[Int], Option[/* max 3850 chars */ String], Option[TypoLocalDateTime]]("id", "productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")(PrViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ProductreviewId.decoder), Decoder.decodeOption(ProductId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[PrViewRow] = Encoder.forProduct9[PrViewRow, Option[Int], Option[ProductreviewId], Option[ProductId], Option[Name], Option[TypoLocalDateTime], Option[/* max 50 chars */ String], Option[Int], Option[/* max 3850 chars */ String], Option[TypoLocalDateTime]]("id", "productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")(x => (x.id, x.productreviewid, x.productid, x.reviewername, x.reviewdate, x.emailaddress, x.rating, x.comments, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ProductreviewId.encoder), Encoder.encodeOption(ProductId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[PrViewRow] = new Read[PrViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ProductreviewId.get, Nullability.Nullable),
      (ProductId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PrViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      productreviewid = ProductreviewId.get.unsafeGetNullable(rs, i + 1),
      productid = ProductId.get.unsafeGetNullable(rs, i + 2),
      reviewername = Name.get.unsafeGetNullable(rs, i + 3),
      reviewdate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 4),
      emailaddress = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      rating = Meta.IntMeta.get.unsafeGetNullable(rs, i + 6),
      comments = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 8)
    )
  )
}