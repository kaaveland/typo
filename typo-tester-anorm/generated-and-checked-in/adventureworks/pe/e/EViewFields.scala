/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import java.util.UUID
import typo.dsl.SqlExpr.Field

trait EViewFields[Row] {
  val id: Field[Int, Row]
  val businessentityid: Field[BusinessentityId, Row]
  val emailaddressid: Field[Int, Row]
  val emailaddress: Field[/* max 50 chars */ String, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object EViewFields extends EViewStructure[EViewRow](None, identity, (_, x) => x)

