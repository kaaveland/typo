/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class EmployeeRepoMock(toRow: Function1[EmployeeRowUnsaved, EmployeeRow],
                       map: scala.collection.mutable.Map[BusinessentityId, EmployeeRow] = scala.collection.mutable.Map.empty) extends EmployeeRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    delay(map.remove(businessentityid).isDefined)
  }
  override def insert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow] = {
    delay {
      if (map.contains(unsaved.businessentityid))
        sys.error(s"id ${unsaved.businessentityid} already exists")
      else
        map.put(unsaved.businessentityid, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: EmployeeRowUnsaved): ConnectionIO[EmployeeRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, EmployeeRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[EmployeeRow]] = {
    delay(map.get(businessentityid))
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, EmployeeRow] = {
    Stream.emits(businessentityids.flatMap(map.get).toList)
  }
  override def update(row: EmployeeRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.businessentityid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.businessentityid, row)
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow] = {
    delay {
      map.put(unsaved.businessentityid, unsaved)
      unsaved
    }
  }
}
