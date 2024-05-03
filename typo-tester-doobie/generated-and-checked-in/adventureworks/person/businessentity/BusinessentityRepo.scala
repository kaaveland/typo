/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait BusinessentityRepo {
  def delete: DeleteBuilder[BusinessentityFields, BusinessentityRow]
  def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean]
  def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int]
  def insert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow]
  def insert(unsaved: BusinessentityRowUnsaved): ConnectionIO[BusinessentityRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, BusinessentityRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BusinessentityRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[BusinessentityFields, BusinessentityRow]
  def selectAll: Stream[ConnectionIO, BusinessentityRow]
  def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[BusinessentityRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, BusinessentityRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ConnectionIO[Map[BusinessentityId, BusinessentityRow]]
  def update: UpdateBuilder[BusinessentityFields, BusinessentityRow]
  def update(row: BusinessentityRow): ConnectionIO[Boolean]
  def upsert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow]
}
