/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductsubcategoryRepo {
  def delete: DeleteBuilder[ProductsubcategoryFields, ProductsubcategoryRow]
  def deleteById(productsubcategoryid: ProductsubcategoryId): ConnectionIO[Boolean]
  def deleteByIds(productsubcategoryids: Array[ProductsubcategoryId]): ConnectionIO[Int]
  def insert(unsaved: ProductsubcategoryRow): ConnectionIO[ProductsubcategoryRow]
  def insert(unsaved: ProductsubcategoryRowUnsaved): ConnectionIO[ProductsubcategoryRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, ProductsubcategoryRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductsubcategoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[ProductsubcategoryFields, ProductsubcategoryRow]
  def selectAll: Stream[ConnectionIO, ProductsubcategoryRow]
  def selectById(productsubcategoryid: ProductsubcategoryId): ConnectionIO[Option[ProductsubcategoryRow]]
  def selectByIds(productsubcategoryids: Array[ProductsubcategoryId]): Stream[ConnectionIO, ProductsubcategoryRow]
  def selectByIdsTracked(productsubcategoryids: Array[ProductsubcategoryId]): ConnectionIO[Map[ProductsubcategoryId, ProductsubcategoryRow]]
  def update: UpdateBuilder[ProductsubcategoryFields, ProductsubcategoryRow]
  def update(row: ProductsubcategoryRow): ConnectionIO[Boolean]
  def upsert(unsaved: ProductsubcategoryRow): ConnectionIO[ProductsubcategoryRow]
}
