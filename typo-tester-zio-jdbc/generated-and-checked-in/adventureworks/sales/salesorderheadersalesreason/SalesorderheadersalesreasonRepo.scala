/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait SalesorderheadersalesreasonRepo {
  def delete: DeleteBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow]
  def deleteById(compositeId: SalesorderheadersalesreasonId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[SalesorderheadersalesreasonId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: SalesorderheadersalesreasonRow): ZIO[ZConnection, Throwable, SalesorderheadersalesreasonRow]
  def insert(unsaved: SalesorderheadersalesreasonRowUnsaved): ZIO[ZConnection, Throwable, SalesorderheadersalesreasonRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheadersalesreasonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheadersalesreasonRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow]
  def selectAll: ZStream[ZConnection, Throwable, SalesorderheadersalesreasonRow]
  def selectById(compositeId: SalesorderheadersalesreasonId): ZIO[ZConnection, Throwable, Option[SalesorderheadersalesreasonRow]]
  def selectByIds(compositeIds: Array[SalesorderheadersalesreasonId]): ZStream[ZConnection, Throwable, SalesorderheadersalesreasonRow]
  def selectByIdsTracked(compositeIds: Array[SalesorderheadersalesreasonId]): ZIO[ZConnection, Throwable, Map[SalesorderheadersalesreasonId, SalesorderheadersalesreasonRow]]
  def update: UpdateBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow]
  def update(row: SalesorderheadersalesreasonRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: SalesorderheadersalesreasonRow): ZIO[ZConnection, Throwable, UpdateResult[SalesorderheadersalesreasonRow]]
}
