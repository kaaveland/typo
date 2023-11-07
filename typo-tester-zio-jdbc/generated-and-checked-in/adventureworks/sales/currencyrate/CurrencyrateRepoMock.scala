/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

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

class CurrencyrateRepoMock(toRow: Function1[CurrencyrateRowUnsaved, CurrencyrateRow],
                           map: scala.collection.mutable.Map[CurrencyrateId, CurrencyrateRow] = scala.collection.mutable.Map.empty) extends CurrencyrateRepo {
  override def delete(currencyrateid: CurrencyrateId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(currencyrateid).isDefined)
  }
  override def delete: DeleteBuilder[CurrencyrateFields, CurrencyrateRow] = {
    DeleteBuilderMock(DeleteParams.empty, CurrencyrateFields, map)
  }
  override def insert(unsaved: CurrencyrateRow): ZIO[ZConnection, Throwable, CurrencyrateRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.currencyrateid))
          sys.error(s"id ${unsaved.currencyrateid} already exists")
        else
          map.put(unsaved.currencyrateid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CurrencyrateRowUnsaved): ZIO[ZConnection, Throwable, CurrencyrateRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[CurrencyrateFields, CurrencyrateRow] = {
    SelectBuilderMock(CurrencyrateFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CurrencyrateRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(currencyrateid: CurrencyrateId): ZIO[ZConnection, Throwable, Option[CurrencyrateRow]] = {
    ZIO.succeed(map.get(currencyrateid))
  }
  override def selectByIds(currencyrateids: Array[CurrencyrateId]): ZStream[ZConnection, Throwable, CurrencyrateRow] = {
    ZStream.fromIterable(currencyrateids.flatMap(map.get))
  }
  override def update(row: CurrencyrateRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.currencyrateid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.currencyrateid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[CurrencyrateFields, CurrencyrateRow] = {
    UpdateBuilderMock(UpdateParams.empty, CurrencyrateFields, map)
  }
  override def upsert(unsaved: CurrencyrateRow): ZIO[ZConnection, Throwable, UpdateResult[CurrencyrateRow]] = {
    ZIO.succeed {
      map.put(unsaved.currencyrateid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
