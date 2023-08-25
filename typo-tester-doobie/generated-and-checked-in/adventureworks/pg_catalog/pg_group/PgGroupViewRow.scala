/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_group

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgGroupViewRow(
  groname: String,
  grosysid: /* oid */ Long,
  grolist: Array[/* oid */ Long]
)

object PgGroupViewRow {
  implicit lazy val decoder: Decoder[PgGroupViewRow] = Decoder.forProduct3[PgGroupViewRow, String, /* oid */ Long, Array[/* oid */ Long]]("groname", "grosysid", "grolist")(PgGroupViewRow.apply)(Decoder.decodeString, Decoder.decodeLong, Decoder.decodeArray[Long](Decoder.decodeLong, implicitly))
  implicit lazy val encoder: Encoder[PgGroupViewRow] = Encoder.forProduct3[PgGroupViewRow, String, /* oid */ Long, Array[/* oid */ Long]]("groname", "grosysid", "grolist")(x => (x.groname, x.grosysid, x.grolist))(Encoder.encodeString, Encoder.encodeLong, Encoder.encodeIterable[Long, Array](Encoder.encodeLong, implicitly))
  implicit lazy val read: Read[PgGroupViewRow] = new Read[PgGroupViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (adventureworks.LongArrayMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgGroupViewRow(
      groname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 0),
      grosysid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      grolist = adventureworks.LongArrayMeta.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
}
