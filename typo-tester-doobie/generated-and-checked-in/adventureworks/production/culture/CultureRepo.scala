/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait CultureRepo {
  def delete: DeleteBuilder[CultureFields, CultureRow]
  def deleteById(cultureid: CultureId): ConnectionIO[Boolean]
  def deleteByIds(cultureids: Array[CultureId]): ConnectionIO[Int]
  def insert(unsaved: CultureRow): ConnectionIO[CultureRow]
  def insert(unsaved: CultureRowUnsaved): ConnectionIO[CultureRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, CultureRow], batchSize: Int): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CultureRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[CultureFields, CultureRow]
  def selectAll: Stream[ConnectionIO, CultureRow]
  def selectById(cultureid: CultureId): ConnectionIO[Option[CultureRow]]
  def selectByIds(cultureids: Array[CultureId]): Stream[ConnectionIO, CultureRow]
  def selectByIdsTracked(cultureids: Array[CultureId]): ConnectionIO[Map[CultureId, Option[CultureRow]]]
  def update: UpdateBuilder[CultureFields, CultureRow]
  def update(row: CultureRow): ConnectionIO[Boolean]
  def upsert(unsaved: CultureRow): ConnectionIO[CultureRow]
}
