/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

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

class CurrencyRepoMock(toRow: Function1[CurrencyRowUnsaved, CurrencyRow],
                       map: scala.collection.mutable.Map[CurrencyId, CurrencyRow] = scala.collection.mutable.Map.empty) extends CurrencyRepo {
  override def delete(currencycode: CurrencyId): ConnectionIO[Boolean] = {
    delay(map.remove(currencycode).isDefined)
  }
  override def delete: DeleteBuilder[CurrencyFields, CurrencyRow] = {
    DeleteBuilderMock(DeleteParams.empty, CurrencyFields.structure.fields, map)
  }
  override def insert(unsaved: CurrencyRow): ConnectionIO[CurrencyRow] = {
    delay {
      val _ = if (map.contains(unsaved.currencycode))
        sys.error(s"id ${unsaved.currencycode} already exists")
      else
        map.put(unsaved.currencycode, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CurrencyRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.currencycode -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: CurrencyRowUnsaved): ConnectionIO[CurrencyRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CurrencyRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.currencycode -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[CurrencyFields, CurrencyRow] = {
    SelectBuilderMock(CurrencyFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, CurrencyRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(currencycode: CurrencyId): ConnectionIO[Option[CurrencyRow]] = {
    delay(map.get(currencycode))
  }
  override def selectByIds(currencycodes: Array[CurrencyId]): Stream[ConnectionIO, CurrencyRow] = {
    Stream.emits(currencycodes.flatMap(map.get).toList)
  }
  override def update(row: CurrencyRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.currencycode) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.currencycode, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[CurrencyFields, CurrencyRow] = {
    UpdateBuilderMock(UpdateParams.empty, CurrencyFields.structure.fields, map)
  }
  override def upsert(unsaved: CurrencyRow): ConnectionIO[CurrencyRow] = {
    delay {
      map.put(unsaved.currencycode, unsaved): @nowarn
      unsaved
    }
  }
}
