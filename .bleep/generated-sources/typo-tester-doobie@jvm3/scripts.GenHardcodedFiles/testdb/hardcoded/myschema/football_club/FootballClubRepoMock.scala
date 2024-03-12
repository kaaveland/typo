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

class FootballClubRepoMock(map: scala.collection.mutable.Map[FootballClubId, FootballClubRow] = scala.collection.mutable.Map.empty) extends FootballClubRepo {
  override def delete(id: FootballClubId): ConnectionIO[Boolean] = {
    delay(map.remove(id).isDefined)
  }
  override def delete: DeleteBuilder[FootballClubFields, FootballClubRow] = {
    DeleteBuilderMock(DeleteParams.empty, FootballClubFields.structure.fields, map)
  }
  override def insert(unsaved: FootballClubRow): ConnectionIO[FootballClubRow] = {
    delay {
      val _ = if (map.contains(unsaved.id))
        sys.error(s"id ${unsaved.id} already exists")
      else
        map.put(unsaved.id, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, FootballClubRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.id -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[FootballClubFields, FootballClubRow] = {
    SelectBuilderMock(FootballClubFields.structure, delay(map.values.toList), SelectParams.empty)
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
  override def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[?]]): Stream[ConnectionIO, FootballClubRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, FootballClubFieldValue.id(value)) => acc.filter(_.id == value)
        case (acc, FootballClubFieldValue.name(value)) => acc.filter(_.name == value)
      }.toList
    }
  }
  override def update(row: FootballClubRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.id) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.id, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[FootballClubFields, FootballClubRow] = {
    UpdateBuilderMock(UpdateParams.empty, FootballClubFields.structure.fields, map)
  }
  override def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[?]]): ConnectionIO[Boolean] = {
    delay {
      map.get(id) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, FootballClubFieldValue.name(value)) => acc.copy(name = value)
          }
          if (updatedRow != oldRow) {
            map.put(id, updatedRow): @nowarn
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: FootballClubRow): ConnectionIO[FootballClubRow] = {
    delay {
      map.put(unsaved.id, unsaved): @nowarn
      unsaved
    }
  }
}
