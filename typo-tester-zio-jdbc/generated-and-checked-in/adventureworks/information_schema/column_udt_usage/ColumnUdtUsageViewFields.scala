/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_udt_usage

import typo.dsl.SqlExpr.OptField

trait ColumnUdtUsageViewFields[Row] {
  val udtCatalog: OptField[String, Row]
  val udtSchema: OptField[String, Row]
  val udtName: OptField[String, Row]
  val tableCatalog: OptField[String, Row]
  val tableSchema: OptField[String, Row]
  val tableName: OptField[String, Row]
  val columnName: OptField[String, Row]
}
object ColumnUdtUsageViewFields extends ColumnUdtUsageViewStructure[ColumnUdtUsageViewRow](None, identity, (_, x) => x)

