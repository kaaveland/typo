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

trait StoreRepo {
  def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean
  def insert(businessentityid: BusinessentityId, unsaved: StoreRowUnsaved)(implicit c: Connection): Boolean
  def selectAll(implicit c: Connection): List[StoreRow]
  def selectByFieldValues(fieldValues: List[StoreFieldOrIdValue[_]])(implicit c: Connection): List[StoreRow]
  def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[StoreRow]
  def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[StoreRow]
  def update(row: StoreRow)(implicit c: Connection): Boolean
  def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[StoreFieldValue[_]])(implicit c: Connection): Boolean
}
