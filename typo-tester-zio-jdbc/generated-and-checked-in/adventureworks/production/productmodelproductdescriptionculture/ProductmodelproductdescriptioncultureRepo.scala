/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ProductmodelproductdescriptioncultureRepo {
  def delete(compositeId: ProductmodelproductdescriptioncultureId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow]
  def insert(unsaved: ProductmodelproductdescriptioncultureRow): ZIO[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow]
  def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved): ZIO[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow]
  def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow]
  def selectAll: ZStream[ZConnection, Throwable, ProductmodelproductdescriptioncultureRow]
  def selectById(compositeId: ProductmodelproductdescriptioncultureId): ZIO[ZConnection, Throwable, Option[ProductmodelproductdescriptioncultureRow]]
  def update(row: ProductmodelproductdescriptioncultureRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow]
  def upsert(unsaved: ProductmodelproductdescriptioncultureRow): ZIO[ZConnection, Throwable, UpdateResult[ProductmodelproductdescriptioncultureRow]]
}
