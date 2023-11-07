/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_subscription_rel

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

class PgSubscriptionRelRepoMock(map: scala.collection.mutable.Map[PgSubscriptionRelId, PgSubscriptionRelRow] = scala.collection.mutable.Map.empty) extends PgSubscriptionRelRepo {
  override def delete(compositeId: PgSubscriptionRelId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[PgSubscriptionRelFields, PgSubscriptionRelRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgSubscriptionRelFields, map)
  }
  override def insert(unsaved: PgSubscriptionRelRow): ZIO[ZConnection, Throwable, PgSubscriptionRelRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgSubscriptionRelFields, PgSubscriptionRelRow] = {
    SelectBuilderMock(PgSubscriptionRelFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgSubscriptionRelRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: PgSubscriptionRelId): ZIO[ZConnection, Throwable, Option[PgSubscriptionRelRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def update(row: PgSubscriptionRelRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[PgSubscriptionRelFields, PgSubscriptionRelRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgSubscriptionRelFields, map)
  }
  override def upsert(unsaved: PgSubscriptionRelRow): ZIO[ZConnection, Throwable, UpdateResult[PgSubscriptionRelRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
