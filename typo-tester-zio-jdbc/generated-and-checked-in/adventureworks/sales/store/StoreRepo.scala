/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait StoreRepo {
  def delete(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[StoreFields, StoreRow]
  def insert(unsaved: StoreRow): ZIO[ZConnection, Throwable, StoreRow]
  def insert(unsaved: StoreRowUnsaved): ZIO[ZConnection, Throwable, StoreRow]
  def select: SelectBuilder[StoreFields, StoreRow]
  def selectAll: ZStream[ZConnection, Throwable, StoreRow]
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[StoreRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, StoreRow]
  def update(row: StoreRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[StoreFields, StoreRow]
  def upsert(unsaved: StoreRow): ZIO[ZConnection, Throwable, UpdateResult[StoreRow]]
}