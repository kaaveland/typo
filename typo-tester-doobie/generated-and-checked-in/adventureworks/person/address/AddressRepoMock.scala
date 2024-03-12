/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

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

class AddressRepoMock(toRow: Function1[AddressRowUnsaved, AddressRow],
                      map: scala.collection.mutable.Map[AddressId, AddressRow] = scala.collection.mutable.Map.empty) extends AddressRepo {
  override def delete(addressid: AddressId): ConnectionIO[Boolean] = {
    delay(map.remove(addressid).isDefined)
  }
  override def delete: DeleteBuilder[AddressFields, AddressRow] = {
    DeleteBuilderMock(DeleteParams.empty, AddressFields.structure.fields, map)
  }
  override def insert(unsaved: AddressRow): ConnectionIO[AddressRow] = {
    delay {
      val _ = if (map.contains(unsaved.addressid))
        sys.error(s"id ${unsaved.addressid} already exists")
      else
        map.put(unsaved.addressid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, AddressRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.addressid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: AddressRowUnsaved): ConnectionIO[AddressRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, AddressRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.addressid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[AddressFields, AddressRow] = {
    SelectBuilderMock(AddressFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, AddressRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(addressid: AddressId): ConnectionIO[Option[AddressRow]] = {
    delay(map.get(addressid))
  }
  override def selectByIds(addressids: Array[AddressId]): Stream[ConnectionIO, AddressRow] = {
    Stream.emits(addressids.flatMap(map.get).toList)
  }
  override def update(row: AddressRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.addressid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.addressid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[AddressFields, AddressRow] = {
    UpdateBuilderMock(UpdateParams.empty, AddressFields.structure.fields, map)
  }
  override def upsert(unsaved: AddressRow): ConnectionIO[AddressRow] = {
    delay {
      map.put(unsaved.addressid, unsaved): @nowarn
      unsaved
    }
  }
}
