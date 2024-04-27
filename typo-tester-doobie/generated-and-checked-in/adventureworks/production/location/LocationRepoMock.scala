/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class LocationRepoMock(toRow: Function1[LocationRowUnsaved, LocationRow],
                       map: scala.collection.mutable.Map[LocationId, LocationRow] = scala.collection.mutable.Map.empty) extends LocationRepo {
  override def delete: DeleteBuilder[LocationFields, LocationRow] = {
    DeleteBuilderMock(DeleteParams.empty, LocationFields.structure.fields, map)
  }
  override def deleteById(locationid: LocationId): ConnectionIO[Boolean] = {
    delay(map.remove(locationid).isDefined)
  }
  override def deleteByIds(locationids: Array[LocationId]): ConnectionIO[Int] = {
    delay(locationids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: LocationRow): ConnectionIO[LocationRow] = {
    delay {
      val _ = if (map.contains(unsaved.locationid))
        sys.error(s"id ${unsaved.locationid} already exists")
      else
        map.put(unsaved.locationid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: LocationRowUnsaved): ConnectionIO[LocationRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, LocationRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.locationid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, LocationRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.locationid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[LocationFields, LocationRow] = {
    SelectBuilderMock(LocationFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, LocationRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(locationid: LocationId): ConnectionIO[Option[LocationRow]] = {
    delay(map.get(locationid))
  }
  override def selectByIds(locationids: Array[LocationId]): Stream[ConnectionIO, LocationRow] = {
    Stream.emits(locationids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(locationids: Array[LocationId]): ConnectionIO[Map[LocationId, Option[LocationRow]]] = {
    selectByIds(locationids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.locationid, x)).toMap
      locationids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[LocationFields, LocationRow] = {
    UpdateBuilderMock(UpdateParams.empty, LocationFields.structure.fields, map)
  }
  override def update(row: LocationRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.locationid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.locationid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: LocationRow): ConnectionIO[LocationRow] = {
    delay {
      map.put(unsaved.locationid, unsaved): @nowarn
      unsaved
    }
  }
}
