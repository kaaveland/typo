/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductvendorRepo {
  def delete: DeleteBuilder[ProductvendorFields, ProductvendorRow]
  def deleteById(compositeId: ProductvendorId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[ProductvendorId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ProductvendorRow): ZIO[ZConnection, Throwable, ProductvendorRow]
  def insert(unsaved: ProductvendorRowUnsaved): ZIO[ZConnection, Throwable, ProductvendorRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductvendorRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductvendorRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ProductvendorFields, ProductvendorRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductvendorRow]
  def selectById(compositeId: ProductvendorId): ZIO[ZConnection, Throwable, Option[ProductvendorRow]]
  def selectByIds(compositeIds: Array[ProductvendorId]): ZStream[ZConnection, Throwable, ProductvendorRow]
  def selectByIdsTracked(compositeIds: Array[ProductvendorId]): ZIO[ZConnection, Throwable, Map[ProductvendorId, ProductvendorRow]]
  def update: UpdateBuilder[ProductvendorFields, ProductvendorRow]
  def update(row: ProductvendorRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ProductvendorRow): ZIO[ZConnection, Throwable, UpdateResult[ProductvendorRow]]
}
