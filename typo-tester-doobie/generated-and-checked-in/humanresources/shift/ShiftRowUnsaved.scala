/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import adventureworks.Defaulted
import adventureworks.public.Name
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.time.LocalTime

/** This class corresponds to a row in table `humanresources.shift` which has not been persisted yet */
case class ShiftRowUnsaved(
  /** Shift description. */
  name: Name,
  /** Shift start time. */
  starttime: LocalTime,
  /** Shift end time. */
  endtime: LocalTime,
  /** Default: nextval('humanresources.shift_shiftid_seq'::regclass)
      Primary key for Shift records. */
  shiftid: Defaulted[ShiftId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(shiftidDefault: => ShiftId, modifieddateDefault: => LocalDateTime): ShiftRow =
    ShiftRow(
      name = name,
      starttime = starttime,
      endtime = endtime,
      shiftid = shiftid match {
                  case Defaulted.UseDefault => shiftidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ShiftRowUnsaved {
  implicit val decoder: Decoder[ShiftRowUnsaved] =
    (c: HCursor) =>
      for {
        name <- c.downField("name").as[Name]
        starttime <- c.downField("starttime").as[LocalTime]
        endtime <- c.downField("endtime").as[LocalTime]
        shiftid <- c.downField("shiftid").as[Defaulted[ShiftId]]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield ShiftRowUnsaved(name, starttime, endtime, shiftid, modifieddate)
  implicit val encoder: Encoder[ShiftRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "name" := row.name,
        "starttime" := row.starttime,
        "endtime" := row.endtime,
        "shiftid" := row.shiftid,
        "modifieddate" := row.modifieddate
      )}
}
