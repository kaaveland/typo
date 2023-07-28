/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import java.sql.Connection

class BusinessentityaddressRepoMock(toRow: Function1[BusinessentityaddressRowUnsaved, BusinessentityaddressRow],
                                    map: scala.collection.mutable.Map[BusinessentityaddressId, BusinessentityaddressRow] = scala.collection.mutable.Map.empty) extends BusinessentityaddressRepo {
  override def delete(compositeId: BusinessentityaddressId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def insert(unsaved: BusinessentityaddressRow)(implicit c: Connection): BusinessentityaddressRow = {
    if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    unsaved
  }
  override def insert(unsaved: BusinessentityaddressRowUnsaved)(implicit c: Connection): BusinessentityaddressRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[BusinessentityaddressRow] = {
    map.values.toList
  }
  override def selectById(compositeId: BusinessentityaddressId)(implicit c: Connection): Option[BusinessentityaddressRow] = {
    map.get(compositeId)
  }
  override def update(row: BusinessentityaddressRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: BusinessentityaddressRow)(implicit c: Connection): BusinessentityaddressRow = {
    map.put(unsaved.compositeId, unsaved)
    unsaved
  }
}
