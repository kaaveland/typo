/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_indexes

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatioAllIndexesViewRow(
  relid: Option[/* oid */ Long],
  indexrelid: Option[/* oid */ Long],
  schemaname: Option[String],
  relname: Option[String],
  indexrelname: Option[String],
  idxBlksRead: Option[Long],
  idxBlksHit: Option[Long]
)

object PgStatioAllIndexesViewRow {
  implicit lazy val decoder: Decoder[PgStatioAllIndexesViewRow] = Decoder.forProduct7[PgStatioAllIndexesViewRow, Option[/* oid */ Long], Option[/* oid */ Long], Option[String], Option[String], Option[String], Option[Long], Option[Long]]("relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_blks_read", "idx_blks_hit")(PgStatioAllIndexesViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgStatioAllIndexesViewRow] = Encoder.forProduct7[PgStatioAllIndexesViewRow, Option[/* oid */ Long], Option[/* oid */ Long], Option[String], Option[String], Option[String], Option[Long], Option[Long]]("relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_blks_read", "idx_blks_hit")(x => (x.relid, x.indexrelid, x.schemaname, x.relname, x.indexrelname, x.idxBlksRead, x.idxBlksHit))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgStatioAllIndexesViewRow] = new Read[PgStatioAllIndexesViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatioAllIndexesViewRow(
      relid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      indexrelid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 1),
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      relname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      indexrelname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      idxBlksRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      idxBlksHit = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
