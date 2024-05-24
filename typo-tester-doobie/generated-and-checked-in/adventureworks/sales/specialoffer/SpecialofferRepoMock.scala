/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

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

class SpecialofferRepoMock(toRow: Function1[SpecialofferRowUnsaved, SpecialofferRow],
                           map: scala.collection.mutable.Map[SpecialofferId, SpecialofferRow] = scala.collection.mutable.Map.empty) extends SpecialofferRepo {
  override def delete: DeleteBuilder[SpecialofferFields, SpecialofferRow] = {
    DeleteBuilderMock(DeleteParams.empty, SpecialofferFields.structure, map)
  }
  override def deleteById(specialofferid: SpecialofferId): ConnectionIO[Boolean] = {
    delay(map.remove(specialofferid).isDefined)
  }
  override def deleteByIds(specialofferids: Array[SpecialofferId]): ConnectionIO[Int] = {
    delay(specialofferids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: SpecialofferRow): ConnectionIO[SpecialofferRow] = {
    delay {
      val _ = if (map.contains(unsaved.specialofferid))
        sys.error(s"id ${unsaved.specialofferid} already exists")
      else
        map.put(unsaved.specialofferid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: SpecialofferRowUnsaved): ConnectionIO[SpecialofferRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SpecialofferRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.specialofferid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SpecialofferRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.specialofferid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[SpecialofferFields, SpecialofferRow] = {
    SelectBuilderMock(SpecialofferFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, SpecialofferRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(specialofferid: SpecialofferId): ConnectionIO[Option[SpecialofferRow]] = {
    delay(map.get(specialofferid))
  }
  override def selectByIds(specialofferids: Array[SpecialofferId]): Stream[ConnectionIO, SpecialofferRow] = {
    Stream.emits(specialofferids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(specialofferids: Array[SpecialofferId]): ConnectionIO[Map[SpecialofferId, SpecialofferRow]] = {
    selectByIds(specialofferids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.specialofferid, x)).toMap
      specialofferids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[SpecialofferFields, SpecialofferRow] = {
    UpdateBuilderMock(UpdateParams.empty, SpecialofferFields.structure, map)
  }
  override def update(row: SpecialofferRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.specialofferid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.specialofferid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: SpecialofferRow): ConnectionIO[SpecialofferRow] = {
    delay {
      map.put(unsaved.specialofferid, unsaved): @nowarn
      unsaved
    }
  }
}
