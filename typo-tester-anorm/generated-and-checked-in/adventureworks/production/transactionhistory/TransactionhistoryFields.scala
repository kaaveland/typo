/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait TransactionhistoryFields[Row] {
  val transactionid: IdField[TransactionhistoryId, Row]
  val productid: Field[ProductId, Row]
  val referenceorderid: Field[Int, Row]
  val referenceorderlineid: Field[Int, Row]
  val transactiondate: Field[TypoLocalDateTime, Row]
  val transactiontype: Field[/* bpchar, max 1 chars */ String, Row]
  val quantity: Field[Int, Row]
  val actualcost: Field[BigDecimal, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object TransactionhistoryFields extends TransactionhistoryStructure[TransactionhistoryRow](None, identity, (_, x) => x)
