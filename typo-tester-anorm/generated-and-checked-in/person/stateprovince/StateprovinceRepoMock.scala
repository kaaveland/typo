/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import java.sql.Connection

class StateprovinceRepoMock(toRow: Function1[StateprovinceRowUnsaved, StateprovinceRow],
                            map: scala.collection.mutable.Map[StateprovinceId, StateprovinceRow] = scala.collection.mutable.Map.empty) extends StateprovinceRepo {
  override def delete(stateprovinceid: StateprovinceId)(implicit c: Connection): Boolean = {
    map.remove(stateprovinceid).isDefined
  }
  override def insert(unsaved: StateprovinceRow)(implicit c: Connection): StateprovinceRow = {
    if (map.contains(unsaved.stateprovinceid))
      sys.error(s"id ${unsaved.stateprovinceid} already exists")
    else
      map.put(unsaved.stateprovinceid, unsaved)
    unsaved
  }
  override def insert(unsaved: StateprovinceRowUnsaved)(implicit c: Connection): StateprovinceRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[StateprovinceRow] = {
    map.values.toList
  }
  override def selectById(stateprovinceid: StateprovinceId)(implicit c: Connection): Option[StateprovinceRow] = {
    map.get(stateprovinceid)
  }
  override def selectByIds(stateprovinceids: Array[StateprovinceId])(implicit c: Connection): List[StateprovinceRow] = {
    stateprovinceids.flatMap(map.get).toList
  }
  override def update(row: StateprovinceRow)(implicit c: Connection): Boolean = {
    map.get(row.stateprovinceid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.stateprovinceid, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: StateprovinceRow)(implicit c: Connection): StateprovinceRow = {
    map.put(unsaved.stateprovinceid, unsaved)
    unsaved
  }
}
