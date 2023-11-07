/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgPublicationRepo {
  def delete(oid: PgPublicationId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgPublicationFields, PgPublicationRow]
  def insert(unsaved: PgPublicationRow): ZIO[ZConnection, Throwable, PgPublicationRow]
  def select: SelectBuilder[PgPublicationFields, PgPublicationRow]
  def selectAll: ZStream[ZConnection, Throwable, PgPublicationRow]
  def selectById(oid: PgPublicationId): ZIO[ZConnection, Throwable, Option[PgPublicationRow]]
  def selectByIds(oids: Array[PgPublicationId]): ZStream[ZConnection, Throwable, PgPublicationRow]
  def selectByUnique(pubname: String): ZIO[ZConnection, Throwable, Option[PgPublicationRow]]
  def update(row: PgPublicationRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgPublicationFields, PgPublicationRow]
  def upsert(unsaved: PgPublicationRow): ZIO[ZConnection, Throwable, UpdateResult[PgPublicationRow]]
}
