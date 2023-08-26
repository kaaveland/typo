/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package key_column_usage

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class KeyColumnUsageViewStructure[Row](val prefix: Option[String], val extract: Row => KeyColumnUsageViewRow, val merge: (Row, KeyColumnUsageViewRow) => Row)
  extends Relation[KeyColumnUsageViewFields, KeyColumnUsageViewRow, Row]
    with KeyColumnUsageViewFields[Row] { outer =>

  override val constraintCatalog = new Field[SqlIdentifier, Row](prefix, "constraint_catalog", None, Some("name"))(x => extract(x).constraintCatalog, (row, value) => merge(row, extract(row).copy(constraintCatalog = value)))
  override val constraintSchema = new Field[SqlIdentifier, Row](prefix, "constraint_schema", None, Some("name"))(x => extract(x).constraintSchema, (row, value) => merge(row, extract(row).copy(constraintSchema = value)))
  override val constraintName = new Field[SqlIdentifier, Row](prefix, "constraint_name", None, Some("name"))(x => extract(x).constraintName, (row, value) => merge(row, extract(row).copy(constraintName = value)))
  override val tableCatalog = new Field[SqlIdentifier, Row](prefix, "table_catalog", None, Some("name"))(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new Field[SqlIdentifier, Row](prefix, "table_schema", None, Some("name"))(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new Field[SqlIdentifier, Row](prefix, "table_name", None, Some("name"))(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))
  override val columnName = new Field[SqlIdentifier, Row](prefix, "column_name", None, Some("name"))(x => extract(x).columnName, (row, value) => merge(row, extract(row).copy(columnName = value)))
  override val ordinalPosition = new Field[CardinalNumber, Row](prefix, "ordinal_position", None, Some("int4"))(x => extract(x).ordinalPosition, (row, value) => merge(row, extract(row).copy(ordinalPosition = value)))
  override val positionInUniqueConstraint = new Field[CardinalNumber, Row](prefix, "position_in_unique_constraint", None, Some("int4"))(x => extract(x).positionInUniqueConstraint, (row, value) => merge(row, extract(row).copy(positionInUniqueConstraint = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](constraintCatalog, constraintSchema, constraintName, tableCatalog, tableSchema, tableName, columnName, ordinalPosition, positionInUniqueConstraint)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => KeyColumnUsageViewRow, merge: (NewRow, KeyColumnUsageViewRow) => NewRow): KeyColumnUsageViewStructure[NewRow] =
    new KeyColumnUsageViewStructure(prefix, extract, merge)
}
