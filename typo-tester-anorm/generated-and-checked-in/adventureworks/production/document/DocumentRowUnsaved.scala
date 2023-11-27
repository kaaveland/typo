/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.document` which has not been persisted yet */
case class DocumentRowUnsaved(
  /** Title of the document. */
  title: /* max 50 chars */ String,
  /** Employee who controls the document.  Foreign key to Employee.BusinessEntityID
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  owner: BusinessentityId,
  /** File name of the document */
  filename: /* max 400 chars */ String,
  /** File extension indicating the document type. For example, .doc or .txt. */
  fileextension: Option[/* max 8 chars */ String],
  /** Revision number of the document. */
  revision: /* bpchar, max 5 chars */ String,
  /** 1 = Pending approval, 2 = Approved, 3 = Obsolete
      Constraint CK_Document_Status affecting columns s, t, a, t, u, s:  (((status >= 1) AND (status <= 3))) */
  status: TypoShort,
  /** Document abstract. */
  documentsummary: Option[String],
  /** Complete document. */
  document: Option[TypoBytea],
  /** Default: false
      0 = This is a folder, 1 = This is a document. */
  folderflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: 0
      Engineering change approval number. */
  changenumber: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1()
      ROWGUIDCOL number uniquely identifying the record. Required for FileStream. */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: '/'::character varying
      Primary key for Document records. */
  documentnode: Defaulted[DocumentId] = Defaulted.UseDefault
) {
  def toRow(folderflagDefault: => Flag, changenumberDefault: => Int, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime, documentnodeDefault: => DocumentId): DocumentRow =
    DocumentRow(
      title = title,
      owner = owner,
      filename = filename,
      fileextension = fileextension,
      revision = revision,
      status = status,
      documentsummary = documentsummary,
      document = document,
      folderflag = folderflag match {
                     case Defaulted.UseDefault => folderflagDefault
                     case Defaulted.Provided(value) => value
                   },
      changenumber = changenumber match {
                       case Defaulted.UseDefault => changenumberDefault
                       case Defaulted.Provided(value) => value
                     },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     },
      documentnode = documentnode match {
                       case Defaulted.UseDefault => documentnodeDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object DocumentRowUnsaved {
  implicit lazy val reads: Reads[DocumentRowUnsaved] = Reads[DocumentRowUnsaved](json => JsResult.fromTry(
      Try(
        DocumentRowUnsaved(
          title = json.\("title").as(Reads.StringReads),
          owner = json.\("owner").as(BusinessentityId.reads),
          filename = json.\("filename").as(Reads.StringReads),
          fileextension = json.\("fileextension").toOption.map(_.as(Reads.StringReads)),
          revision = json.\("revision").as(Reads.StringReads),
          status = json.\("status").as(TypoShort.reads),
          documentsummary = json.\("documentsummary").toOption.map(_.as(Reads.StringReads)),
          document = json.\("document").toOption.map(_.as(TypoBytea.reads)),
          folderflag = json.\("folderflag").as(Defaulted.reads(Flag.reads)),
          changenumber = json.\("changenumber").as(Defaulted.reads(Reads.IntReads)),
          rowguid = json.\("rowguid").as(Defaulted.reads(TypoUUID.reads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads)),
          documentnode = json.\("documentnode").as(Defaulted.reads(DocumentId.reads))
        )
      )
    ),
  )
  implicit lazy val text: Text[DocumentRowUnsaved] = Text.instance[DocumentRowUnsaved]{ (row, sb) =>
    Text.stringInstance.unsafeEncode(row.title, sb)
    sb.append(Text.DELIMETER)
    BusinessentityId.text.unsafeEncode(row.owner, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.filename, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.fileextension, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.revision, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.status, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.documentsummary, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoBytea.text).unsafeEncode(row.document, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Flag.text).unsafeEncode(row.folderflag, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.intInstance).unsafeEncode(row.changenumber, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(DocumentId.text).unsafeEncode(row.documentnode, sb)
  }
  implicit lazy val writes: OWrites[DocumentRowUnsaved] = OWrites[DocumentRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "title" -> Writes.StringWrites.writes(o.title),
      "owner" -> BusinessentityId.writes.writes(o.owner),
      "filename" -> Writes.StringWrites.writes(o.filename),
      "fileextension" -> Writes.OptionWrites(Writes.StringWrites).writes(o.fileextension),
      "revision" -> Writes.StringWrites.writes(o.revision),
      "status" -> TypoShort.writes.writes(o.status),
      "documentsummary" -> Writes.OptionWrites(Writes.StringWrites).writes(o.documentsummary),
      "document" -> Writes.OptionWrites(TypoBytea.writes).writes(o.document),
      "folderflag" -> Defaulted.writes(Flag.writes).writes(o.folderflag),
      "changenumber" -> Defaulted.writes(Writes.IntWrites).writes(o.changenumber),
      "rowguid" -> Defaulted.writes(TypoUUID.writes).writes(o.rowguid),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate),
      "documentnode" -> Defaulted.writes(DocumentId.writes).writes(o.documentnode)
    ))
  )
}
