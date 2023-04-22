/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import java.sql.Connection

trait AddresstypeRepo {
  def delete(addresstypeid: AddresstypeId)(implicit c: Connection): Boolean
  def insert(unsaved: AddresstypeRowUnsaved)(implicit c: Connection): AddresstypeRow
  def selectAll(implicit c: Connection): List[AddresstypeRow]
  def selectByFieldValues(fieldValues: List[AddresstypeFieldOrIdValue[_]])(implicit c: Connection): List[AddresstypeRow]
  def selectById(addresstypeid: AddresstypeId)(implicit c: Connection): Option[AddresstypeRow]
  def selectByIds(addresstypeids: Array[AddresstypeId])(implicit c: Connection): List[AddresstypeRow]
  def update(row: AddresstypeRow)(implicit c: Connection): Boolean
  def updateFieldValues(addresstypeid: AddresstypeId, fieldValues: List[AddresstypeFieldValue[_]])(implicit c: Connection): Boolean
}
