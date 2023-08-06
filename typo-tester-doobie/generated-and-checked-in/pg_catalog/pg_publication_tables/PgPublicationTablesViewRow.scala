/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication_tables

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgPublicationTablesViewRow(
  pubname: Option[String],
  schemaname: Option[String],
  tablename: Option[String]
)

object PgPublicationTablesViewRow {
  implicit lazy val decoder: Decoder[PgPublicationTablesViewRow] = Decoder.forProduct3[PgPublicationTablesViewRow, Option[String], Option[String], Option[String]]("pubname", "schemaname", "tablename")(PgPublicationTablesViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[PgPublicationTablesViewRow] = Encoder.forProduct3[PgPublicationTablesViewRow, Option[String], Option[String], Option[String]]("pubname", "schemaname", "tablename")(x => (x.pubname, x.schemaname, x.tablename))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[PgPublicationTablesViewRow] = new Read[PgPublicationTablesViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgPublicationTablesViewRow(
      pubname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      tablename = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2)
    )
  )
}
