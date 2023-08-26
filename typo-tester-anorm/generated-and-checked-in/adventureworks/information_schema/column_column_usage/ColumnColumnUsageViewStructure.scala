/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_column_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class ColumnColumnUsageViewStructure[Row](val prefix: Option[String], val extract: Row => ColumnColumnUsageViewRow, val merge: (Row, ColumnColumnUsageViewRow) => Row)
  extends Relation[ColumnColumnUsageViewFields, ColumnColumnUsageViewRow, Row]
    with ColumnColumnUsageViewFields[Row] { outer =>

  override val tableCatalog = new Field[SqlIdentifier, Row](prefix, "table_catalog", None, Some("name"))(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new Field[SqlIdentifier, Row](prefix, "table_schema", None, Some("name"))(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new Field[SqlIdentifier, Row](prefix, "table_name", None, Some("name"))(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))
  override val columnName = new Field[SqlIdentifier, Row](prefix, "column_name", None, Some("name"))(x => extract(x).columnName, (row, value) => merge(row, extract(row).copy(columnName = value)))
  override val dependentColumn = new Field[SqlIdentifier, Row](prefix, "dependent_column", None, Some("name"))(x => extract(x).dependentColumn, (row, value) => merge(row, extract(row).copy(dependentColumn = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](tableCatalog, tableSchema, tableName, columnName, dependentColumn)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ColumnColumnUsageViewRow, merge: (NewRow, ColumnColumnUsageViewRow) => NewRow): ColumnColumnUsageViewStructure[NewRow] =
    new ColumnColumnUsageViewStructure(prefix, extract, merge)
}
