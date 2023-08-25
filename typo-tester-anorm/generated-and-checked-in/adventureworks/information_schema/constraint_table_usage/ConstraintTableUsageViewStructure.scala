/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package constraint_table_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class ConstraintTableUsageViewStructure[Row](val prefix: Option[String], val extract: Row => ConstraintTableUsageViewRow, val merge: (Row, ConstraintTableUsageViewRow) => Row)
  extends Relation[ConstraintTableUsageViewFields, ConstraintTableUsageViewRow, Row]
    with ConstraintTableUsageViewFields[Row] { outer =>

  override val tableCatalog = new Field[SqlIdentifier, Row](prefix, "table_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new Field[SqlIdentifier, Row](prefix, "table_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new Field[SqlIdentifier, Row](prefix, "table_name", None, Some("information_schema.sql_identifier"))(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))
  override val constraintCatalog = new Field[SqlIdentifier, Row](prefix, "constraint_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).constraintCatalog, (row, value) => merge(row, extract(row).copy(constraintCatalog = value)))
  override val constraintSchema = new Field[SqlIdentifier, Row](prefix, "constraint_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).constraintSchema, (row, value) => merge(row, extract(row).copy(constraintSchema = value)))
  override val constraintName = new Field[SqlIdentifier, Row](prefix, "constraint_name", None, Some("information_schema.sql_identifier"))(x => extract(x).constraintName, (row, value) => merge(row, extract(row).copy(constraintName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](tableCatalog, tableSchema, tableName, constraintCatalog, constraintSchema, constraintName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ConstraintTableUsageViewRow, merge: (NewRow, ConstraintTableUsageViewRow) => NewRow): ConstraintTableUsageViewStructure[NewRow] =
    new ConstraintTableUsageViewStructure(prefix, extract, merge)
}
