/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import java.sql.Connection

class PhonenumbertypeRepoMock(toRow: Function1[PhonenumbertypeRowUnsaved, PhonenumbertypeRow],
                              map: scala.collection.mutable.Map[PhonenumbertypeId, PhonenumbertypeRow] = scala.collection.mutable.Map.empty) extends PhonenumbertypeRepo {
  override def delete(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Boolean = {
    map.remove(phonenumbertypeid).isDefined
  }
  override def insert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow = {
    if (map.contains(unsaved.phonenumbertypeid))
      sys.error(s"id ${unsaved.phonenumbertypeid} already exists")
    else
      map.put(unsaved.phonenumbertypeid, unsaved)
    unsaved
  }
  override def insert(unsaved: PhonenumbertypeRowUnsaved)(implicit c: Connection): PhonenumbertypeRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[PhonenumbertypeRow] = {
    map.values.toList
  }
  override def selectById(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Option[PhonenumbertypeRow] = {
    map.get(phonenumbertypeid)
  }
  override def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId])(implicit c: Connection): List[PhonenumbertypeRow] = {
    phonenumbertypeids.flatMap(map.get).toList
  }
  override def update(row: PhonenumbertypeRow)(implicit c: Connection): Boolean = {
    map.get(row.phonenumbertypeid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.phonenumbertypeid, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: PhonenumbertypeRow)(implicit c: Connection): PhonenumbertypeRow = {
    map.put(unsaved.phonenumbertypeid, unsaved)
    unsaved
  }
}
