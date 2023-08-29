/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartmenthistory

import adventureworks.customtypes.TypoLocalDate
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.userdefined.FirstName
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait VemployeedepartmenthistoryViewFields[Row] {
  val businessentityid: Field[BusinessentityId, Row]
  val title: OptField[/* max 8 chars */ String, Row]
  val firstname: Field[/* user-picked */ FirstName, Row]
  val middlename: OptField[Name, Row]
  val lastname: Field[Name, Row]
  val suffix: OptField[/* max 10 chars */ String, Row]
  val shift: Field[Name, Row]
  val department: Field[Name, Row]
  val groupname: Field[Name, Row]
  val startdate: Field[TypoLocalDate, Row]
  val enddate: OptField[TypoLocalDate, Row]
}
object VemployeedepartmenthistoryViewFields extends VemployeedepartmenthistoryViewStructure[VemployeedepartmenthistoryViewRow](None, identity, (_, x) => x)

