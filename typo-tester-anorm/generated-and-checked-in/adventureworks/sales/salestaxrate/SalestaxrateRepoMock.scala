/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

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

class SalestaxrateRepoMock(toRow: Function1[SalestaxrateRowUnsaved, SalestaxrateRow],
                           map: scala.collection.mutable.Map[SalestaxrateId, SalestaxrateRow] = scala.collection.mutable.Map.empty) extends SalestaxrateRepo {
  override def delete: DeleteBuilder[SalestaxrateFields, SalestaxrateRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalestaxrateFields.structure.fields, map)
  }
  override def deleteById(salestaxrateid: SalestaxrateId)(implicit c: Connection): Boolean = {
    map.remove(salestaxrateid).isDefined
  }
  override def deleteByIds(salestaxrateids: Array[SalestaxrateId])(implicit c: Connection): Int = {
    salestaxrateids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: SalestaxrateRow)(implicit c: Connection): SalestaxrateRow = {
    val _ = if (map.contains(unsaved.salestaxrateid))
      sys.error(s"id ${unsaved.salestaxrateid} already exists")
    else
      map.put(unsaved.salestaxrateid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: SalestaxrateRowUnsaved)(implicit c: Connection): SalestaxrateRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[SalestaxrateRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.salestaxrateid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SalestaxrateRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.salestaxrateid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[SalestaxrateFields, SalestaxrateRow] = {
    SelectBuilderMock(SalestaxrateFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[SalestaxrateRow] = {
    map.values.toList
  }
  override def selectById(salestaxrateid: SalestaxrateId)(implicit c: Connection): Option[SalestaxrateRow] = {
    map.get(salestaxrateid)
  }
  override def selectByIds(salestaxrateids: Array[SalestaxrateId])(implicit c: Connection): List[SalestaxrateRow] = {
    salestaxrateids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(salestaxrateids: Array[SalestaxrateId])(implicit c: Connection): Map[SalestaxrateId, SalestaxrateRow] = {
    val byId = selectByIds(salestaxrateids).view.map(x => (x.salestaxrateid, x)).toMap
    salestaxrateids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[SalestaxrateFields, SalestaxrateRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalestaxrateFields.structure.fields, map)
  }
  override def update(row: SalestaxrateRow)(implicit c: Connection): Boolean = {
    map.get(row.salestaxrateid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.salestaxrateid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: SalestaxrateRow)(implicit c: Connection): SalestaxrateRow = {
    map.put(unsaved.salestaxrateid, unsaved): @nowarn
    unsaved
  }
}
