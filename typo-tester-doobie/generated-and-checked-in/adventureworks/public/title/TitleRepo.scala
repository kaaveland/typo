/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package title

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait TitleRepo {
  def delete: DeleteBuilder[TitleFields, TitleRow]
  def deleteById(code: TitleId): ConnectionIO[Boolean]
  def deleteByIds(codes: Array[TitleId]): ConnectionIO[Int]
  def insert(unsaved: TitleRow): ConnectionIO[TitleRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, TitleRow], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[TitleFields, TitleRow]
  def selectAll: Stream[ConnectionIO, TitleRow]
  def selectById(code: TitleId): ConnectionIO[Option[TitleRow]]
  def selectByIds(codes: Array[TitleId]): Stream[ConnectionIO, TitleRow]
  def selectByIdsTracked(codes: Array[TitleId]): ConnectionIO[Map[TitleId, TitleRow]]
  def update: UpdateBuilder[TitleFields, TitleRow]
  def upsert(unsaved: TitleRow): ConnectionIO[TitleRow]
  def upsertBatch(unsaved: List[TitleRow]): Stream[ConnectionIO, TitleRow]
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, TitleRow], batchSize: Int = 10000): ConnectionIO[Int]
}
