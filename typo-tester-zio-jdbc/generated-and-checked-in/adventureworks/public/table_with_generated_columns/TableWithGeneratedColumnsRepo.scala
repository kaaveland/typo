/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package table_with_generated_columns

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait TableWithGeneratedColumnsRepo {
  def delete: DeleteBuilder[TableWithGeneratedColumnsFields, TableWithGeneratedColumnsRow]
  def deleteById(name: TableWithGeneratedColumnsId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(names: Array[TableWithGeneratedColumnsId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: TableWithGeneratedColumnsRow): ZIO[ZConnection, Throwable, TableWithGeneratedColumnsRow]
  def insert(unsaved: TableWithGeneratedColumnsRowUnsaved): ZIO[ZConnection, Throwable, TableWithGeneratedColumnsRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, TableWithGeneratedColumnsRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, TableWithGeneratedColumnsRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[TableWithGeneratedColumnsFields, TableWithGeneratedColumnsRow]
  def selectAll: ZStream[ZConnection, Throwable, TableWithGeneratedColumnsRow]
  def selectById(name: TableWithGeneratedColumnsId): ZIO[ZConnection, Throwable, Option[TableWithGeneratedColumnsRow]]
  def selectByIds(names: Array[TableWithGeneratedColumnsId]): ZStream[ZConnection, Throwable, TableWithGeneratedColumnsRow]
  def selectByIdsTracked(names: Array[TableWithGeneratedColumnsId]): ZIO[ZConnection, Throwable, Map[TableWithGeneratedColumnsId, TableWithGeneratedColumnsRow]]
  def update: UpdateBuilder[TableWithGeneratedColumnsFields, TableWithGeneratedColumnsRow]
  def upsert(unsaved: TableWithGeneratedColumnsRow): ZIO[ZConnection, Throwable, UpdateResult[TableWithGeneratedColumnsRow]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, TableWithGeneratedColumnsRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
