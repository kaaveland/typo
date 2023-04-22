/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import java.sql.Connection

trait ContacttypeRepo {
  def delete(contacttypeid: ContacttypeId)(implicit c: Connection): Boolean
  def insert(unsaved: ContacttypeRowUnsaved)(implicit c: Connection): ContacttypeRow
  def selectAll(implicit c: Connection): List[ContacttypeRow]
  def selectByFieldValues(fieldValues: List[ContacttypeFieldOrIdValue[_]])(implicit c: Connection): List[ContacttypeRow]
  def selectById(contacttypeid: ContacttypeId)(implicit c: Connection): Option[ContacttypeRow]
  def selectByIds(contacttypeids: Array[ContacttypeId])(implicit c: Connection): List[ContacttypeRow]
  def update(row: ContacttypeRow)(implicit c: Connection): Boolean
  def updateFieldValues(contacttypeid: ContacttypeId, fieldValues: List[ContacttypeFieldValue[_]])(implicit c: Connection): Boolean
}
