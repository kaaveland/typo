/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_trigger

import adventureworks.TypoInt2Vector
import adventureworks.TypoPgNodeTree
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgTriggerRow(
  oid: PgTriggerId,
  tgrelid: /* oid */ Long,
  tgparentid: /* oid */ Long,
  tgname: String,
  tgfoid: /* oid */ Long,
  tgtype: Int,
  tgenabled: String,
  tgisinternal: Boolean,
  tgconstrrelid: /* oid */ Long,
  tgconstrindid: /* oid */ Long,
  tgconstraint: /* oid */ Long,
  tgdeferrable: Boolean,
  tginitdeferred: Boolean,
  tgnargs: Int,
  tgattr: TypoInt2Vector,
  tgargs: Array[Byte],
  tgqual: Option[TypoPgNodeTree],
  tgoldtable: Option[String],
  tgnewtable: Option[String]
)

object PgTriggerRow {
  implicit lazy val decoder: Decoder[PgTriggerRow] = Decoder.forProduct19[PgTriggerRow, PgTriggerId, /* oid */ Long, /* oid */ Long, String, /* oid */ Long, Int, String, Boolean, /* oid */ Long, /* oid */ Long, /* oid */ Long, Boolean, Boolean, Int, TypoInt2Vector, Array[Byte], Option[TypoPgNodeTree], Option[String], Option[String]]("oid", "tgrelid", "tgparentid", "tgname", "tgfoid", "tgtype", "tgenabled", "tgisinternal", "tgconstrrelid", "tgconstrindid", "tgconstraint", "tgdeferrable", "tginitdeferred", "tgnargs", "tgattr", "tgargs", "tgqual", "tgoldtable", "tgnewtable")(PgTriggerRow.apply)(PgTriggerId.decoder, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeString, Decoder.decodeBoolean, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeInt, TypoInt2Vector.decoder, Decoder.decodeArray[Byte](Decoder.decodeByte, implicitly), Decoder.decodeOption(TypoPgNodeTree.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[PgTriggerRow] = Encoder.forProduct19[PgTriggerRow, PgTriggerId, /* oid */ Long, /* oid */ Long, String, /* oid */ Long, Int, String, Boolean, /* oid */ Long, /* oid */ Long, /* oid */ Long, Boolean, Boolean, Int, TypoInt2Vector, Array[Byte], Option[TypoPgNodeTree], Option[String], Option[String]]("oid", "tgrelid", "tgparentid", "tgname", "tgfoid", "tgtype", "tgenabled", "tgisinternal", "tgconstrrelid", "tgconstrindid", "tgconstraint", "tgdeferrable", "tginitdeferred", "tgnargs", "tgattr", "tgargs", "tgqual", "tgoldtable", "tgnewtable")(x => (x.oid, x.tgrelid, x.tgparentid, x.tgname, x.tgfoid, x.tgtype, x.tgenabled, x.tgisinternal, x.tgconstrrelid, x.tgconstrindid, x.tgconstraint, x.tgdeferrable, x.tginitdeferred, x.tgnargs, x.tgattr, x.tgargs, x.tgqual, x.tgoldtable, x.tgnewtable))(PgTriggerId.encoder, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeString, Encoder.encodeBoolean, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeInt, TypoInt2Vector.encoder, Encoder.encodeIterable[Byte, Array](Encoder.encodeByte, implicitly), Encoder.encodeOption(TypoPgNodeTree.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[PgTriggerRow] = new Read[PgTriggerRow](
    gets = List(
      (PgTriggerId.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoInt2Vector.get, Nullability.NoNulls),
      (Meta.ByteArrayMeta.get, Nullability.NoNulls),
      (TypoPgNodeTree.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgTriggerRow(
      oid = PgTriggerId.get.unsafeGetNonNullable(rs, i + 0),
      tgrelid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      tgparentid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      tgname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      tgfoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 4),
      tgtype = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 5),
      tgenabled = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 6),
      tgisinternal = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 7),
      tgconstrrelid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 8),
      tgconstrindid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 9),
      tgconstraint = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 10),
      tgdeferrable = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 11),
      tginitdeferred = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 12),
      tgnargs = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 13),
      tgattr = TypoInt2Vector.get.unsafeGetNonNullable(rs, i + 14),
      tgargs = Meta.ByteArrayMeta.get.unsafeGetNonNullable(rs, i + 15),
      tgqual = TypoPgNodeTree.get.unsafeGetNullable(rs, i + 16),
      tgoldtable = Meta.StringMeta.get.unsafeGetNullable(rs, i + 17),
      tgnewtable = Meta.StringMeta.get.unsafeGetNullable(rs, i + 18)
    )
  )
}
