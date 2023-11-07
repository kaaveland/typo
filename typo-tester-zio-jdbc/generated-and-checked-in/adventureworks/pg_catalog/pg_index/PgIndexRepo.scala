/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_index

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgIndexRepo {
  def delete(indexrelid: PgIndexId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgIndexFields, PgIndexRow]
  def insert(unsaved: PgIndexRow): ZIO[ZConnection, Throwable, PgIndexRow]
  def select: SelectBuilder[PgIndexFields, PgIndexRow]
  def selectAll: ZStream[ZConnection, Throwable, PgIndexRow]
  def selectById(indexrelid: PgIndexId): ZIO[ZConnection, Throwable, Option[PgIndexRow]]
  def selectByIds(indexrelids: Array[PgIndexId]): ZStream[ZConnection, Throwable, PgIndexRow]
  def update(row: PgIndexRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgIndexFields, PgIndexRow]
  def upsert(unsaved: PgIndexRow): ZIO[ZConnection, Throwable, UpdateResult[PgIndexRow]]
}
