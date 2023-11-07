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
import adventureworks.userdefined.FirstName
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class VstorewithcontactsViewStructure[Row](val prefix: Option[String], val extract: Row => VstorewithcontactsViewRow, val merge: (Row, VstorewithcontactsViewRow) => Row)
  extends Relation[VstorewithcontactsViewFields, VstorewithcontactsViewRow, Row]
    with VstorewithcontactsViewFields[Row] { outer =>

  override val businessentityid = new Field[BusinessentityId, Row](prefix, "businessentityid", None, None)(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val name = new Field[Name, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val contacttype = new Field[Name, Row](prefix, "contacttype", None, None)(x => extract(x).contacttype, (row, value) => merge(row, extract(row).copy(contacttype = value)))
  override val title = new OptField[/* max 8 chars */ String, Row](prefix, "title", None, None)(x => extract(x).title, (row, value) => merge(row, extract(row).copy(title = value)))
  override val firstname = new Field[/* user-picked */ FirstName, Row](prefix, "firstname", None, None)(x => extract(x).firstname, (row, value) => merge(row, extract(row).copy(firstname = value)))
  override val middlename = new OptField[Name, Row](prefix, "middlename", None, None)(x => extract(x).middlename, (row, value) => merge(row, extract(row).copy(middlename = value)))
  override val lastname = new Field[Name, Row](prefix, "lastname", None, None)(x => extract(x).lastname, (row, value) => merge(row, extract(row).copy(lastname = value)))
  override val suffix = new OptField[/* max 10 chars */ String, Row](prefix, "suffix", None, None)(x => extract(x).suffix, (row, value) => merge(row, extract(row).copy(suffix = value)))
  override val phonenumber = new OptField[Phone, Row](prefix, "phonenumber", None, None)(x => extract(x).phonenumber, (row, value) => merge(row, extract(row).copy(phonenumber = value)))
  override val phonenumbertype = new OptField[Name, Row](prefix, "phonenumbertype", None, None)(x => extract(x).phonenumbertype, (row, value) => merge(row, extract(row).copy(phonenumbertype = value)))
  override val emailaddress = new OptField[/* max 50 chars */ String, Row](prefix, "emailaddress", None, None)(x => extract(x).emailaddress, (row, value) => merge(row, extract(row).copy(emailaddress = value)))
  override val emailpromotion = new Field[Int, Row](prefix, "emailpromotion", None, None)(x => extract(x).emailpromotion, (row, value) => merge(row, extract(row).copy(emailpromotion = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](businessentityid, name, contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => VstorewithcontactsViewRow, merge: (NewRow, VstorewithcontactsViewRow) => NewRow): VstorewithcontactsViewStructure[NewRow] =
    new VstorewithcontactsViewStructure(prefix, extract, merge)
}
