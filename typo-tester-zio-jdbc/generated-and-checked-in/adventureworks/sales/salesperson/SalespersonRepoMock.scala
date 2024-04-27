/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.person.businessentity.BusinessentityId
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

class SalespersonRepoMock(toRow: Function1[SalespersonRowUnsaved, SalespersonRow],
                          map: scala.collection.mutable.Map[BusinessentityId, SalespersonRow] = scala.collection.mutable.Map.empty) extends SalespersonRepo {
  override def delete: DeleteBuilder[SalespersonFields, SalespersonRow] = {
    DeleteBuilderMock(DeleteParams.empty, SalespersonFields.structure.fields, map)
  }
  override def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(businessentityid).isDefined)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(businessentityids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: SalespersonRow): ZIO[ZConnection, Throwable, SalespersonRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.businessentityid))
          sys.error(s"id ${unsaved.businessentityid} already exists")
        else
          map.put(unsaved.businessentityid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: SalespersonRowUnsaved): ZIO[ZConnection, Throwable, SalespersonRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalespersonRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalespersonRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[SalespersonFields, SalespersonRow] = {
    SelectBuilderMock(SalespersonFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalespersonRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[SalespersonRow]] = {
    ZIO.succeed(map.get(businessentityid))
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, SalespersonRow] = {
    ZStream.fromIterable(businessentityids.flatMap(map.get))
  }
  override def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, Option[SalespersonRow]]] = {
    selectByIds(businessentityids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[SalespersonFields, SalespersonRow] = {
    UpdateBuilderMock(UpdateParams.empty, SalespersonFields.structure.fields, map)
  }
  override def update(row: SalespersonRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.businessentityid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.businessentityid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: SalespersonRow): ZIO[ZConnection, Throwable, UpdateResult[SalespersonRow]] = {
    ZIO.succeed {
      map.put(unsaved.businessentityid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
