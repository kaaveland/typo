/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

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

class ProductmodelillustrationRepoMock(toRow: Function1[ProductmodelillustrationRowUnsaved, ProductmodelillustrationRow],
                                       map: scala.collection.mutable.Map[ProductmodelillustrationId, ProductmodelillustrationRow] = scala.collection.mutable.Map.empty) extends ProductmodelillustrationRepo {
  override def delete: DeleteBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductmodelillustrationFields.structure.fields, map)
  }
  override def deleteById(compositeId: ProductmodelillustrationId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def deleteByIds(compositeIds: Array[ProductmodelillustrationId]): ConnectionIO[Int] = {
    delay(compositeIds.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: ProductmodelillustrationRow): ConnectionIO[ProductmodelillustrationRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: ProductmodelillustrationRowUnsaved): ConnectionIO[ProductmodelillustrationRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductmodelillustrationRow], batchSize: Int): ConnectionIO[Long] = {
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
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductmodelillustrationRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    SelectBuilderMock(ProductmodelillustrationFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductmodelillustrationRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: ProductmodelillustrationId): ConnectionIO[Option[ProductmodelillustrationRow]] = {
    delay(map.get(compositeId))
  }
  override def selectByIds(compositeIds: Array[ProductmodelillustrationId]): Stream[ConnectionIO, ProductmodelillustrationRow] = {
    Stream.emits(compositeIds.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(compositeIds: Array[ProductmodelillustrationId]): ConnectionIO[Map[ProductmodelillustrationId, Option[ProductmodelillustrationRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductmodelillustrationFields.structure.fields, map)
  }
  override def update(row: ProductmodelillustrationRow): ConnectionIO[Boolean] = {
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
  override def upsert(unsaved: ProductmodelillustrationRow): ConnectionIO[ProductmodelillustrationRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
