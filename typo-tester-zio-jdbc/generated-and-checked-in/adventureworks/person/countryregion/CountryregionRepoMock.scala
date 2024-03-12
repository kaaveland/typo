/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

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

class CountryregionRepoMock(toRow: Function1[CountryregionRowUnsaved, CountryregionRow],
                            map: scala.collection.mutable.Map[CountryregionId, CountryregionRow] = scala.collection.mutable.Map.empty) extends CountryregionRepo {
  override def delete(countryregioncode: CountryregionId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(countryregioncode).isDefined)
  }
  override def delete: DeleteBuilder[CountryregionFields, CountryregionRow] = {
    DeleteBuilderMock(DeleteParams.empty, CountryregionFields.structure.fields, map)
  }
  override def insert(unsaved: CountryregionRow): ZIO[ZConnection, Throwable, CountryregionRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.countryregioncode))
          sys.error(s"id ${unsaved.countryregioncode} already exists")
        else
          map.put(unsaved.countryregioncode, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CountryregionRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.countryregioncode -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: CountryregionRowUnsaved): ZIO[ZConnection, Throwable, CountryregionRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CountryregionRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.countryregioncode -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[CountryregionFields, CountryregionRow] = {
    SelectBuilderMock(CountryregionFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CountryregionRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(countryregioncode: CountryregionId): ZIO[ZConnection, Throwable, Option[CountryregionRow]] = {
    ZIO.succeed(map.get(countryregioncode))
  }
  override def selectByIds(countryregioncodes: Array[CountryregionId]): ZStream[ZConnection, Throwable, CountryregionRow] = {
    ZStream.fromIterable(countryregioncodes.flatMap(map.get))
  }
  override def update(row: CountryregionRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.countryregioncode) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.countryregioncode, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[CountryregionFields, CountryregionRow] = {
    UpdateBuilderMock(UpdateParams.empty, CountryregionFields.structure.fields, map)
  }
  override def upsert(unsaved: CountryregionRow): ZIO[ZConnection, Throwable, UpdateResult[CountryregionRow]] = {
    ZIO.succeed {
      map.put(unsaved.countryregioncode, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
