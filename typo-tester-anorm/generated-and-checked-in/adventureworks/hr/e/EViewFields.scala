/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package e

import adventureworks.TypoLocalDate
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import java.util.UUID
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait EViewFields[Row] {
  val id: OptField[Int, Row]
  val businessentityid: OptField[BusinessentityId, Row]
  val nationalidnumber: OptField[/* max 15 chars */ String, Row]
  val loginid: OptField[/* max 256 chars */ String, Row]
  val jobtitle: OptField[/* max 50 chars */ String, Row]
  val birthdate: OptField[TypoLocalDate, Row]
  val maritalstatus: OptField[/* bpchar, max 1 chars */ String, Row]
  val gender: OptField[/* bpchar, max 1 chars */ String, Row]
  val hiredate: OptField[TypoLocalDate, Row]
  val salariedflag: Field[Flag, Row]
  val vacationhours: OptField[Int, Row]
  val sickleavehours: OptField[Int, Row]
  val currentflag: Field[Flag, Row]
  val rowguid: OptField[UUID, Row]
  val modifieddate: OptField[TypoLocalDateTime, Row]
  val organizationnode: OptField[String, Row]
}
object EViewFields extends EViewStructure[EViewRow](None, identity, (_, x) => x)
