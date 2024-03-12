/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pnt

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait PntViewFields[Row] {
  val id: Field[PhonenumbertypeId, Row]
  val phonenumbertypeid: Field[PhonenumbertypeId, Row]
  val name: Field[Name, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object PntViewFields {
  val structure: Relation[PntViewFields, PntViewRow, PntViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => PntViewRow, val merge: (Row, PntViewRow) => Row)
    extends Relation[PntViewFields, PntViewRow, Row] { 
  
    override val fields: PntViewFields[Row] = new PntViewFields[Row] {
      override val id = new Field[PhonenumbertypeId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
      override val phonenumbertypeid = new Field[PhonenumbertypeId, Row](prefix, "phonenumbertypeid", None, None)(x => extract(x).phonenumbertypeid, (row, value) => merge(row, extract(row).copy(phonenumbertypeid = value)))
      override val name = new Field[Name, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.id, fields.phonenumbertypeid, fields.name, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => PntViewRow, merge: (NewRow, PntViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
