/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

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

class ShoppingcartitemRepoMock(toRow: Function1[ShoppingcartitemRowUnsaved, ShoppingcartitemRow],
                               map: scala.collection.mutable.Map[ShoppingcartitemId, ShoppingcartitemRow] = scala.collection.mutable.Map.empty) extends ShoppingcartitemRepo {
  override def delete(shoppingcartitemid: ShoppingcartitemId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(shoppingcartitemid).isDefined)
  }
  override def delete: DeleteBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    DeleteBuilderMock(DeleteParams.empty, ShoppingcartitemFields.structure.fields, map)
  }
  override def insert(unsaved: ShoppingcartitemRow): ZIO[ZConnection, Throwable, ShoppingcartitemRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.shoppingcartitemid))
          sys.error(s"id ${unsaved.shoppingcartitemid} already exists")
        else
          map.put(unsaved.shoppingcartitemid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ShoppingcartitemRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.shoppingcartitemid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: ShoppingcartitemRowUnsaved): ZIO[ZConnection, Throwable, ShoppingcartitemRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ShoppingcartitemRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.shoppingcartitemid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    SelectBuilderMock(ShoppingcartitemFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ShoppingcartitemRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(shoppingcartitemid: ShoppingcartitemId): ZIO[ZConnection, Throwable, Option[ShoppingcartitemRow]] = {
    ZIO.succeed(map.get(shoppingcartitemid))
  }
  override def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId]): ZStream[ZConnection, Throwable, ShoppingcartitemRow] = {
    ZStream.fromIterable(shoppingcartitemids.flatMap(map.get))
  }
  override def update(row: ShoppingcartitemRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.shoppingcartitemid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.shoppingcartitemid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    UpdateBuilderMock(UpdateParams.empty, ShoppingcartitemFields.structure.fields, map)
  }
  override def upsert(unsaved: ShoppingcartitemRow): ZIO[ZConnection, Throwable, UpdateResult[ShoppingcartitemRow]] = {
    ZIO.succeed {
      map.put(unsaved.shoppingcartitemid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
