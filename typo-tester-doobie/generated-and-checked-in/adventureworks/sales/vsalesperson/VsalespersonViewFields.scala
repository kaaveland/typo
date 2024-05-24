/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalesperson

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import adventureworks.userdefined.FirstName
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VsalespersonViewFields {
  def businessentityid: Field[BusinessentityId, VsalespersonViewRow]
  def title: OptField[/* max 8 chars */ String, VsalespersonViewRow]
  def firstname: Field[/* user-picked */ FirstName, VsalespersonViewRow]
  def middlename: OptField[Name, VsalespersonViewRow]
  def lastname: Field[Name, VsalespersonViewRow]
  def suffix: OptField[/* max 10 chars */ String, VsalespersonViewRow]
  def jobtitle: Field[/* max 50 chars */ String, VsalespersonViewRow]
  def phonenumber: OptField[Phone, VsalespersonViewRow]
  def phonenumbertype: OptField[Name, VsalespersonViewRow]
  def emailaddress: OptField[/* max 50 chars */ String, VsalespersonViewRow]
  def emailpromotion: Field[Int, VsalespersonViewRow]
  def addressline1: Field[/* max 60 chars */ String, VsalespersonViewRow]
  def addressline2: OptField[/* max 60 chars */ String, VsalespersonViewRow]
  def city: Field[/* max 30 chars */ String, VsalespersonViewRow]
  def stateprovincename: Field[Name, VsalespersonViewRow]
  def postalcode: Field[/* max 15 chars */ String, VsalespersonViewRow]
  def countryregionname: Field[Name, VsalespersonViewRow]
  def territoryname: OptField[Name, VsalespersonViewRow]
  def territorygroup: OptField[/* max 50 chars */ String, VsalespersonViewRow]
  def salesquota: OptField[BigDecimal, VsalespersonViewRow]
  def salesytd: Field[BigDecimal, VsalespersonViewRow]
  def saleslastyear: Field[BigDecimal, VsalespersonViewRow]
}

object VsalespersonViewFields {
  lazy val structure: Relation[VsalespersonViewFields, VsalespersonViewRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[VsalespersonViewFields, VsalespersonViewRow] {
  
    override lazy val fields: VsalespersonViewFields = new VsalespersonViewFields {
      override def businessentityid = Field[BusinessentityId, VsalespersonViewRow](_path, "businessentityid", None, None, x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def title = OptField[/* max 8 chars */ String, VsalespersonViewRow](_path, "title", None, None, x => x.title, (row, value) => row.copy(title = value))
      override def firstname = Field[/* user-picked */ FirstName, VsalespersonViewRow](_path, "firstname", None, None, x => x.firstname, (row, value) => row.copy(firstname = value))
      override def middlename = OptField[Name, VsalespersonViewRow](_path, "middlename", None, None, x => x.middlename, (row, value) => row.copy(middlename = value))
      override def lastname = Field[Name, VsalespersonViewRow](_path, "lastname", None, None, x => x.lastname, (row, value) => row.copy(lastname = value))
      override def suffix = OptField[/* max 10 chars */ String, VsalespersonViewRow](_path, "suffix", None, None, x => x.suffix, (row, value) => row.copy(suffix = value))
      override def jobtitle = Field[/* max 50 chars */ String, VsalespersonViewRow](_path, "jobtitle", None, None, x => x.jobtitle, (row, value) => row.copy(jobtitle = value))
      override def phonenumber = OptField[Phone, VsalespersonViewRow](_path, "phonenumber", None, None, x => x.phonenumber, (row, value) => row.copy(phonenumber = value))
      override def phonenumbertype = OptField[Name, VsalespersonViewRow](_path, "phonenumbertype", None, None, x => x.phonenumbertype, (row, value) => row.copy(phonenumbertype = value))
      override def emailaddress = OptField[/* max 50 chars */ String, VsalespersonViewRow](_path, "emailaddress", None, None, x => x.emailaddress, (row, value) => row.copy(emailaddress = value))
      override def emailpromotion = Field[Int, VsalespersonViewRow](_path, "emailpromotion", None, None, x => x.emailpromotion, (row, value) => row.copy(emailpromotion = value))
      override def addressline1 = Field[/* max 60 chars */ String, VsalespersonViewRow](_path, "addressline1", None, None, x => x.addressline1, (row, value) => row.copy(addressline1 = value))
      override def addressline2 = OptField[/* max 60 chars */ String, VsalespersonViewRow](_path, "addressline2", None, None, x => x.addressline2, (row, value) => row.copy(addressline2 = value))
      override def city = Field[/* max 30 chars */ String, VsalespersonViewRow](_path, "city", None, None, x => x.city, (row, value) => row.copy(city = value))
      override def stateprovincename = Field[Name, VsalespersonViewRow](_path, "stateprovincename", None, None, x => x.stateprovincename, (row, value) => row.copy(stateprovincename = value))
      override def postalcode = Field[/* max 15 chars */ String, VsalespersonViewRow](_path, "postalcode", None, None, x => x.postalcode, (row, value) => row.copy(postalcode = value))
      override def countryregionname = Field[Name, VsalespersonViewRow](_path, "countryregionname", None, None, x => x.countryregionname, (row, value) => row.copy(countryregionname = value))
      override def territoryname = OptField[Name, VsalespersonViewRow](_path, "territoryname", None, None, x => x.territoryname, (row, value) => row.copy(territoryname = value))
      override def territorygroup = OptField[/* max 50 chars */ String, VsalespersonViewRow](_path, "territorygroup", None, None, x => x.territorygroup, (row, value) => row.copy(territorygroup = value))
      override def salesquota = OptField[BigDecimal, VsalespersonViewRow](_path, "salesquota", None, None, x => x.salesquota, (row, value) => row.copy(salesquota = value))
      override def salesytd = Field[BigDecimal, VsalespersonViewRow](_path, "salesytd", None, None, x => x.salesytd, (row, value) => row.copy(salesytd = value))
      override def saleslastyear = Field[BigDecimal, VsalespersonViewRow](_path, "saleslastyear", None, None, x => x.saleslastyear, (row, value) => row.copy(saleslastyear = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, VsalespersonViewRow]] =
      List[FieldLikeNoHkt[?, VsalespersonViewRow]](fields.businessentityid, fields.title, fields.firstname, fields.middlename, fields.lastname, fields.suffix, fields.jobtitle, fields.phonenumber, fields.phonenumbertype, fields.emailaddress, fields.emailpromotion, fields.addressline1, fields.addressline2, fields.city, fields.stateprovincename, fields.postalcode, fields.countryregionname, fields.territoryname, fields.territorygroup, fields.salesquota, fields.salesytd, fields.saleslastyear)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
