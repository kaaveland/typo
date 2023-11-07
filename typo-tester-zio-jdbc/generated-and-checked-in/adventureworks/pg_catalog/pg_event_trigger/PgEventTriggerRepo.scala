/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_event_trigger

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgEventTriggerRepo {
  def delete(oid: PgEventTriggerId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgEventTriggerFields, PgEventTriggerRow]
  def insert(unsaved: PgEventTriggerRow): ZIO[ZConnection, Throwable, PgEventTriggerRow]
  def select: SelectBuilder[PgEventTriggerFields, PgEventTriggerRow]
  def selectAll: ZStream[ZConnection, Throwable, PgEventTriggerRow]
  def selectById(oid: PgEventTriggerId): ZIO[ZConnection, Throwable, Option[PgEventTriggerRow]]
  def selectByIds(oids: Array[PgEventTriggerId]): ZStream[ZConnection, Throwable, PgEventTriggerRow]
  def selectByUnique(evtname: String): ZIO[ZConnection, Throwable, Option[PgEventTriggerRow]]
  def update(row: PgEventTriggerRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgEventTriggerFields, PgEventTriggerRow]
  def upsert(unsaved: PgEventTriggerRow): ZIO[ZConnection, Throwable, UpdateResult[PgEventTriggerRow]]
}
