/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait UnitmeasureRepo {
  def delete: DeleteBuilder[UnitmeasureFields, UnitmeasureRow]
  def deleteById(unitmeasurecode: UnitmeasureId)(implicit c: Connection): Boolean
  def deleteByIds(unitmeasurecodes: Array[UnitmeasureId])(implicit c: Connection): Int
  def insert(unsaved: UnitmeasureRow)(implicit c: Connection): UnitmeasureRow
  def insert(unsaved: UnitmeasureRowUnsaved)(implicit c: Connection): UnitmeasureRow
  def insertStreaming(unsaved: Iterator[UnitmeasureRow], batchSize: Int)(implicit c: Connection): Long
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[UnitmeasureRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[UnitmeasureFields, UnitmeasureRow]
  def selectAll(implicit c: Connection): List[UnitmeasureRow]
  def selectById(unitmeasurecode: UnitmeasureId)(implicit c: Connection): Option[UnitmeasureRow]
  def selectByIds(unitmeasurecodes: Array[UnitmeasureId])(implicit c: Connection): List[UnitmeasureRow]
  def selectByIdsTracked(unitmeasurecodes: Array[UnitmeasureId])(implicit c: Connection): Map[UnitmeasureId, Option[UnitmeasureRow]]
  def update: UpdateBuilder[UnitmeasureFields, UnitmeasureRow]
  def update(row: UnitmeasureRow)(implicit c: Connection): Boolean
  def upsert(unsaved: UnitmeasureRow)(implicit c: Connection): UnitmeasureRow
}
