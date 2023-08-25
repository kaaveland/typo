/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package plph

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import typo.dsl.SqlExpr.Field

trait PlphViewFields[Row] {
  val id: Field[Int, Row]
  val productid: Field[ProductId, Row]
  val startdate: Field[TypoLocalDateTime, Row]
  val enddate: Field[TypoLocalDateTime, Row]
  val listprice: Field[BigDecimal, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object PlphViewFields extends PlphViewStructure[PlphViewRow](None, identity, (_, x) => x)

