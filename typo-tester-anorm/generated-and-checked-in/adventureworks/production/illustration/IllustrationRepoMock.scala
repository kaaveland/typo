/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

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

class IllustrationRepoMock(toRow: Function1[IllustrationRowUnsaved, IllustrationRow],
                           map: scala.collection.mutable.Map[IllustrationId, IllustrationRow] = scala.collection.mutable.Map.empty) extends IllustrationRepo {
  override def delete: DeleteBuilder[IllustrationFields, IllustrationRow] = {
    DeleteBuilderMock(DeleteParams.empty, IllustrationFields.structure.fields, map)
  }
  override def deleteById(illustrationid: IllustrationId)(implicit c: Connection): Boolean = {
    map.remove(illustrationid).isDefined
  }
  override def deleteByIds(illustrationids: Array[IllustrationId])(implicit c: Connection): Int = {
    illustrationids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: IllustrationRow)(implicit c: Connection): IllustrationRow = {
    val _ = if (map.contains(unsaved.illustrationid))
      sys.error(s"id ${unsaved.illustrationid} already exists")
    else
      map.put(unsaved.illustrationid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: IllustrationRowUnsaved)(implicit c: Connection): IllustrationRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[IllustrationRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.illustrationid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[IllustrationRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.illustrationid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[IllustrationFields, IllustrationRow] = {
    SelectBuilderMock(IllustrationFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[IllustrationRow] = {
    map.values.toList
  }
  override def selectById(illustrationid: IllustrationId)(implicit c: Connection): Option[IllustrationRow] = {
    map.get(illustrationid)
  }
  override def selectByIds(illustrationids: Array[IllustrationId])(implicit c: Connection): List[IllustrationRow] = {
    illustrationids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(illustrationids: Array[IllustrationId])(implicit c: Connection): Map[IllustrationId, IllustrationRow] = {
    val byId = selectByIds(illustrationids).view.map(x => (x.illustrationid, x)).toMap
    illustrationids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[IllustrationFields, IllustrationRow] = {
    UpdateBuilderMock(UpdateParams.empty, IllustrationFields.structure.fields, map)
  }
  override def update(row: IllustrationRow)(implicit c: Connection): Boolean = {
    map.get(row.illustrationid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.illustrationid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: IllustrationRow)(implicit c: Connection): IllustrationRow = {
    map.put(unsaved.illustrationid, unsaved): @nowarn
    unsaved
  }
}
