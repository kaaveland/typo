/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

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

class LocationRepoMock(toRow: Function1[LocationRowUnsaved, LocationRow],
                       map: scala.collection.mutable.Map[LocationId, LocationRow] = scala.collection.mutable.Map.empty) extends LocationRepo {
  override def delete(locationid: LocationId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(locationid).isDefined)
  }
  override def delete: DeleteBuilder[LocationFields, LocationRow] = {
    DeleteBuilderMock(DeleteParams.empty, LocationFields, map)
  }
  override def insert(unsaved: LocationRow): ZIO[ZConnection, Throwable, LocationRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.locationid))
          sys.error(s"id ${unsaved.locationid} already exists")
        else
          map.put(unsaved.locationid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: LocationRowUnsaved): ZIO[ZConnection, Throwable, LocationRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[LocationFields, LocationRow] = {
    SelectBuilderMock(LocationFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, LocationRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(locationid: LocationId): ZIO[ZConnection, Throwable, Option[LocationRow]] = {
    ZIO.succeed(map.get(locationid))
  }
  override def selectByIds(locationids: Array[LocationId]): ZStream[ZConnection, Throwable, LocationRow] = {
    ZStream.fromIterable(locationids.flatMap(map.get))
  }
  override def update(row: LocationRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.locationid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.locationid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[LocationFields, LocationRow] = {
    UpdateBuilderMock(UpdateParams.empty, LocationFields, map)
  }
  override def upsert(unsaved: LocationRow): ZIO[ZConnection, Throwable, UpdateResult[LocationRow]] = {
    ZIO.succeed {
      map.put(unsaved.locationid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}