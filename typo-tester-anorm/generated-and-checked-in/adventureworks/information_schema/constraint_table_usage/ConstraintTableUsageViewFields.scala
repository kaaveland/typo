/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package constraint_table_usage

import typo.dsl.SqlExpr.OptField

trait ConstraintTableUsageViewFields[Row] {
  val tableCatalog: OptField[String, Row]
  val tableSchema: OptField[String, Row]
  val tableName: OptField[String, Row]
  val constraintCatalog: OptField[String, Row]
  val constraintSchema: OptField[String, Row]
  val constraintName: OptField[String, Row]
}
object ConstraintTableUsageViewFields extends ConstraintTableUsageViewStructure[ConstraintTableUsageViewRow](None, identity, (_, x) => x)

