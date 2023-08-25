/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tables

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgTablesViewRow(
  schemaname: Option[String],
  tablename: String,
  tableowner: String,
  tablespace: Option[String],
  hasindexes: Boolean,
  hasrules: Boolean,
  hastriggers: Boolean,
  rowsecurity: Boolean
)

object PgTablesViewRow {
  implicit lazy val decoder: Decoder[PgTablesViewRow] = Decoder.forProduct8[PgTablesViewRow, Option[String], String, String, Option[String], Boolean, Boolean, Boolean, Boolean]("schemaname", "tablename", "tableowner", "tablespace", "hasindexes", "hasrules", "hastriggers", "rowsecurity")(PgTablesViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeBoolean)
  implicit lazy val encoder: Encoder[PgTablesViewRow] = Encoder.forProduct8[PgTablesViewRow, Option[String], String, String, Option[String], Boolean, Boolean, Boolean, Boolean]("schemaname", "tablename", "tableowner", "tablespace", "hasindexes", "hasrules", "hastriggers", "rowsecurity")(x => (x.schemaname, x.tablename, x.tableowner, x.tablespace, x.hasindexes, x.hasrules, x.hastriggers, x.rowsecurity))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeBoolean)
  implicit lazy val read: Read[PgTablesViewRow] = new Read[PgTablesViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgTablesViewRow(
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      tablename = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      tableowner = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      tablespace = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      hasindexes = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 4),
      hasrules = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 5),
      hastriggers = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 6),
      rowsecurity = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 7)
    )
  )
}
