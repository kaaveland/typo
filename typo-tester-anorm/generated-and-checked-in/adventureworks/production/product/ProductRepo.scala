/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductRepo {
  def delete: DeleteBuilder[ProductFields, ProductRow]
  def deleteById(productid: ProductId)(implicit c: Connection): Boolean
  def deleteByIds(productids: Array[ProductId])(implicit c: Connection): Int
  def insert(unsaved: ProductRow)(implicit c: Connection): ProductRow
  def insert(unsaved: ProductRowUnsaved)(implicit c: Connection): ProductRow
  def insertStreaming(unsaved: Iterator[ProductRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[ProductFields, ProductRow]
  def selectAll(implicit c: Connection): List[ProductRow]
  def selectById(productid: ProductId)(implicit c: Connection): Option[ProductRow]
  def selectByIds(productids: Array[ProductId])(implicit c: Connection): List[ProductRow]
  def selectByIdsTracked(productids: Array[ProductId])(implicit c: Connection): Map[ProductId, ProductRow]
  def update: UpdateBuilder[ProductFields, ProductRow]
  def update(row: ProductRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ProductRow)(implicit c: Connection): ProductRow
}
