/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sod

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import java.util.UUID
import typo.dsl.SqlExpr.Field

trait SodViewFields[Row] {
  val id: Field[Int, Row]
  val salesorderid: Field[SalesorderheaderId, Row]
  val salesorderdetailid: Field[Int, Row]
  val carriertrackingnumber: Field[/* max 25 chars */ String, Row]
  val orderqty: Field[Int, Row]
  val productid: Field[ProductId, Row]
  val specialofferid: Field[SpecialofferId, Row]
  val unitprice: Field[BigDecimal, Row]
  val unitpricediscount: Field[BigDecimal, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object SodViewFields extends SodViewStructure[SodViewRow](None, identity, (_, x) => x)

