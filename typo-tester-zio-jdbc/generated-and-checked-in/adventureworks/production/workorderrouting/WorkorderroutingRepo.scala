/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait WorkorderroutingRepo {
  def delete: DeleteBuilder[WorkorderroutingFields, WorkorderroutingRow]
  def deleteById(compositeId: WorkorderroutingId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[WorkorderroutingId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: WorkorderroutingRow): ZIO[ZConnection, Throwable, WorkorderroutingRow]
  def insert(unsaved: WorkorderroutingRowUnsaved): ZIO[ZConnection, Throwable, WorkorderroutingRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderroutingRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderroutingRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[WorkorderroutingFields, WorkorderroutingRow]
  def selectAll: ZStream[ZConnection, Throwable, WorkorderroutingRow]
  def selectById(compositeId: WorkorderroutingId): ZIO[ZConnection, Throwable, Option[WorkorderroutingRow]]
  def selectByIds(compositeIds: Array[WorkorderroutingId]): ZStream[ZConnection, Throwable, WorkorderroutingRow]
  def selectByIdsTracked(compositeIds: Array[WorkorderroutingId]): ZIO[ZConnection, Throwable, Map[WorkorderroutingId, Option[WorkorderroutingRow]]]
  def update: UpdateBuilder[WorkorderroutingFields, WorkorderroutingRow]
  def update(row: WorkorderroutingRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: WorkorderroutingRow): ZIO[ZConnection, Throwable, UpdateResult[WorkorderroutingRow]]
}
