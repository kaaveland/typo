/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

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
import zio.Chunk
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

class FootballClubRepoMock(map: scala.collection.mutable.Map[FootballClubId, FootballClubRow] = scala.collection.mutable.Map.empty) extends FootballClubRepo {
  override def delete: DeleteBuilder[FootballClubFields, FootballClubRow] = {
    DeleteBuilderMock(DeleteParams.empty, FootballClubFields.structure, map)
  }
  override def deleteById(id: FootballClubId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(id).isDefined)
  }
  override def deleteByIds(ids: Array[FootballClubId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(ids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: FootballClubRow): ZIO[ZConnection, Throwable, FootballClubRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.id))
          sys.error(s"id ${unsaved.id} already exists")
        else
          map.put(unsaved.id, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, FootballClubRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.id -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[FootballClubFields, FootballClubRow] = {
    SelectBuilderMock(FootballClubFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, FootballClubRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[?]]): ZStream[ZConnection, Throwable, FootballClubRow] = {
    ZStream.fromIterable {
      fieldValues.foldLeft(map.values) {
        case (acc, FootballClubFieldValue.id(value)) => acc.filter(_.id == value)
        case (acc, FootballClubFieldValue.name(value)) => acc.filter(_.name == value)
      }
    }
  }
  override def selectById(id: FootballClubId): ZIO[ZConnection, Throwable, Option[FootballClubRow]] = {
    ZIO.succeed(map.get(id))
  }
  override def selectByIds(ids: Array[FootballClubId]): ZStream[ZConnection, Throwable, FootballClubRow] = {
    ZStream.fromIterable(ids.flatMap(map.get))
  }
  override def selectByIdsTracked(ids: Array[FootballClubId]): ZIO[ZConnection, Throwable, Map[FootballClubId, FootballClubRow]] = {
    selectByIds(ids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.id, x)).toMap
      ids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[FootballClubFields, FootballClubRow] = {
    UpdateBuilderMock(UpdateParams.empty, FootballClubFields.structure, map)
  }
  override def update(row: FootballClubRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.id) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.id, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[?]]): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
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
  override def upsert(unsaved: FootballClubRow): ZIO[ZConnection, Throwable, UpdateResult[FootballClubRow]] = {
    ZIO.succeed {
      map.put(unsaved.id, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
