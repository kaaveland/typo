/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import java.sql.Connection

trait TransactionhistoryarchiveRepo {
  def delete(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Boolean
  def insert(unsaved: TransactionhistoryarchiveRow)(implicit c: Connection): TransactionhistoryarchiveRow
  def insert(unsaved: TransactionhistoryarchiveRowUnsaved)(implicit c: Connection): TransactionhistoryarchiveRow
  def selectAll(implicit c: Connection): List[TransactionhistoryarchiveRow]
  def selectById(transactionid: TransactionhistoryarchiveId)(implicit c: Connection): Option[TransactionhistoryarchiveRow]
  def selectByIds(transactionids: Array[TransactionhistoryarchiveId])(implicit c: Connection): List[TransactionhistoryarchiveRow]
  def update(row: TransactionhistoryarchiveRow)(implicit c: Connection): Boolean
  def upsert(unsaved: TransactionhistoryarchiveRow)(implicit c: Connection): TransactionhistoryarchiveRow
}
