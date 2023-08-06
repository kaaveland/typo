/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin_status

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgReplicationOriginStatusViewRow(
  localId: Option[/* oid */ Long],
  externalId: Option[String],
  remoteLsn: Option[/* pg_lsn */ Long],
  localLsn: Option[/* pg_lsn */ Long]
)

object PgReplicationOriginStatusViewRow {
  implicit lazy val decoder: Decoder[PgReplicationOriginStatusViewRow] = Decoder.forProduct4[PgReplicationOriginStatusViewRow, Option[/* oid */ Long], Option[String], Option[/* pg_lsn */ Long], Option[/* pg_lsn */ Long]]("local_id", "external_id", "remote_lsn", "local_lsn")(PgReplicationOriginStatusViewRow.apply)(Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong))
  implicit lazy val encoder: Encoder[PgReplicationOriginStatusViewRow] = Encoder.forProduct4[PgReplicationOriginStatusViewRow, Option[/* oid */ Long], Option[String], Option[/* pg_lsn */ Long], Option[/* pg_lsn */ Long]]("local_id", "external_id", "remote_lsn", "local_lsn")(x => (x.localId, x.externalId, x.remoteLsn, x.localLsn))(Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong))
  implicit lazy val read: Read[PgReplicationOriginStatusViewRow] = new Read[PgReplicationOriginStatusViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgReplicationOriginStatusViewRow(
      localId = Meta.LongMeta.get.unsafeGetNullable(rs, i + 0),
      externalId = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      remoteLsn = Meta.LongMeta.get.unsafeGetNullable(rs, i + 2),
      localLsn = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3)
    )
  )
}
