/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.customtype.FirstName
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `person.person` which has not been persisted yet */
case class PersonRowUnsaved(
  /** Primary key for Person records.
      Points to [[businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary type of person: SC = Store Contact, IN = Individual (retail) customer, SP = Sales person, EM = Employee (non-sales), VC = Vendor contact, GC = General contact */
  persontype: /* bpchar, max 2 chars */ String,
  /** A courtesy title. For example, Mr. or Ms. */
  title: Option[/* max 8 chars */ String],
  /** First name of the person. */
  firstname: /* user-picked */ FirstName,
  /** Middle name or middle initial of the person. */
  middlename: Option[Name],
  /** Last name of the person. */
  lastname: Name,
  /** Surname suffix. For example, Sr. or Jr. */
  suffix: Option[/* max 10 chars */ String],
  /** Additional contact information about the person stored in xml format. */
  additionalcontactinfo: Option[TypoXml],
  /** Personal information such as hobbies, and income collected from online shoppers. Used for sales analysis. */
  demographics: Option[TypoXml],
  /** Default: false
      0 = The data in FirstName and LastName are stored in western style (first name, last name) order.  1 = Eastern style (last name, first name) order. */
  namestyle: Defaulted[NameStyle] = Defaulted.UseDefault,
  /** Default: 0
      0 = Contact does not wish to receive e-mail promotions, 1 = Contact does wish to receive e-mail promotions from AdventureWorks, 2 = Contact does wish to receive e-mail promotions from AdventureWorks and selected partners. */
  emailpromotion: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(namestyleDefault: => NameStyle, emailpromotionDefault: => Int, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): PersonRow =
    PersonRow(
      businessentityid = businessentityid,
      persontype = persontype,
      title = title,
      firstname = firstname,
      middlename = middlename,
      lastname = lastname,
      suffix = suffix,
      additionalcontactinfo = additionalcontactinfo,
      demographics = demographics,
      namestyle = namestyle match {
                    case Defaulted.UseDefault => namestyleDefault
                    case Defaulted.Provided(value) => value
                  },
      emailpromotion = emailpromotion match {
                         case Defaulted.UseDefault => emailpromotionDefault
                         case Defaulted.Provided(value) => value
                       },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PersonRowUnsaved {
  implicit lazy val decoder: Decoder[PersonRowUnsaved] = Decoder.forProduct13[PersonRowUnsaved, BusinessentityId, /* bpchar, max 2 chars */ String, Option[/* max 8 chars */ String], /* user-picked */ FirstName, Option[Name], Name, Option[/* max 10 chars */ String], Option[TypoXml], Option[TypoXml], Defaulted[NameStyle], Defaulted[Int], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "persontype", "title", "firstname", "middlename", "lastname", "suffix", "additionalcontactinfo", "demographics", "namestyle", "emailpromotion", "rowguid", "modifieddate")(PersonRowUnsaved.apply)(BusinessentityId.decoder, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), FirstName.decoder, Decoder.decodeOption(Name.decoder), Name.decoder, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Defaulted.decoder(NameStyle.decoder), Defaulted.decoder(Decoder.decodeInt), Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[PersonRowUnsaved] = Encoder.forProduct13[PersonRowUnsaved, BusinessentityId, /* bpchar, max 2 chars */ String, Option[/* max 8 chars */ String], /* user-picked */ FirstName, Option[Name], Name, Option[/* max 10 chars */ String], Option[TypoXml], Option[TypoXml], Defaulted[NameStyle], Defaulted[Int], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "persontype", "title", "firstname", "middlename", "lastname", "suffix", "additionalcontactinfo", "demographics", "namestyle", "emailpromotion", "rowguid", "modifieddate")(x => (x.businessentityid, x.persontype, x.title, x.firstname, x.middlename, x.lastname, x.suffix, x.additionalcontactinfo, x.demographics, x.namestyle, x.emailpromotion, x.rowguid, x.modifieddate))(BusinessentityId.encoder, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), FirstName.encoder, Encoder.encodeOption(Name.encoder), Name.encoder, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Defaulted.encoder(NameStyle.encoder), Defaulted.encoder(Encoder.encodeInt), Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}
