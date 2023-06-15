/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package um

import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

case class UmViewRow(
  id: Option[/* bpchar */ String],
  /** Points to [[production.unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.unitmeasure.UnitmeasureRow.name]] */
  name: Option[Name],
  /** Points to [[production.unitmeasure.UnitmeasureRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object UmViewRow {
  implicit val decoder: Decoder[UmViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[/* bpchar */ String]]
        unitmeasurecode <- c.downField("unitmeasurecode").as[Option[UnitmeasureId]]
        name <- c.downField("name").as[Option[Name]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield UmViewRow(id, unitmeasurecode, name, modifieddate)
  implicit val encoder: Encoder[UmViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "unitmeasurecode" := row.unitmeasurecode,
        "name" := row.name,
        "modifieddate" := row.modifieddate
      )}
}