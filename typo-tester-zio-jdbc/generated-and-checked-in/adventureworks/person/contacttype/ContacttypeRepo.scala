/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ContacttypeRepo {
  def delete: DeleteBuilder[ContacttypeFields, ContacttypeRow]
  def deleteById(contacttypeid: ContacttypeId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(contacttypeids: Array[ContacttypeId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: ContacttypeRow): ZIO[ZConnection, Throwable, ContacttypeRow]
  def insert(unsaved: ContacttypeRowUnsaved): ZIO[ZConnection, Throwable, ContacttypeRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ContacttypeRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ContacttypeRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[ContacttypeFields, ContacttypeRow]
  def selectAll: ZStream[ZConnection, Throwable, ContacttypeRow]
  def selectById(contacttypeid: ContacttypeId): ZIO[ZConnection, Throwable, Option[ContacttypeRow]]
  def selectByIds(contacttypeids: Array[ContacttypeId]): ZStream[ZConnection, Throwable, ContacttypeRow]
  def selectByIdsTracked(contacttypeids: Array[ContacttypeId]): ZIO[ZConnection, Throwable, Map[ContacttypeId, Option[ContacttypeRow]]]
  def update: UpdateBuilder[ContacttypeFields, ContacttypeRow]
  def update(row: ContacttypeRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: ContacttypeRow): ZIO[ZConnection, Throwable, UpdateResult[ContacttypeRow]]
}
