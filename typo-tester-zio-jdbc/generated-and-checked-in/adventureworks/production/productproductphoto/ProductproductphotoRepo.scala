/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductproductphotoRepo {
  def delete: DeleteBuilder[ProductproductphotoFields, ProductproductphotoRow]
  def deleteById(compositeId: ProductproductphotoId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[ProductproductphotoId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ProductproductphotoRow): ZIO[ZConnection, Throwable, ProductproductphotoRow]
  def insert(unsaved: ProductproductphotoRowUnsaved): ZIO[ZConnection, Throwable, ProductproductphotoRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductproductphotoRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductproductphotoRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ProductproductphotoFields, ProductproductphotoRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductproductphotoRow]
  def selectById(compositeId: ProductproductphotoId): ZIO[ZConnection, Throwable, Option[ProductproductphotoRow]]
  def selectByIds(compositeIds: Array[ProductproductphotoId]): ZStream[ZConnection, Throwable, ProductproductphotoRow]
  def selectByIdsTracked(compositeIds: Array[ProductproductphotoId]): ZIO[ZConnection, Throwable, Map[ProductproductphotoId, Option[ProductproductphotoRow]]]
  def update: UpdateBuilder[ProductproductphotoFields, ProductproductphotoRow]
  def update(row: ProductproductphotoRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ProductproductphotoRow): ZIO[ZConnection, Throwable, UpdateResult[ProductproductphotoRow]]
}
