/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_column_usage

import typo.dsl.SqlExpr.OptField

trait ViewColumnUsageViewFields[Row] {
  val viewCatalog: OptField[String, Row]
  val viewSchema: OptField[String, Row]
  val viewName: OptField[String, Row]
  val tableCatalog: OptField[String, Row]
  val tableSchema: OptField[String, Row]
  val tableName: OptField[String, Row]
  val columnName: OptField[String, Row]
}
object ViewColumnUsageViewFields extends ViewColumnUsageViewStructure[ViewColumnUsageViewRow](None, identity, (_, x) => x)

