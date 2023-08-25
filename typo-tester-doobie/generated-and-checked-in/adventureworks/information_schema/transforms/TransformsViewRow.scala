/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package transforms

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class TransformsViewRow(
  udtCatalog: SqlIdentifier,
  udtSchema: SqlIdentifier,
  udtName: SqlIdentifier,
  specificCatalog: SqlIdentifier,
  specificSchema: SqlIdentifier,
  specificName: SqlIdentifier,
  groupName: SqlIdentifier,
  transformType: CharacterData
)

object TransformsViewRow {
  implicit lazy val decoder: Decoder[TransformsViewRow] = Decoder.forProduct8[TransformsViewRow, SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, CharacterData]("udt_catalog", "udt_schema", "udt_name", "specific_catalog", "specific_schema", "specific_name", "group_name", "transform_type")(TransformsViewRow.apply)(SqlIdentifier.decoder, SqlIdentifier.decoder, SqlIdentifier.decoder, SqlIdentifier.decoder, SqlIdentifier.decoder, SqlIdentifier.decoder, SqlIdentifier.decoder, CharacterData.decoder)
  implicit lazy val encoder: Encoder[TransformsViewRow] = Encoder.forProduct8[TransformsViewRow, SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, SqlIdentifier, CharacterData]("udt_catalog", "udt_schema", "udt_name", "specific_catalog", "specific_schema", "specific_name", "group_name", "transform_type")(x => (x.udtCatalog, x.udtSchema, x.udtName, x.specificCatalog, x.specificSchema, x.specificName, x.groupName, x.transformType))(SqlIdentifier.encoder, SqlIdentifier.encoder, SqlIdentifier.encoder, SqlIdentifier.encoder, SqlIdentifier.encoder, SqlIdentifier.encoder, SqlIdentifier.encoder, CharacterData.encoder)
  implicit lazy val read: Read[TransformsViewRow] = new Read[TransformsViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (CharacterData.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => TransformsViewRow(
      udtCatalog = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 0),
      udtSchema = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 1),
      udtName = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 2),
      specificCatalog = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 3),
      specificSchema = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 4),
      specificName = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 5),
      groupName = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 6),
      transformType = CharacterData.get.unsafeGetNonNullable(rs, i + 7)
    )
  )
}
