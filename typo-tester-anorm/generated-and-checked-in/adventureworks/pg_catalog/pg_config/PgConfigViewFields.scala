/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_config

import typo.dsl.SqlExpr.OptField

trait PgConfigViewFields[Row] {
  val name: OptField[String, Row]
  val setting: OptField[String, Row]
}
object PgConfigViewFields extends PgConfigViewStructure[PgConfigViewRow](None, identity, (_, x) => x)

