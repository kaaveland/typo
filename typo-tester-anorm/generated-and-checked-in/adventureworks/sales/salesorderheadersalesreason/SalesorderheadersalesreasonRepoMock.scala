/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

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

class SalesorderheadersalesreasonRepoMock(toRow: Function1[SalesorderheadersalesreasonRowUnsaved, SalesorderheadersalesreasonRow],
                                          map: scala.collection.mutable.Map[SalesorderheadersalesreasonId, SalesorderheadersalesreasonRow] = scala.collection.mutable.Map.empty) extends SalesorderheadersalesreasonRepo {
  override def delete: DeleteBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesorderheadersalesreasonFields.structure, map)
  }
  override def deleteById(compositeId: SalesorderheadersalesreasonId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[SalesorderheadersalesreasonId])(implicit c: Connection): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: SalesorderheadersalesreasonRow)(implicit c: Connection): SalesorderheadersalesreasonRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insert(unsaved: SalesorderheadersalesreasonRowUnsaved)(implicit c: Connection): SalesorderheadersalesreasonRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[SalesorderheadersalesreasonRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SalesorderheadersalesreasonRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    SelectBuilderMock(SalesorderheadersalesreasonFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[SalesorderheadersalesreasonRow] = {
    map.values.toList
  }
  override def selectById(compositeId: SalesorderheadersalesreasonId)(implicit c: Connection): Option[SalesorderheadersalesreasonRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[SalesorderheadersalesreasonId])(implicit c: Connection): List[SalesorderheadersalesreasonRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(compositeIds: Array[SalesorderheadersalesreasonId])(implicit c: Connection): Map[SalesorderheadersalesreasonId, SalesorderheadersalesreasonRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[SalesorderheadersalesreasonFields, SalesorderheadersalesreasonRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesorderheadersalesreasonFields.structure, map)
  }
  override def update(row: SalesorderheadersalesreasonRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: SalesorderheadersalesreasonRow)(implicit c: Connection): SalesorderheadersalesreasonRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
