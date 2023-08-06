/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField

trait WorkorderroutingFields[Row] {
  val workorderid: IdField[WorkorderId, Row]
  val productid: IdField[Int, Row]
  val operationsequence: IdField[Int, Row]
  val locationid: Field[LocationId, Row]
  val scheduledstartdate: Field[TypoLocalDateTime, Row]
  val scheduledenddate: Field[TypoLocalDateTime, Row]
  val actualstartdate: OptField[TypoLocalDateTime, Row]
  val actualenddate: OptField[TypoLocalDateTime, Row]
  val actualresourcehrs: OptField[BigDecimal, Row]
  val plannedcost: Field[BigDecimal, Row]
  val actualcost: OptField[BigDecimal, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object WorkorderroutingFields extends WorkorderroutingStructure[WorkorderroutingRow](None, identity, (_, x) => x)
