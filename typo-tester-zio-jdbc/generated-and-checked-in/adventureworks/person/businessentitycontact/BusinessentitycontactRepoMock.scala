/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

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

class BusinessentitycontactRepoMock(toRow: Function1[BusinessentitycontactRowUnsaved, BusinessentitycontactRow],
                                    map: scala.collection.mutable.Map[BusinessentitycontactId, BusinessentitycontactRow] = scala.collection.mutable.Map.empty) extends BusinessentitycontactRepo {
  override def delete(compositeId: BusinessentitycontactId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    DeleteBuilderMock(DeleteParams.empty, BusinessentitycontactFields, map)
  }
  override def insert(unsaved: BusinessentitycontactRow): ZIO[ZConnection, Throwable, BusinessentitycontactRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: BusinessentitycontactRowUnsaved): ZIO[ZConnection, Throwable, BusinessentitycontactRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    SelectBuilderMock(BusinessentitycontactFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, BusinessentitycontactRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: BusinessentitycontactId): ZIO[ZConnection, Throwable, Option[BusinessentitycontactRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def update(row: BusinessentitycontactRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    UpdateBuilderMock(UpdateParams.empty, BusinessentitycontactFields, map)
  }
  override def upsert(unsaved: BusinessentitycontactRow): ZIO[ZConnection, Throwable, UpdateResult[BusinessentitycontactRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
