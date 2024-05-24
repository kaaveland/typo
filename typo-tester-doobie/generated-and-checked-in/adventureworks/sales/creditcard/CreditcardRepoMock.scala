/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.userdefined.CustomCreditcardId
import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import doobie.util.Put
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

class CreditcardRepoMock(toRow: Function1[CreditcardRowUnsaved, CreditcardRow],
                         map: scala.collection.mutable.Map[/* user-picked */ CustomCreditcardId, CreditcardRow] = scala.collection.mutable.Map.empty) extends CreditcardRepo {
  override def delete: DeleteBuilder[CreditcardFields, CreditcardRow] = {
    DeleteBuilderMock(DeleteParams.empty, CreditcardFields.structure, map)
  }
  override def deleteById(creditcardid: /* user-picked */ CustomCreditcardId): ConnectionIO[Boolean] = {
    delay(map.remove(creditcardid).isDefined)
  }
  override def deleteByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit put0: Put[Array[/* user-picked */ CustomCreditcardId]]): ConnectionIO[Int] = {
    delay(creditcardids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: CreditcardRow): ConnectionIO[CreditcardRow] = {
    delay {
      val _ = if (map.contains(unsaved.creditcardid))
        sys.error(s"id ${unsaved.creditcardid} already exists")
      else
        map.put(unsaved.creditcardid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CreditcardRowUnsaved): ConnectionIO[CreditcardRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CreditcardRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.creditcardid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CreditcardRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.creditcardid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[CreditcardFields, CreditcardRow] = {
    SelectBuilderMock(CreditcardFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, CreditcardRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(creditcardid: /* user-picked */ CustomCreditcardId): ConnectionIO[Option[CreditcardRow]] = {
    delay(map.get(creditcardid))
  }
  override def selectByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit puts0: Put[Array[/* user-picked */ CustomCreditcardId]]): Stream[ConnectionIO, CreditcardRow] = {
    Stream.emits(creditcardids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit puts0: Put[Array[/* user-picked */ CustomCreditcardId]]): ConnectionIO[Map[/* user-picked */ CustomCreditcardId, CreditcardRow]] = {
    selectByIds(creditcardids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.creditcardid, x)).toMap
      creditcardids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[CreditcardFields, CreditcardRow] = {
    UpdateBuilderMock(UpdateParams.empty, CreditcardFields.structure, map)
  }
  override def update(row: CreditcardRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.creditcardid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.creditcardid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: CreditcardRow): ConnectionIO[CreditcardRow] = {
    delay {
      map.put(unsaved.creditcardid, unsaved): @nowarn
      unsaved
    }
  }
}
