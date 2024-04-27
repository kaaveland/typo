/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

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

class ProductmodelillustrationRepoMock(toRow: Function1[ProductmodelillustrationRowUnsaved, ProductmodelillustrationRow],
                                       map: scala.collection.mutable.Map[ProductmodelillustrationId, ProductmodelillustrationRow] = scala.collection.mutable.Map.empty) extends ProductmodelillustrationRepo {
  override def delete: DeleteBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductmodelillustrationFields.structure.fields, map)
  }
  override def deleteById(compositeId: ProductmodelillustrationId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[ProductmodelillustrationId])(implicit c: Connection): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductmodelillustrationRow)(implicit c: Connection): ProductmodelillustrationRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductmodelillustrationRowUnsaved)(implicit c: Connection): ProductmodelillustrationRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductmodelillustrationRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductmodelillustrationRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    SelectBuilderMock(ProductmodelillustrationFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductmodelillustrationRow] = {
    map.values.toList
  }
  override def selectById(compositeId: ProductmodelillustrationId)(implicit c: Connection): Option[ProductmodelillustrationRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[ProductmodelillustrationId])(implicit c: Connection): List[ProductmodelillustrationRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(compositeIds: Array[ProductmodelillustrationId])(implicit c: Connection): Map[ProductmodelillustrationId, Option[ProductmodelillustrationRow]] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[ProductmodelillustrationFields, ProductmodelillustrationRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductmodelillustrationFields.structure.fields, map)
  }
  override def update(row: ProductmodelillustrationRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductmodelillustrationRow)(implicit c: Connection): ProductmodelillustrationRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
