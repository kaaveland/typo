/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductlistpricehistoryRepo {
  def delete: DeleteBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow]
  def deleteById(compositeId: ProductlistpricehistoryId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[ProductlistpricehistoryId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ProductlistpricehistoryRow): ZIO[ZConnection, Throwable, ProductlistpricehistoryRow]
  def insert(unsaved: ProductlistpricehistoryRowUnsaved): ZIO[ZConnection, Throwable, ProductlistpricehistoryRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductlistpricehistoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductlistpricehistoryRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductlistpricehistoryRow]
  def selectById(compositeId: ProductlistpricehistoryId): ZIO[ZConnection, Throwable, Option[ProductlistpricehistoryRow]]
  def selectByIds(compositeIds: Array[ProductlistpricehistoryId]): ZStream[ZConnection, Throwable, ProductlistpricehistoryRow]
  def selectByIdsTracked(compositeIds: Array[ProductlistpricehistoryId]): ZIO[ZConnection, Throwable, Map[ProductlistpricehistoryId, ProductlistpricehistoryRow]]
  def update: UpdateBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow]
  def update(row: ProductlistpricehistoryRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ProductlistpricehistoryRow): ZIO[ZConnection, Throwable, UpdateResult[ProductlistpricehistoryRow]]
}
