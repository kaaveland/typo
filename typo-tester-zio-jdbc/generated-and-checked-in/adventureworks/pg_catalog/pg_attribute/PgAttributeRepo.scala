/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attribute

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgAttributeRepo {
  def delete(compositeId: PgAttributeId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgAttributeFields, PgAttributeRow]
  def insert(unsaved: PgAttributeRow): ZIO[ZConnection, Throwable, PgAttributeRow]
  def select: SelectBuilder[PgAttributeFields, PgAttributeRow]
  def selectAll: ZStream[ZConnection, Throwable, PgAttributeRow]
  def selectById(compositeId: PgAttributeId): ZIO[ZConnection, Throwable, Option[PgAttributeRow]]
  def selectByUnique(attrelid: /* oid */ Long, attname: String): ZIO[ZConnection, Throwable, Option[PgAttributeRow]]
  def update(row: PgAttributeRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgAttributeFields, PgAttributeRow]
  def upsert(unsaved: PgAttributeRow): ZIO[ZConnection, Throwable, UpdateResult[PgAttributeRow]]
}
