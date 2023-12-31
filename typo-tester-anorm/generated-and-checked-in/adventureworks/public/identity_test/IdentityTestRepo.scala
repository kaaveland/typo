/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait IdentityTestRepo {
  def delete(name: IdentityTestId)(implicit c: Connection): Boolean
  def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow]
  def insert(unsaved: IdentityTestRow)(implicit c: Connection): IdentityTestRow
  def insertStreaming(unsaved: Iterator[IdentityTestRow], batchSize: Int)(implicit c: Connection): Long
  def insert(unsaved: IdentityTestRowUnsaved)(implicit c: Connection): IdentityTestRow
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Iterator[IdentityTestRowUnsaved], batchSize: Int)(implicit c: Connection): Long
  def select: SelectBuilder[IdentityTestFields, IdentityTestRow]
  def selectAll(implicit c: Connection): List[IdentityTestRow]
  def selectById(name: IdentityTestId)(implicit c: Connection): Option[IdentityTestRow]
  def selectByIds(names: Array[IdentityTestId])(implicit c: Connection): List[IdentityTestRow]
  def update(row: IdentityTestRow)(implicit c: Connection): Boolean
  def update: UpdateBuilder[IdentityTestFields, IdentityTestRow]
  def upsert(unsaved: IdentityTestRow)(implicit c: Connection): IdentityTestRow
}
