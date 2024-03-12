/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesreason

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

class SalesreasonRepoMock(toRow: Function1[SalesreasonRowUnsaved, SalesreasonRow],
                          map: scala.collection.mutable.Map[SalesreasonId, SalesreasonRow] = scala.collection.mutable.Map.empty) extends SalesreasonRepo {
  override def delete(salesreasonid: SalesreasonId): ConnectionIO[Boolean] = {
    delay(map.remove(salesreasonid).isDefined)
  }
  override def delete: DeleteBuilder[SalesreasonFields, SalesreasonRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesreasonFields.structure.fields, map)
  }
  override def insert(unsaved: SalesreasonRow): ConnectionIO[SalesreasonRow] = {
    delay {
      val _ = if (map.contains(unsaved.salesreasonid))
        sys.error(s"id ${unsaved.salesreasonid} already exists")
      else
        map.put(unsaved.salesreasonid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SalesreasonRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.salesreasonid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: SalesreasonRowUnsaved): ConnectionIO[SalesreasonRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesreasonRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.salesreasonid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[SalesreasonFields, SalesreasonRow] = {
    SelectBuilderMock(SalesreasonFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, SalesreasonRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(salesreasonid: SalesreasonId): ConnectionIO[Option[SalesreasonRow]] = {
    delay(map.get(salesreasonid))
  }
  override def selectByIds(salesreasonids: Array[SalesreasonId]): Stream[ConnectionIO, SalesreasonRow] = {
    Stream.emits(salesreasonids.flatMap(map.get).toList)
  }
  override def update(row: SalesreasonRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.salesreasonid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.salesreasonid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[SalesreasonFields, SalesreasonRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesreasonFields.structure.fields, map)
  }
  override def upsert(unsaved: SalesreasonRow): ConnectionIO[SalesreasonRow] = {
    delay {
      map.put(unsaved.salesreasonid, unsaved): @nowarn
      unsaved
    }
  }
}
