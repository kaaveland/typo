/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_column_grants

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class RoleColumnGrantsViewStructure[Row](val prefix: Option[String], val extract: Row => RoleColumnGrantsViewRow, val merge: (Row, RoleColumnGrantsViewRow) => Row)
  extends Relation[RoleColumnGrantsViewFields, RoleColumnGrantsViewRow, Row]
    with RoleColumnGrantsViewFields[Row] { outer =>

  override val grantor = new Field[SqlIdentifier, Row](prefix, "grantor", None, Some("information_schema.sql_identifier"))(x => extract(x).grantor, (row, value) => merge(row, extract(row).copy(grantor = value)))
  override val grantee = new Field[SqlIdentifier, Row](prefix, "grantee", None, Some("information_schema.sql_identifier"))(x => extract(x).grantee, (row, value) => merge(row, extract(row).copy(grantee = value)))
  override val tableCatalog = new Field[SqlIdentifier, Row](prefix, "table_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new Field[SqlIdentifier, Row](prefix, "table_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new Field[SqlIdentifier, Row](prefix, "table_name", None, Some("information_schema.sql_identifier"))(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))
  override val columnName = new Field[SqlIdentifier, Row](prefix, "column_name", None, Some("information_schema.sql_identifier"))(x => extract(x).columnName, (row, value) => merge(row, extract(row).copy(columnName = value)))
  override val privilegeType = new Field[CharacterData, Row](prefix, "privilege_type", None, Some("information_schema.character_data"))(x => extract(x).privilegeType, (row, value) => merge(row, extract(row).copy(privilegeType = value)))
  override val isGrantable = new Field[YesOrNo, Row](prefix, "is_grantable", None, Some("information_schema.yes_or_no"))(x => extract(x).isGrantable, (row, value) => merge(row, extract(row).copy(isGrantable = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](grantor, grantee, tableCatalog, tableSchema, tableName, columnName, privilegeType, isGrantable)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => RoleColumnGrantsViewRow, merge: (NewRow, RoleColumnGrantsViewRow) => NewRow): RoleColumnGrantsViewStructure[NewRow] =
    new RoleColumnGrantsViewStructure(prefix, extract, merge)
}
