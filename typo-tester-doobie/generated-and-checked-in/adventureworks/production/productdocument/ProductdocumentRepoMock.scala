/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

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

class ProductdocumentRepoMock(toRow: Function1[ProductdocumentRowUnsaved, ProductdocumentRow],
                              map: scala.collection.mutable.Map[ProductdocumentId, ProductdocumentRow] = scala.collection.mutable.Map.empty) extends ProductdocumentRepo {
  override def delete(compositeId: ProductdocumentId): ConnectionIO[Boolean] = {
    delay(map.remove(compositeId).isDefined)
  }
  override def delete: DeleteBuilder[ProductdocumentFields, ProductdocumentRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductdocumentFields.structure.fields, map)
  }
  override def insert(unsaved: ProductdocumentRow): ConnectionIO[ProductdocumentRow] = {
    delay {
      val _ = if (map.contains(unsaved.compositeId))
        sys.error(s"id ${unsaved.compositeId} already exists")
      else
        map.put(unsaved.compositeId, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductdocumentRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.compositeId -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: ProductdocumentRowUnsaved): ConnectionIO[ProductdocumentRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductdocumentRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
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
  override def select: SelectBuilder[ProductdocumentFields, ProductdocumentRow] = {
    SelectBuilderMock(ProductdocumentFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, ProductdocumentRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(compositeId: ProductdocumentId): ConnectionIO[Option[ProductdocumentRow]] = {
    delay(map.get(compositeId))
  }
  override def update(row: ProductdocumentRow): ConnectionIO[Boolean] = {
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
  override def update: UpdateBuilder[ProductdocumentFields, ProductdocumentRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductdocumentFields.structure.fields, map)
  }
  override def upsert(unsaved: ProductdocumentRow): ConnectionIO[ProductdocumentRow] = {
    delay {
      map.put(unsaved.compositeId, unsaved): @nowarn
      unsaved
    }
  }
}
