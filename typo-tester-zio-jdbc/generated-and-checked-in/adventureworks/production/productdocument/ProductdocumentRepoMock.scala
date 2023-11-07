/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

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

class ProductdocumentRepoMock(toRow: Function1[ProductdocumentRowUnsaved, ProductdocumentRow],
                              map: scala.collection.mutable.Map[ProductdocumentId, ProductdocumentRow] = scala.collection.mutable.Map.empty) extends ProductdocumentRepo {
  override def delete(compositeId: ProductdocumentId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[ProductdocumentFields, ProductdocumentRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductdocumentFields, map)
  }
  override def insert(unsaved: ProductdocumentRow): ZIO[ZConnection, Throwable, ProductdocumentRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ProductdocumentRowUnsaved): ZIO[ZConnection, Throwable, ProductdocumentRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[ProductdocumentFields, ProductdocumentRow] = {
    SelectBuilderMock(ProductdocumentFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductdocumentRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: ProductdocumentId): ZIO[ZConnection, Throwable, Option[ProductdocumentRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def update(row: ProductdocumentRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[ProductdocumentFields, ProductdocumentRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductdocumentFields, map)
  }
  override def upsert(unsaved: ProductdocumentRow): ZIO[ZConnection, Throwable, UpdateResult[ProductdocumentRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
