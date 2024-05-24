/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

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

class CustomerRepoMock(toRow: Function1[CustomerRowUnsaved, CustomerRow],
                       map: scala.collection.mutable.Map[CustomerId, CustomerRow] = scala.collection.mutable.Map.empty) extends CustomerRepo {
  override def delete: DeleteBuilder[CustomerFields, CustomerRow] = {
    DeleteBuilderMock(DeleteParams.empty, CustomerFields.structure, map)
  }
  override def deleteById(customerid: CustomerId): ConnectionIO[Boolean] = {
    delay(map.remove(customerid).isDefined)
  }
  override def deleteByIds(customerids: Array[CustomerId]): ConnectionIO[Int] = {
    delay(customerids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: CustomerRow): ConnectionIO[CustomerRow] = {
    delay {
      val _ = if (map.contains(unsaved.customerid))
        sys.error(s"id ${unsaved.customerid} already exists")
      else
        map.put(unsaved.customerid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CustomerRowUnsaved): ConnectionIO[CustomerRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CustomerRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.customerid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CustomerRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.customerid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[CustomerFields, CustomerRow] = {
    SelectBuilderMock(CustomerFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, CustomerRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(customerid: CustomerId): ConnectionIO[Option[CustomerRow]] = {
    delay(map.get(customerid))
  }
  override def selectByIds(customerids: Array[CustomerId]): Stream[ConnectionIO, CustomerRow] = {
    Stream.emits(customerids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(customerids: Array[CustomerId]): ConnectionIO[Map[CustomerId, CustomerRow]] = {
    selectByIds(customerids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.customerid, x)).toMap
      customerids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[CustomerFields, CustomerRow] = {
    UpdateBuilderMock(UpdateParams.empty, CustomerFields.structure, map)
  }
  override def update(row: CustomerRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.customerid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.customerid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: CustomerRow): ConnectionIO[CustomerRow] = {
    delay {
      map.put(unsaved.customerid, unsaved): @nowarn
      unsaved
    }
  }
}
