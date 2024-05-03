/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

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

class ProductvendorRepoMock(toRow: Function1[ProductvendorRowUnsaved, ProductvendorRow],
                            map: scala.collection.mutable.Map[ProductvendorId, ProductvendorRow] = scala.collection.mutable.Map.empty) extends ProductvendorRepo {
  override def delete: DeleteBuilder[ProductvendorFields, ProductvendorRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductvendorFields.structure.fields, map)
  }
  override def deleteById(compositeId: ProductvendorId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[ProductvendorId])(implicit c: Connection): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductvendorRowUnsaved)(implicit c: Connection): ProductvendorRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductvendorRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductvendorRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductvendorFields, ProductvendorRow] = {
    SelectBuilderMock(ProductvendorFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductvendorRow] = {
    map.values.toList
  }
  override def selectById(compositeId: ProductvendorId)(implicit c: Connection): Option[ProductvendorRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[ProductvendorId])(implicit c: Connection): List[ProductvendorRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(compositeIds: Array[ProductvendorId])(implicit c: Connection): Map[ProductvendorId, ProductvendorRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ProductvendorFields, ProductvendorRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductvendorFields.structure.fields, map)
  }
  override def update(row: ProductvendorRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
