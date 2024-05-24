/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

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

class ScrapreasonRepoMock(toRow: Function1[ScrapreasonRowUnsaved, ScrapreasonRow],
                          map: scala.collection.mutable.Map[ScrapreasonId, ScrapreasonRow] = scala.collection.mutable.Map.empty) extends ScrapreasonRepo {
  override def delete: DeleteBuilder[ScrapreasonFields, ScrapreasonRow] = {
    DeleteBuilderMock(DeleteParams.empty, ScrapreasonFields.structure, map)
  }
  override def deleteById(scrapreasonid: ScrapreasonId)(implicit c: Connection): Boolean = {
    map.remove(scrapreasonid).isDefined
  }
  override def deleteByIds(scrapreasonids: Array[ScrapreasonId])(implicit c: Connection): Int = {
    scrapreasonids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ScrapreasonRow)(implicit c: Connection): ScrapreasonRow = {
    val _ = if (map.contains(unsaved.scrapreasonid))
      sys.error(s"id ${unsaved.scrapreasonid} already exists")
    else
      map.put(unsaved.scrapreasonid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ScrapreasonRowUnsaved)(implicit c: Connection): ScrapreasonRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ScrapreasonRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.scrapreasonid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ScrapreasonRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.scrapreasonid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ScrapreasonFields, ScrapreasonRow] = {
    SelectBuilderMock(ScrapreasonFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ScrapreasonRow] = {
    map.values.toList
  }
  override def selectById(scrapreasonid: ScrapreasonId)(implicit c: Connection): Option[ScrapreasonRow] = {
    map.get(scrapreasonid)
  }
  override def selectByIds(scrapreasonids: Array[ScrapreasonId])(implicit c: Connection): List[ScrapreasonRow] = {
    scrapreasonids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(scrapreasonids: Array[ScrapreasonId])(implicit c: Connection): Map[ScrapreasonId, ScrapreasonRow] = {
    val byId = selectByIds(scrapreasonids).view.map(x => (x.scrapreasonid, x)).toMap
    scrapreasonids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ScrapreasonFields, ScrapreasonRow] = {
    UpdateBuilderMock(UpdateParams.empty, ScrapreasonFields.structure, map)
  }
  override def update(row: ScrapreasonRow)(implicit c: Connection): Boolean = {
    map.get(row.scrapreasonid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.scrapreasonid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ScrapreasonRow)(implicit c: Connection): ScrapreasonRow = {
    map.put(unsaved.scrapreasonid, unsaved): @nowarn
    unsaved
  }
}
