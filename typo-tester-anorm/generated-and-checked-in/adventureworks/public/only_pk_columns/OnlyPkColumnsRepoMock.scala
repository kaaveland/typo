/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package only_pk_columns

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

class OnlyPkColumnsRepoMock(map: scala.collection.mutable.Map[OnlyPkColumnsId, OnlyPkColumnsRow] = scala.collection.mutable.Map.empty) extends OnlyPkColumnsRepo {
  override def delete: DeleteBuilder[OnlyPkColumnsFields, OnlyPkColumnsRow] = {
    DeleteBuilderMock(DeleteParams.empty, OnlyPkColumnsFields.structure, map)
  }
  override def deleteById(compositeId: OnlyPkColumnsId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[OnlyPkColumnsId])(implicit c: Connection): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: OnlyPkColumnsRow)(implicit c: Connection): OnlyPkColumnsRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[OnlyPkColumnsRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[OnlyPkColumnsFields, OnlyPkColumnsRow] = {
    SelectBuilderMock(OnlyPkColumnsFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[OnlyPkColumnsRow] = {
    map.values.toList
  }
  override def selectById(compositeId: OnlyPkColumnsId)(implicit c: Connection): Option[OnlyPkColumnsRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[OnlyPkColumnsId])(implicit c: Connection): List[OnlyPkColumnsRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(compositeIds: Array[OnlyPkColumnsId])(implicit c: Connection): Map[OnlyPkColumnsId, OnlyPkColumnsRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[OnlyPkColumnsFields, OnlyPkColumnsRow] = {
    UpdateBuilderMock(UpdateParams.empty, OnlyPkColumnsFields.structure, map)
  }
  override def upsert(unsaved: OnlyPkColumnsRow)(implicit c: Connection): OnlyPkColumnsRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
  override def upsertBatch(unsaved: Iterable[OnlyPkColumnsRow])(implicit c: Connection): List[OnlyPkColumnsRow] = {
    unsaved.map { row =>
      map += (row.compositeId -> row)
      row
    }.toList
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[OnlyPkColumnsRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size
  }
}
