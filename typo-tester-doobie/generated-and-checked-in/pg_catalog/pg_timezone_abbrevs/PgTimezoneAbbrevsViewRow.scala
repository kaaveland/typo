/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_timezone_abbrevs

import adventureworks.TypoInterval
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgTimezoneAbbrevsViewRow(
  abbrev: Option[String],
  utcOffset: Option[TypoInterval],
  isDst: Option[Boolean]
)

object PgTimezoneAbbrevsViewRow {
  implicit lazy val decoder: Decoder[PgTimezoneAbbrevsViewRow] = Decoder.forProduct3[PgTimezoneAbbrevsViewRow, Option[String], Option[TypoInterval], Option[Boolean]]("abbrev", "utc_offset", "is_dst")(PgTimezoneAbbrevsViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoInterval.decoder), Decoder.decodeOption(Decoder.decodeBoolean))
  implicit lazy val encoder: Encoder[PgTimezoneAbbrevsViewRow] = Encoder.forProduct3[PgTimezoneAbbrevsViewRow, Option[String], Option[TypoInterval], Option[Boolean]]("abbrev", "utc_offset", "is_dst")(x => (x.abbrev, x.utcOffset, x.isDst))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoInterval.encoder), Encoder.encodeOption(Encoder.encodeBoolean))
  implicit lazy val read: Read[PgTimezoneAbbrevsViewRow] = new Read[PgTimezoneAbbrevsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoInterval.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgTimezoneAbbrevsViewRow(
      abbrev = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      utcOffset = TypoInterval.get.unsafeGetNullable(rs, i + 1),
      isDst = Meta.BooleanMeta.get.unsafeGetNullable(rs, i + 2)
    )
  )
}
