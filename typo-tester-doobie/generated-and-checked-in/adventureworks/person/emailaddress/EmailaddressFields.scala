/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait EmailaddressFields[Row] {
  val businessentityid: IdField[BusinessentityId, Row]
  val emailaddressid: IdField[Int, Row]
  val emailaddress: OptField[/* max 50 chars */ String, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object EmailaddressFields {
  val structure: Relation[EmailaddressFields, EmailaddressRow, EmailaddressRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => EmailaddressRow, val merge: (Row, EmailaddressRow) => Row)
    extends Relation[EmailaddressFields, EmailaddressRow, Row] { 
  
    override val fields: EmailaddressFields[Row] = new EmailaddressFields[Row] {
      override val businessentityid = new IdField[BusinessentityId, Row](prefix, "businessentityid", None, Some("int4"))(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
      override val emailaddressid = new IdField[Int, Row](prefix, "emailaddressid", None, Some("int4"))(x => extract(x).emailaddressid, (row, value) => merge(row, extract(row).copy(emailaddressid = value)))
      override val emailaddress = new OptField[/* max 50 chars */ String, Row](prefix, "emailaddress", None, None)(x => extract(x).emailaddress, (row, value) => merge(row, extract(row).copy(emailaddress = value)))
      override val rowguid = new Field[TypoUUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.businessentityid, fields.emailaddressid, fields.emailaddress, fields.rowguid, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => EmailaddressRow, merge: (NewRow, EmailaddressRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
