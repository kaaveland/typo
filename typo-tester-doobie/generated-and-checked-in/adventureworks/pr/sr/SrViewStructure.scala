/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package sr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.scrapreason.ScrapreasonId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class SrViewStructure[Row](val prefix: Option[String], val extract: Row => SrViewRow, val merge: (Row, SrViewRow) => Row)
  extends Relation[SrViewFields, SrViewRow, Row]
    with SrViewFields[Row] { outer =>

  override val id = new Field[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val scrapreasonid = new Field[ScrapreasonId, Row](prefix, "scrapreasonid", None, Some("int4"))(x => extract(x).scrapreasonid, (row, value) => merge(row, extract(row).copy(scrapreasonid = value)))
  override val name = new Field[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, scrapreasonid, name, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => SrViewRow, merge: (NewRow, SrViewRow) => NewRow): SrViewStructure[NewRow] =
    new SrViewStructure(prefix, extract, merge)
}
