/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import zio.Chunk
import zio.ZIO
import zio.jdbc.ZConnection
import zio.stream.ZStream

class PurchaseorderdetailRepoMock(map: scala.collection.mutable.Map[PurchaseorderdetailId, PurchaseorderdetailRow] = scala.collection.mutable.Map.empty) extends PurchaseorderdetailRepo {
  override def select: SelectBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow] = {
    SelectBuilderMock(PurchaseorderdetailFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PurchaseorderdetailRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: PurchaseorderdetailId): ZIO[ZConnection, Throwable, Option[PurchaseorderdetailRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
}
