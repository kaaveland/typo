/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VstorewithaddressesViewFields {
  def businessentityid: Field[BusinessentityId, VstorewithaddressesViewRow]
  def name: Field[Name, VstorewithaddressesViewRow]
  def addresstype: Field[Name, VstorewithaddressesViewRow]
  def addressline1: Field[/* max 60 chars */ String, VstorewithaddressesViewRow]
  def addressline2: OptField[/* max 60 chars */ String, VstorewithaddressesViewRow]
  def city: Field[/* max 30 chars */ String, VstorewithaddressesViewRow]
  def stateprovincename: Field[Name, VstorewithaddressesViewRow]
  def postalcode: Field[/* max 15 chars */ String, VstorewithaddressesViewRow]
  def countryregionname: Field[Name, VstorewithaddressesViewRow]
}

object VstorewithaddressesViewFields {
  lazy val structure: Relation[VstorewithaddressesViewFields, VstorewithaddressesViewRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[VstorewithaddressesViewFields, VstorewithaddressesViewRow] {
  
    override lazy val fields: VstorewithaddressesViewFields = new VstorewithaddressesViewFields {
      override def businessentityid = Field[BusinessentityId, VstorewithaddressesViewRow](_path, "businessentityid", None, None, x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def name = Field[Name, VstorewithaddressesViewRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
      override def addresstype = Field[Name, VstorewithaddressesViewRow](_path, "addresstype", None, None, x => x.addresstype, (row, value) => row.copy(addresstype = value))
      override def addressline1 = Field[/* max 60 chars */ String, VstorewithaddressesViewRow](_path, "addressline1", None, None, x => x.addressline1, (row, value) => row.copy(addressline1 = value))
      override def addressline2 = OptField[/* max 60 chars */ String, VstorewithaddressesViewRow](_path, "addressline2", None, None, x => x.addressline2, (row, value) => row.copy(addressline2 = value))
      override def city = Field[/* max 30 chars */ String, VstorewithaddressesViewRow](_path, "city", None, None, x => x.city, (row, value) => row.copy(city = value))
      override def stateprovincename = Field[Name, VstorewithaddressesViewRow](_path, "stateprovincename", None, None, x => x.stateprovincename, (row, value) => row.copy(stateprovincename = value))
      override def postalcode = Field[/* max 15 chars */ String, VstorewithaddressesViewRow](_path, "postalcode", None, None, x => x.postalcode, (row, value) => row.copy(postalcode = value))
      override def countryregionname = Field[Name, VstorewithaddressesViewRow](_path, "countryregionname", None, None, x => x.countryregionname, (row, value) => row.copy(countryregionname = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, VstorewithaddressesViewRow]] =
      List[FieldLikeNoHkt[?, VstorewithaddressesViewRow]](fields.businessentityid, fields.name, fields.addresstype, fields.addressline1, fields.addressline2, fields.city, fields.stateprovincename, fields.postalcode, fields.countryregionname)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
