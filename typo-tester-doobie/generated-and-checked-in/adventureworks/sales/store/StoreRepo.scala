/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait StoreRepo {
  def delete: DeleteBuilder[StoreFields, StoreRow]
  def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean]
  def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int]
  def insert(unsaved: StoreRow): ConnectionIO[StoreRow]
  def insert(unsaved: StoreRowUnsaved): ConnectionIO[StoreRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, StoreRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, StoreRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[StoreFields, StoreRow]
  def selectAll: Stream[ConnectionIO, StoreRow]
  def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[StoreRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, StoreRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ConnectionIO[Map[BusinessentityId, StoreRow]]
  def update: UpdateBuilder[StoreFields, StoreRow]
  def update(row: StoreRow): ConnectionIO[Boolean]
  def upsert(unsaved: StoreRow): ConnectionIO[StoreRow]
}
