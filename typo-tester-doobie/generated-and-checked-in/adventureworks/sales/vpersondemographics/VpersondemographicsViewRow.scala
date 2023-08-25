/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import adventureworks.TypoLocalDate
import adventureworks.TypoMoney
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class VpersondemographicsViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  totalpurchaseytd: Option[TypoMoney],
  datefirstpurchase: Option[TypoLocalDate],
  birthdate: Option[TypoLocalDate],
  maritalstatus: Option[/* max 1 chars */ String],
  yearlyincome: Option[/* max 30 chars */ String],
  gender: Option[/* max 1 chars */ String],
  totalchildren: Option[Int],
  numberchildrenathome: Option[Int],
  education: Option[/* max 30 chars */ String],
  occupation: Option[/* max 30 chars */ String],
  homeownerflag: Option[Boolean],
  numbercarsowned: Option[Int]
)

object VpersondemographicsViewRow {
  implicit lazy val decoder: Decoder[VpersondemographicsViewRow] = Decoder.forProduct13[VpersondemographicsViewRow, Option[BusinessentityId], Option[TypoMoney], Option[TypoLocalDate], Option[TypoLocalDate], Option[/* max 1 chars */ String], Option[/* max 30 chars */ String], Option[/* max 1 chars */ String], Option[Int], Option[Int], Option[/* max 30 chars */ String], Option[/* max 30 chars */ String], Option[Boolean], Option[Int]]("businessentityid", "totalpurchaseytd", "datefirstpurchase", "birthdate", "maritalstatus", "yearlyincome", "gender", "totalchildren", "numberchildrenathome", "education", "occupation", "homeownerflag", "numbercarsowned")(VpersondemographicsViewRow.apply)(Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(TypoMoney.decoder), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(TypoLocalDate.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeBoolean), Decoder.decodeOption(Decoder.decodeInt))
  implicit lazy val encoder: Encoder[VpersondemographicsViewRow] = Encoder.forProduct13[VpersondemographicsViewRow, Option[BusinessentityId], Option[TypoMoney], Option[TypoLocalDate], Option[TypoLocalDate], Option[/* max 1 chars */ String], Option[/* max 30 chars */ String], Option[/* max 1 chars */ String], Option[Int], Option[Int], Option[/* max 30 chars */ String], Option[/* max 30 chars */ String], Option[Boolean], Option[Int]]("businessentityid", "totalpurchaseytd", "datefirstpurchase", "birthdate", "maritalstatus", "yearlyincome", "gender", "totalchildren", "numberchildrenathome", "education", "occupation", "homeownerflag", "numbercarsowned")(x => (x.businessentityid, x.totalpurchaseytd, x.datefirstpurchase, x.birthdate, x.maritalstatus, x.yearlyincome, x.gender, x.totalchildren, x.numberchildrenathome, x.education, x.occupation, x.homeownerflag, x.numbercarsowned))(Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(TypoMoney.encoder), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(TypoLocalDate.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeBoolean), Encoder.encodeOption(Encoder.encodeInt))
  implicit lazy val read: Read[VpersondemographicsViewRow] = new Read[VpersondemographicsViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.Nullable),
      (TypoMoney.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable),
      (TypoLocalDate.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VpersondemographicsViewRow(
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 0),
      totalpurchaseytd = TypoMoney.get.unsafeGetNullable(rs, i + 1),
      datefirstpurchase = TypoLocalDate.get.unsafeGetNullable(rs, i + 2),
      birthdate = TypoLocalDate.get.unsafeGetNullable(rs, i + 3),
      maritalstatus = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      yearlyincome = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      gender = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      totalchildren = Meta.IntMeta.get.unsafeGetNullable(rs, i + 7),
      numberchildrenathome = Meta.IntMeta.get.unsafeGetNullable(rs, i + 8),
      education = Meta.StringMeta.get.unsafeGetNullable(rs, i + 9),
      occupation = Meta.StringMeta.get.unsafeGetNullable(rs, i + 10),
      homeownerflag = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 11),
      numbercarsowned = Meta.IntMeta.get.unsafeGetNullable(rs, i + 12)
    )
  )
}