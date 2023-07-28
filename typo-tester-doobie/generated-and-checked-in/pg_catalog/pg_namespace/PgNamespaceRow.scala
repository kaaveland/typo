/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_namespace

import adventureworks.TypoAclItem
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgNamespaceRow(
  oid: PgNamespaceId,
  nspname: String,
  nspowner: /* oid */ Long,
  nspacl: Option[Array[TypoAclItem]]
)

object PgNamespaceRow {
  implicit val decoder: Decoder[PgNamespaceRow] = Decoder.forProduct4[PgNamespaceRow, PgNamespaceId, String, /* oid */ Long, Option[Array[TypoAclItem]]]("oid", "nspname", "nspowner", "nspacl")(PgNamespaceRow.apply)(PgNamespaceId.decoder, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeOption(Decoder.decodeArray[TypoAclItem](TypoAclItem.decoder, implicitly)))
  implicit val encoder: Encoder[PgNamespaceRow] = Encoder.forProduct4[PgNamespaceRow, PgNamespaceId, String, /* oid */ Long, Option[Array[TypoAclItem]]]("oid", "nspname", "nspowner", "nspacl")(x => (x.oid, x.nspname, x.nspowner, x.nspacl))(PgNamespaceId.encoder, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeOption(Encoder.encodeIterable[TypoAclItem, Array](TypoAclItem.encoder, implicitly)))
  implicit val read: Read[PgNamespaceRow] = new Read[PgNamespaceRow](
    gets = List(
      (PgNamespaceId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoAclItem.arrayGet, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgNamespaceRow(
      oid = PgNamespaceId.get.unsafeGetNonNullable(rs, i + 0),
      nspname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      nspowner = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      nspacl = TypoAclItem.arrayGet.unsafeGetNullable(rs, i + 3)
    )
  )
}