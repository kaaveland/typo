/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class PgLargeobjectRepoMock(map: scala.collection.mutable.Map[PgLargeobjectId, PgLargeobjectRow] = scala.collection.mutable.Map.empty) extends PgLargeobjectRepo {
  override def delete(compositeId: PgLargeobjectId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def insert(unsaved: PgLargeobjectRow): ConnectionIO[PgLargeobjectRow] = {
    delay {
      if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
  override def selectAll: Stream[ConnectionIO, PgLargeobjectRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: PgLargeobjectId): ConnectionIO[Option[PgLargeobjectRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: PgLargeobjectRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row)
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: PgLargeobjectRow): ConnectionIO[PgLargeobjectRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved)
      unsaved
    }
  }
}