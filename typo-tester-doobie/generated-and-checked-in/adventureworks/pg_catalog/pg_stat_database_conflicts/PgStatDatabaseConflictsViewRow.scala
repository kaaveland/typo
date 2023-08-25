/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_database_conflicts

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatDatabaseConflictsViewRow(
  datid: /* oid */ Long,
  datname: String,
  conflTablespace: Long,
  conflLock: Long,
  conflSnapshot: Long,
  conflBufferpin: Long,
  conflDeadlock: Long
)

object PgStatDatabaseConflictsViewRow {
  implicit lazy val decoder: Decoder[PgStatDatabaseConflictsViewRow] = Decoder.forProduct7[PgStatDatabaseConflictsViewRow, /* oid */ Long, String, Long, Long, Long, Long, Long]("datid", "datname", "confl_tablespace", "confl_lock", "confl_snapshot", "confl_bufferpin", "confl_deadlock")(PgStatDatabaseConflictsViewRow.apply)(Decoder.decodeLong, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong)
  implicit lazy val encoder: Encoder[PgStatDatabaseConflictsViewRow] = Encoder.forProduct7[PgStatDatabaseConflictsViewRow, /* oid */ Long, String, Long, Long, Long, Long, Long]("datid", "datname", "confl_tablespace", "confl_lock", "confl_snapshot", "confl_bufferpin", "confl_deadlock")(x => (x.datid, x.datname, x.conflTablespace, x.conflLock, x.conflSnapshot, x.conflBufferpin, x.conflDeadlock))(Encoder.encodeLong, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong)
  implicit lazy val read: Read[PgStatDatabaseConflictsViewRow] = new Read[PgStatDatabaseConflictsViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatDatabaseConflictsViewRow(
      datid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      datname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      conflTablespace = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      conflLock = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      conflSnapshot = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 4),
      conflBufferpin = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 5),
      conflDeadlock = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 6)
    )
  )
}
