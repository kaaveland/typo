/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_servers`

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgForeignServersViewRow(
  oid: /* oid */ Long,
  srvoptions: Array[String],
  foreignServerCatalog: SqlIdentifier,
  foreignServerName: SqlIdentifier,
  foreignDataWrapperCatalog: SqlIdentifier,
  foreignDataWrapperName: SqlIdentifier,
  foreignServerType: CharacterData,
  foreignServerVersion: CharacterData,
  authorizationIdentifier: SqlIdentifier
)

object PgForeignServersViewRow {
  implicit lazy val decoder: Decoder[PgForeignServersViewRow] = Decoder.forProduct9[PgForeignServersViewRow, /* oid */ Long, Array[String], SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, CharacterData, CharacterData, SqlIdentifier]("oid", "srvoptions", "foreign_server_catalog", "foreign_server_name", "foreign_data_wrapper_catalog", "foreign_data_wrapper_name", "foreign_server_type", "foreign_server_version", "authorization_identifier")(PgForeignServersViewRow.apply)(Decoder.decodeLong, Decoder.decodeArray[String](Decoder.decodeString, implicitly), SqlIdentifier.decoder, SqlIdentifier.decoder, SqlIdentifier.decoder, SqlIdentifier.decoder, CharacterData.decoder, CharacterData.decoder, SqlIdentifier.decoder)
  implicit lazy val encoder: Encoder[PgForeignServersViewRow] = Encoder.forProduct9[PgForeignServersViewRow, /* oid */ Long, Array[String], SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, CharacterData, CharacterData, SqlIdentifier]("oid", "srvoptions", "foreign_server_catalog", "foreign_server_name", "foreign_data_wrapper_catalog", "foreign_data_wrapper_name", "foreign_server_type", "foreign_server_version", "authorization_identifier")(x => (x.oid, x.srvoptions, x.foreignServerCatalog, x.foreignServerName, x.foreignDataWrapperCatalog, x.foreignDataWrapperName, x.foreignServerType, x.foreignServerVersion, x.authorizationIdentifier))(Encoder.encodeLong, Encoder.encodeIterable[String, Array](Encoder.encodeString, implicitly), SqlIdentifier.encoder, SqlIdentifier.encoder, SqlIdentifier.encoder, SqlIdentifier.encoder, CharacterData.encoder, CharacterData.encoder, SqlIdentifier.encoder)
  implicit lazy val read: Read[PgForeignServersViewRow] = new Read[PgForeignServersViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (adventureworks.StringArrayMeta.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (CharacterData.get, Nullability.NoNulls),
      (CharacterData.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgForeignServersViewRow(
      oid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      srvoptions = adventureworks.StringArrayMeta.get.unsafeGetNonNullable(rs, i + 1),
      foreignServerCatalog = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 2),
      foreignServerName = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 3),
      foreignDataWrapperCatalog = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 4),
      foreignDataWrapperName = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 5),
      foreignServerType = CharacterData.get.unsafeGetNonNullable(rs, i + 6),
      foreignServerVersion = CharacterData.get.unsafeGetNonNullable(rs, i + 7),
      authorizationIdentifier = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}
