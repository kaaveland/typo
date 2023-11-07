/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_subscription

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

class PgSubscriptionRepoMock(map: scala.collection.mutable.Map[PgSubscriptionId, PgSubscriptionRow] = scala.collection.mutable.Map.empty) extends PgSubscriptionRepo {
  override def delete(oid: PgSubscriptionId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgSubscriptionFields, PgSubscriptionRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgSubscriptionFields, map)
  }
  override def insert(unsaved: PgSubscriptionRow): ZIO[ZConnection, Throwable, PgSubscriptionRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.oid))
          sys.error(s"id ${unsaved.oid} already exists")
        else
          map.put(unsaved.oid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgSubscriptionFields, PgSubscriptionRow] = {
    SelectBuilderMock(PgSubscriptionFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgSubscriptionRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(oid: PgSubscriptionId): ZIO[ZConnection, Throwable, Option[PgSubscriptionRow]] = {
    ZIO.succeed(map.get(oid))
  }
  override def selectByIds(oids: Array[PgSubscriptionId]): ZStream[ZConnection, Throwable, PgSubscriptionRow] = {
    ZStream.fromIterable(oids.flatMap(map.get))
  }
  override def selectByUnique(subdbid: /* oid */ Long, subname: String): ZIO[ZConnection, Throwable, Option[PgSubscriptionRow]] = {
    ZIO.succeed(map.values.find(v => subdbid == v.subdbid && subname == v.subname))
  }
  override def update(row: PgSubscriptionRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.oid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.oid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgSubscriptionFields, PgSubscriptionRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgSubscriptionFields, map)
  }
  override def upsert(unsaved: PgSubscriptionRow): ZIO[ZConnection, Throwable, UpdateResult[PgSubscriptionRow]] = {
    ZIO.succeed {
      map.put(unsaved.oid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
