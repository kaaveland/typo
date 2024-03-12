/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.customtypes.TypoUUID
import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream
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

class DocumentRepoMock(toRow: Function1[DocumentRowUnsaved, DocumentRow],
                       map: scala.collection.mutable.Map[DocumentId, DocumentRow] = scala.collection.mutable.Map.empty) extends DocumentRepo {
  override def delete(documentnode: DocumentId): ConnectionIO[Boolean] = {
    delay(map.remove(documentnode).isDefined)
  }
  override def delete: DeleteBuilder[DocumentFields, DocumentRow] = {
    DeleteBuilderMock(DeleteParams.empty, DocumentFields.structure.fields, map)
  }
  override def insert(unsaved: DocumentRow): ConnectionIO[DocumentRow] = {
    delay {
      val _ = if (map.contains(unsaved.documentnode))
        sys.error(s"id ${unsaved.documentnode} already exists")
      else
        map.put(unsaved.documentnode, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, DocumentRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.documentnode -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: DocumentRowUnsaved): ConnectionIO[DocumentRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, DocumentRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.documentnode -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[DocumentFields, DocumentRow] = {
    SelectBuilderMock(DocumentFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, DocumentRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(documentnode: DocumentId): ConnectionIO[Option[DocumentRow]] = {
    delay(map.get(documentnode))
  }
  override def selectByIds(documentnodes: Array[DocumentId]): Stream[ConnectionIO, DocumentRow] = {
    Stream.emits(documentnodes.flatMap(map.get).toList)
  }
  override def selectByUnique(rowguid: TypoUUID): ConnectionIO[Option[DocumentRow]] = {
    delay(map.values.find(v => rowguid == v.rowguid))
  }
  override def update(row: DocumentRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.documentnode) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.documentnode, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[DocumentFields, DocumentRow] = {
    UpdateBuilderMock(UpdateParams.empty, DocumentFields.structure.fields, map)
  }
  override def upsert(unsaved: DocumentRow): ConnectionIO[DocumentRow] = {
    delay {
      map.put(unsaved.documentnode, unsaved): @nowarn
      unsaved
    }
  }
}
