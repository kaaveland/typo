/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.person.businessentity.BusinessentityId
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait StoreRepo {
  def delete: DeleteBuilder[StoreFields, StoreRow]
  def deleteById(businessentityid: BusinessentityId)(implicit c: Connection): Boolean
  def deleteByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): Int
  def insert(unsaved: StoreRow)(implicit c: Connection): StoreRow
  def insert(unsaved: StoreRowUnsaved)(implicit c: Connection): StoreRow
  def insertStreaming(unsaved: Iterator[StoreRow], batchSize: Int)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[StoreRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[StoreFields, StoreRow]
  def selectAll(implicit c: Connection): List[StoreRow]
  def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[StoreRow]
  def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[StoreRow]
  def selectByIdsTracked(businessentityids: Array[BusinessentityId])(implicit c: Connection): Map[BusinessentityId, Option[StoreRow]]
  def update: UpdateBuilder[StoreFields, StoreRow]
  def update(row: StoreRow)(implicit c: Connection): Boolean
  def upsert(unsaved: StoreRow)(implicit c: Connection): StoreRow
}
