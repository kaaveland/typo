/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

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

class SalesorderheadersalesreasonRepoMock(toRow: Function1[SalesorderheadersalesreasonRowUnsaved, SalesorderheadersalesreasonRow],
                                          map: scala.collection.mutable.Map[SalesorderheadersalesreasonId, SalesorderheadersalesreasonRow] = scala.collection.mutable.Map.empty) extends SalesorderheadersalesreasonRepo {
  override def delete: DeleteBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesorderheadersalesreasonFields.structure.fields, map)
  }
  override def deleteById(compositeId: SalesorderheadersalesreasonId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[SalesorderheadersalesreasonId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(compositeIds.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: SalesorderheadersalesreasonRow): ZIO[ZConnection, Throwable, SalesorderheadersalesreasonRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: SalesorderheadersalesreasonRowUnsaved): ZIO[ZConnection, Throwable, SalesorderheadersalesreasonRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheadersalesreasonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheadersalesreasonRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    SelectBuilderMock(SalesorderheadersalesreasonFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalesorderheadersalesreasonRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: SalesorderheadersalesreasonId): ZIO[ZConnection, Throwable, Option[SalesorderheadersalesreasonRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[SalesorderheadersalesreasonId]): ZStream[ZConnection, Throwable, SalesorderheadersalesreasonRow] = {
    ZStream.fromIterable(compositeIds.flatMap(map.get))
  }
  override def selectByIdsTracked(compositeIds: Array[SalesorderheadersalesreasonId]): ZIO[ZConnection, Throwable, Map[SalesorderheadersalesreasonId, SalesorderheadersalesreasonRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesorderheadersalesreasonFields.structure.fields, map)
  }
  override def update(row: SalesorderheadersalesreasonRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: SalesorderheadersalesreasonRow): ZIO[ZConnection, Throwable, UpdateResult[SalesorderheadersalesreasonRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
