/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait EmployeedepartmenthistoryRepo {
  def delete: DeleteBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow]
  def deleteById(compositeId: EmployeedepartmenthistoryId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(compositeIds: Array[EmployeedepartmenthistoryId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: EmployeedepartmenthistoryRow): ZIO[ZConnection, Throwable, EmployeedepartmenthistoryRow]
  def insert(unsaved: EmployeedepartmenthistoryRowUnsaved): ZIO[ZConnection, Throwable, EmployeedepartmenthistoryRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow]
  def selectAll: ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRow]
  def selectById(compositeId: EmployeedepartmenthistoryId): ZIO[ZConnection, Throwable, Option[EmployeedepartmenthistoryRow]]
  def selectByIds(compositeIds: Array[EmployeedepartmenthistoryId]): ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRow]
  def selectByIdsTracked(compositeIds: Array[EmployeedepartmenthistoryId]): ZIO[ZConnection, Throwable, Map[EmployeedepartmenthistoryId, EmployeedepartmenthistoryRow]]
  def update: UpdateBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow]
  def update(row: EmployeedepartmenthistoryRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: EmployeedepartmenthistoryRow): ZIO[ZConnection, Throwable, UpdateResult[EmployeedepartmenthistoryRow]]
}
