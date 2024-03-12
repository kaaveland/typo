/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait PaViewFields[Row] {
  val id: Field[BusinessentityId, Row]
  val businessentityid: Field[BusinessentityId, Row]
  val passwordhash: Field[/* max 128 chars */ String, Row]
  val passwordsalt: Field[/* max 10 chars */ String, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object PaViewFields {
  val structure: Relation[PaViewFields, PaViewRow, PaViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => PaViewRow, val merge: (Row, PaViewRow) => Row)
    extends Relation[PaViewFields, PaViewRow, Row] { 
  
    override val fields: PaViewFields[Row] = new PaViewFields[Row] {
      override val id = new Field[BusinessentityId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
      override val businessentityid = new Field[BusinessentityId, Row](prefix, "businessentityid", None, None)(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
      override val passwordhash = new Field[/* max 128 chars */ String, Row](prefix, "passwordhash", None, None)(x => extract(x).passwordhash, (row, value) => merge(row, extract(row).copy(passwordhash = value)))
      override val passwordsalt = new Field[/* max 10 chars */ String, Row](prefix, "passwordsalt", None, None)(x => extract(x).passwordsalt, (row, value) => merge(row, extract(row).copy(passwordsalt = value)))
      override val rowguid = new Field[TypoUUID, Row](prefix, "rowguid", None, None)(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.id, fields.businessentityid, fields.passwordhash, fields.passwordsalt, fields.rowguid, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => PaViewRow, merge: (NewRow, PaViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
