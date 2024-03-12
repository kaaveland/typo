/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

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

class SpecialofferRepoMock(toRow: Function1[SpecialofferRowUnsaved, SpecialofferRow],
                           map: scala.collection.mutable.Map[SpecialofferId, SpecialofferRow] = scala.collection.mutable.Map.empty) extends SpecialofferRepo {
  override def delete(specialofferid: SpecialofferId)(implicit c: Connection): Boolean = {
    map.remove(specialofferid).isDefined
  }
  override def delete: DeleteBuilder[SpecialofferFields, SpecialofferRow] = {
    DeleteBuilderMock(DeleteParams.empty, SpecialofferFields.structure.fields, map)
  }
  override def insert(unsaved: SpecialofferRow)(implicit c: Connection): SpecialofferRow = {
    val _ = if (map.contains(unsaved.specialofferid))
      sys.error(s"id ${unsaved.specialofferid} already exists")
    else
      map.put(unsaved.specialofferid, unsaved)
    
    unsaved
  }
  override def insertStreaming(unsaved: Iterator[SpecialofferRow], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.specialofferid -> row)
    }
    unsaved.size.toLong
  }
  override def insert(unsaved: SpecialofferRowUnsaved)(implicit c: Connection): SpecialofferRow = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SpecialofferRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.specialofferid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[SpecialofferFields, SpecialofferRow] = {
    SelectBuilderMock(SpecialofferFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[SpecialofferRow] = {
    map.values.toList
  }
  override def selectById(specialofferid: SpecialofferId)(implicit c: Connection): Option[SpecialofferRow] = {
    map.get(specialofferid)
  }
  override def selectByIds(specialofferids: Array[SpecialofferId])(implicit c: Connection): List[SpecialofferRow] = {
    specialofferids.flatMap(map.get).toList
  }
  override def update(row: SpecialofferRow)(implicit c: Connection): Boolean = {
    map.get(row.specialofferid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.specialofferid, row): @nowarn
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[SpecialofferFields, SpecialofferRow] = {
    UpdateBuilderMock(UpdateParams.empty, SpecialofferFields.structure.fields, map)
  }
  override def upsert(unsaved: SpecialofferRow)(implicit c: Connection): SpecialofferRow = {
    map.put(unsaved.specialofferid, unsaved): @nowarn
    unsaved
  }
}
