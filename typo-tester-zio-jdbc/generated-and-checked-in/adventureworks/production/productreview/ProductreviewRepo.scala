/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductreviewRepo {
  def delete(productreviewid: ProductreviewId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[ProductreviewFields, ProductreviewRow]
  def insert(unsaved: ProductreviewRow): ZIO[ZConnection, Throwable, ProductreviewRow]
  def insert(unsaved: ProductreviewRowUnsaved): ZIO[ZConnection, Throwable, ProductreviewRow]
  def select: SelectBuilder[ProductreviewFields, ProductreviewRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductreviewRow]
  def selectById(productreviewid: ProductreviewId): ZIO[ZConnection, Throwable, Option[ProductreviewRow]]
  def selectByIds(productreviewids: Array[ProductreviewId]): ZStream[ZConnection, Throwable, ProductreviewRow]
  def update(row: ProductreviewRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[ProductreviewFields, ProductreviewRow]
  def upsert(unsaved: ProductreviewRow): ZIO[ZConnection, Throwable, UpdateResult[ProductreviewRow]]
}
