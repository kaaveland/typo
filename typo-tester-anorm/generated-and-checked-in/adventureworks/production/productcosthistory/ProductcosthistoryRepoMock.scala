/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

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

class ProductcosthistoryRepoMock(toRow: Function1[ProductcosthistoryRowUnsaved, ProductcosthistoryRow],
                                 map: scala.collection.mutable.Map[ProductcosthistoryId, ProductcosthistoryRow] = scala.collection.mutable.Map.empty) extends ProductcosthistoryRepo {
  override def delete: DeleteBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductcosthistoryFields.structure.fields, map)
  }
  override def deleteById(compositeId: ProductcosthistoryId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[ProductcosthistoryId])(implicit c: Connection): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductcosthistoryRowUnsaved)(implicit c: Connection): ProductcosthistoryRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductcosthistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductcosthistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    SelectBuilderMock(ProductcosthistoryFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductcosthistoryRow] = {
    map.values.toList
  }
  override def selectById(compositeId: ProductcosthistoryId)(implicit c: Connection): Option[ProductcosthistoryRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[ProductcosthistoryId])(implicit c: Connection): List[ProductcosthistoryRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(compositeIds: Array[ProductcosthistoryId])(implicit c: Connection): Map[ProductcosthistoryId, ProductcosthistoryRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductcosthistoryFields.structure.fields, map)
  }
  override def update(row: ProductcosthistoryRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
