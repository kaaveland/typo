/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_table_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class RoutineTableUsageViewStructure[Row](val prefix: Option[String], val extract: Row => RoutineTableUsageViewRow, val merge: (Row, RoutineTableUsageViewRow) => Row)
  extends Relation[RoutineTableUsageViewFields, RoutineTableUsageViewRow, Row]
    with RoutineTableUsageViewFields[Row] { outer =>

  override val specificCatalog = new Field[SqlIdentifier, Row](prefix, "specific_catalog", None, Some("name"))(x => extract(x).specificCatalog, (row, value) => merge(row, extract(row).copy(specificCatalog = value)))
  override val specificSchema = new Field[SqlIdentifier, Row](prefix, "specific_schema", None, Some("name"))(x => extract(x).specificSchema, (row, value) => merge(row, extract(row).copy(specificSchema = value)))
  override val specificName = new Field[SqlIdentifier, Row](prefix, "specific_name", None, Some("name"))(x => extract(x).specificName, (row, value) => merge(row, extract(row).copy(specificName = value)))
  override val routineCatalog = new Field[SqlIdentifier, Row](prefix, "routine_catalog", None, Some("name"))(x => extract(x).routineCatalog, (row, value) => merge(row, extract(row).copy(routineCatalog = value)))
  override val routineSchema = new Field[SqlIdentifier, Row](prefix, "routine_schema", None, Some("name"))(x => extract(x).routineSchema, (row, value) => merge(row, extract(row).copy(routineSchema = value)))
  override val routineName = new Field[SqlIdentifier, Row](prefix, "routine_name", None, Some("name"))(x => extract(x).routineName, (row, value) => merge(row, extract(row).copy(routineName = value)))
  override val tableCatalog = new Field[SqlIdentifier, Row](prefix, "table_catalog", None, Some("name"))(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new Field[SqlIdentifier, Row](prefix, "table_schema", None, Some("name"))(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new Field[SqlIdentifier, Row](prefix, "table_name", None, Some("name"))(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](specificCatalog, specificSchema, specificName, routineCatalog, routineSchema, routineName, tableCatalog, tableSchema, tableName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => RoutineTableUsageViewRow, merge: (NewRow, RoutineTableUsageViewRow) => NewRow): RoutineTableUsageViewStructure[NewRow] =
    new RoutineTableUsageViewStructure(prefix, extract, merge)
}
