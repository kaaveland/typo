/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import java.sql.Connection

trait ScrapreasonRepo {
  def delete(scrapreasonid: ScrapreasonId)(implicit c: Connection): Boolean
  def insert(unsaved: ScrapreasonRowUnsaved)(implicit c: Connection): ScrapreasonId
  def selectAll(implicit c: Connection): List[ScrapreasonRow]
  def selectByFieldValues(fieldValues: List[ScrapreasonFieldOrIdValue[_]])(implicit c: Connection): List[ScrapreasonRow]
  def selectById(scrapreasonid: ScrapreasonId)(implicit c: Connection): Option[ScrapreasonRow]
  def selectByIds(scrapreasonids: Array[ScrapreasonId])(implicit c: Connection): List[ScrapreasonRow]
  def update(row: ScrapreasonRow)(implicit c: Connection): Boolean
  def updateFieldValues(scrapreasonid: ScrapreasonId, fieldValues: List[ScrapreasonFieldValue[_]])(implicit c: Connection): Boolean
}
