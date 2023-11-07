/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgReplicationOriginRepo {
  def delete(roident: PgReplicationOriginId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgReplicationOriginFields, PgReplicationOriginRow]
  def insert(unsaved: PgReplicationOriginRow): ZIO[ZConnection, Throwable, PgReplicationOriginRow]
  def select: SelectBuilder[PgReplicationOriginFields, PgReplicationOriginRow]
  def selectAll: ZStream[ZConnection, Throwable, PgReplicationOriginRow]
  def selectById(roident: PgReplicationOriginId): ZIO[ZConnection, Throwable, Option[PgReplicationOriginRow]]
  def selectByIds(roidents: Array[PgReplicationOriginId]): ZStream[ZConnection, Throwable, PgReplicationOriginRow]
  def selectByUnique(roname: String): ZIO[ZConnection, Throwable, Option[PgReplicationOriginRow]]
  def update(row: PgReplicationOriginRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgReplicationOriginFields, PgReplicationOriginRow]
  def upsert(unsaved: PgReplicationOriginRow): ZIO[ZConnection, Throwable, UpdateResult[PgReplicationOriginRow]]
}
