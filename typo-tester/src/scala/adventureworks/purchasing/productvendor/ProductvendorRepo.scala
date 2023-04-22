/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import java.sql.Connection

trait ProductvendorRepo {
  def delete(compositeId: ProductvendorId)(implicit c: Connection): Boolean
  def insert(compositeId: ProductvendorId, unsaved: ProductvendorRowUnsaved)(implicit c: Connection): ProductvendorRow
  def selectAll(implicit c: Connection): List[ProductvendorRow]
  def selectByFieldValues(fieldValues: List[ProductvendorFieldOrIdValue[_]])(implicit c: Connection): List[ProductvendorRow]
  def selectById(compositeId: ProductvendorId)(implicit c: Connection): Option[ProductvendorRow]
  def update(row: ProductvendorRow)(implicit c: Connection): Boolean
  def updateFieldValues(compositeId: ProductvendorId, fieldValues: List[ProductvendorFieldValue[_]])(implicit c: Connection): Boolean
}
