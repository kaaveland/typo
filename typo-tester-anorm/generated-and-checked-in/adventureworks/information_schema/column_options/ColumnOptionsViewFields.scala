/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_options

import typo.dsl.SqlExpr.OptField

trait ColumnOptionsViewFields[Row] {
  val tableCatalog: OptField[String, Row]
  val tableSchema: OptField[String, Row]
  val tableName: OptField[String, Row]
  val columnName: OptField[String, Row]
  val optionName: OptField[String, Row]
  val optionValue: OptField[String, Row]
}
object ColumnOptionsViewFields extends ColumnOptionsViewStructure[ColumnOptionsViewRow](None, identity, (_, x) => x)

