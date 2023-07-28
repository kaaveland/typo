/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import java.sql.Connection

class TransactionhistoryRepoMock(toRow: Function1[TransactionhistoryRowUnsaved, TransactionhistoryRow],
                                 map: scala.collection.mutable.Map[TransactionhistoryId, TransactionhistoryRow] = scala.collection.mutable.Map.empty) extends TransactionhistoryRepo {
  override def delete(transactionid: TransactionhistoryId)(implicit c: Connection): Boolean = {
    map.remove(transactionid).isDefined
  }
  override def insert(unsaved: TransactionhistoryRow)(implicit c: Connection): TransactionhistoryRow = {
    if (map.contains(unsaved.transactionid))
      sys.error(s"id ${unsaved.transactionid} already exists")
    else
      map.put(unsaved.transactionid, unsaved)
    unsaved
  }
  override def insert(unsaved: TransactionhistoryRowUnsaved)(implicit c: Connection): TransactionhistoryRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[TransactionhistoryRow] = {
    map.values.toList
  }
  override def selectById(transactionid: TransactionhistoryId)(implicit c: Connection): Option[TransactionhistoryRow] = {
    map.get(transactionid)
  }
  override def selectByIds(transactionids: Array[TransactionhistoryId])(implicit c: Connection): List[TransactionhistoryRow] = {
    transactionids.flatMap(map.get).toList
  }
  override def update(row: TransactionhistoryRow)(implicit c: Connection): Boolean = {
    map.get(row.transactionid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.transactionid, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: TransactionhistoryRow)(implicit c: Connection): TransactionhistoryRow = {
    map.put(unsaved.transactionid, unsaved)
    unsaved
  }
}
