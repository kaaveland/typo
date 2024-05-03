/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait ProductinventoryRepo {
  def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow]
  def deleteById(compositeId: ProductinventoryId)(implicit c: Connection): Boolean
  def deleteByIds(compositeIds: Array[ProductinventoryId])(implicit c: Connection): Int
  def insert(unsaved: ProductinventoryRow)(implicit c: Connection): ProductinventoryRow
  def insert(unsaved: ProductinventoryRowUnsaved)(implicit c: Connection): ProductinventoryRow
  def insertStreaming(unsaved: Iterator[ProductinventoryRow], batchSize: Int = 10000)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[ProductinventoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow]
  def selectAll(implicit c: Connection): List[ProductinventoryRow]
  def selectById(compositeId: ProductinventoryId)(implicit c: Connection): Option[ProductinventoryRow]
  def selectByIds(compositeIds: Array[ProductinventoryId])(implicit c: Connection): List[ProductinventoryRow]
  def selectByIdsTracked(compositeIds: Array[ProductinventoryId])(implicit c: Connection): Map[ProductinventoryId, ProductinventoryRow]
  def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow]
  def update(row: ProductinventoryRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ProductinventoryRow)(implicit c: Connection): ProductinventoryRow
}
