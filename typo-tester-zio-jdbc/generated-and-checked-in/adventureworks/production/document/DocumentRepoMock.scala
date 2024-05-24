/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.customtypes.TypoUUID
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
import zio.Chunk
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

class DocumentRepoMock(toRow: Function1[DocumentRowUnsaved, DocumentRow],
                       map: scala.collection.mutable.Map[DocumentId, DocumentRow] = scala.collection.mutable.Map.empty) extends DocumentRepo {
  override def delete: DeleteBuilder[DocumentFields, DocumentRow] = {
    DeleteBuilderMock(DeleteParams.empty, DocumentFields.structure, map)
  }
  override def deleteById(documentnode: DocumentId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(documentnode).isDefined)
  }
  override def deleteByIds(documentnodes: Array[DocumentId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(documentnodes.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: DocumentRow): ZIO[ZConnection, Throwable, DocumentRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.documentnode))
          sys.error(s"id ${unsaved.documentnode} already exists")
        else
          map.put(unsaved.documentnode, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: DocumentRowUnsaved): ZIO[ZConnection, Throwable, DocumentRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, DocumentRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.documentnode -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, DocumentRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.documentnode -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[DocumentFields, DocumentRow] = {
    SelectBuilderMock(DocumentFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, DocumentRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(documentnode: DocumentId): ZIO[ZConnection, Throwable, Option[DocumentRow]] = {
    ZIO.succeed(map.get(documentnode))
  }
  override def selectByIds(documentnodes: Array[DocumentId]): ZStream[ZConnection, Throwable, DocumentRow] = {
    ZStream.fromIterable(documentnodes.flatMap(map.get))
  }
  override def selectByIdsTracked(documentnodes: Array[DocumentId]): ZIO[ZConnection, Throwable, Map[DocumentId, DocumentRow]] = {
    selectByIds(documentnodes).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.documentnode, x)).toMap
      documentnodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def selectByUniqueRowguid(rowguid: TypoUUID): ZIO[ZConnection, Throwable, Option[DocumentRow]] = {
    ZIO.succeed(map.values.find(v => rowguid == v.rowguid))
  }
  override def update: UpdateBuilder[DocumentFields, DocumentRow] = {
    UpdateBuilderMock(UpdateParams.empty, DocumentFields.structure, map)
  }
  override def update(row: DocumentRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.documentnode) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.documentnode, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: DocumentRow): ZIO[ZConnection, Throwable, UpdateResult[DocumentRow]] = {
    ZIO.succeed {
      map.put(unsaved.documentnode, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
