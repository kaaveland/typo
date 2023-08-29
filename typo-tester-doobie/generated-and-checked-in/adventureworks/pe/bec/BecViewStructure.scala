/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bec

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class BecViewStructure[Row](val prefix: Option[String], val extract: Row => BecViewRow, val merge: (Row, BecViewRow) => Row)
  extends Relation[BecViewFields, BecViewRow, Row]
    with BecViewFields[Row] { outer =>

  override val id = new Field[BusinessentityId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val businessentityid = new Field[BusinessentityId, Row](prefix, "businessentityid", None, None)(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val personid = new Field[BusinessentityId, Row](prefix, "personid", None, None)(x => extract(x).personid, (row, value) => merge(row, extract(row).copy(personid = value)))
  override val contacttypeid = new Field[ContacttypeId, Row](prefix, "contacttypeid", None, None)(x => extract(x).contacttypeid, (row, value) => merge(row, extract(row).copy(contacttypeid = value)))
  override val rowguid = new Field[UUID, Row](prefix, "rowguid", None, None)(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, businessentityid, personid, contacttypeid, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => BecViewRow, merge: (NewRow, BecViewRow) => NewRow): BecViewStructure[NewRow] =
    new BecViewStructure(prefix, extract, merge)
}
