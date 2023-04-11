/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithcontacts

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection

object VstorewithcontactsRepoImpl extends VstorewithcontactsRepo {
  override def selectAll(implicit c: Connection): List[VstorewithcontactsRow] = {
    SQL"""select businessentityid, name, contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion from sales.vstorewithcontacts""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VstorewithcontactsFieldOrIdValue[_]])(implicit c: Connection): List[VstorewithcontactsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VstorewithcontactsFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.contacttype(value) => NamedParameter("contacttype", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.firstname(value) => NamedParameter("firstname", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.middlename(value) => NamedParameter("middlename", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.lastname(value) => NamedParameter("lastname", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.suffix(value) => NamedParameter("suffix", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.phonenumber(value) => NamedParameter("phonenumber", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.phonenumbertype(value) => NamedParameter("phonenumbertype", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.emailaddress(value) => NamedParameter("emailaddress", ParameterValue.from(value))
          case VstorewithcontactsFieldValue.emailpromotion(value) => NamedParameter("emailpromotion", ParameterValue.from(value))
        }
        val q = s"""select * from sales.vstorewithcontacts where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[VstorewithcontactsRow] =
    RowParser[VstorewithcontactsRow] { row =>
      Success(
        VstorewithcontactsRow(
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          name = row[Option[Name]]("name"),
          contacttype = row[Option[Name]]("contacttype"),
          title = row[Option[String]]("title"),
          firstname = row[Option[Name]]("firstname"),
          middlename = row[Option[Name]]("middlename"),
          lastname = row[Option[Name]]("lastname"),
          suffix = row[Option[String]]("suffix"),
          phonenumber = row[Option[Phone]]("phonenumber"),
          phonenumbertype = row[Option[Name]]("phonenumbertype"),
          emailaddress = row[Option[String]]("emailaddress"),
          emailpromotion = row[Option[Int]]("emailpromotion")
        )
      )
    }
}