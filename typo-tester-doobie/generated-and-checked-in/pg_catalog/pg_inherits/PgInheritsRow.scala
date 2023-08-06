/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_inherits

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgInheritsRow(
  inhrelid: /* oid */ Long,
  inhparent: /* oid */ Long,
  inhseqno: Int,
  inhdetachpending: Boolean
){
   val compositeId: PgInheritsId = PgInheritsId(inhrelid, inhseqno)
 }

object PgInheritsRow {
  implicit lazy val decoder: Decoder[PgInheritsRow] = Decoder.forProduct4[PgInheritsRow, /* oid */ Long, /* oid */ Long, Int, Boolean]("inhrelid", "inhparent", "inhseqno", "inhdetachpending")(PgInheritsRow.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeBoolean)
  implicit lazy val encoder: Encoder[PgInheritsRow] = Encoder.forProduct4[PgInheritsRow, /* oid */ Long, /* oid */ Long, Int, Boolean]("inhrelid", "inhparent", "inhseqno", "inhdetachpending")(x => (x.inhrelid, x.inhparent, x.inhseqno, x.inhdetachpending))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeBoolean)
  implicit lazy val read: Read[PgInheritsRow] = new Read[PgInheritsRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgInheritsRow(
      inhrelid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      inhparent = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      inhseqno = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 2),
      inhdetachpending = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
}
