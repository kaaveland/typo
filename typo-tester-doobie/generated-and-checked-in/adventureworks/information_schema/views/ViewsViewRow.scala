/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package views

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ViewsViewRow(
  tableCatalog: SqlIdentifier,
  tableSchema: SqlIdentifier,
  tableName: SqlIdentifier,
  viewDefinition: CharacterData,
  checkOption: CharacterData,
  isUpdatable: YesOrNo,
  isInsertableInto: YesOrNo,
  isTriggerUpdatable: YesOrNo,
  isTriggerDeletable: YesOrNo,
  isTriggerInsertableInto: YesOrNo
)

object ViewsViewRow {
  implicit lazy val decoder: Decoder[ViewsViewRow] = Decoder.forProduct10[ViewsViewRow, SqlIdentifier, SqlIdentifier, SqlIdentifier, CharacterData, CharacterData, YesOrNo, YesOrNo, YesOrNo, YesOrNo, YesOrNo]("table_catalog", "table_schema", "table_name", "view_definition", "check_option", "is_updatable", "is_insertable_into", "is_trigger_updatable", "is_trigger_deletable", "is_trigger_insertable_into")(ViewsViewRow.apply)(SqlIdentifier.decoder, SqlIdentifier.decoder, SqlIdentifier.decoder, CharacterData.decoder, CharacterData.decoder, YesOrNo.decoder, YesOrNo.decoder, YesOrNo.decoder, YesOrNo.decoder, YesOrNo.decoder)
  implicit lazy val encoder: Encoder[ViewsViewRow] = Encoder.forProduct10[ViewsViewRow, SqlIdentifier, SqlIdentifier, SqlIdentifier, CharacterData, CharacterData, YesOrNo, YesOrNo, YesOrNo, YesOrNo, YesOrNo]("table_catalog", "table_schema", "table_name", "view_definition", "check_option", "is_updatable", "is_insertable_into", "is_trigger_updatable", "is_trigger_deletable", "is_trigger_insertable_into")(x => (x.tableCatalog, x.tableSchema, x.tableName, x.viewDefinition, x.checkOption, x.isUpdatable, x.isInsertableInto, x.isTriggerUpdatable, x.isTriggerDeletable, x.isTriggerInsertableInto))(SqlIdentifier.encoder, SqlIdentifier.encoder, SqlIdentifier.encoder, CharacterData.encoder, CharacterData.encoder, YesOrNo.encoder, YesOrNo.encoder, YesOrNo.encoder, YesOrNo.encoder, YesOrNo.encoder)
  implicit lazy val read: Read[ViewsViewRow] = new Read[ViewsViewRow](
    gets = List(
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (SqlIdentifier.get, Nullability.NoNulls),
      (CharacterData.get, Nullability.NoNulls),
      (CharacterData.get, Nullability.NoNulls),
      (YesOrNo.get, Nullability.NoNulls),
      (YesOrNo.get, Nullability.NoNulls),
      (YesOrNo.get, Nullability.NoNulls),
      (YesOrNo.get, Nullability.NoNulls),
      (YesOrNo.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ViewsViewRow(
      tableCatalog = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 0),
      tableSchema = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 1),
      tableName = SqlIdentifier.get.unsafeGetNonNullable(rs, i + 2),
      viewDefinition = CharacterData.get.unsafeGetNonNullable(rs, i + 3),
      checkOption = CharacterData.get.unsafeGetNonNullable(rs, i + 4),
      isUpdatable = YesOrNo.get.unsafeGetNonNullable(rs, i + 5),
      isInsertableInto = YesOrNo.get.unsafeGetNonNullable(rs, i + 6),
      isTriggerUpdatable = YesOrNo.get.unsafeGetNonNullable(rs, i + 7),
      isTriggerDeletable = YesOrNo.get.unsafeGetNonNullable(rs, i + 8),
      isTriggerInsertableInto = YesOrNo.get.unsafeGetNonNullable(rs, i + 9)
    )
  )
}
