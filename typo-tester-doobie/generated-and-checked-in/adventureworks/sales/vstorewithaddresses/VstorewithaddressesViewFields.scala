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
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VstorewithaddressesViewFields[Row] {
  val businessentityid: Field[BusinessentityId, Row]
  val name: Field[Name, Row]
  val addresstype: Field[Name, Row]
  val addressline1: Field[/* max 60 chars */ String, Row]
  val addressline2: OptField[/* max 60 chars */ String, Row]
  val city: Field[/* max 30 chars */ String, Row]
  val stateprovincename: Field[Name, Row]
  val postalcode: Field[/* max 15 chars */ String, Row]
  val countryregionname: Field[Name, Row]
}

object VstorewithaddressesViewFields {
  val structure: Relation[VstorewithaddressesViewFields, VstorewithaddressesViewRow, VstorewithaddressesViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => VstorewithaddressesViewRow, val merge: (Row, VstorewithaddressesViewRow) => Row)
    extends Relation[VstorewithaddressesViewFields, VstorewithaddressesViewRow, Row] { 
  
    override val fields: VstorewithaddressesViewFields[Row] = new VstorewithaddressesViewFields[Row] {
      override val businessentityid = new Field[BusinessentityId, Row](prefix, "businessentityid", None, None)(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
      override val name = new Field[Name, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
      override val addresstype = new Field[Name, Row](prefix, "addresstype", None, None)(x => extract(x).addresstype, (row, value) => merge(row, extract(row).copy(addresstype = value)))
      override val addressline1 = new Field[/* max 60 chars */ String, Row](prefix, "addressline1", None, None)(x => extract(x).addressline1, (row, value) => merge(row, extract(row).copy(addressline1 = value)))
      override val addressline2 = new OptField[/* max 60 chars */ String, Row](prefix, "addressline2", None, None)(x => extract(x).addressline2, (row, value) => merge(row, extract(row).copy(addressline2 = value)))
      override val city = new Field[/* max 30 chars */ String, Row](prefix, "city", None, None)(x => extract(x).city, (row, value) => merge(row, extract(row).copy(city = value)))
      override val stateprovincename = new Field[Name, Row](prefix, "stateprovincename", None, None)(x => extract(x).stateprovincename, (row, value) => merge(row, extract(row).copy(stateprovincename = value)))
      override val postalcode = new Field[/* max 15 chars */ String, Row](prefix, "postalcode", None, None)(x => extract(x).postalcode, (row, value) => merge(row, extract(row).copy(postalcode = value)))
      override val countryregionname = new Field[Name, Row](prefix, "countryregionname", None, None)(x => extract(x).countryregionname, (row, value) => merge(row, extract(row).copy(countryregionname = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.businessentityid, fields.name, fields.addresstype, fields.addressline1, fields.addressline2, fields.city, fields.stateprovincename, fields.postalcode, fields.countryregionname)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => VstorewithaddressesViewRow, merge: (NewRow, VstorewithaddressesViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
