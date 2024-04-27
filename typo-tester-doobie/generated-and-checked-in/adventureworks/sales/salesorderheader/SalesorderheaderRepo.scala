/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait SalesorderheaderRepo {
  def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def deleteById(salesorderid: SalesorderheaderId): ConnectionIO[Boolean]
  def deleteByIds(salesorderids: Array[SalesorderheaderId]): ConnectionIO[Int]
  def insert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow]
  def insert(unsaved: SalesorderheaderRowUnsaved): ConnectionIO[SalesorderheaderRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, SalesorderheaderRow], batchSize: Int): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesorderheaderRowUnsaved], batchSize: Int): ConnectionIO[Long]
  def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def selectAll: Stream[ConnectionIO, SalesorderheaderRow]
  def selectById(salesorderid: SalesorderheaderId): ConnectionIO[Option[SalesorderheaderRow]]
  def selectByIds(salesorderids: Array[SalesorderheaderId]): Stream[ConnectionIO, SalesorderheaderRow]
  def selectByIdsTracked(salesorderids: Array[SalesorderheaderId]): ConnectionIO[Map[SalesorderheaderId, Option[SalesorderheaderRow]]]
  def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow]
  def update(row: SalesorderheaderRow): ConnectionIO[Boolean]
  def upsert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow]
}
