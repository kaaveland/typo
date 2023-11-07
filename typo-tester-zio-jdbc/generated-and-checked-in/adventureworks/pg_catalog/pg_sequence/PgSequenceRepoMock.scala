/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequence

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

class PgSequenceRepoMock(map: scala.collection.mutable.Map[PgSequenceId, PgSequenceRow] = scala.collection.mutable.Map.empty) extends PgSequenceRepo {
  override def delete(seqrelid: PgSequenceId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(seqrelid).isDefined)
  }
  override def delete: DeleteBuilder[PgSequenceFields, PgSequenceRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgSequenceFields, map)
  }
  override def insert(unsaved: PgSequenceRow): ZIO[ZConnection, Throwable, PgSequenceRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.seqrelid))
          sys.error(s"id ${unsaved.seqrelid} already exists")
        else
          map.put(unsaved.seqrelid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgSequenceFields, PgSequenceRow] = {
    SelectBuilderMock(PgSequenceFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgSequenceRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(seqrelid: PgSequenceId): ZIO[ZConnection, Throwable, Option[PgSequenceRow]] = {
    ZIO.succeed(map.get(seqrelid))
  }
  override def selectByIds(seqrelids: Array[PgSequenceId]): ZStream[ZConnection, Throwable, PgSequenceRow] = {
    ZStream.fromIterable(seqrelids.flatMap(map.get))
  }
  override def update(row: PgSequenceRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.seqrelid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.seqrelid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgSequenceFields, PgSequenceRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgSequenceFields, map)
  }
  override def upsert(unsaved: PgSequenceRow): ZIO[ZConnection, Throwable, UpdateResult[PgSequenceRow]] = {
    ZIO.succeed {
      map.put(unsaved.seqrelid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
