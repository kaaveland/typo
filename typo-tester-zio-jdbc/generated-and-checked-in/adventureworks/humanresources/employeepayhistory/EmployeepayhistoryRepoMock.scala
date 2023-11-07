/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

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

class EmployeepayhistoryRepoMock(toRow: Function1[EmployeepayhistoryRowUnsaved, EmployeepayhistoryRow],
                                 map: scala.collection.mutable.Map[EmployeepayhistoryId, EmployeepayhistoryRow] = scala.collection.mutable.Map.empty) extends EmployeepayhistoryRepo {
  override def delete(compositeId: EmployeepayhistoryId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, EmployeepayhistoryFields, map)
  }
  override def insert(unsaved: EmployeepayhistoryRow): ZIO[ZConnection, Throwable, EmployeepayhistoryRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: EmployeepayhistoryRowUnsaved): ZIO[ZConnection, Throwable, EmployeepayhistoryRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    SelectBuilderMock(EmployeepayhistoryFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, EmployeepayhistoryRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: EmployeepayhistoryId): ZIO[ZConnection, Throwable, Option[EmployeepayhistoryRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def update(row: EmployeepayhistoryRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, EmployeepayhistoryFields, map)
  }
  override def upsert(unsaved: EmployeepayhistoryRow): ZIO[ZConnection, Throwable, UpdateResult[EmployeepayhistoryRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
