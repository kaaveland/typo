/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductcategoryRepo {
  def delete(productcategoryid: ProductcategoryId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[ProductcategoryFields, ProductcategoryRow]
  def insert(unsaved: ProductcategoryRow): ZIO[ZConnection, Throwable, ProductcategoryRow]
  def insert(unsaved: ProductcategoryRowUnsaved): ZIO[ZConnection, Throwable, ProductcategoryRow]
  def select: SelectBuilder[ProductcategoryFields, ProductcategoryRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductcategoryRow]
  def selectById(productcategoryid: ProductcategoryId): ZIO[ZConnection, Throwable, Option[ProductcategoryRow]]
  def selectByIds(productcategoryids: Array[ProductcategoryId]): ZStream[ZConnection, Throwable, ProductcategoryRow]
  def update(row: ProductcategoryRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[ProductcategoryFields, ProductcategoryRow]
  def upsert(unsaved: ProductcategoryRow): ZIO[ZConnection, Throwable, UpdateResult[ProductcategoryRow]]
}
