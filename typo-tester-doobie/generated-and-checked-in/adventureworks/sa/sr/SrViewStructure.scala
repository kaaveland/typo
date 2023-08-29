/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.sales.salesreason.SalesreasonId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class SrViewStructure[Row](val prefix: Option[String], val extract: Row => SrViewRow, val merge: (Row, SrViewRow) => Row)
  extends Relation[SrViewFields, SrViewRow, Row]
    with SrViewFields[Row] { outer =>

  override val id = new Field[SalesreasonId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val salesreasonid = new Field[SalesreasonId, Row](prefix, "salesreasonid", None, None)(x => extract(x).salesreasonid, (row, value) => merge(row, extract(row).copy(salesreasonid = value)))
  override val name = new Field[Name, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val reasontype = new Field[Name, Row](prefix, "reasontype", None, None)(x => extract(x).reasontype, (row, value) => merge(row, extract(row).copy(reasontype = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, salesreasonid, name, reasontype, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => SrViewRow, merge: (NewRow, SrViewRow) => NewRow): SrViewStructure[NewRow] =
    new SrViewStructure(prefix, extract, merge)
}
