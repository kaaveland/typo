/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class PersonRepoMock(toRow: Function1[PersonRowUnsaved, PersonRow],
                     map: scala.collection.mutable.Map[PersonId, PersonRow] = scala.collection.mutable.Map.empty) extends PersonRepo {
  override def delete(id: PersonId): ConnectionIO[Boolean] = {
    delay(map.remove(id).isDefined)
  }
  override def insert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    delay {
      if (map.contains(unsaved.id))
        sys.error(s"id ${unsaved.id} already exists")
      else
        map.put(unsaved.id, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, PersonRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(id: PersonId): ConnectionIO[Option[PersonRow]] = {
    delay(map.get(id))
  }
  override def selectByIds(ids: Array[PersonId]): Stream[ConnectionIO, PersonRow] = {
    Stream.emits(ids.flatMap(map.get).toList)
  }
  override def update(row: PersonRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.id) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.id, row)
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    delay {
      map.put(unsaved.id, unsaved)
      unsaved
    }
  }
}
