/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithcontacts

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json

case class VvendorwithcontactsViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.contacttype.ContacttypeRow.name]] */
  name: Option[Name],
  contacttype: Option[Name],
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: Option[Name],
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[String],
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  phonenumbertype: Option[Name],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[String],
  /** Points to [[person.person.PersonRow.emailpromotion]] */
  emailpromotion: Option[Int]
)

object VvendorwithcontactsViewRow {
  implicit val decoder: Decoder[VvendorwithcontactsViewRow] =
    (c: HCursor) =>
      for {
        businessentityid <- c.downField("businessentityid").as[Option[BusinessentityId]]
        name <- c.downField("name").as[Option[Name]]
        contacttype <- c.downField("contacttype").as[Option[Name]]
        title <- c.downField("title").as[Option[String]]
        firstname <- c.downField("firstname").as[Option[Name]]
        middlename <- c.downField("middlename").as[Option[Name]]
        lastname <- c.downField("lastname").as[Option[Name]]
        suffix <- c.downField("suffix").as[Option[String]]
        phonenumber <- c.downField("phonenumber").as[Option[Phone]]
        phonenumbertype <- c.downField("phonenumbertype").as[Option[Name]]
        emailaddress <- c.downField("emailaddress").as[Option[String]]
        emailpromotion <- c.downField("emailpromotion").as[Option[Int]]
      } yield VvendorwithcontactsViewRow(businessentityid, name, contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion)
  implicit val encoder: Encoder[VvendorwithcontactsViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "businessentityid" := row.businessentityid,
        "name" := row.name,
        "contacttype" := row.contacttype,
        "title" := row.title,
        "firstname" := row.firstname,
        "middlename" := row.middlename,
        "lastname" := row.lastname,
        "suffix" := row.suffix,
        "phonenumber" := row.phonenumber,
        "phonenumbertype" := row.phonenumbertype,
        "emailaddress" := row.emailaddress,
        "emailpromotion" := row.emailpromotion
      )}
}
