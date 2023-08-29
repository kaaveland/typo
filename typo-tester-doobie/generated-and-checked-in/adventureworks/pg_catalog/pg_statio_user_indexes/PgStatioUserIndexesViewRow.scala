/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_user_indexes

import adventureworks.pg_catalog.pg_class.PgClassId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatioUserIndexesViewRow(
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.relid]] */
  relid: Option[PgClassId],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.indexrelid]] */
  indexrelid: Option[PgClassId],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.indexrelname]] */
  indexrelname: Option[String],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.idxBlksRead]] */
  idxBlksRead: Option[/* nullability unknown */ Long],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.idxBlksHit]] */
  idxBlksHit: Option[/* nullability unknown */ Long]
)

object PgStatioUserIndexesViewRow {
  implicit lazy val decoder: Decoder[PgStatioUserIndexesViewRow] = Decoder.forProduct7[PgStatioUserIndexesViewRow, Option[PgClassId], Option[PgClassId], Option[String], Option[String], Option[String], Option[/* nullability unknown */ Long], Option[/* nullability unknown */ Long]]("relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_blks_read", "idx_blks_hit")(PgStatioUserIndexesViewRow.apply)(Decoder.decodeOption(PgClassId.decoder), Decoder.decodeOption(PgClassId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgStatioUserIndexesViewRow] = Encoder.forProduct7[PgStatioUserIndexesViewRow, Option[PgClassId], Option[PgClassId], Option[String], Option[String], Option[String], Option[/* nullability unknown */ Long], Option[/* nullability unknown */ Long]]("relid", "indexrelid", "schemaname", "relname", "indexrelname", "idx_blks_read", "idx_blks_hit")(x => (x.relid, x.indexrelid, x.schemaname, x.relname, x.indexrelname, x.idxBlksRead, x.idxBlksHit))(Encoder.encodeOption(PgClassId.encoder), Encoder.encodeOption(PgClassId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgStatioUserIndexesViewRow] = new Read[PgStatioUserIndexesViewRow](
    gets = List(
      (PgClassId.get, Nullability.Nullable),
      (PgClassId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatioUserIndexesViewRow(
      relid = PgClassId.get.unsafeGetNullable(rs, i + 0),
      indexrelid = PgClassId.get.unsafeGetNullable(rs, i + 1),
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      relname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      indexrelname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      idxBlksRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      idxBlksHit = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
