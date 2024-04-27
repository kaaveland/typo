/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

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

class SalesterritoryhistoryRepoMock(toRow: Function1[SalesterritoryhistoryRowUnsaved, SalesterritoryhistoryRow],
                                    map: scala.collection.mutable.Map[SalesterritoryhistoryId, SalesterritoryhistoryRow] = scala.collection.mutable.Map.empty) extends SalesterritoryhistoryRepo {
  override def delete: DeleteBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesterritoryhistoryFields.structure.fields, map)
  }
  override def deleteById(compositeId: SalesterritoryhistoryId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[SalesterritoryhistoryId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: SalesterritoryhistoryRow): ConnectionIO[SalesterritoryhistoryRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: SalesterritoryhistoryRowUnsaved): ConnectionIO[SalesterritoryhistoryRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SalesterritoryhistoryRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesterritoryhistoryRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    SelectBuilderMock(SalesterritoryhistoryFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, SalesterritoryhistoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: SalesterritoryhistoryId): ConnectionIO[Option[SalesterritoryhistoryRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[SalesterritoryhistoryId]): Stream[ConnectionIO, SalesterritoryhistoryRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(compositeIds: Array[SalesterritoryhistoryId]): ConnectionIO[Map[SalesterritoryhistoryId, Option[SalesterritoryhistoryRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesterritoryhistoryFields.structure.fields, map)
  }
  override def update(row: SalesterritoryhistoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: SalesterritoryhistoryRow): ConnectionIO[SalesterritoryhistoryRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
