/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

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

class PersonphoneRepoMock(toRow: Function1[PersonphoneRowUnsaved, PersonphoneRow],
                          map: scala.collection.mutable.Map[PersonphoneId, PersonphoneRow] = scala.collection.mutable.Map.empty) extends PersonphoneRepo {
  override def delete: DeleteBuilder[PersonphoneFields, PersonphoneRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersonphoneFields.structure.fields, map)
  }
  override def deleteById(compositeId: PersonphoneId)(implicit c: Connection): Boolean = {
    map.remove(compositeId).isDefined
  }
  override def deleteByIds(compositeIds: Array[PersonphoneId])(implicit c: Connection): Int = {
    compositeIds.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: PersonphoneRow)(implicit c: Connection): PersonphoneRow = {
    val _ = if (map.contains(unsaved.compositeId))
      sys.error(s"id ${unsaved.compositeId} already exists")
    else
      map.put(unsaved.compositeId, unsaved)
    
    unsaved
  }
  override def insert(unsaved: PersonphoneRowUnsaved)(implicit c: Connection): PersonphoneRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[PersonphoneRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[PersonphoneRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.compositeId -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[PersonphoneFields, PersonphoneRow] = {
    SelectBuilderMock(PersonphoneFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PersonphoneRow] = {
    map.values.toList
  }
  override def selectById(compositeId: PersonphoneId)(implicit c: Connection): Option[PersonphoneRow] = {
    map.get(compositeId)
  }
  override def selectByIds(compositeIds: Array[PersonphoneId])(implicit c: Connection): List[PersonphoneRow] = {
    compositeIds.flatMap(map.get).toList
  }
  override def selectByIdsTracked(compositeIds: Array[PersonphoneId])(implicit c: Connection): Map[PersonphoneId, Option[PersonphoneRow]] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[PersonphoneFields, PersonphoneRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersonphoneFields.structure.fields, map)
  }
  override def update(row: PersonphoneRow)(implicit c: Connection): Boolean = {
    map.get(row.compositeId) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.compositeId, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: PersonphoneRow)(implicit c: Connection): PersonphoneRow = {
    map.put(unsaved.compositeId, unsaved): @nowarn
    unsaved
  }
}
