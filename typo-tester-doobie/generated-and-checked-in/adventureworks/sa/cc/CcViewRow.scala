/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.userdefined.CustomCreditcardId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class CcViewRow(
  id: Int,
  /** Points to [[sales.creditcard.CreditcardRow.creditcardid]] */
  creditcardid: /* user-picked */ CustomCreditcardId,
  /** Points to [[sales.creditcard.CreditcardRow.cardtype]] */
  cardtype: /* max 50 chars */ String,
  /** Points to [[sales.creditcard.CreditcardRow.cardnumber]] */
  cardnumber: /* max 25 chars */ String,
  /** Points to [[sales.creditcard.CreditcardRow.expmonth]] */
  expmonth: Int,
  /** Points to [[sales.creditcard.CreditcardRow.expyear]] */
  expyear: Int,
  /** Points to [[sales.creditcard.CreditcardRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object CcViewRow {
  implicit lazy val decoder: Decoder[CcViewRow] = Decoder.forProduct7[CcViewRow, Int, /* user-picked */ CustomCreditcardId, /* max 50 chars */ String, /* max 25 chars */ String, Int, Int, TypoLocalDateTime]("id", "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")(CcViewRow.apply)(Decoder.decodeInt, CustomCreditcardId.decoder, Decoder.decodeString, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeInt, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CcViewRow] = Encoder.forProduct7[CcViewRow, Int, /* user-picked */ CustomCreditcardId, /* max 50 chars */ String, /* max 25 chars */ String, Int, Int, TypoLocalDateTime]("id", "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate")(x => (x.id, x.creditcardid, x.cardtype, x.cardnumber, x.expmonth, x.expyear, x.modifieddate))(Encoder.encodeInt, CustomCreditcardId.encoder, Encoder.encodeString, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeInt, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CcViewRow] = new Read[CcViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (/* user-picked */ CustomCreditcardId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CcViewRow(
      id = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      creditcardid = /* user-picked */ CustomCreditcardId.get.unsafeGetNonNullable(rs, i + 1),
      cardtype = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      cardnumber = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      expmonth = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 4),
      expyear = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6)
    )
  )
}
