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
  def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[BusinessentityFields, BusinessentityRow]
  def insert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow]
  def insert(unsaved: BusinessentityRowUnsaved): ConnectionIO[BusinessentityRow]
  def select: SelectBuilder[BusinessentityFields, BusinessentityRow]
  def selectAll: Stream[ConnectionIO, BusinessentityRow]
  def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[BusinessentityRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, BusinessentityRow]
  def update(row: BusinessentityRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[BusinessentityFields, BusinessentityRow]
  def upsert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow]
}