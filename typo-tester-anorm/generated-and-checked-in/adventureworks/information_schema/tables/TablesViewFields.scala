/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package tables

import typo.dsl.SqlExpr.OptField

trait TablesViewFields[Row] {
  val tableCatalog: OptField[String, Row]
  val tableSchema: OptField[String, Row]
  val tableName: OptField[String, Row]
  val tableType: OptField[String, Row]
  val selfReferencingColumnName: OptField[String, Row]
  val referenceGeneration: OptField[String, Row]
  val userDefinedTypeCatalog: OptField[String, Row]
  val userDefinedTypeSchema: OptField[String, Row]
  val userDefinedTypeName: OptField[String, Row]
  val isInsertableInto: OptField[/* max 3 chars */ String, Row]
  val isTyped: OptField[/* max 3 chars */ String, Row]
  val commitAction: OptField[String, Row]
}
object TablesViewFields extends TablesViewStructure[TablesViewRow](None, identity, (_, x) => x)

