/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import org.postgresql.jdbc.PgSQLXML

case class IllustrationRow(
  /** Primary key for Illustration records. */
  illustrationid: IllustrationId,
  /** Illustrations used in manufacturing instructions. Stored as XML. */
  diagram: Option[PgSQLXML],
  modifieddate: LocalDateTime
)

object IllustrationRow {
  implicit val decoder: Decoder[IllustrationRow] =
    (c: HCursor) =>
      for {
        illustrationid <- c.downField("illustrationid").as[IllustrationId]
        diagram <- c.downField("diagram").as[Option[PgSQLXML]]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield IllustrationRow(illustrationid, diagram, modifieddate)
  implicit val encoder: Encoder[IllustrationRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "illustrationid" := row.illustrationid,
        "diagram" := row.diagram,
        "modifieddate" := row.modifieddate
      )}
}
