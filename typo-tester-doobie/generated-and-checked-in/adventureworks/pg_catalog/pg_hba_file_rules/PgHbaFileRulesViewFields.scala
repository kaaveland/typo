/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_hba_file_rules

import typo.dsl.SqlExpr.OptField

trait PgHbaFileRulesViewFields[Row] {
  val lineNumber: OptField[Int, Row]
  val `type`: OptField[String, Row]
  val database: OptField[Array[String], Row]
  val userName: OptField[Array[String], Row]
  val address: OptField[String, Row]
  val netmask: OptField[String, Row]
  val authMethod: OptField[String, Row]
  val options: OptField[Array[String], Row]
  val error: OptField[String, Row]
}
object PgHbaFileRulesViewFields extends PgHbaFileRulesViewStructure[PgHbaFileRulesViewRow](None, identity, (_, x) => x)

