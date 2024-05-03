/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

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

class ProductmodelillustrationRepoMock(toRow: Function1[ProductmodelillustrationRowUnsaved, ProductmodelillustrationRow],
                                       map: scala.collection.mutable.Map[ProductmodelillustrationId, ProductmodelillustrationRow] = scala.collection.mutable.Map.empty) extends ProductmodelillustrationRepo {
  override def delete: DeleteBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductmodelillustrationFields.structure.fields, map)
  }
  override def deleteById(compositeId: ProductmodelillustrationId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[ProductmodelillustrationId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(compositeIds.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: ProductmodelillustrationRow): ZIO[ZConnection, Throwable, ProductmodelillustrationRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ProductmodelillustrationRowUnsaved): ZIO[ZConnection, Throwable, ProductmodelillustrationRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelillustrationRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelillustrationRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    SelectBuilderMock(ProductmodelillustrationFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductmodelillustrationRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: ProductmodelillustrationId): ZIO[ZConnection, Throwable, Option[ProductmodelillustrationRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[ProductmodelillustrationId]): ZStream[ZConnection, Throwable, ProductmodelillustrationRow] = {
    ZStream.fromIterable(compositeIds.flatMap(map.get))
  }
  override def selectByIdsTracked(compositeIds: Array[ProductmodelillustrationId]): ZIO[ZConnection, Throwable, Map[ProductmodelillustrationId, ProductmodelillustrationRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductmodelillustrationFields.structure.fields, map)
  }
  override def update(row: ProductmodelillustrationRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def upsert(unsaved: ProductmodelillustrationRow): ZIO[ZConnection, Throwable, UpdateResult[ProductmodelillustrationRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
