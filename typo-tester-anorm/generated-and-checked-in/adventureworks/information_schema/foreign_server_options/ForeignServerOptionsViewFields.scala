/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_server_options

import typo.dsl.SqlExpr.OptField

trait ForeignServerOptionsViewFields[Row] {
  val foreignServerCatalog: OptField[/* nullability unknown */ String, Row]
  val foreignServerName: OptField[/* nullability unknown */ String, Row]
  val optionName: OptField[String, Row]
  val optionValue: OptField[String, Row]
}
object ForeignServerOptionsViewFields extends ForeignServerOptionsViewStructure[ForeignServerOptionsViewRow](None, identity, (_, x) => x)

