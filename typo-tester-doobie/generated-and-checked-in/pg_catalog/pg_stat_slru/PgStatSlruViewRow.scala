/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_slru

import adventureworks.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatSlruViewRow(
  name: Option[String],
  blksZeroed: Option[Long],
  blksHit: Option[Long],
  blksRead: Option[Long],
  blksWritten: Option[Long],
  blksExists: Option[Long],
  flushes: Option[Long],
  truncates: Option[Long],
  statsReset: Option[TypoOffsetDateTime]
)

object PgStatSlruViewRow {
  implicit lazy val decoder: Decoder[PgStatSlruViewRow] = Decoder.forProduct9[PgStatSlruViewRow, Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[TypoOffsetDateTime]]("name", "blks_zeroed", "blks_hit", "blks_read", "blks_written", "blks_exists", "flushes", "truncates", "stats_reset")(PgStatSlruViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(TypoOffsetDateTime.decoder))
  implicit lazy val encoder: Encoder[PgStatSlruViewRow] = Encoder.forProduct9[PgStatSlruViewRow, Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[TypoOffsetDateTime]]("name", "blks_zeroed", "blks_hit", "blks_read", "blks_written", "blks_exists", "flushes", "truncates", "stats_reset")(x => (x.name, x.blksZeroed, x.blksHit, x.blksRead, x.blksWritten, x.blksExists, x.flushes, x.truncates, x.statsReset))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(TypoOffsetDateTime.encoder))
  implicit lazy val read: Read[PgStatSlruViewRow] = new Read[PgStatSlruViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatSlruViewRow(
      name = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      blksZeroed = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      blksHit = Meta.LongMeta.get.unsafeGetNullable(rs, i + 2),
      blksRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      blksWritten = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      blksExists = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      flushes = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      truncates = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      statsReset = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 8)
    )
  )
}
