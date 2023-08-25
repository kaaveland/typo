/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_user_tables

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatioUserTablesViewRow(
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.relid]] */
  relid: Option[/* oid */ Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.heapBlksRead]] */
  heapBlksRead: Option[Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.heapBlksHit]] */
  heapBlksHit: Option[Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.idxBlksRead]] */
  idxBlksRead: Option[Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.idxBlksHit]] */
  idxBlksHit: Option[Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.toastBlksRead]] */
  toastBlksRead: Option[Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.toastBlksHit]] */
  toastBlksHit: Option[Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.tidxBlksRead]] */
  tidxBlksRead: Option[Long],
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.tidxBlksHit]] */
  tidxBlksHit: Option[Long]
)

object PgStatioUserTablesViewRow {
  implicit lazy val decoder: Decoder[PgStatioUserTablesViewRow] = Decoder.forProduct11[PgStatioUserTablesViewRow, Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long]]("relid", "schemaname", "relname", "heap_blks_read", "heap_blks_hit", "idx_blks_read", "idx_blks_hit", "toast_blks_read", "toast_blks_hit", "tidx_blks_read", "tidx_blks_hit")(PgStatioUserTablesViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgStatioUserTablesViewRow] = Encoder.forProduct11[PgStatioUserTablesViewRow, Option[/* oid */ Long], Option[String], Option[String], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long], Option[Long]]("relid", "schemaname", "relname", "heap_blks_read", "heap_blks_hit", "idx_blks_read", "idx_blks_hit", "toast_blks_read", "toast_blks_hit", "tidx_blks_read", "tidx_blks_hit")(x => (x.relid, x.schemaname, x.relname, x.heapBlksRead, x.heapBlksHit, x.idxBlksRead, x.idxBlksHit, x.toastBlksRead, x.toastBlksHit, x.tidxBlksRead, x.tidxBlksHit))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgStatioUserTablesViewRow] = new Read[PgStatioUserTablesViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatioUserTablesViewRow(
      relid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      relname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      heapBlksRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      heapBlksHit = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      idxBlksRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      idxBlksHit = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      toastBlksRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      toastBlksHit = Meta.LongMeta.get.unsafeGetNullable(rs, i + 8),
      tidxBlksRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 9),
      tidxBlksHit = Meta.LongMeta.get.unsafeGetNullable(rs, i + 10)
    )
  )
}