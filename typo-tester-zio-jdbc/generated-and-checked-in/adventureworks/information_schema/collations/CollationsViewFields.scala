/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collations

import typo.dsl.SqlExpr.OptField

trait CollationsViewFields[Row] {
  val collationCatalog: OptField[String, Row]
  val collationSchema: OptField[String, Row]
  val collationName: OptField[String, Row]
  val padAttribute: OptField[String, Row]
}
object CollationsViewFields extends CollationsViewStructure[CollationsViewRow](None, identity, (_, x) => x)

