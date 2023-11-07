/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package eph

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.SqlExpr.Field

trait EphViewFields[Row] {
  val id: Field[BusinessentityId, Row]
  val businessentityid: Field[BusinessentityId, Row]
  val ratechangedate: Field[TypoLocalDateTime, Row]
  val rate: Field[BigDecimal, Row]
  val payfrequency: Field[TypoShort, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object EphViewFields extends EphViewStructure[EphViewRow](None, identity, (_, x) => x)

