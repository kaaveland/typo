/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package domain_constraints

import typo.dsl.SqlExpr.OptField

trait DomainConstraintsViewFields[Row] {
  val constraintCatalog: OptField[String, Row]
  val constraintSchema: OptField[String, Row]
  val constraintName: OptField[String, Row]
  val domainCatalog: OptField[String, Row]
  val domainSchema: OptField[String, Row]
  val domainName: OptField[String, Row]
  val isDeferrable: OptField[/* max 3 chars */ String, Row]
  val initiallyDeferred: OptField[/* max 3 chars */ String, Row]
}
object DomainConstraintsViewFields extends DomainConstraintsViewStructure[DomainConstraintsViewRow](None, identity, (_, x) => x)

