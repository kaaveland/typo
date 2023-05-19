/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package d

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.document.DocumentId
import adventureworks.public.Flag
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

case class DViewRow(
  /** Points to [[production.document.DocumentRow.title]] */
  title: Option[String],
  /** Points to [[production.document.DocumentRow.owner]] */
  owner: Option[BusinessentityId],
  /** Points to [[production.document.DocumentRow.folderflag]] */
  folderflag: Flag,
  /** Points to [[production.document.DocumentRow.filename]] */
  filename: Option[String],
  /** Points to [[production.document.DocumentRow.fileextension]] */
  fileextension: Option[String],
  /** Points to [[production.document.DocumentRow.revision]] */
  revision: Option[/* bpchar */ String],
  /** Points to [[production.document.DocumentRow.changenumber]] */
  changenumber: Option[Int],
  /** Points to [[production.document.DocumentRow.status]] */
  status: Option[Int],
  /** Points to [[production.document.DocumentRow.documentsummary]] */
  documentsummary: Option[String],
  /** Points to [[production.document.DocumentRow.document]] */
  document: Option[Byte],
  /** Points to [[production.document.DocumentRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.document.DocumentRow.modifieddate]] */
  modifieddate: Option[LocalDateTime],
  /** Points to [[production.document.DocumentRow.documentnode]] */
  documentnode: Option[DocumentId]
)

object DViewRow {
  implicit val decoder: Decoder[DViewRow] =
    (c: HCursor) =>
      for {
        title <- c.downField("title").as[Option[String]]
        owner <- c.downField("owner").as[Option[BusinessentityId]]
        folderflag <- c.downField("folderflag").as[Flag]
        filename <- c.downField("filename").as[Option[String]]
        fileextension <- c.downField("fileextension").as[Option[String]]
        revision <- c.downField("revision").as[Option[/* bpchar */ String]]
        changenumber <- c.downField("changenumber").as[Option[Int]]
        status <- c.downField("status").as[Option[Int]]
        documentsummary <- c.downField("documentsummary").as[Option[String]]
        document <- c.downField("document").as[Option[Byte]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
        documentnode <- c.downField("documentnode").as[Option[DocumentId]]
      } yield DViewRow(title, owner, folderflag, filename, fileextension, revision, changenumber, status, documentsummary, document, rowguid, modifieddate, documentnode)
  implicit val encoder: Encoder[DViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "title" := row.title,
        "owner" := row.owner,
        "folderflag" := row.folderflag,
        "filename" := row.filename,
        "fileextension" := row.fileextension,
        "revision" := row.revision,
        "changenumber" := row.changenumber,
        "status" := row.status,
        "documentsummary" := row.documentsummary,
        "document" := row.document,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate,
        "documentnode" := row.documentnode
      )}
}
