/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductcosthistoryRepo {
  def delete: DeleteBuilder[ProductcosthistoryFields, ProductcosthistoryRow]
  def deleteById(compositeId: ProductcosthistoryId): ConnectionIO[Boolean]
  def deleteByIds(compositeIds: Array[ProductcosthistoryId]): ConnectionIO[Int]
  def insert(unsaved: ProductcosthistoryRow): ConnectionIO[ProductcosthistoryRow]
  def insert(unsaved: ProductcosthistoryRowUnsaved): ConnectionIO[ProductcosthistoryRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductcosthistoryRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductcosthistoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[ProductcosthistoryFields, ProductcosthistoryRow]
  def selectAll: Stream[ConnectionIO, ProductcosthistoryRow]
  def selectById(compositeId: ProductcosthistoryId): ConnectionIO[Option[ProductcosthistoryRow]]
  def selectByIds(compositeIds: Array[ProductcosthistoryId]): Stream[ConnectionIO, ProductcosthistoryRow]
  def selectByIdsTracked(compositeIds: Array[ProductcosthistoryId]): ConnectionIO[Map[ProductcosthistoryId, ProductcosthistoryRow]]
  def update: UpdateBuilder[ProductcosthistoryFields, ProductcosthistoryRow]
  def update(row: ProductcosthistoryRow): ConnectionIO[Boolean]
  def upsert(unsaved: ProductcosthistoryRow): ConnectionIO[ProductcosthistoryRow]
}
