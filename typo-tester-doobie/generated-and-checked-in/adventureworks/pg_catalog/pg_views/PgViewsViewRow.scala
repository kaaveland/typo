/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_views

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgViewsViewRow(
  /** Points to [[pg_namespace.PgNamespaceRow.nspname]] */
  schemaname: Option[String],
  /** Points to [[pg_class.PgClassRow.relname]] */
  viewname: String,
  viewowner: /* nullability unknown */ Option[String],
  definition: /* nullability unknown */ Option[String]
)

object PgViewsViewRow {
  implicit lazy val decoder: Decoder[PgViewsViewRow] = Decoder.forProduct4[PgViewsViewRow, Option[String], String, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("schemaname", "viewname", "viewowner", "definition")(PgViewsViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[PgViewsViewRow] = Encoder.forProduct4[PgViewsViewRow, Option[String], String, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("schemaname", "viewname", "viewowner", "definition")(x => (x.schemaname, x.viewname, x.viewowner, x.definition))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[PgViewsViewRow] = new Read[PgViewsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgViewsViewRow(
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      viewname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      viewowner = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      definition = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3)
    )
  )
}
