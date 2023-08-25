/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package d

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.document.DocumentId
import adventureworks.public.Flag
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class DViewStructure[Row](val prefix: Option[String], val extract: Row => DViewRow, val merge: (Row, DViewRow) => Row)
  extends Relation[DViewFields, DViewRow, Row]
    with DViewFields[Row] { outer =>

  override val title = new Field[/* max 50 chars */ String, Row](prefix, "title", None, None)(x => extract(x).title, (row, value) => merge(row, extract(row).copy(title = value)))
  override val owner = new Field[BusinessentityId, Row](prefix, "owner", None, Some("int4"))(x => extract(x).owner, (row, value) => merge(row, extract(row).copy(owner = value)))
  override val folderflag = new Field[Flag, Row](prefix, "folderflag", None, Some(""""public"."Flag""""))(x => extract(x).folderflag, (row, value) => merge(row, extract(row).copy(folderflag = value)))
  override val filename = new Field[/* max 400 chars */ String, Row](prefix, "filename", None, None)(x => extract(x).filename, (row, value) => merge(row, extract(row).copy(filename = value)))
  override val fileextension = new Field[/* max 8 chars */ String, Row](prefix, "fileextension", None, None)(x => extract(x).fileextension, (row, value) => merge(row, extract(row).copy(fileextension = value)))
  override val revision = new Field[/* bpchar, max 5 chars */ String, Row](prefix, "revision", None, Some("bpchar"))(x => extract(x).revision, (row, value) => merge(row, extract(row).copy(revision = value)))
  override val changenumber = new Field[Int, Row](prefix, "changenumber", None, Some("int4"))(x => extract(x).changenumber, (row, value) => merge(row, extract(row).copy(changenumber = value)))
  override val status = new Field[Int, Row](prefix, "status", None, Some("int2"))(x => extract(x).status, (row, value) => merge(row, extract(row).copy(status = value)))
  override val documentsummary = new Field[String, Row](prefix, "documentsummary", None, None)(x => extract(x).documentsummary, (row, value) => merge(row, extract(row).copy(documentsummary = value)))
  override val document = new Field[Byte, Row](prefix, "document", None, Some("bytea"))(x => extract(x).document, (row, value) => merge(row, extract(row).copy(document = value)))
  override val rowguid = new Field[UUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
  override val documentnode = new Field[DocumentId, Row](prefix, "documentnode", None, None)(x => extract(x).documentnode, (row, value) => merge(row, extract(row).copy(documentnode = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](title, owner, folderflag, filename, fileextension, revision, changenumber, status, documentsummary, document, rowguid, modifieddate, documentnode)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => DViewRow, merge: (NewRow, DViewRow) => NewRow): DViewStructure[NewRow] =
    new DViewStructure(prefix, extract, merge)
}
