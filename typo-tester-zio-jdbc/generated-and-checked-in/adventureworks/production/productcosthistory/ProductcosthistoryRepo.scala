/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductcosthistoryRepo {
  def delete(compositeId: ProductcosthistoryId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[ProductcosthistoryFields, ProductcosthistoryRow]
  def insert(unsaved: ProductcosthistoryRow): ZIO[ZConnection, Throwable, ProductcosthistoryRow]
  def insert(unsaved: ProductcosthistoryRowUnsaved): ZIO[ZConnection, Throwable, ProductcosthistoryRow]
  def select: SelectBuilder[ProductcosthistoryFields, ProductcosthistoryRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductcosthistoryRow]
  def selectById(compositeId: ProductcosthistoryId): ZIO[ZConnection, Throwable, Option[ProductcosthistoryRow]]
  def update(row: ProductcosthistoryRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[ProductcosthistoryFields, ProductcosthistoryRow]
  def upsert(unsaved: ProductcosthistoryRow): ZIO[ZConnection, Throwable, UpdateResult[ProductcosthistoryRow]]
}
