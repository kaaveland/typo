/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class FootballClubRepoMock(map: scala.collection.mutable.Map[FootballClubId, FootballClubRow] = scala.collection.mutable.Map.empty) extends FootballClubRepo {
  override def delete(id: FootballClubId): ConnectionIO[Boolean] = {
    delay(map.remove(id).isDefined)
  }
  override def insert(unsaved: FootballClubRow): ConnectionIO[FootballClubRow] = {
    delay {
      if (map.contains(unsaved.id))
        sys.error(s"id ${unsaved.id} already exists")
      else
        map.put(unsaved.id, unsaved)
      unsaved
    }
  }
  override def selectAll: Stream[ConnectionIO, FootballClubRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(id: FootballClubId): ConnectionIO[Option[FootballClubRow]] = {
    delay(map.get(id))
  }
  override def selectByIds(ids: Array[FootballClubId]): Stream[ConnectionIO, FootballClubRow] = {
    Stream.emits(ids.flatMap(map.get).toList)
  }
  override def update(row: FootballClubRow): ConnectionIO[Boolean] = {
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
  override def upsert(unsaved: FootballClubRow): ConnectionIO[FootballClubRow] = {
    delay {
      map.put(unsaved.id, unsaved)
      unsaved
    }
  }
}
