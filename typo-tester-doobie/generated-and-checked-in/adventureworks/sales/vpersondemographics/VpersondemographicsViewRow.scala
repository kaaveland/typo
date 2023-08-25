/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoMoney
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class VpersondemographicsViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  totalpurchaseytd: TypoMoney,
  datefirstpurchase: TypoLocalDate,
  birthdate: TypoLocalDate,
  maritalstatus: /* max 1 chars */ String,
  yearlyincome: /* max 30 chars */ String,
  gender: /* max 1 chars */ String,
  totalchildren: Int,
  numberchildrenathome: Int,
  education: /* max 30 chars */ String,
  occupation: /* max 30 chars */ String,
  homeownerflag: Boolean,
  numbercarsowned: Int
)

object VpersondemographicsViewRow {
  implicit lazy val decoder: Decoder[VpersondemographicsViewRow] = Decoder.forProduct13[VpersondemographicsViewRow, BusinessentityId, TypoMoney, TypoLocalDate, TypoLocalDate, /* max 1 chars */ String, /* max 30 chars */ String, /* max 1 chars */ String, Int, Int, /* max 30 chars */ String, /* max 30 chars */ String, Boolean, Int]("businessentityid", "totalpurchaseytd", "datefirstpurchase", "birthdate", "maritalstatus", "yearlyincome", "gender", "totalchildren", "numberchildrenathome", "education", "occupation", "homeownerflag", "numbercarsowned")(VpersondemographicsViewRow.apply)(BusinessentityId.decoder, TypoMoney.decoder, TypoLocalDate.decoder, TypoLocalDate.decoder, Decoder.decodeString, Decoder.decodeString, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeInt, Decoder.decodeString, Decoder.decodeString, Decoder.decodeBoolean, Decoder.decodeInt)
  implicit lazy val encoder: Encoder[VpersondemographicsViewRow] = Encoder.forProduct13[VpersondemographicsViewRow, BusinessentityId, TypoMoney, TypoLocalDate, TypoLocalDate, /* max 1 chars */ String, /* max 30 chars */ String, /* max 1 chars */ String, Int, Int, /* max 30 chars */ String, /* max 30 chars */ String, Boolean, Int]("businessentityid", "totalpurchaseytd", "datefirstpurchase", "birthdate", "maritalstatus", "yearlyincome", "gender", "totalchildren", "numberchildrenathome", "education", "occupation", "homeownerflag", "numbercarsowned")(x => (x.businessentityid, x.totalpurchaseytd, x.datefirstpurchase, x.birthdate, x.maritalstatus, x.yearlyincome, x.gender, x.totalchildren, x.numberchildrenathome, x.education, x.occupation, x.homeownerflag, x.numbercarsowned))(BusinessentityId.encoder, TypoMoney.encoder, TypoLocalDate.encoder, TypoLocalDate.encoder, Encoder.encodeString, Encoder.encodeString, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeInt, Encoder.encodeString, Encoder.encodeString, Encoder.encodeBoolean, Encoder.encodeInt)
  implicit lazy val read: Read[VpersondemographicsViewRow] = new Read[VpersondemographicsViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.NoNulls),
      (TypoMoney.get, Nullability.NoNulls),
      (TypoLocalDate.get, Nullability.NoNulls),
      (TypoLocalDate.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VpersondemographicsViewRow(
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 0),
      totalpurchaseytd = TypoMoney.get.unsafeGetNonNullable(rs, i + 1),
      datefirstpurchase = TypoLocalDate.get.unsafeGetNonNullable(rs, i + 2),
      birthdate = TypoLocalDate.get.unsafeGetNonNullable(rs, i + 3),
      maritalstatus = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4),
      yearlyincome = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      gender = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 6),
      totalchildren = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 7),
      numberchildrenathome = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 8),
      education = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 9),
      occupation = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 10),
      homeownerflag = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 11),
      numbercarsowned = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 12)
    )
  )
}
