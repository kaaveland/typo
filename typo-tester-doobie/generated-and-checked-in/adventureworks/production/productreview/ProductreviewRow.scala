/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: production.productreview
    Customer reviews of products they have purchased.
    Primary key: productreviewid */
case class ProductreviewRow(
  /** Primary key for ProductReview records.
      Default: nextval('production.productreview_productreviewid_seq'::regclass) */
  productreviewid: ProductreviewId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Name of the reviewer. */
  reviewername: Name,
  /** Date review was submitted.
      Default: now() */
  reviewdate: TypoLocalDateTime,
  /** Reviewer's e-mail address. */
  emailaddress: /* max 50 chars */ String,
  /** Product rating given by the reviewer. Scale is 1 to 5 with 5 as the highest rating.
      Constraint CK_ProductReview_Rating affecting columns rating: (((rating >= 1) AND (rating <= 5))) */
  rating: Int,
  /** Reviewer's comments */
  comments: Option[/* max 3850 chars */ String],
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object ProductreviewRow {
  implicit lazy val decoder: Decoder[ProductreviewRow] = Decoder.forProduct8[ProductreviewRow, ProductreviewId, ProductId, Name, TypoLocalDateTime, /* max 50 chars */ String, Int, Option[/* max 3850 chars */ String], TypoLocalDateTime]("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")(ProductreviewRow.apply)(ProductreviewId.decoder, ProductId.decoder, Name.decoder, TypoLocalDateTime.decoder, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeString), TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ProductreviewRow] = Encoder.forProduct8[ProductreviewRow, ProductreviewId, ProductId, Name, TypoLocalDateTime, /* max 50 chars */ String, Int, Option[/* max 3850 chars */ String], TypoLocalDateTime]("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")(x => (x.productreviewid, x.productid, x.reviewername, x.reviewdate, x.emailaddress, x.rating, x.comments, x.modifieddate))(ProductreviewId.encoder, ProductId.encoder, Name.encoder, TypoLocalDateTime.encoder, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeString), TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ProductreviewRow] = new Read[ProductreviewRow](
    gets = List(
      (ProductreviewId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductreviewRow(
      productreviewid = ProductreviewId.get.unsafeGetNonNullable(rs, i + 0),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 1),
      reviewername = Name.get.unsafeGetNonNullable(rs, i + 2),
      reviewdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3),
      emailaddress = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4),
      rating = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 5),
      comments = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 7)
    )
  )
  implicit lazy val text: Text[ProductreviewRow] = Text.instance[ProductreviewRow]{ (row, sb) =>
    ProductreviewId.text.unsafeEncode(row.productreviewid, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.reviewername, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.reviewdate, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.emailaddress, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.rating, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.comments, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
