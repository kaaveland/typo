/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package title

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

class TitleRepoMock(map: scala.collection.mutable.Map[TitleId, TitleRow] = scala.collection.mutable.Map.empty) extends TitleRepo {
  override def delete: DeleteBuilder[TitleFields, TitleRow] = {
    DeleteBuilderMock(DeleteParams.empty, TitleFields.structure, map)
  }
  override def deleteById(code: TitleId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(code).isDefined)
  }
  override def deleteByIds(codes: Array[TitleId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(codes.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: TitleRow): ZIO[ZConnection, Throwable, TitleRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.code))
          sys.error(s"id ${unsaved.code} already exists")
        else
          map.put(unsaved.code, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, TitleRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.code -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[TitleFields, TitleRow] = {
    SelectBuilderMock(TitleFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, TitleRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(code: TitleId): ZIO[ZConnection, Throwable, Option[TitleRow]] = {
    ZIO.succeed(map.get(code))
  }
  override def selectByIds(codes: Array[TitleId]): ZStream[ZConnection, Throwable, TitleRow] = {
    ZStream.fromIterable(codes.flatMap(map.get))
  }
  override def selectByIdsTracked(codes: Array[TitleId]): ZIO[ZConnection, Throwable, Map[TitleId, TitleRow]] = {
    selectByIds(codes).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.code, x)).toMap
      codes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[TitleFields, TitleRow] = {
    UpdateBuilderMock(UpdateParams.empty, TitleFields.structure, map)
  }
  override def upsert(unsaved: TitleRow): ZIO[ZConnection, Throwable, UpdateResult[TitleRow]] = {
    ZIO.succeed {
      map.put(unsaved.code, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, TitleRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.code -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}
