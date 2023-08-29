/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_mapping_options

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class UserMappingOptionsViewRow(
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_user_mappings`.PgUserMappingsViewRow.foreignServerName]] */
  foreignServerName: Option[/* nullability unknown */ String],
  optionName: /* nullability unknown */ Option[String],
  optionValue: /* nullability unknown */ Option[String]
)

object UserMappingOptionsViewRow {
  implicit lazy val decoder: Decoder[UserMappingOptionsViewRow] = Decoder.forProduct5[UserMappingOptionsViewRow, Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("authorization_identifier", "foreign_server_catalog", "foreign_server_name", "option_name", "option_value")(UserMappingOptionsViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[UserMappingOptionsViewRow] = Encoder.forProduct5[UserMappingOptionsViewRow, Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[String]]("authorization_identifier", "foreign_server_catalog", "foreign_server_name", "option_name", "option_value")(x => (x.authorizationIdentifier, x.foreignServerCatalog, x.foreignServerName, x.optionName, x.optionValue))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[UserMappingOptionsViewRow] = new Read[UserMappingOptionsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => UserMappingOptionsViewRow(
      authorizationIdentifier = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      foreignServerCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      foreignServerName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      optionName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      optionValue = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4)
    )
  )
}
