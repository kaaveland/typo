/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.person.businessentity.BusinessentityId
import java.sql.Connection

trait VendorRepo {
  def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean
  def insert(unsaved: VendorRow)(implicit c: Connection): VendorRow
  def insert(unsaved: VendorRowUnsaved)(implicit c: Connection): VendorRow
  def selectAll(implicit c: Connection): List[VendorRow]
  def selectByFieldValues(fieldValues: List[VendorFieldOrIdValue[_]])(implicit c: Connection): List[VendorRow]
  def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[VendorRow]
  def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[VendorRow]
  def update(row: VendorRow)(implicit c: Connection): Boolean
  def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[VendorFieldValue[_]])(implicit c: Connection): Boolean
  def upsert(unsaved: VendorRow)(implicit c: Connection): VendorRow
}