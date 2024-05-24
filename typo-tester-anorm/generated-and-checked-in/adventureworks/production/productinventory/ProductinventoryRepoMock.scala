/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import java.sql.Connection
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

class ProductinventoryRepoMock(toRow: Function1[ProductinventoryRowUnsaved, ProductinventoryRow],
                               map: scala.collection.mutable.Map[ProductinventoryId, ProductinventoryRow] = scala.collection.mutable.Map.empty) extends ProductinventoryRepo {
  override def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductinventoryFields.structure, map)
  }
  override def deleteById(compositeId: ProductinventoryId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[ProductinventoryId])(implicit c: Connection): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductinventoryRow)(implicit c: Connection): ProductinventoryRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductinventoryRowUnsaved)(implicit c: Connection): ProductinventoryRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductinventoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductinventoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow] = {
    SelectBuilderMock(ProductinventoryFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductinventoryRow] = {
    map.values.toList
  }
  override def selectById(compositeId: ProductinventoryId)(implicit c: Connection): Option[ProductinventoryRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[ProductinventoryId])(implicit c: Connection): List[ProductinventoryRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(compositeIds: Array[ProductinventoryId])(implicit c: Connection): Map[ProductinventoryId, ProductinventoryRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductinventoryFields.structure, map)
  }
  override def update(row: ProductinventoryRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductinventoryRow)(implicit c: Connection): ProductinventoryRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
