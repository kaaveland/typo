/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait CurrencyRepo {
  def delete: DeleteBuilder[CurrencyFields, CurrencyRow]
  def deleteById(currencycode: CurrencyId): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(currencycodes: Array[CurrencyId]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: CurrencyRow): ZIO[ZConnection, Throwable, CurrencyRow]
  def insert(unsaved: CurrencyRowUnsaved): ZIO[ZConnection, Throwable, CurrencyRow]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CurrencyRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CurrencyRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[CurrencyFields, CurrencyRow]
  def selectAll: ZStream[ZConnection, Throwable, CurrencyRow]
  def selectById(currencycode: CurrencyId): ZIO[ZConnection, Throwable, Option[CurrencyRow]]
  def selectByIds(currencycodes: Array[CurrencyId]): ZStream[ZConnection, Throwable, CurrencyRow]
  def selectByIdsTracked(currencycodes: Array[CurrencyId]): ZIO[ZConnection, Throwable, Map[CurrencyId, Option[CurrencyRow]]]
  def update: UpdateBuilder[CurrencyFields, CurrencyRow]
  def update(row: CurrencyRow): ZIO[ZConnection, Throwable, Boolean]
  def upsert(unsaved: CurrencyRow): ZIO[ZConnection, Throwable, UpdateResult[CurrencyRow]]
}
