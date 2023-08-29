/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package character_sets

import typo.dsl.SqlExpr.OptField

trait CharacterSetsViewFields[Row] {
  val characterSetCatalog: OptField[String, Row]
  val characterSetSchema: OptField[String, Row]
  val characterSetName: OptField[String, Row]
  val characterRepertoire: OptField[String, Row]
  val formOfUse: OptField[String, Row]
  val defaultCollateCatalog: OptField[String, Row]
  val defaultCollateSchema: OptField[String, Row]
  val defaultCollateName: OptField[String, Row]
}
object CharacterSetsViewFields extends CharacterSetsViewStructure[CharacterSetsViewRow](None, identity, (_, x) => x)

