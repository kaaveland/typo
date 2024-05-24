/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
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

class TransactionhistoryRepoMock(toRow: Function1[TransactionhistoryRowUnsaved, TransactionhistoryRow],
                                 map: scala.collection.mutable.Map[TransactionhistoryId, TransactionhistoryRow] = scala.collection.mutable.Map.empty) extends TransactionhistoryRepo {
  override def delete: DeleteBuilder[TransactionhistoryFields, TransactionhistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, TransactionhistoryFields.structure, map)
  }
  override def deleteById(transactionid: TransactionhistoryId): ConnectionIO[Boolean] = {
    delay(map.remove(transactionid).isDefined)
  }
  override def deleteByIds(transactionids: Array[TransactionhistoryId]): ConnectionIO[Int] = {
    delay(transactionids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: TransactionhistoryRow): ConnectionIO[TransactionhistoryRow] = {
    delay {
      val _ = if (map.contains(unsaved.transactionid))
        sys.error(s"id ${unsaved.transactionid} already exists")
      else
        map.put(unsaved.transactionid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: TransactionhistoryRowUnsaved): ConnectionIO[TransactionhistoryRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, TransactionhistoryRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.transactionid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, TransactionhistoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.transactionid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[TransactionhistoryFields, TransactionhistoryRow] = {
    SelectBuilderMock(TransactionhistoryFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, TransactionhistoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(transactionid: TransactionhistoryId): ConnectionIO[Option[TransactionhistoryRow]] = {
    delay(map.get(transactionid))
  }
  override def selectByIds(transactionids: Array[TransactionhistoryId]): Stream[ConnectionIO, TransactionhistoryRow] = {
    Stream.emits(transactionids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(transactionids: Array[TransactionhistoryId]): ConnectionIO[Map[TransactionhistoryId, TransactionhistoryRow]] = {
    selectByIds(transactionids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.transactionid, x)).toMap
      transactionids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[TransactionhistoryFields, TransactionhistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, TransactionhistoryFields.structure, map)
  }
  override def update(row: TransactionhistoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.transactionid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.transactionid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: TransactionhistoryRow): ConnectionIO[TransactionhistoryRow] = {
    delay {
      map.put(unsaved.transactionid, unsaved): @nowarn
      unsaved
    }
  }
}
