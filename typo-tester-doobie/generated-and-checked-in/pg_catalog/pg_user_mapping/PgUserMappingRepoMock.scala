/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mapping

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class PgUserMappingRepoMock(map: scala.collection.mutable.Map[PgUserMappingId, PgUserMappingRow] = scala.collection.mutable.Map.empty) extends PgUserMappingRepo {
  override def delete(oid: PgUserMappingId): ConnectionIO[Boolean] = {
    delay(map.remove(oid).isDefined)
  }
  override def insert(unsaved: PgUserMappingRow): ConnectionIO[PgUserMappingRow] = {
    delay {
      if (map.contains(unsaved.oid))
        sys.error(s"id ${unsaved.oid} already exists")
      else
        map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
  override def selectAll: Stream[ConnectionIO, PgUserMappingRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(oid: PgUserMappingId): ConnectionIO[Option[PgUserMappingRow]] = {
    delay(map.get(oid))
  }
  override def selectByIds(oids: Array[PgUserMappingId]): Stream[ConnectionIO, PgUserMappingRow] = {
    Stream.emits(oids.flatMap(map.get).toList)
  }
  override def update(row: PgUserMappingRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.oid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.oid, row)
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: PgUserMappingRow): ConnectionIO[PgUserMappingRow] = {
    delay {
      map.put(unsaved.oid, unsaved)
      unsaved
    }
  }
}