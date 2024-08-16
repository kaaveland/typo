/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package titledperson

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait TitledpersonRepo {
  def delete: DeleteBuilder[TitledpersonFields, TitledpersonRow]
  def insert(unsaved: TitledpersonRow)(implicit c: Connection): TitledpersonRow
  def insertStreaming(unsaved: Iterator[TitledpersonRow], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[TitledpersonFields, TitledpersonRow]
  def selectAll(implicit c: Connection): List[TitledpersonRow]
  def update: UpdateBuilder[TitledpersonFields, TitledpersonRow]
}
