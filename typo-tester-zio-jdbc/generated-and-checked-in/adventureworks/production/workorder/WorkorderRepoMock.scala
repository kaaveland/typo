/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

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

class WorkorderRepoMock(toRow: Function1[WorkorderRowUnsaved, WorkorderRow],
                        map: scala.collection.mutable.Map[WorkorderId, WorkorderRow] = scala.collection.mutable.Map.empty) extends WorkorderRepo {
  override def delete: DeleteBuilder[WorkorderFields, WorkorderRow] = {
    DeleteBuilderMock(DeleteParams.empty, WorkorderFields.structure, map)
  }
  override def deleteById(workorderid: WorkorderId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(workorderid).isDefined)
  }
  override def deleteByIds(workorderids: Array[WorkorderId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(workorderids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: WorkorderRow): ZIO[ZConnection, Throwable, WorkorderRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.workorderid))
          sys.error(s"id ${unsaved.workorderid} already exists")
        else
          map.put(unsaved.workorderid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: WorkorderRowUnsaved): ZIO[ZConnection, Throwable, WorkorderRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.workorderid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.workorderid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[WorkorderFields, WorkorderRow] = {
    SelectBuilderMock(WorkorderFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, WorkorderRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(workorderid: WorkorderId): ZIO[ZConnection, Throwable, Option[WorkorderRow]] = {
    ZIO.succeed(map.get(workorderid))
  }
  override def selectByIds(workorderids: Array[WorkorderId]): ZStream[ZConnection, Throwable, WorkorderRow] = {
    ZStream.fromIterable(workorderids.flatMap(map.get))
  }
  override def selectByIdsTracked(workorderids: Array[WorkorderId]): ZIO[ZConnection, Throwable, Map[WorkorderId, WorkorderRow]] = {
    selectByIds(workorderids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.workorderid, x)).toMap
      workorderids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[WorkorderFields, WorkorderRow] = {
    UpdateBuilderMock(UpdateParams.empty, WorkorderFields.structure, map)
  }
  override def update(row: WorkorderRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.workorderid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.workorderid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: WorkorderRow): ZIO[ZConnection, Throwable, UpdateResult[WorkorderRow]] = {
    ZIO.succeed {
      map.put(unsaved.workorderid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
