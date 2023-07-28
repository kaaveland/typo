/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_server_options

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ForeignServerOptionsViewRow(
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerName]] */
  foreignServerName: Option[SqlIdentifier],
  optionName: Option[SqlIdentifier],
  optionValue: Option[CharacterData]
)

object ForeignServerOptionsViewRow {
  implicit val decoder: Decoder[ForeignServerOptionsViewRow] = Decoder.forProduct4[ForeignServerOptionsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData]]("foreign_server_catalog", "foreign_server_name", "option_name", "option_value")(ForeignServerOptionsViewRow.apply)(Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(SqlIdentifier.decoder), Decoder.decodeOption(CharacterData.decoder))
  implicit val encoder: Encoder[ForeignServerOptionsViewRow] = Encoder.forProduct4[ForeignServerOptionsViewRow, Option[SqlIdentifier], Option[SqlIdentifier], Option[SqlIdentifier], Option[CharacterData]]("foreign_server_catalog", "foreign_server_name", "option_name", "option_value")(x => (x.foreignServerCatalog, x.foreignServerName, x.optionName, x.optionValue))(Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(SqlIdentifier.encoder), Encoder.encodeOption(CharacterData.encoder))
  implicit val read: Read[ForeignServerOptionsViewRow] = new Read[ForeignServerOptionsViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (SqlIdentifier.get, Nullability.Nullable),
      (CharacterData.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ForeignServerOptionsViewRow(
      foreignServerCatalog = SqlIdentifier.get.unsafeGetNullable(rs, i + 0),
      foreignServerName = SqlIdentifier.get.unsafeGetNullable(rs, i + 1),
      optionName = SqlIdentifier.get.unsafeGetNullable(rs, i + 2),
      optionValue = CharacterData.get.unsafeGetNullable(rs, i + 3)
    )
  )
}