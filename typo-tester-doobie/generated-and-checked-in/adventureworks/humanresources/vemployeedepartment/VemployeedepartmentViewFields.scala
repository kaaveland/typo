/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartment

import adventureworks.customtypes.TypoLocalDate
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.userdefined.FirstName
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VemployeedepartmentViewFields[Row] {
  val businessentityid: Field[BusinessentityId, Row]
  val title: OptField[/* max 8 chars */ String, Row]
  val firstname: Field[/* user-picked */ FirstName, Row]
  val middlename: OptField[Name, Row]
  val lastname: Field[Name, Row]
  val suffix: OptField[/* max 10 chars */ String, Row]
  val jobtitle: Field[/* max 50 chars */ String, Row]
  val department: Field[Name, Row]
  val groupname: Field[Name, Row]
  val startdate: Field[TypoLocalDate, Row]
}

object VemployeedepartmentViewFields {
  val structure: Relation[VemployeedepartmentViewFields, VemployeedepartmentViewRow, VemployeedepartmentViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => VemployeedepartmentViewRow, val merge: (Row, VemployeedepartmentViewRow) => Row)
    extends Relation[VemployeedepartmentViewFields, VemployeedepartmentViewRow, Row] { 
  
    override val fields: VemployeedepartmentViewFields[Row] = new VemployeedepartmentViewFields[Row] {
      override val businessentityid = new Field[BusinessentityId, Row](prefix, "businessentityid", None, None)(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
      override val title = new OptField[/* max 8 chars */ String, Row](prefix, "title", None, None)(x => extract(x).title, (row, value) => merge(row, extract(row).copy(title = value)))
      override val firstname = new Field[/* user-picked */ FirstName, Row](prefix, "firstname", None, None)(x => extract(x).firstname, (row, value) => merge(row, extract(row).copy(firstname = value)))
      override val middlename = new OptField[Name, Row](prefix, "middlename", None, None)(x => extract(x).middlename, (row, value) => merge(row, extract(row).copy(middlename = value)))
      override val lastname = new Field[Name, Row](prefix, "lastname", None, None)(x => extract(x).lastname, (row, value) => merge(row, extract(row).copy(lastname = value)))
      override val suffix = new OptField[/* max 10 chars */ String, Row](prefix, "suffix", None, None)(x => extract(x).suffix, (row, value) => merge(row, extract(row).copy(suffix = value)))
      override val jobtitle = new Field[/* max 50 chars */ String, Row](prefix, "jobtitle", None, None)(x => extract(x).jobtitle, (row, value) => merge(row, extract(row).copy(jobtitle = value)))
      override val department = new Field[Name, Row](prefix, "department", None, None)(x => extract(x).department, (row, value) => merge(row, extract(row).copy(department = value)))
      override val groupname = new Field[Name, Row](prefix, "groupname", None, None)(x => extract(x).groupname, (row, value) => merge(row, extract(row).copy(groupname = value)))
      override val startdate = new Field[TypoLocalDate, Row](prefix, "startdate", Some("text"), None)(x => extract(x).startdate, (row, value) => merge(row, extract(row).copy(startdate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.businessentityid, fields.title, fields.firstname, fields.middlename, fields.lastname, fields.suffix, fields.jobtitle, fields.department, fields.groupname, fields.startdate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => VemployeedepartmentViewRow, merge: (NewRow, VemployeedepartmentViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
