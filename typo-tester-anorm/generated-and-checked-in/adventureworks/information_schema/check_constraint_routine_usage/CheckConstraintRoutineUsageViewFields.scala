/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package check_constraint_routine_usage

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.Field

trait CheckConstraintRoutineUsageViewFields[Row] {
  val constraintCatalog: Field[SqlIdentifier, Row]
  val constraintSchema: Field[SqlIdentifier, Row]
  val constraintName: Field[SqlIdentifier, Row]
  val specificCatalog: Field[SqlIdentifier, Row]
  val specificSchema: Field[SqlIdentifier, Row]
  val specificName: Field[SqlIdentifier, Row]
}
object CheckConstraintRoutineUsageViewFields extends CheckConstraintRoutineUsageViewStructure[CheckConstraintRoutineUsageViewRow](None, identity, (_, x) => x)

