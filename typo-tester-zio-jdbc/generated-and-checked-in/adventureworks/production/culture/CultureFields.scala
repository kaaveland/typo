/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait CultureFields[Row] {
  val cultureid: IdField[CultureId, Row]
  val name: Field[Name, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object CultureFields {
  val structure: Relation[CultureFields, CultureRow, CultureRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => CultureRow, val merge: (Row, CultureRow) => Row)
    extends Relation[CultureFields, CultureRow, Row] { 
  
    override val fields: CultureFields[Row] = new CultureFields[Row] {
      override val cultureid = new IdField[CultureId, Row](prefix, "cultureid", None, Some("bpchar"))(x => extract(x).cultureid, (row, value) => merge(row, extract(row).copy(cultureid = value)))
      override val name = new Field[Name, Row](prefix, "name", None, Some("varchar"))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.cultureid, fields.name, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => CultureRow, merge: (NewRow, CultureRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
