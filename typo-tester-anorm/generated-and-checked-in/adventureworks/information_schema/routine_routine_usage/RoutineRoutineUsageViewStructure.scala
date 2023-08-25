/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_routine_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class RoutineRoutineUsageViewStructure[Row](val prefix: Option[String], val extract: Row => RoutineRoutineUsageViewRow, val merge: (Row, RoutineRoutineUsageViewRow) => Row)
  extends Relation[RoutineRoutineUsageViewFields, RoutineRoutineUsageViewRow, Row]
    with RoutineRoutineUsageViewFields[Row] { outer =>

  override val specificCatalog = new Field[SqlIdentifier, Row](prefix, "specific_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).specificCatalog, (row, value) => merge(row, extract(row).copy(specificCatalog = value)))
  override val specificSchema = new Field[SqlIdentifier, Row](prefix, "specific_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).specificSchema, (row, value) => merge(row, extract(row).copy(specificSchema = value)))
  override val specificName = new Field[SqlIdentifier, Row](prefix, "specific_name", None, Some("information_schema.sql_identifier"))(x => extract(x).specificName, (row, value) => merge(row, extract(row).copy(specificName = value)))
  override val routineCatalog = new Field[SqlIdentifier, Row](prefix, "routine_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).routineCatalog, (row, value) => merge(row, extract(row).copy(routineCatalog = value)))
  override val routineSchema = new Field[SqlIdentifier, Row](prefix, "routine_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).routineSchema, (row, value) => merge(row, extract(row).copy(routineSchema = value)))
  override val routineName = new Field[SqlIdentifier, Row](prefix, "routine_name", None, Some("information_schema.sql_identifier"))(x => extract(x).routineName, (row, value) => merge(row, extract(row).copy(routineName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](specificCatalog, specificSchema, specificName, routineCatalog, routineSchema, routineName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => RoutineRoutineUsageViewRow, merge: (NewRow, RoutineRoutineUsageViewRow) => NewRow): RoutineRoutineUsageViewStructure[NewRow] =
    new RoutineRoutineUsageViewStructure(prefix, extract, merge)
}
