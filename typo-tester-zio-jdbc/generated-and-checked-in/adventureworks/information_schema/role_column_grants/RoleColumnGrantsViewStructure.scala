/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_column_grants

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class RoleColumnGrantsViewStructure[Row](val prefix: Option[String], val extract: Row => RoleColumnGrantsViewRow, val merge: (Row, RoleColumnGrantsViewRow) => Row)
  extends Relation[RoleColumnGrantsViewFields, RoleColumnGrantsViewRow, Row]
    with RoleColumnGrantsViewFields[Row] { outer =>

  override val grantor = new OptField[/* nullability unknown */ String, Row](prefix, "grantor", None, None)(x => extract(x).grantor, (row, value) => merge(row, extract(row).copy(grantor = value)))
  override val grantee = new OptField[/* nullability unknown */ String, Row](prefix, "grantee", None, None)(x => extract(x).grantee, (row, value) => merge(row, extract(row).copy(grantee = value)))
  override val tableCatalog = new OptField[/* nullability unknown */ String, Row](prefix, "table_catalog", None, None)(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new OptField[/* nullability unknown */ String, Row](prefix, "table_schema", None, None)(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new OptField[/* nullability unknown */ String, Row](prefix, "table_name", None, None)(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))
  override val columnName = new OptField[/* nullability unknown */ String, Row](prefix, "column_name", None, None)(x => extract(x).columnName, (row, value) => merge(row, extract(row).copy(columnName = value)))
  override val privilegeType = new OptField[/* nullability unknown */ String, Row](prefix, "privilege_type", None, None)(x => extract(x).privilegeType, (row, value) => merge(row, extract(row).copy(privilegeType = value)))
  override val isGrantable = new OptField[/* nullability unknown */ /* max 3 chars */ String, Row](prefix, "is_grantable", None, None)(x => extract(x).isGrantable, (row, value) => merge(row, extract(row).copy(isGrantable = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](grantor, grantee, tableCatalog, tableSchema, tableName, columnName, privilegeType, isGrantable)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => RoleColumnGrantsViewRow, merge: (NewRow, RoleColumnGrantsViewRow) => NewRow): RoleColumnGrantsViewStructure[NewRow] =
    new RoleColumnGrantsViewStructure(prefix, extract, merge)
}
