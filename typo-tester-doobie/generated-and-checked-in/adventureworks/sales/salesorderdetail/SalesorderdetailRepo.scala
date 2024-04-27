/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalesorderdetailRepo {
  def delete: DeleteBuilder[SalesorderdetailFields, SalesorderdetailRow]
  def deleteById(compositeId: SalesorderdetailId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[SalesorderdetailId]): ConnectionIO[Int]
  def insert(unsaved: SalesorderdetailRow): ConnectionIO[SalesorderdetailRow]
  def insert(unsaved: SalesorderdetailRowUnsaved): ConnectionIO[SalesorderdetailRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, SalesorderdetailRow], batchSize: Int): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesorderdetailRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[SalesorderdetailFields, SalesorderdetailRow]
  def selectAll: Stream[ConnectionIO, SalesorderdetailRow]
  def selectById(compositeId: SalesorderdetailId): ConnectionIO[Option[SalesorderdetailRow]]
  def selectByIds(compositeIds: Array[SalesorderdetailId]): Stream[ConnectionIO, SalesorderdetailRow]
  def selectByIdsTracked(compositeIds: Array[SalesorderdetailId]): ConnectionIO[Map[SalesorderdetailId, Option[SalesorderdetailRow]]]
  def update: UpdateBuilder[SalesorderdetailFields, SalesorderdetailRow]
  def update(row: SalesorderdetailRow): ConnectionIO[Boolean]
  def upsert(unsaved: SalesorderdetailRow): ConnectionIO[SalesorderdetailRow]
}
