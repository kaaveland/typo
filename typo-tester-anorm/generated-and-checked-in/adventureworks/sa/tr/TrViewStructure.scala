/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package tr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import adventureworks.sales.salestaxrate.SalestaxrateId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class TrViewStructure[Row](val prefix: Option[String], val extract: Row => TrViewRow, val merge: (Row, TrViewRow) => Row)
  extends Relation[TrViewFields, TrViewRow, Row]
    with TrViewFields[Row] { outer =>

  override val id = new Field[SalestaxrateId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val salestaxrateid = new Field[SalestaxrateId, Row](prefix, "salestaxrateid", None, None)(x => extract(x).salestaxrateid, (row, value) => merge(row, extract(row).copy(salestaxrateid = value)))
  override val stateprovinceid = new Field[StateprovinceId, Row](prefix, "stateprovinceid", None, None)(x => extract(x).stateprovinceid, (row, value) => merge(row, extract(row).copy(stateprovinceid = value)))
  override val taxtype = new Field[Int, Row](prefix, "taxtype", None, None)(x => extract(x).taxtype, (row, value) => merge(row, extract(row).copy(taxtype = value)))
  override val taxrate = new Field[BigDecimal, Row](prefix, "taxrate", None, None)(x => extract(x).taxrate, (row, value) => merge(row, extract(row).copy(taxrate = value)))
  override val name = new Field[Name, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val rowguid = new Field[UUID, Row](prefix, "rowguid", None, None)(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, salestaxrateid, stateprovinceid, taxtype, taxrate, name, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => TrViewRow, merge: (NewRow, TrViewRow) => NewRow): TrViewStructure[NewRow] =
    new TrViewStructure(prefix, extract, merge)
}
