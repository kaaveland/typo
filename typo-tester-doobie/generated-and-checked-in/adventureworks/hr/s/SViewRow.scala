/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package s

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoLocalTime
import adventureworks.humanresources.shift.ShiftId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class SViewRow(
  /** Points to [[humanresources.shift.ShiftRow.shiftid]] */
  id: ShiftId,
  /** Points to [[humanresources.shift.ShiftRow.shiftid]] */
  shiftid: ShiftId,
  /** Points to [[humanresources.shift.ShiftRow.name]] */
  name: Name,
  /** Points to [[humanresources.shift.ShiftRow.starttime]] */
  starttime: TypoLocalTime,
  /** Points to [[humanresources.shift.ShiftRow.endtime]] */
  endtime: TypoLocalTime,
  /** Points to [[humanresources.shift.ShiftRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SViewRow {
  implicit lazy val decoder: Decoder[SViewRow] = Decoder.forProduct6[SViewRow, ShiftId, ShiftId, Name, TypoLocalTime, TypoLocalTime, TypoLocalDateTime]("id", "shiftid", "name", "starttime", "endtime", "modifieddate")(SViewRow.apply)(ShiftId.decoder, ShiftId.decoder, Name.decoder, TypoLocalTime.decoder, TypoLocalTime.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SViewRow] = Encoder.forProduct6[SViewRow, ShiftId, ShiftId, Name, TypoLocalTime, TypoLocalTime, TypoLocalDateTime]("id", "shiftid", "name", "starttime", "endtime", "modifieddate")(x => (x.id, x.shiftid, x.name, x.starttime, x.endtime, x.modifieddate))(ShiftId.encoder, ShiftId.encoder, Name.encoder, TypoLocalTime.encoder, TypoLocalTime.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SViewRow] = new Read[SViewRow](
    gets = List(
      (ShiftId.get, Nullability.NoNulls),
      (ShiftId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalTime.get, Nullability.NoNulls),
      (TypoLocalTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SViewRow(
      id = ShiftId.get.unsafeGetNonNullable(rs, i + 0),
      shiftid = ShiftId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      starttime = TypoLocalTime.get.unsafeGetNonNullable(rs, i + 3),
      endtime = TypoLocalTime.get.unsafeGetNonNullable(rs, i + 4),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5)
    )
  )
}
