/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalesperson

import adventureworks.customtype.FirstName
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class VsalespersonViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: Option[/* user-picked */ FirstName],
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: Option[/* max 50 chars */ String],
  /** Points to [[person.personphone.PersonphoneRow.phonenumber]] */
  phonenumber: Option[Phone],
  phonenumbertype: Option[Name],
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[person.person.PersonRow.emailpromotion]] */
  emailpromotion: Option[Int],
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.addressline2]] */
  addressline2: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.city]] */
  city: Option[/* max 30 chars */ String],
  stateprovincename: Option[Name],
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: Option[/* max 15 chars */ String],
  countryregionname: Option[Name],
  territoryname: Option[Name],
  territorygroup: Option[/* max 50 chars */ String],
  /** Points to [[salesperson.SalespersonRow.salesquota]] */
  salesquota: Option[BigDecimal],
  /** Points to [[salesperson.SalespersonRow.salesytd]] */
  salesytd: Option[BigDecimal],
  /** Points to [[salesperson.SalespersonRow.saleslastyear]] */
  saleslastyear: Option[BigDecimal]
)

object VsalespersonViewRow {
  implicit lazy val reads: Reads[VsalespersonViewRow] = Reads[VsalespersonViewRow](json => JsResult.fromTry(
      Try(
        VsalespersonViewRow(
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          title = json.\("title").toOption.map(_.as(Reads.StringReads)),
          firstname = json.\("firstname").toOption.map(_.as(FirstName.reads)),
          middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
          lastname = json.\("lastname").toOption.map(_.as(Name.reads)),
          suffix = json.\("suffix").toOption.map(_.as(Reads.StringReads)),
          jobtitle = json.\("jobtitle").toOption.map(_.as(Reads.StringReads)),
          phonenumber = json.\("phonenumber").toOption.map(_.as(Phone.reads)),
          phonenumbertype = json.\("phonenumbertype").toOption.map(_.as(Name.reads)),
          emailaddress = json.\("emailaddress").toOption.map(_.as(Reads.StringReads)),
          emailpromotion = json.\("emailpromotion").toOption.map(_.as(Reads.IntReads)),
          addressline1 = json.\("addressline1").toOption.map(_.as(Reads.StringReads)),
          addressline2 = json.\("addressline2").toOption.map(_.as(Reads.StringReads)),
          city = json.\("city").toOption.map(_.as(Reads.StringReads)),
          stateprovincename = json.\("stateprovincename").toOption.map(_.as(Name.reads)),
          postalcode = json.\("postalcode").toOption.map(_.as(Reads.StringReads)),
          countryregionname = json.\("countryregionname").toOption.map(_.as(Name.reads)),
          territoryname = json.\("territoryname").toOption.map(_.as(Name.reads)),
          territorygroup = json.\("territorygroup").toOption.map(_.as(Reads.StringReads)),
          salesquota = json.\("salesquota").toOption.map(_.as(Reads.bigDecReads)),
          salesytd = json.\("salesytd").toOption.map(_.as(Reads.bigDecReads)),
          saleslastyear = json.\("saleslastyear").toOption.map(_.as(Reads.bigDecReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VsalespersonViewRow] = RowParser[VsalespersonViewRow] { row =>
    Success(
      VsalespersonViewRow(
        businessentityid = row(idx + 0)(Column.columnToOption(BusinessentityId.column)),
        title = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        firstname = row(idx + 2)(Column.columnToOption(FirstName.column)),
        middlename = row(idx + 3)(Column.columnToOption(Name.column)),
        lastname = row(idx + 4)(Column.columnToOption(Name.column)),
        suffix = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        jobtitle = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        phonenumber = row(idx + 7)(Column.columnToOption(Phone.column)),
        phonenumbertype = row(idx + 8)(Column.columnToOption(Name.column)),
        emailaddress = row(idx + 9)(Column.columnToOption(Column.columnToString)),
        emailpromotion = row(idx + 10)(Column.columnToOption(Column.columnToInt)),
        addressline1 = row(idx + 11)(Column.columnToOption(Column.columnToString)),
        addressline2 = row(idx + 12)(Column.columnToOption(Column.columnToString)),
        city = row(idx + 13)(Column.columnToOption(Column.columnToString)),
        stateprovincename = row(idx + 14)(Column.columnToOption(Name.column)),
        postalcode = row(idx + 15)(Column.columnToOption(Column.columnToString)),
        countryregionname = row(idx + 16)(Column.columnToOption(Name.column)),
        territoryname = row(idx + 17)(Column.columnToOption(Name.column)),
        territorygroup = row(idx + 18)(Column.columnToOption(Column.columnToString)),
        salesquota = row(idx + 19)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        salesytd = row(idx + 20)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        saleslastyear = row(idx + 21)(Column.columnToOption(Column.columnToScalaBigDecimal))
      )
    )
  }
  implicit lazy val writes: OWrites[VsalespersonViewRow] = OWrites[VsalespersonViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
      "firstname" -> Writes.OptionWrites(FirstName.writes).writes(o.firstname),
      "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
      "lastname" -> Writes.OptionWrites(Name.writes).writes(o.lastname),
      "suffix" -> Writes.OptionWrites(Writes.StringWrites).writes(o.suffix),
      "jobtitle" -> Writes.OptionWrites(Writes.StringWrites).writes(o.jobtitle),
      "phonenumber" -> Writes.OptionWrites(Phone.writes).writes(o.phonenumber),
      "phonenumbertype" -> Writes.OptionWrites(Name.writes).writes(o.phonenumbertype),
      "emailaddress" -> Writes.OptionWrites(Writes.StringWrites).writes(o.emailaddress),
      "emailpromotion" -> Writes.OptionWrites(Writes.IntWrites).writes(o.emailpromotion),
      "addressline1" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline1),
      "addressline2" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline2),
      "city" -> Writes.OptionWrites(Writes.StringWrites).writes(o.city),
      "stateprovincename" -> Writes.OptionWrites(Name.writes).writes(o.stateprovincename),
      "postalcode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.postalcode),
      "countryregionname" -> Writes.OptionWrites(Name.writes).writes(o.countryregionname),
      "territoryname" -> Writes.OptionWrites(Name.writes).writes(o.territoryname),
      "territorygroup" -> Writes.OptionWrites(Writes.StringWrites).writes(o.territorygroup),
      "salesquota" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.salesquota),
      "salesytd" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.salesytd),
      "saleslastyear" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.saleslastyear)
    ))
  )
}