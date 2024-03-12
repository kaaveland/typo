/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package v

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VViewFields[Row] {
  val id: Field[BusinessentityId, Row]
  val businessentityid: Field[BusinessentityId, Row]
  val accountnumber: Field[AccountNumber, Row]
  val name: Field[Name, Row]
  val creditrating: Field[TypoShort, Row]
  val preferredvendorstatus: Field[Flag, Row]
  val activeflag: Field[Flag, Row]
  val purchasingwebserviceurl: OptField[/* max 1024 chars */ String, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object VViewFields {
  val structure: Relation[VViewFields, VViewRow, VViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => VViewRow, val merge: (Row, VViewRow) => Row)
    extends Relation[VViewFields, VViewRow, Row] { 
  
    override val fields: VViewFields[Row] = new VViewFields[Row] {
      override val id = new Field[BusinessentityId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
      override val businessentityid = new Field[BusinessentityId, Row](prefix, "businessentityid", None, None)(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
      override val accountnumber = new Field[AccountNumber, Row](prefix, "accountnumber", None, None)(x => extract(x).accountnumber, (row, value) => merge(row, extract(row).copy(accountnumber = value)))
      override val name = new Field[Name, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
      override val creditrating = new Field[TypoShort, Row](prefix, "creditrating", None, None)(x => extract(x).creditrating, (row, value) => merge(row, extract(row).copy(creditrating = value)))
      override val preferredvendorstatus = new Field[Flag, Row](prefix, "preferredvendorstatus", None, None)(x => extract(x).preferredvendorstatus, (row, value) => merge(row, extract(row).copy(preferredvendorstatus = value)))
      override val activeflag = new Field[Flag, Row](prefix, "activeflag", None, None)(x => extract(x).activeflag, (row, value) => merge(row, extract(row).copy(activeflag = value)))
      override val purchasingwebserviceurl = new OptField[/* max 1024 chars */ String, Row](prefix, "purchasingwebserviceurl", None, None)(x => extract(x).purchasingwebserviceurl, (row, value) => merge(row, extract(row).copy(purchasingwebserviceurl = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.id, fields.businessentityid, fields.accountnumber, fields.name, fields.creditrating, fields.preferredvendorstatus, fields.activeflag, fields.purchasingwebserviceurl, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => VViewRow, merge: (NewRow, VViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
