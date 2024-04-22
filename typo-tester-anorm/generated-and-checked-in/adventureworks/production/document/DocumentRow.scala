/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.Text
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
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

/** Table: production.document
    Product maintenance documents.
    Primary key: documentnode */
case class DocumentRow(
  /** Title of the document. */
  title: /* max 50 chars */ String,
  /** Employee who controls the document.  Foreign key to Employee.BusinessEntityID
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  owner: BusinessentityId,
  /** 0 = This is a folder, 1 = This is a document.
      Default: false */
  folderflag: Flag,
  /** File name of the document */
  filename: /* max 400 chars */ String,
  /** File extension indicating the document type. For example, .doc or .txt. */
  fileextension: Option[/* max 8 chars */ String],
  /** Revision number of the document. */
  revision: /* bpchar, max 5 chars */ String,
  /** Engineering change approval number.
      Default: 0 */
  changenumber: Int,
  /** 1 = Pending approval, 2 = Approved, 3 = Obsolete
      Constraint CK_Document_Status affecting columns status: (((status >= 1) AND (status <= 3))) */
  status: TypoShort,
  /** Document abstract. */
  documentsummary: Option[String],
  /** Complete document. */
  document: Option[TypoBytea],
  /** ROWGUIDCOL number uniquely identifying the record. Required for FileStream.
      Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime,
  /** Primary key for Document records.
      Default: '/'::character varying */
  documentnode: DocumentId
)

object DocumentRow {
  implicit lazy val reads: Reads[DocumentRow] = Reads[DocumentRow](json => JsResult.fromTry(
      Try(
        DocumentRow(
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
  def rowParser(idx: Int): RowParser[DocumentRow] = RowParser[DocumentRow] { row =>
    Success(
      DocumentRow(
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
  implicit lazy val text: Text[DocumentRow] = Text.instance[DocumentRow]{ (row, sb) =>
    Text.stringInstance.unsafeEncode(row.title, sb)
    sb.append(Text.DELIMETER)
    BusinessentityId.text.unsafeEncode(row.owner, sb)
    sb.append(Text.DELIMETER)
    Flag.text.unsafeEncode(row.folderflag, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.filename, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.fileextension, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.revision, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.changenumber, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.status, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.documentsummary, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoBytea.text).unsafeEncode(row.document, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    sb.append(Text.DELIMETER)
    DocumentId.text.unsafeEncode(row.documentnode, sb)
  }
  implicit lazy val writes: OWrites[DocumentRow] = OWrites[DocumentRow](o =>
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
