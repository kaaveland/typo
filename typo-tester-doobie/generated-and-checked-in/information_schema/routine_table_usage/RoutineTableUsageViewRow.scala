/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_table_usage

import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class RoutineTableUsageViewRow(
  specificCatalog: Option[SqlIdentifier],
  specificSchema: Option[SqlIdentifier],
  specificName: Option[SqlIdentifier],
  routineCatalog: Option[SqlIdentifier],
  routineSchema: Option[SqlIdentifier],
  routineName: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier]
)

object RoutineTableUsageViewRow {
  implicit lazy val decoder: Decoder[RoutineTableUsageViewRow] = Decoder.forProduct9[RoutineTableUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("specific_catalog", "specific_schema", "specific_name", "routine_catalog", "routine_schema", "routine_name", "table_catalog", "table_schema", "table_name")(RoutineTableUsageViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder))
  implicit lazy val encoder: Encoder[RoutineTableUsageViewRow] = Encoder.forProduct9[RoutineTableUsageViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier]]("specific_catalog", "specific_schema", "specific_name", "routine_catalog", "routine_schema", "routine_name", "table_catalog", "table_schema", "table_name")(x => (x.specificCatalog, x.specificSchema, x.specificName, x.routineCatalog, x.routineSchema, x.routineName, x.tableCatalog, x.tableSchema, x.tableName))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder))
  implicit lazy val read: Read[RoutineTableUsageViewRow] = new Read[RoutineTableUsageViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => RoutineTableUsageViewRow(
      specificCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      specificSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      specificName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      routineCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 3),
      routineSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 4),
      routineName = SqlIdentifier.get.unsafeGetNullable(rs, i + 5),
      tableCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 6),
      tableSchema = SqlIdentifier.get.unsafeGetNullable(rs, i + 7),
      tableName = SqlIdentifier.get.unsafeGetNullable(rs, i + 8)
    )
  )
}
