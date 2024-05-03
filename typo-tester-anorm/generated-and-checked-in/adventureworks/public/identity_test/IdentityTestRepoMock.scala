/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

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

class IdentityTestRepoMock(toRow: Function1[IdentityTestRowUnsaved, IdentityTestRow],
                           map: scala.collection.mutable.Map[IdentityTestId, IdentityTestRow] = scala.collection.mutable.Map.empty) extends IdentityTestRepo {
  override def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow] = {
    DeleteBuilderMock(DeleteParams.empty, IdentityTestFields.structure.fields, map)
  }
  override def deleteById(name: IdentityTestId)(implicit c: Connection): Boolean = {
    map.remove(name).isDefined
  }
  override def deleteByIds(names: Array[IdentityTestId])(implicit c: Connection): Int = {
    names.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: IdentityTestRow)(implicit c: Connection): IdentityTestRow = {
    val _ = if (map.contains(unsaved.name))
      sys.error(s"id ${unsaved.name} already exists")
    else
      map.put(unsaved.name, unsaved)
    
    unsaved
  }
  override def insert(unsaved: IdentityTestRowUnsaved)(implicit c: Connection): IdentityTestRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[IdentityTestRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.name -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[IdentityTestRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.name -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[IdentityTestFields, IdentityTestRow] = {
    SelectBuilderMock(IdentityTestFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[IdentityTestRow] = {
    map.values.toList
  }
  override def selectById(name: IdentityTestId)(implicit c: Connection): Option[IdentityTestRow] = {
    map.get(name)
  }
  override def selectByIds(names: Array[IdentityTestId])(implicit c: Connection): List[IdentityTestRow] = {
    names.flatMap(map.get).toList
  }
  override def selectByIdsTracked(names: Array[IdentityTestId])(implicit c: Connection): Map[IdentityTestId, IdentityTestRow] = {
    val byId = selectByIds(names).view.map(x => (x.name, x)).toMap
    names.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[IdentityTestFields, IdentityTestRow] = {
    UpdateBuilderMock(UpdateParams.empty, IdentityTestFields.structure.fields, map)
  }
  override def update(row: IdentityTestRow)(implicit c: Connection): Boolean = {
    map.get(row.name) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.name, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: IdentityTestRow)(implicit c: Connection): IdentityTestRow = {
    map.put(unsaved.name, unsaved): @nowarn
    unsaved
  }
}
