/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

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

class StateprovinceRepoMock(toRow: Function1[StateprovinceRowUnsaved, StateprovinceRow],
                            map: scala.collection.mutable.Map[StateprovinceId, StateprovinceRow] = scala.collection.mutable.Map.empty) extends StateprovinceRepo {
  override def delete(stateprovinceid: StateprovinceId): ConnectionIO[Boolean] = {
    delay(map.remove(stateprovinceid).isDefined)
  }
  override def delete: DeleteBuilder[StateprovinceFields, StateprovinceRow] = {
    DeleteBuilderMock(DeleteParams.empty, StateprovinceFields.structure.fields, map)
  }
  override def insert(unsaved: StateprovinceRow): ConnectionIO[StateprovinceRow] = {
    delay {
      val _ = if (map.contains(unsaved.stateprovinceid))
        sys.error(s"id ${unsaved.stateprovinceid} already exists")
      else
        map.put(unsaved.stateprovinceid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, StateprovinceRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.stateprovinceid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: StateprovinceRowUnsaved): ConnectionIO[StateprovinceRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, StateprovinceRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.stateprovinceid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[StateprovinceFields, StateprovinceRow] = {
    SelectBuilderMock(StateprovinceFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, StateprovinceRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(stateprovinceid: StateprovinceId): ConnectionIO[Option[StateprovinceRow]] = {
    delay(map.get(stateprovinceid))
  }
  override def selectByIds(stateprovinceids: Array[StateprovinceId]): Stream[ConnectionIO, StateprovinceRow] = {
    Stream.emits(stateprovinceids.flatMap(map.get).toList)
  }
  override def update(row: StateprovinceRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.stateprovinceid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.stateprovinceid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[StateprovinceFields, StateprovinceRow] = {
    UpdateBuilderMock(UpdateParams.empty, StateprovinceFields.structure.fields, map)
  }
  override def upsert(unsaved: StateprovinceRow): ConnectionIO[StateprovinceRow] = {
    delay {
      map.put(unsaved.stateprovinceid, unsaved): @nowarn
      unsaved
    }
  }
}
