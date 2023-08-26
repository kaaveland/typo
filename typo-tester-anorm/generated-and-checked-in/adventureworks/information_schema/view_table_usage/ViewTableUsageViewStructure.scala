/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_table_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class ViewTableUsageViewStructure[Row](val prefix: Option[String], val extract: Row => ViewTableUsageViewRow, val merge: (Row, ViewTableUsageViewRow) => Row)
  extends Relation[ViewTableUsageViewFields, ViewTableUsageViewRow, Row]
    with ViewTableUsageViewFields[Row] { outer =>

  override val viewCatalog = new Field[SqlIdentifier, Row](prefix, "view_catalog", None, Some("name"))(x => extract(x).viewCatalog, (row, value) => merge(row, extract(row).copy(viewCatalog = value)))
  override val viewSchema = new Field[SqlIdentifier, Row](prefix, "view_schema", None, Some("name"))(x => extract(x).viewSchema, (row, value) => merge(row, extract(row).copy(viewSchema = value)))
  override val viewName = new Field[SqlIdentifier, Row](prefix, "view_name", None, Some("name"))(x => extract(x).viewName, (row, value) => merge(row, extract(row).copy(viewName = value)))
  override val tableCatalog = new Field[SqlIdentifier, Row](prefix, "table_catalog", None, Some("name"))(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new Field[SqlIdentifier, Row](prefix, "table_schema", None, Some("name"))(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new Field[SqlIdentifier, Row](prefix, "table_name", None, Some("name"))(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](viewCatalog, viewSchema, viewName, tableCatalog, tableSchema, tableName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ViewTableUsageViewRow, merge: (NewRow, ViewTableUsageViewRow) => NewRow): ViewTableUsageViewStructure[NewRow] =
    new ViewTableUsageViewStructure(prefix, extract, merge)
}
