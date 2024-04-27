/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

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

class SalesorderheadersalesreasonRepoMock(toRow: Function1[SalesorderheadersalesreasonRowUnsaved, SalesorderheadersalesreasonRow],
                                          map: scala.collection.mutable.Map[SalesorderheadersalesreasonId, SalesorderheadersalesreasonRow] = scala.collection.mutable.Map.empty) extends SalesorderheadersalesreasonRepo {
  override def delete: DeleteBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesorderheadersalesreasonFields.structure.fields, map)
  }
  override def deleteById(compositeId: SalesorderheadersalesreasonId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[SalesorderheadersalesreasonId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: SalesorderheadersalesreasonRow): ConnectionIO[SalesorderheadersalesreasonRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: SalesorderheadersalesreasonRowUnsaved): ConnectionIO[SalesorderheadersalesreasonRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SalesorderheadersalesreasonRow], batchSize: Int): ConnectionIO[Long] = {
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
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesorderheadersalesreasonRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    SelectBuilderMock(SalesorderheadersalesreasonFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, SalesorderheadersalesreasonRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: SalesorderheadersalesreasonId): ConnectionIO[Option[SalesorderheadersalesreasonRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[SalesorderheadersalesreasonId]): Stream[ConnectionIO, SalesorderheadersalesreasonRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(compositeIds: Array[SalesorderheadersalesreasonId]): ConnectionIO[Map[SalesorderheadersalesreasonId, Option[SalesorderheadersalesreasonRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesorderheadersalesreasonFields.structure.fields, map)
  }
  override def update(row: SalesorderheadersalesreasonRow): ConnectionIO[Boolean] = {
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
  override def upsert(unsaved: SalesorderheadersalesreasonRow): ConnectionIO[SalesorderheadersalesreasonRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
