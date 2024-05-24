/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait EmailaddressFields {
  val businessentityid: IdField[BusinessentityId, Row]
  val emailaddressid: IdField[Int, Row]
  val emailaddress: OptField[/* max 50 chars */ String, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object EmailaddressFields extends EmailaddressStructure[EmailaddressRow](None, identity, (_, x) => x)

