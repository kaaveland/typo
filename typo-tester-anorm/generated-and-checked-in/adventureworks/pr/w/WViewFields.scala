/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package w

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import adventureworks.production.workorder.WorkorderId
import typo.dsl.SqlExpr.Field

trait WViewFields[Row] {
  val id: Field[Int, Row]
  val workorderid: Field[WorkorderId, Row]
  val productid: Field[ProductId, Row]
  val orderqty: Field[Int, Row]
  val scrappedqty: Field[Int, Row]
  val startdate: Field[TypoLocalDateTime, Row]
  val enddate: Field[TypoLocalDateTime, Row]
  val duedate: Field[TypoLocalDateTime, Row]
  val scrapreasonid: Field[ScrapreasonId, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object WViewFields extends WViewStructure[WViewRow](None, identity, (_, x) => x)

