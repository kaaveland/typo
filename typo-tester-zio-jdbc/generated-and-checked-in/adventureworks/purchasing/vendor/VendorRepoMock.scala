/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

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

class VendorRepoMock(toRow: Function1[VendorRowUnsaved, VendorRow],
                     map: scala.collection.mutable.Map[BusinessentityId, VendorRow] = scala.collection.mutable.Map.empty) extends VendorRepo {
  override def delete(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(businessentityid).isDefined)
  }
  override def delete: DeleteBuilder[VendorFields, VendorRow] = {
    DeleteBuilderMock(DeleteParams.empty, VendorFields.structure.fields, map)
  }
  override def insert(unsaved: VendorRow): ZIO[ZConnection, Throwable, VendorRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.businessentityid))
          sys.error(s"id ${unsaved.businessentityid} already exists")
        else
          map.put(unsaved.businessentityid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, VendorRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def insert(unsaved: VendorRowUnsaved): ZIO[ZConnection, Throwable, VendorRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, VendorRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.businessentityid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[VendorFields, VendorRow] = {
    SelectBuilderMock(VendorFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VendorRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[VendorRow]] = {
    ZIO.succeed(map.get(businessentityid))
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, VendorRow] = {
    ZStream.fromIterable(businessentityids.flatMap(map.get))
  }
  override def update(row: VendorRow): ZIO[ZConnection, Throwable, Boolean] = {
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
  override def update: UpdateBuilder[VendorFields, VendorRow] = {
    UpdateBuilderMock(UpdateParams.empty, VendorFields.structure.fields, map)
  }
  override def upsert(unsaved: VendorRow): ZIO[ZConnection, Throwable, UpdateResult[VendorRow]] = {
    ZIO.succeed {
      map.put(unsaved.businessentityid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
