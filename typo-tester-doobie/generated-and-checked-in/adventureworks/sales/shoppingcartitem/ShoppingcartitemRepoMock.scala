/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

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

class ShoppingcartitemRepoMock(toRow: Function1[ShoppingcartitemRowUnsaved, ShoppingcartitemRow],
                               map: scala.collection.mutable.Map[ShoppingcartitemId, ShoppingcartitemRow] = scala.collection.mutable.Map.empty) extends ShoppingcartitemRepo {
  override def delete: DeleteBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    DeleteBuilderMock(DeleteParams.empty, ShoppingcartitemFields.structure, map)
  }
  override def deleteById(shoppingcartitemid: ShoppingcartitemId): ConnectionIO[Boolean] = {
    delay(map.remove(shoppingcartitemid).isDefined)
  }
  override def deleteByIds(shoppingcartitemids: Array[ShoppingcartitemId]): ConnectionIO[Int] = {
    delay(shoppingcartitemids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: ShoppingcartitemRow): ConnectionIO[ShoppingcartitemRow] = {
    delay {
      val _ = if (map.contains(unsaved.shoppingcartitemid))
        sys.error(s"id ${unsaved.shoppingcartitemid} already exists")
      else
        map.put(unsaved.shoppingcartitemid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ShoppingcartitemRowUnsaved): ConnectionIO[ShoppingcartitemRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ShoppingcartitemRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.shoppingcartitemid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ShoppingcartitemRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.shoppingcartitemid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    SelectBuilderMock(ShoppingcartitemFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ShoppingcartitemRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(shoppingcartitemid: ShoppingcartitemId): ConnectionIO[Option[ShoppingcartitemRow]] = {
    delay(map.get(shoppingcartitemid))
  }
  override def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId]): Stream[ConnectionIO, ShoppingcartitemRow] = {
    Stream.emits(shoppingcartitemids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(shoppingcartitemids: Array[ShoppingcartitemId]): ConnectionIO[Map[ShoppingcartitemId, ShoppingcartitemRow]] = {
    selectByIds(shoppingcartitemids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.shoppingcartitemid, x)).toMap
      shoppingcartitemids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    UpdateBuilderMock(UpdateParams.empty, ShoppingcartitemFields.structure, map)
  }
  override def update(row: ShoppingcartitemRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.shoppingcartitemid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.shoppingcartitemid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: ShoppingcartitemRow): ConnectionIO[ShoppingcartitemRow] = {
    delay {
      map.put(unsaved.shoppingcartitemid, unsaved): @nowarn
      unsaved
    }
  }
}
