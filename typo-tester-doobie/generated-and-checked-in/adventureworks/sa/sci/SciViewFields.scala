/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sci

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.shoppingcartitem.ShoppingcartitemId
import typo.dsl.SqlExpr.Field

trait SciViewFields[Row] {
  val id: Field[Int, Row]
  val shoppingcartitemid: Field[ShoppingcartitemId, Row]
  val shoppingcartid: Field[/* max 50 chars */ String, Row]
  val quantity: Field[Int, Row]
  val productid: Field[ProductId, Row]
  val datecreated: Field[TypoLocalDateTime, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SciViewFields extends SciViewStructure[SciViewRow](None, identity, (_, x) => x)

