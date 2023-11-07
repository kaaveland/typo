/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgDatabaseRepo {
  def delete(oid: PgDatabaseId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgDatabaseFields, PgDatabaseRow]
  def insert(unsaved: PgDatabaseRow): ZIO[ZConnection, Throwable, PgDatabaseRow]
  def select: SelectBuilder[PgDatabaseFields, PgDatabaseRow]
  def selectAll: ZStream[ZConnection, Throwable, PgDatabaseRow]
  def selectById(oid: PgDatabaseId): ZIO[ZConnection, Throwable, Option[PgDatabaseRow]]
  def selectByIds(oids: Array[PgDatabaseId]): ZStream[ZConnection, Throwable, PgDatabaseRow]
  def selectByUnique(datname: String): ZIO[ZConnection, Throwable, Option[PgDatabaseRow]]
  def update(row: PgDatabaseRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgDatabaseFields, PgDatabaseRow]
  def upsert(unsaved: PgDatabaseRow): ZIO[ZConnection, Throwable, UpdateResult[PgDatabaseRow]]
}
