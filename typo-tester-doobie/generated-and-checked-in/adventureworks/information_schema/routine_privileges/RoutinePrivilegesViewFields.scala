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

trait RoutinePrivilegesViewFields[Row] {
  val grantor: Field[SqlIdentifier, Row]
  val grantee: Field[SqlIdentifier, Row]
  val specificCatalog: Field[SqlIdentifier, Row]
  val specificSchema: Field[SqlIdentifier, Row]
  val specificName: Field[SqlIdentifier, Row]
  val routineCatalog: Field[SqlIdentifier, Row]
  val routineSchema: Field[SqlIdentifier, Row]
  val routineName: Field[SqlIdentifier, Row]
  val privilegeType: Field[CharacterData, Row]
  val isGrantable: Field[YesOrNo, Row]
}
object RoutinePrivilegesViewFields extends RoutinePrivilegesViewStructure[RoutinePrivilegesViewRow](None, identity, (_, x) => x)

