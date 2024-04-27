/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ShiftRepo {
  def delete: DeleteBuilder[ShiftFields, ShiftRow]
  def deleteById(shiftid: ShiftId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(shiftids: Array[ShiftId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ShiftRow): ZIO[ZConnection, Throwable, ShiftRow]
  def insert(unsaved: ShiftRowUnsaved): ZIO[ZConnection, Throwable, ShiftRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ShiftRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ShiftRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ShiftFields, ShiftRow]
  def selectAll: ZStream[ZConnection, Throwable, ShiftRow]
  def selectById(shiftid: ShiftId): ZIO[ZConnection, Throwable, Option[ShiftRow]]
  def selectByIds(shiftids: Array[ShiftId]): ZStream[ZConnection, Throwable, ShiftRow]
  def selectByIdsTracked(shiftids: Array[ShiftId]): ZIO[ZConnection, Throwable, Map[ShiftId, Option[ShiftRow]]]
  def update: UpdateBuilder[ShiftFields, ShiftRow]
  def update(row: ShiftRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ShiftRow): ZIO[ZConnection, Throwable, UpdateResult[ShiftRow]]
}
