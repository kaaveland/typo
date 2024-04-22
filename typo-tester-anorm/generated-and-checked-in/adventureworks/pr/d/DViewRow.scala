/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package d

import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.document.DocumentId
import adventureworks.public.Flag
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** View: pr.d */
case class DViewRow(
  /** Points to [[production.document.DocumentRow.title]] */
  title: /* max 50 chars */ String,
  /** Points to [[production.document.DocumentRow.owner]] */
  owner: BusinessentityId,
  /** Points to [[production.document.DocumentRow.folderflag]] */
  folderflag: Flag,
  /** Points to [[production.document.DocumentRow.filename]] */
  filename: /* max 400 chars */ String,
  /** Points to [[production.document.DocumentRow.fileextension]] */
  fileextension: Option[/* max 8 chars */ String],
  /** Points to [[production.document.DocumentRow.revision]] */
  revision: /* bpchar, max 5 chars */ String,
  /** Points to [[production.document.DocumentRow.changenumber]] */
  changenumber: Int,
  /** Points to [[production.document.DocumentRow.status]] */
  status: TypoShort,
  /** Points to [[production.document.DocumentRow.documentsummary]] */
  documentsummary: Option[String],
  /** Points to [[production.document.DocumentRow.document]] */
  document: Option[TypoBytea],
  /** Points to [[production.document.DocumentRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[production.document.DocumentRow.modifieddate]] */
  modifieddate: TypoLocalDateTime,
  /** Points to [[production.document.DocumentRow.documentnode]] */
  documentnode: DocumentId
)

object DViewRow {
  implicit lazy val reads: Reads[DViewRow] = Reads[DViewRow](json => JsResult.fromTry(
      Try(
        DViewRow(
          title = json.\("title").as(Reads.StringReads),
          owner = json.\("owner").as(BusinessentityId.reads),
          folderflag = json.\("folderflag").as(Flag.reads),
          filename = json.\("filename").as(Reads.StringReads),
          fileextension = json.\("fileextension").toOption.map(_.as(Reads.StringReads)),
          revision = json.\("revision").as(Reads.StringReads),
          changenumber = json.\("changenumber").as(Reads.IntReads),
          status = json.\("status").as(TypoShort.reads),
          documentsummary = json.\("documentsummary").toOption.map(_.as(Reads.StringReads)),
          document = json.\("document").toOption.map(_.as(TypoBytea.reads)),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads),
          documentnode = json.\("documentnode").as(DocumentId.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[DViewRow] = RowParser[DViewRow] { row =>
    Success(
      DViewRow(
        title = row(idx + 0)(Column.columnToString),
        owner = row(idx + 1)(BusinessentityId.column),
        folderflag = row(idx + 2)(Flag.column),
        filename = row(idx + 3)(Column.columnToString),
        fileextension = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        revision = row(idx + 5)(Column.columnToString),
        changenumber = row(idx + 6)(Column.columnToInt),
        status = row(idx + 7)(TypoShort.column),
        documentsummary = row(idx + 8)(Column.columnToOption(Column.columnToString)),
        document = row(idx + 9)(Column.columnToOption(TypoBytea.column)),
        rowguid = row(idx + 10)(TypoUUID.column),
        modifieddate = row(idx + 11)(TypoLocalDateTime.column),
        documentnode = row(idx + 12)(DocumentId.column)
      )
    )
  }
  implicit lazy val writes: OWrites[DViewRow] = OWrites[DViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "title" -> Writes.StringWrites.writes(o.title),
      "owner" -> BusinessentityId.writes.writes(o.owner),
      "folderflag" -> Flag.writes.writes(o.folderflag),
      "filename" -> Writes.StringWrites.writes(o.filename),
      "fileextension" -> Writes.OptionWrites(Writes.StringWrites).writes(o.fileextension),
      "revision" -> Writes.StringWrites.writes(o.revision),
      "changenumber" -> Writes.IntWrites.writes(o.changenumber),
      "status" -> TypoShort.writes.writes(o.status),
      "documentsummary" -> Writes.OptionWrites(Writes.StringWrites).writes(o.documentsummary),
      "document" -> Writes.OptionWrites(TypoBytea.writes).writes(o.document),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate),
      "documentnode" -> DocumentId.writes.writes(o.documentnode)
    ))
  )
}
