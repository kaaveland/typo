/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package only_pk_columns

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

class OnlyPkColumnsRepoMock(map: scala.collection.mutable.Map[OnlyPkColumnsId, OnlyPkColumnsRow] = scala.collection.mutable.Map.empty) extends OnlyPkColumnsRepo {
  override def delete: DeleteBuilder[OnlyPkColumnsFields, OnlyPkColumnsRow] = {
    DeleteBuilderMock(DeleteParams.empty, OnlyPkColumnsFields.structure, map)
  }
  override def deleteById(compositeId: OnlyPkColumnsId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[OnlyPkColumnsId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(compositeIds.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: OnlyPkColumnsRow): ZIO[ZConnection, Throwable, OnlyPkColumnsRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, OnlyPkColumnsRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[OnlyPkColumnsFields, OnlyPkColumnsRow] = {
    SelectBuilderMock(OnlyPkColumnsFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, OnlyPkColumnsRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: OnlyPkColumnsId): ZIO[ZConnection, Throwable, Option[OnlyPkColumnsRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[OnlyPkColumnsId]): ZStream[ZConnection, Throwable, OnlyPkColumnsRow] = {
    ZStream.fromIterable(compositeIds.flatMap(map.get))
  }
  override def selectByIdsTracked(compositeIds: Array[OnlyPkColumnsId]): ZIO[ZConnection, Throwable, Map[OnlyPkColumnsId, OnlyPkColumnsRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[OnlyPkColumnsFields, OnlyPkColumnsRow] = {
    UpdateBuilderMock(UpdateParams.empty, OnlyPkColumnsFields.structure, map)
  }
  override def upsert(unsaved: OnlyPkColumnsRow): ZIO[ZConnection, Throwable, UpdateResult[OnlyPkColumnsRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, OnlyPkColumnsRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}
