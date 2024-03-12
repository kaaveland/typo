/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

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

class SalesterritoryhistoryRepoMock(toRow: Function1[SalesterritoryhistoryRowUnsaved, SalesterritoryhistoryRow],
                                    map: scala.collection.mutable.Map[SalesterritoryhistoryId, SalesterritoryhistoryRow] = scala.collection.mutable.Map.empty) extends SalesterritoryhistoryRepo {
  override def delete(compositeId: SalesterritoryhistoryId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def delete: DeleteBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalesterritoryhistoryFields.structure.fields, map)
  }
  override def insert(unsaved: SalesterritoryhistoryRow)(implicit c: Connection): SalesterritoryhistoryRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[SalesterritoryhistoryRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def insert(unsaved: SalesterritoryhistoryRowUnsaved)(implicit c: Connection): SalesterritoryhistoryRow = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SalesterritoryhistoryRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    SelectBuilderMock(SalesterritoryhistoryFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[SalesterritoryhistoryRow] = {
    map.values.toList
  }
  override def selectById(compositeId: SalesterritoryhistoryId)(implicit c: Connection): Option[SalesterritoryhistoryRow] = {
    map.get(compositeId)
  }
  override def update(row: SalesterritoryhistoryRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalesterritoryhistoryFields.structure.fields, map)
  }
  override def upsert(unsaved: SalesterritoryhistoryRow)(implicit c: Connection): SalesterritoryhistoryRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
