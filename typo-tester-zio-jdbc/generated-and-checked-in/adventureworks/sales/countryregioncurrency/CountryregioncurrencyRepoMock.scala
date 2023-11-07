/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

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

class CountryregioncurrencyRepoMock(toRow: Function1[CountryregioncurrencyRowUnsaved, CountryregioncurrencyRow],
                                    map: scala.collection.mutable.Map[CountryregioncurrencyId, CountryregioncurrencyRow] = scala.collection.mutable.Map.empty) extends CountryregioncurrencyRepo {
  override def delete(compositeId: CountryregioncurrencyId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    DeleteBuilderMock(DeleteParams.empty, CountryregioncurrencyFields, map)
  }
  override def insert(unsaved: CountryregioncurrencyRow): ZIO[ZConnection, Throwable, CountryregioncurrencyRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.compositeId))
          sys.error(s"id ${unsaved.compositeId} already exists")
        else
          map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CountryregioncurrencyRowUnsaved): ZIO[ZConnection, Throwable, CountryregioncurrencyRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    SelectBuilderMock(CountryregioncurrencyFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CountryregioncurrencyRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(compositeId: CountryregioncurrencyId): ZIO[ZConnection, Throwable, Option[CountryregioncurrencyRow]] = {
    ZIO.succeed(map.get(compositeId))
  }
  override def update(row: CountryregioncurrencyRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[CountryregioncurrencyFields, CountryregioncurrencyRow] = {
    UpdateBuilderMock(UpdateParams.empty, CountryregioncurrencyFields, map)
  }
  override def upsert(unsaved: CountryregioncurrencyRow): ZIO[ZConnection, Throwable, UpdateResult[CountryregioncurrencyRow]] = {
    ZIO.succeed {
      map.put(unsaved.compositeId, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
