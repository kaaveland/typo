/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

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

class PersoncreditcardRepoMock(toRow: Function1[PersoncreditcardRowUnsaved, PersoncreditcardRow],
                               map: scala.collection.mutable.Map[PersoncreditcardId, PersoncreditcardRow] = scala.collection.mutable.Map.empty) extends PersoncreditcardRepo {
  override def delete(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersoncreditcardFields, map)
  }
  override def insert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, PersoncreditcardRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: PersoncreditcardRowUnsaved): ZIO[ZConnection, Throwable, PersoncreditcardRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    SelectBuilderMock(PersoncreditcardFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PersoncreditcardRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Option[PersoncreditcardRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def update(row: PersoncreditcardRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersoncreditcardFields, map)
  }
  override def upsert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, UpdateResult[PersoncreditcardRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
