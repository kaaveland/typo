/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

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

class UnitmeasureRepoMock(toRow: Function1[UnitmeasureRowUnsaved, UnitmeasureRow],
                          map: scala.collection.mutable.Map[UnitmeasureId, UnitmeasureRow] = scala.collection.mutable.Map.empty) extends UnitmeasureRepo {
  override def delete: DeleteBuilder[UnitmeasureFields, UnitmeasureRow] = {
    DeleteBuilderMock(DeleteParams.empty, UnitmeasureFields.structure, map)
  }
  override def deleteById(unitmeasurecode: UnitmeasureId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(unitmeasurecode).isDefined)
  }
  override def deleteByIds(unitmeasurecodes: Array[UnitmeasureId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(unitmeasurecodes.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: UnitmeasureRow): ZIO[ZConnection, Throwable, UnitmeasureRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.unitmeasurecode))
          sys.error(s"id ${unsaved.unitmeasurecode} already exists")
        else
          map.put(unsaved.unitmeasurecode, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: UnitmeasureRowUnsaved): ZIO[ZConnection, Throwable, UnitmeasureRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, UnitmeasureRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.unitmeasurecode -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, UnitmeasureRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.unitmeasurecode -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[UnitmeasureFields, UnitmeasureRow] = {
    SelectBuilderMock(UnitmeasureFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, UnitmeasureRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(unitmeasurecode: UnitmeasureId): ZIO[ZConnection, Throwable, Option[UnitmeasureRow]] = {
    ZIO.succeed(map.get(unitmeasurecode))
  }
  override def selectByIds(unitmeasurecodes: Array[UnitmeasureId]): ZStream[ZConnection, Throwable, UnitmeasureRow] = {
    ZStream.fromIterable(unitmeasurecodes.flatMap(map.get))
  }
  override def selectByIdsTracked(unitmeasurecodes: Array[UnitmeasureId]): ZIO[ZConnection, Throwable, Map[UnitmeasureId, UnitmeasureRow]] = {
    selectByIds(unitmeasurecodes).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.unitmeasurecode, x)).toMap
      unitmeasurecodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[UnitmeasureFields, UnitmeasureRow] = {
    UpdateBuilderMock(UpdateParams.empty, UnitmeasureFields.structure, map)
  }
  override def update(row: UnitmeasureRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.unitmeasurecode) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.unitmeasurecode, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: UnitmeasureRow): ZIO[ZConnection, Throwable, UpdateResult[UnitmeasureRow]] = {
    ZIO.succeed {
      map.put(unsaved.unitmeasurecode, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
