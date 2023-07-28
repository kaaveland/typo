/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_data_wrapper

import adventureworks.TypoAclItem
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgForeignDataWrapperRow(
  oid: PgForeignDataWrapperId,
  fdwname: String,
  fdwowner: /* oid */ Long,
  fdwhandler: /* oid */ Long,
  fdwvalidator: /* oid */ Long,
  fdwacl: Option[Array[TypoAclItem]],
  fdwoptions: Option[Array[String]]
)

object PgForeignDataWrapperRow {
  implicit val decoder: Decoder[PgForeignDataWrapperRow] = Decoder.forProduct7[PgForeignDataWrapperRow, PgForeignDataWrapperId, String, /* oid */ Long, /* oid */ Long, /* oid */ Long, Option[Array[TypoAclItem]], Option[Array[String]]]("oid", "fdwname", "fdwowner", "fdwhandler", "fdwvalidator", "fdwacl", "fdwoptions")(PgForeignDataWrapperRow.apply)(PgForeignDataWrapperId.decoder, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeOption(Decoder.decodeArray[TypoAclItem](TypoAclItem.decoder, implicitly)), Decoder.decodeOption(Decoder.decodeArray[String](Decoder.decodeString, implicitly)))
  implicit val encoder: Encoder[PgForeignDataWrapperRow] = Encoder.forProduct7[PgForeignDataWrapperRow, PgForeignDataWrapperId, String, /* oid */ Long, /* oid */ Long, /* oid */ Long, Option[Array[TypoAclItem]], Option[Array[String]]]("oid", "fdwname", "fdwowner", "fdwhandler", "fdwvalidator", "fdwacl", "fdwoptions")(x => (x.oid, x.fdwname, x.fdwowner, x.fdwhandler, x.fdwvalidator, x.fdwacl, x.fdwoptions))(PgForeignDataWrapperId.encoder, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeOption(Encoder.encodeIterable[TypoAclItem, Array](TypoAclItem.encoder, implicitly)), Encoder.encodeOption(Encoder.encodeIterable[String, Array](Encoder.encodeString, implicitly)))
  implicit val read: Read[PgForeignDataWrapperRow] = new Read[PgForeignDataWrapperRow](
    gets = List(
      (PgForeignDataWrapperId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoAclItem.arrayGet, Nullability.Nullable),
      (adventureworks.StringArrayMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgForeignDataWrapperRow(
      oid = PgForeignDataWrapperId.get.unsafeGetNonNullable(rs, i + 0),
      fdwname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      fdwowner = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      fdwhandler = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      fdwvalidator = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 4),
      fdwacl = TypoAclItem.arrayGet.unsafeGetNullable(rs, i + 5),
      fdwoptions = adventureworks.StringArrayMeta.get.unsafeGetNullable(rs, i + 6)
    )
  )
}