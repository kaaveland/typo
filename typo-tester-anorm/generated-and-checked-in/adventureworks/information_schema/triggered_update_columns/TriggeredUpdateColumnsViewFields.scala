/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggered_update_columns

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.OptField

trait TriggeredUpdateColumnsViewFields[Row] {
  val triggerCatalog: OptField[SqlIdentifier, Row]
  val triggerSchema: OptField[SqlIdentifier, Row]
  val triggerName: OptField[SqlIdentifier, Row]
  val eventObjectCatalog: OptField[SqlIdentifier, Row]
  val eventObjectSchema: OptField[SqlIdentifier, Row]
  val eventObjectTable: OptField[SqlIdentifier, Row]
  val eventObjectColumn: OptField[SqlIdentifier, Row]
}
object TriggeredUpdateColumnsViewFields extends TriggeredUpdateColumnsViewStructure[TriggeredUpdateColumnsViewRow](None, identity, (_, x) => x)
