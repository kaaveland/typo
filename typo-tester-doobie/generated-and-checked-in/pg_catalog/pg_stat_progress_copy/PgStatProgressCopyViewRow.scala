/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_copy

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatProgressCopyViewRow(
  pid: Option[Int],
  datid: Option[/* oid */ Long],
  datname: Option[String],
  relid: Option[/* oid */ Long],
  command: Option[String],
  `type`: Option[String],
  bytesProcessed: Option[Long],
  bytesTotal: Option[Long],
  tuplesProcessed: Option[Long],
  tuplesExcluded: Option[Long]
)

object PgStatProgressCopyViewRow {
  implicit lazy val decoder: Decoder[PgStatProgressCopyViewRow] = Decoder.forProduct10[PgStatProgressCopyViewRow, Option[Int], Option[/* oid */ Long], Option[String], Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Long], Option[Long], Option[Long]]("pid", "datid", "datname", "relid", "command", "type", "bytes_processed", "bytes_total", "tuples_processed", "tuples_excluded")(PgStatProgressCopyViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgStatProgressCopyViewRow] = Encoder.forProduct10[PgStatProgressCopyViewRow, Option[Int], Option[/* oid */ Long], Option[String], Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Long], Option[Long], Option[Long]]("pid", "datid", "datname", "relid", "command", "type", "bytes_processed", "bytes_total", "tuples_processed", "tuples_excluded")(x => (x.pid, x.datid, x.datname, x.relid, x.command, x.`type`, x.bytesProcessed, x.bytesTotal, x.tuplesProcessed, x.tuplesExcluded))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgStatProgressCopyViewRow] = new Read[PgStatProgressCopyViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatProgressCopyViewRow(
      pid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      datid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      datname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      relid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      command = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      `type` = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      bytesProcessed = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      bytesTotal = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      tuplesProcessed = Meta.LongMeta.get.unsafeGetNullable(rs, i + 8),
      tuplesExcluded = Meta.LongMeta.get.unsafeGetNullable(rs, i + 9)
    )
  )
}
