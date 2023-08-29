/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package v

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait VViewFields[Row] {
  val id: Field[BusinessentityId, Row]
  val businessentityid: Field[BusinessentityId, Row]
  val accountnumber: Field[AccountNumber, Row]
  val name: Field[Name, Row]
  val creditrating: Field[Int, Row]
  val preferredvendorstatus: Field[Flag, Row]
  val activeflag: Field[Flag, Row]
  val purchasingwebserviceurl: OptField[/* max 1024 chars */ String, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object VViewFields extends VViewStructure[VViewRow](None, identity, (_, x) => x)

