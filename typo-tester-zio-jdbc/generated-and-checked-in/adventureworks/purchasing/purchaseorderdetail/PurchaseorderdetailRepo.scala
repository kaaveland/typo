/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import typo.dsl.SelectBuilder
import zio.ZIO
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PurchaseorderdetailRepo {
  def select: SelectBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow]
  def selectAll: ZStream[ZConnection, Throwable, PurchaseorderdetailRow]
  def selectById(compositeId: PurchaseorderdetailId): ZIO[ZConnection, Throwable, Option[PurchaseorderdetailRow]]
}
