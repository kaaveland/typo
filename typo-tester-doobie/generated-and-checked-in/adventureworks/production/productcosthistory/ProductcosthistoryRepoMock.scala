/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

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

class ProductcosthistoryRepoMock(toRow: Function1[ProductcosthistoryRowUnsaved, ProductcosthistoryRow],
                                 map: scala.collection.mutable.Map[ProductcosthistoryId, ProductcosthistoryRow] = scala.collection.mutable.Map.empty) extends ProductcosthistoryRepo {
  override def delete: DeleteBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductcosthistoryFields.structure.fields, map)
  }
  override def deleteById(compositeId: ProductcosthistoryId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[ProductcosthistoryId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: ProductcosthistoryRow): ConnectionIO[ProductcosthistoryRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ProductcosthistoryRowUnsaved): ConnectionIO[ProductcosthistoryRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductcosthistoryRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductcosthistoryRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    SelectBuilderMock(ProductcosthistoryFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductcosthistoryRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: ProductcosthistoryId): ConnectionIO[Option[ProductcosthistoryRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[ProductcosthistoryId]): Stream[ConnectionIO, ProductcosthistoryRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(compositeIds: Array[ProductcosthistoryId]): ConnectionIO[Map[ProductcosthistoryId, Option[ProductcosthistoryRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductcosthistoryFields.structure.fields, map)
  }
  override def update(row: ProductcosthistoryRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.compositeId) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.compositeId, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: ProductcosthistoryRow): ConnectionIO[ProductcosthistoryRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
