/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_tables

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ForeignTablesViewRow(
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignTableCatalog]] */
  foreignTableCatalog: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignTableSchema]] */
  foreignTableSchema: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignTableName]] */
  foreignTableName: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_tables`.PgForeignTablesViewRow.foreignServerName]] */
  foreignServerName: Option[/* nullability unknown */ String]
)

object ForeignTablesViewRow {
  implicit lazy val decoder: Decoder[ForeignTablesViewRow] = Decoder.forProduct5[ForeignTablesViewRow, Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String]]("foreign_table_catalog", "foreign_table_schema", "foreign_table_name", "foreign_server_catalog", "foreign_server_name")(ForeignTablesViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[ForeignTablesViewRow] = Encoder.forProduct5[ForeignTablesViewRow, Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String]]("foreign_table_catalog", "foreign_table_schema", "foreign_table_name", "foreign_server_catalog", "foreign_server_name")(x => (x.foreignTableCatalog, x.foreignTableSchema, x.foreignTableName, x.foreignServerCatalog, x.foreignServerName))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[ForeignTablesViewRow] = new Read[ForeignTablesViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ForeignTablesViewRow(
      foreignTableCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      foreignTableSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      foreignTableName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      foreignServerCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      foreignServerName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4)
    )
  )
}
