/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_collation

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgCollationRow(
  oid: PgCollationId,
  collname: String,
  collnamespace: /* oid */ Long,
  collowner: /* oid */ Long,
  collprovider: String,
  collisdeterministic: Boolean,
  collencoding: Int,
  collcollate: String,
  collctype: String,
  collversion: Option[String]
)

object PgCollationRow {
  implicit val decoder: Decoder[PgCollationRow] = Decoder.forProduct10[PgCollationRow, PgCollationId, String, /* oid */ Long, /* oid */ Long, String, Boolean, Int, String, String, Option[String]]("oid", "collname", "collnamespace", "collowner", "collprovider", "collisdeterministic", "collencoding", "collcollate", "collctype", "collversion")(PgCollationRow.apply)(PgCollationId.decoder, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeString, Decoder.decodeBoolean, Decoder.decodeInt, Decoder.decodeString, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString))
  implicit val encoder: Encoder[PgCollationRow] = Encoder.forProduct10[PgCollationRow, PgCollationId, String, /* oid */ Long, /* oid */ Long, String, Boolean, Int, String, String, Option[String]]("oid", "collname", "collnamespace", "collowner", "collprovider", "collisdeterministic", "collencoding", "collcollate", "collctype", "collversion")(x => (x.oid, x.collname, x.collnamespace, x.collowner, x.collprovider, x.collisdeterministic, x.collencoding, x.collcollate, x.collctype, x.collversion))(PgCollationId.encoder, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeString, Encoder.encodeBoolean, Encoder.encodeInt, Encoder.encodeString, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString))
  implicit val read: Read[PgCollationRow] = new Read[PgCollationRow](
    gets = List(
      (PgCollationId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgCollationRow(
      oid = PgCollationId.get.unsafeGetNonNullable(rs, i + 0),
      collname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      collnamespace = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      collowner = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      collprovider = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4),
      collisdeterministic = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 5),
      collencoding = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      collcollate = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 7),
      collctype = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 8),
      collversion = Meta.StringMeta.get.unsafeGetNullable(rs, i + 9)
    )
  )
}