/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vadditionalcontactinfo

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.customtype.FirstName
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class VadditionalcontactinfoViewRow(
  /** Points to [[person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.PersonRow.firstname]] */
  firstname: Option[/* user-picked */ FirstName],
  /** Points to [[person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.PersonRow.lastname]] */
  lastname: Option[Name],
  telephonenumber: Option[TypoXml],
  telephonespecialinstructions: Option[String],
  street: Option[TypoXml],
  city: Option[TypoXml],
  stateprovince: Option[TypoXml],
  postalcode: Option[TypoXml],
  countryregion: Option[TypoXml],
  homeaddressspecialinstructions: Option[TypoXml],
  emailaddress: Option[TypoXml],
  emailspecialinstructions: Option[String],
  emailtelephonenumber: Option[TypoXml],
  /** Points to [[person.PersonRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.PersonRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object VadditionalcontactinfoViewRow {
  implicit lazy val decoder: Decoder[VadditionalcontactinfoViewRow] = Decoder.forProduct17[VadditionalcontactinfoViewRow, Option[BusinessentityId], Option[/* user-picked */ FirstName], Option[Name], Option[Name], Option[TypoXml], Option[String], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[String], Option[TypoXml], Option[UUID], Option[TypoLocalDateTime]]("businessentityid", "firstname", "middlename", "lastname", "telephonenumber", "telephonespecialinstructions", "street", "city", "stateprovince", "postalcode", "countryregion", "homeaddressspecialinstructions", "emailaddress", "emailspecialinstructions", "emailtelephonenumber", "rowguid", "modifieddate")(VadditionalcontactinfoViewRow.apply)(Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(FirstName.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[VadditionalcontactinfoViewRow] = Encoder.forProduct17[VadditionalcontactinfoViewRow, Option[BusinessentityId], Option[/* user-picked */ FirstName], Option[Name], Option[Name], Option[TypoXml], Option[String], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[TypoXml], Option[String], Option[TypoXml], Option[UUID], Option[TypoLocalDateTime]]("businessentityid", "firstname", "middlename", "lastname", "telephonenumber", "telephonespecialinstructions", "street", "city", "stateprovince", "postalcode", "countryregion", "homeaddressspecialinstructions", "emailaddress", "emailspecialinstructions", "emailtelephonenumber", "rowguid", "modifieddate")(x => (x.businessentityid, x.firstname, x.middlename, x.lastname, x.telephonenumber, x.telephonespecialinstructions, x.street, x.city, x.stateprovince, x.postalcode, x.countryregion, x.homeaddressspecialinstructions, x.emailaddress, x.emailspecialinstructions, x.emailtelephonenumber, x.rowguid, x.modifieddate))(Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(FirstName.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[VadditionalcontactinfoViewRow] = new Read[VadditionalcontactinfoViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.Nullable),
      (/* user-picked */ FirstName.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VadditionalcontactinfoViewRow(
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 0),
      firstname = /* user-picked */ FirstName.get.unsafeGetNullable(rs, i + 1),
      middlename = Name.get.unsafeGetNullable(rs, i + 2),
      lastname = Name.get.unsafeGetNullable(rs, i + 3),
      telephonenumber = TypoXml.get.unsafeGetNullable(rs, i + 4),
      telephonespecialinstructions = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      street = TypoXml.get.unsafeGetNullable(rs, i + 6),
      city = TypoXml.get.unsafeGetNullable(rs, i + 7),
      stateprovince = TypoXml.get.unsafeGetNullable(rs, i + 8),
      postalcode = TypoXml.get.unsafeGetNullable(rs, i + 9),
      countryregion = TypoXml.get.unsafeGetNullable(rs, i + 10),
      homeaddressspecialinstructions = TypoXml.get.unsafeGetNullable(rs, i + 11),
      emailaddress = TypoXml.get.unsafeGetNullable(rs, i + 12),
      emailspecialinstructions = Meta.StringMeta.get.unsafeGetNullable(rs, i + 13),
      emailtelephonenumber = TypoXml.get.unsafeGetNullable(rs, i + 14),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 15),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 16)
    )
  )
}
