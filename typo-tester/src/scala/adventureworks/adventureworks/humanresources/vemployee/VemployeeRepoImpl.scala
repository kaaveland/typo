/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployee

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection

object VemployeeRepoImpl extends VemployeeRepo {
  override def selectAll(implicit c: Connection): List[VemployeeRow] = {
    SQL"""select businessentityid, title, firstname, middlename, lastname, suffix, jobtitle, phonenumber, phonenumbertype, emailaddress, emailpromotion, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname, additionalcontactinfo from humanresources.vemployee""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VemployeeFieldOrIdValue[_]])(implicit c: Connection): List[VemployeeRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VemployeeFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VemployeeFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case VemployeeFieldValue.firstname(value) => NamedParameter("firstname", ParameterValue.from(value))
          case VemployeeFieldValue.middlename(value) => NamedParameter("middlename", ParameterValue.from(value))
          case VemployeeFieldValue.lastname(value) => NamedParameter("lastname", ParameterValue.from(value))
          case VemployeeFieldValue.suffix(value) => NamedParameter("suffix", ParameterValue.from(value))
          case VemployeeFieldValue.jobtitle(value) => NamedParameter("jobtitle", ParameterValue.from(value))
          case VemployeeFieldValue.phonenumber(value) => NamedParameter("phonenumber", ParameterValue.from(value))
          case VemployeeFieldValue.phonenumbertype(value) => NamedParameter("phonenumbertype", ParameterValue.from(value))
          case VemployeeFieldValue.emailaddress(value) => NamedParameter("emailaddress", ParameterValue.from(value))
          case VemployeeFieldValue.emailpromotion(value) => NamedParameter("emailpromotion", ParameterValue.from(value))
          case VemployeeFieldValue.addressline1(value) => NamedParameter("addressline1", ParameterValue.from(value))
          case VemployeeFieldValue.addressline2(value) => NamedParameter("addressline2", ParameterValue.from(value))
          case VemployeeFieldValue.city(value) => NamedParameter("city", ParameterValue.from(value))
          case VemployeeFieldValue.stateprovincename(value) => NamedParameter("stateprovincename", ParameterValue.from(value))
          case VemployeeFieldValue.postalcode(value) => NamedParameter("postalcode", ParameterValue.from(value))
          case VemployeeFieldValue.countryregionname(value) => NamedParameter("countryregionname", ParameterValue.from(value))
          case VemployeeFieldValue.additionalcontactinfo(value) => NamedParameter("additionalcontactinfo", ParameterValue.from(value))
        }
        val q = s"""select * from humanresources.vemployee where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[VemployeeRow] =
    RowParser[VemployeeRow] { row =>
      Success(
        VemployeeRow(
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          title = row[Option[String]]("title"),
          firstname = row[Option[Name]]("firstname"),
          middlename = row[Option[Name]]("middlename"),
          lastname = row[Option[Name]]("lastname"),
          suffix = row[Option[String]]("suffix"),
          jobtitle = row[Option[String]]("jobtitle"),
          phonenumber = row[Option[Phone]]("phonenumber"),
          phonenumbertype = row[Option[Name]]("phonenumbertype"),
          emailaddress = row[Option[String]]("emailaddress"),
          emailpromotion = row[Option[Int]]("emailpromotion"),
          addressline1 = row[Option[String]]("addressline1"),
          addressline2 = row[Option[String]]("addressline2"),
          city = row[Option[String]]("city"),
          stateprovincename = row[Option[Name]]("stateprovincename"),
          postalcode = row[Option[String]]("postalcode"),
          countryregionname = row[Option[Name]]("countryregionname"),
          additionalcontactinfo = row[Option[/* xml */ String]]("additionalcontactinfo")
        )
      )
    }
}