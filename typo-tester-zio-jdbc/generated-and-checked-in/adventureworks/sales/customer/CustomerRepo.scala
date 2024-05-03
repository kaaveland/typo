/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait CustomerRepo {
  def delete: DeleteBuilder[CustomerFields, CustomerRow]
  def deleteById(customerid: CustomerId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(customerids: Array[CustomerId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: CustomerRow): ZIO[ZConnection, Throwable, CustomerRow]
  def insert(unsaved: CustomerRowUnsaved): ZIO[ZConnection, Throwable, CustomerRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CustomerRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CustomerRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[CustomerFields, CustomerRow]
  def selectAll: ZStream[ZConnection, Throwable, CustomerRow]
  def selectById(customerid: CustomerId): ZIO[ZConnection, Throwable, Option[CustomerRow]]
  def selectByIds(customerids: Array[CustomerId]): ZStream[ZConnection, Throwable, CustomerRow]
  def selectByIdsTracked(customerids: Array[CustomerId]): ZIO[ZConnection, Throwable, Map[CustomerId, CustomerRow]]
  def update: UpdateBuilder[CustomerFields, CustomerRow]
  def update(row: CustomerRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: CustomerRow): ZIO[ZConnection, Throwable, UpdateResult[CustomerRow]]
}
