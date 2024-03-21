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
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

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
  implicit lazy val jsonDecoder: JsonDecoder[DocumentRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val title = jsonObj.get("title").toRight("Missing field 'title'").flatMap(_.as(JsonDecoder.string))
    val owner = jsonObj.get("owner").toRight("Missing field 'owner'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val filename = jsonObj.get("filename").toRight("Missing field 'filename'").flatMap(_.as(JsonDecoder.string))
    val fileextension = jsonObj.get("fileextension").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val revision = jsonObj.get("revision").toRight("Missing field 'revision'").flatMap(_.as(JsonDecoder.string))
    val status = jsonObj.get("status").toRight("Missing field 'status'").flatMap(_.as(TypoShort.jsonDecoder))
    val documentsummary = jsonObj.get("documentsummary").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val document = jsonObj.get("document").fold[Either[String, Option[TypoBytea]]](Right(None))(_.as(JsonDecoder.option(using TypoBytea.jsonDecoder)))
    val folderflag = jsonObj.get("folderflag").toRight("Missing field 'folderflag'").flatMap(_.as(Defaulted.jsonDecoder(Flag.jsonDecoder)))
    val changenumber = jsonObj.get("changenumber").toRight("Missing field 'changenumber'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.int)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(Defaulted.jsonDecoder(TypoUUID.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    val documentnode = jsonObj.get("documentnode").toRight("Missing field 'documentnode'").flatMap(_.as(Defaulted.jsonDecoder(DocumentId.jsonDecoder)))
    if (title.isRight && owner.isRight && filename.isRight && fileextension.isRight && revision.isRight && status.isRight && documentsummary.isRight && document.isRight && folderflag.isRight && changenumber.isRight && rowguid.isRight && modifieddate.isRight && documentnode.isRight)
      Right(DocumentRowUnsaved(title = title.toOption.get, owner = owner.toOption.get, filename = filename.toOption.get, fileextension = fileextension.toOption.get, revision = revision.toOption.get, status = status.toOption.get, documentsummary = documentsummary.toOption.get, document = document.toOption.get, folderflag = folderflag.toOption.get, changenumber = changenumber.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get, documentnode = documentnode.toOption.get))
    else Left(List[Either[String, Any]](title, owner, filename, fileextension, revision, status, documentsummary, document, folderflag, changenumber, rowguid, modifieddate, documentnode).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[DocumentRowUnsaved] = new JsonEncoder[DocumentRowUnsaved] {
    override def unsafeEncode(a: DocumentRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""title":""")
      JsonEncoder.string.unsafeEncode(a.title, indent, out)
      out.write(",")
      out.write(""""owner":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.owner, indent, out)
      out.write(",")
      out.write(""""filename":""")
      JsonEncoder.string.unsafeEncode(a.filename, indent, out)
      out.write(",")
      out.write(""""fileextension":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.fileextension, indent, out)
      out.write(",")
      out.write(""""revision":""")
      JsonEncoder.string.unsafeEncode(a.revision, indent, out)
      out.write(",")
      out.write(""""status":""")
      TypoShort.jsonEncoder.unsafeEncode(a.status, indent, out)
      out.write(",")
      out.write(""""documentsummary":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.documentsummary, indent, out)
      out.write(",")
      out.write(""""document":""")
      JsonEncoder.option(using TypoBytea.jsonEncoder).unsafeEncode(a.document, indent, out)
      out.write(",")
      out.write(""""folderflag":""")
      Defaulted.jsonEncoder(Flag.jsonEncoder).unsafeEncode(a.folderflag, indent, out)
      out.write(",")
      out.write(""""changenumber":""")
      Defaulted.jsonEncoder(JsonEncoder.int).unsafeEncode(a.changenumber, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      Defaulted.jsonEncoder(TypoUUID.jsonEncoder).unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write(",")
      out.write(""""documentnode":""")
      Defaulted.jsonEncoder(DocumentId.jsonEncoder).unsafeEncode(a.documentnode, indent, out)
      out.write("}")
    }
  }
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
}
