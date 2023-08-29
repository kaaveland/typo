/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package columns

import typo.dsl.SqlExpr.OptField

trait ColumnsViewFields[Row] {
  val tableCatalog: OptField[String, Row]
  val tableSchema: OptField[String, Row]
  val tableName: OptField[String, Row]
  val columnName: OptField[String, Row]
  val ordinalPosition: OptField[Int, Row]
  val columnDefault: OptField[String, Row]
  val isNullable: OptField[/* max 3 chars */ String, Row]
  val dataType: OptField[String, Row]
  val characterMaximumLength: OptField[Int, Row]
  val characterOctetLength: OptField[Int, Row]
  val numericPrecision: OptField[Int, Row]
  val numericPrecisionRadix: OptField[Int, Row]
  val numericScale: OptField[Int, Row]
  val datetimePrecision: OptField[Int, Row]
  val intervalType: OptField[String, Row]
  val intervalPrecision: OptField[Int, Row]
  val characterSetCatalog: OptField[String, Row]
  val characterSetSchema: OptField[String, Row]
  val characterSetName: OptField[String, Row]
  val collationCatalog: OptField[String, Row]
  val collationSchema: OptField[String, Row]
  val collationName: OptField[String, Row]
  val domainCatalog: OptField[String, Row]
  val domainSchema: OptField[String, Row]
  val domainName: OptField[String, Row]
  val udtCatalog: OptField[String, Row]
  val udtSchema: OptField[String, Row]
  val udtName: OptField[String, Row]
  val scopeCatalog: OptField[String, Row]
  val scopeSchema: OptField[String, Row]
  val scopeName: OptField[String, Row]
  val maximumCardinality: OptField[Int, Row]
  val dtdIdentifier: OptField[String, Row]
  val isSelfReferencing: OptField[/* max 3 chars */ String, Row]
  val isIdentity: OptField[/* max 3 chars */ String, Row]
  val identityGeneration: OptField[String, Row]
  val identityStart: OptField[String, Row]
  val identityIncrement: OptField[String, Row]
  val identityMaximum: OptField[String, Row]
  val identityMinimum: OptField[String, Row]
  val identityCycle: OptField[/* max 3 chars */ String, Row]
  val isGenerated: OptField[String, Row]
  val generationExpression: OptField[String, Row]
  val isUpdatable: OptField[/* max 3 chars */ String, Row]
}
object ColumnsViewFields extends ColumnsViewStructure[ColumnsViewRow](None, identity, (_, x) => x)

