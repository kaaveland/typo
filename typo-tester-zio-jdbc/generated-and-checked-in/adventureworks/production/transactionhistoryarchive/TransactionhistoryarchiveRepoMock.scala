/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

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

class TransactionhistoryarchiveRepoMock(toRow: Function1[TransactionhistoryarchiveRowUnsaved, TransactionhistoryarchiveRow],
                                        map: scala.collection.mutable.Map[TransactionhistoryarchiveId, TransactionhistoryarchiveRow] = scala.collection.mutable.Map.empty) extends TransactionhistoryarchiveRepo {
  override def delete: DeleteBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    DeleteBuilderMock(DeleteParams.empty, TransactionhistoryarchiveFields.structure.fields, map)
  }
  override def deleteById(transactionid: TransactionhistoryarchiveId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(transactionid).isDefined)
  }
  override def deleteByIds(transactionids: Array[TransactionhistoryarchiveId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(transactionids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: TransactionhistoryarchiveRow): ZIO[ZConnection, Throwable, TransactionhistoryarchiveRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.transactionid))
          sys.error(s"id ${unsaved.transactionid} already exists")
        else
          map.put(unsaved.transactionid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: TransactionhistoryarchiveRowUnsaved): ZIO[ZConnection, Throwable, TransactionhistoryarchiveRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, TransactionhistoryarchiveRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.transactionid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, TransactionhistoryarchiveRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.transactionid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    SelectBuilderMock(TransactionhistoryarchiveFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, TransactionhistoryarchiveRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(transactionid: TransactionhistoryarchiveId): ZIO[ZConnection, Throwable, Option[TransactionhistoryarchiveRow]] = {
    ZIO.succeed(map.get(transactionid))
  }
  override def selectByIds(transactionids: Array[TransactionhistoryarchiveId]): ZStream[ZConnection, Throwable, TransactionhistoryarchiveRow] = {
    ZStream.fromIterable(transactionids.flatMap(map.get))
  }
  override def selectByIdsTracked(transactionids: Array[TransactionhistoryarchiveId]): ZIO[ZConnection, Throwable, Map[TransactionhistoryarchiveId, TransactionhistoryarchiveRow]] = {
    selectByIds(transactionids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.transactionid, x)).toMap
      transactionids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    UpdateBuilderMock(UpdateParams.empty, TransactionhistoryarchiveFields.structure.fields, map)
  }
  override def update(row: TransactionhistoryarchiveRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.transactionid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.transactionid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: TransactionhistoryarchiveRow): ZIO[ZConnection, Throwable, UpdateResult[TransactionhistoryarchiveRow]] = {
    ZIO.succeed {
      map.put(unsaved.transactionid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
