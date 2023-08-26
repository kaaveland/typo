/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class AddresstypeStructure[Row](val prefix: Option[String], val extract: Row => AddresstypeRow, val merge: (Row, AddresstypeRow) => Row)
  extends Relation[AddresstypeFields, AddresstypeRow, Row]
    with AddresstypeFields[Row] { outer =>

  override val addresstypeid = new IdField[AddresstypeId, Row](prefix, "addresstypeid", None, Some("int4"))(x => extract(x).addresstypeid, (row, value) => merge(row, extract(row).copy(addresstypeid = value)))
  override val name = new Field[Name, Row](prefix, "name", None, Some("varchar"))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val rowguid = new Field[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](addresstypeid, name, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => AddresstypeRow, merge: (NewRow, AddresstypeRow) => NewRow): AddresstypeStructure[NewRow] =
    new AddresstypeStructure(prefix, extract, merge)
}
