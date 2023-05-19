/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.Defaulted
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

/** This class corresponds to a row in table `production.scrapreason` which has not been persisted yet */
case class ScrapreasonRowUnsaved(
  /** Failure description. */
  name: Name,
  /** Default: nextval('production.scrapreason_scrapreasonid_seq'::regclass)
      Primary key for ScrapReason records. */
  scrapreasonid: Defaulted[ScrapreasonId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(scrapreasonidDefault: => ScrapreasonId, modifieddateDefault: => LocalDateTime): ScrapreasonRow =
    ScrapreasonRow(
      name = name,
      scrapreasonid = scrapreasonid match {
                        case Defaulted.UseDefault => scrapreasonidDefault
                        case Defaulted.Provided(value) => value
                      },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ScrapreasonRowUnsaved {
  implicit val decoder: Decoder[ScrapreasonRowUnsaved] =
    (c: HCursor) =>
      for {
        name <- c.downField("name").as[Name]
        scrapreasonid <- c.downField("scrapreasonid").as[Defaulted[ScrapreasonId]]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield ScrapreasonRowUnsaved(name, scrapreasonid, modifieddate)
  implicit val encoder: Encoder[ScrapreasonRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "name" := row.name,
        "scrapreasonid" := row.scrapreasonid,
        "modifieddate" := row.modifieddate
      )}
}
