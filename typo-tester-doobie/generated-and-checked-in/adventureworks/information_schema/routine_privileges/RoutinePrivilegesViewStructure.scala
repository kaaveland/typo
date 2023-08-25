/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_privileges

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class RoutinePrivilegesViewStructure[Row](val prefix: Option[String], val extract: Row => RoutinePrivilegesViewRow, val merge: (Row, RoutinePrivilegesViewRow) => Row)
  extends Relation[RoutinePrivilegesViewFields, RoutinePrivilegesViewRow, Row]
    with RoutinePrivilegesViewFields[Row] { outer =>

  override val grantor = new Field[SqlIdentifier, Row](prefix, "grantor", None, Some("information_schema.sql_identifier"))(x => extract(x).grantor, (row, value) => merge(row, extract(row).copy(grantor = value)))
  override val grantee = new Field[SqlIdentifier, Row](prefix, "grantee", None, Some("information_schema.sql_identifier"))(x => extract(x).grantee, (row, value) => merge(row, extract(row).copy(grantee = value)))
  override val specificCatalog = new Field[SqlIdentifier, Row](prefix, "specific_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).specificCatalog, (row, value) => merge(row, extract(row).copy(specificCatalog = value)))
  override val specificSchema = new Field[SqlIdentifier, Row](prefix, "specific_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).specificSchema, (row, value) => merge(row, extract(row).copy(specificSchema = value)))
  override val specificName = new Field[SqlIdentifier, Row](prefix, "specific_name", None, Some("information_schema.sql_identifier"))(x => extract(x).specificName, (row, value) => merge(row, extract(row).copy(specificName = value)))
  override val routineCatalog = new Field[SqlIdentifier, Row](prefix, "routine_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).routineCatalog, (row, value) => merge(row, extract(row).copy(routineCatalog = value)))
  override val routineSchema = new Field[SqlIdentifier, Row](prefix, "routine_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).routineSchema, (row, value) => merge(row, extract(row).copy(routineSchema = value)))
  override val routineName = new Field[SqlIdentifier, Row](prefix, "routine_name", None, Some("information_schema.sql_identifier"))(x => extract(x).routineName, (row, value) => merge(row, extract(row).copy(routineName = value)))
  override val privilegeType = new Field[CharacterData, Row](prefix, "privilege_type", None, Some("information_schema.character_data"))(x => extract(x).privilegeType, (row, value) => merge(row, extract(row).copy(privilegeType = value)))
  override val isGrantable = new Field[YesOrNo, Row](prefix, "is_grantable", None, Some("information_schema.yes_or_no"))(x => extract(x).isGrantable, (row, value) => merge(row, extract(row).copy(isGrantable = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](grantor, grantee, specificCatalog, specificSchema, specificName, routineCatalog, routineSchema, routineName, privilegeType, isGrantable)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => RoutinePrivilegesViewRow, merge: (NewRow, RoutinePrivilegesViewRow) => NewRow): RoutinePrivilegesViewStructure[NewRow] =
    new RoutinePrivilegesViewStructure(prefix, extract, merge)
}
