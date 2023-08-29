/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package i

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import adventureworks.production.illustration.IllustrationId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class IViewStructure[Row](val prefix: Option[String], val extract: Row => IViewRow, val merge: (Row, IViewRow) => Row)
  extends Relation[IViewFields, IViewRow, Row]
    with IViewFields[Row] { outer =>

  override val id = new Field[IllustrationId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val illustrationid = new Field[IllustrationId, Row](prefix, "illustrationid", None, None)(x => extract(x).illustrationid, (row, value) => merge(row, extract(row).copy(illustrationid = value)))
  override val diagram = new OptField[TypoXml, Row](prefix, "diagram", None, None)(x => extract(x).diagram, (row, value) => merge(row, extract(row).copy(diagram = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, illustrationid, diagram, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => IViewRow, merge: (NewRow, IViewRow) => NewRow): IViewStructure[NewRow] =
    new IViewStructure(prefix, extract, merge)
}
