/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

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

class PersonphoneRepoMock(toRow: Function1[PersonphoneRowUnsaved, PersonphoneRow],
                          map: scala.collection.mutable.Map[PersonphoneId, PersonphoneRow] = scala.collection.mutable.Map.empty) extends PersonphoneRepo {
  override def delete: DeleteBuilder[PersonphoneFields, PersonphoneRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersonphoneFields.structure.fields, map)
  }
  override def deleteById(compositeId: PersonphoneId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[PersonphoneId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: PersonphoneRow): ConnectionIO[PersonphoneRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: PersonphoneRowUnsaved): ConnectionIO[PersonphoneRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PersonphoneRow], batchSize: Int): ConnectionIO[Long] = {
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
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PersonphoneRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[PersonphoneFields, PersonphoneRow] = {
    SelectBuilderMock(PersonphoneFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PersonphoneRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: PersonphoneId): ConnectionIO[Option[PersonphoneRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[PersonphoneId]): Stream[ConnectionIO, PersonphoneRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(compositeIds: Array[PersonphoneId]): ConnectionIO[Map[PersonphoneId, Option[PersonphoneRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[PersonphoneFields, PersonphoneRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersonphoneFields.structure.fields, map)
  }
  override def update(row: PersonphoneRow): ConnectionIO[Boolean] = {
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
  override def upsert(unsaved: PersonphoneRow): ConnectionIO[PersonphoneRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
