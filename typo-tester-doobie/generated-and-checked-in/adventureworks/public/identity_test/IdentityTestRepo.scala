/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait IdentityTestRepo {
  def delete(name: IdentityTestId): ConnectionIO[Boolean]
  def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow]
  def insert(unsaved: IdentityTestRow): ConnectionIO[IdentityTestRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, IdentityTestRow], batchSize: Int): ConnectionIO[Long]
  def insert(unsaved: IdentityTestRowUnsaved): ConnectionIO[IdentityTestRow]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, IdentityTestRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[IdentityTestFields, IdentityTestRow]
  def selectAll: Stream[ConnectionIO, IdentityTestRow]
  def selectById(name: IdentityTestId): ConnectionIO[Option[IdentityTestRow]]
  def selectByIds(names: Array[IdentityTestId]): Stream[ConnectionIO, IdentityTestRow]
  def update(row: IdentityTestRow): ConnectionIO[Boolean]
  def update: UpdateBuilder[IdentityTestFields, IdentityTestRow]
  def upsert(unsaved: IdentityTestRow): ConnectionIO[IdentityTestRow]
}
