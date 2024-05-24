/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

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

class PhonenumbertypeRepoMock(toRow: Function1[PhonenumbertypeRowUnsaved, PhonenumbertypeRow],
                              map: scala.collection.mutable.Map[PhonenumbertypeId, PhonenumbertypeRow] = scala.collection.mutable.Map.empty) extends PhonenumbertypeRepo {
  override def delete: DeleteBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    DeleteBuilderMock(DeleteParams.empty, PhonenumbertypeFields.structure, map)
  }
  override def deleteById(phonenumbertypeid: PhonenumbertypeId): ConnectionIO[Boolean] = {
    delay(map.remove(phonenumbertypeid).isDefined)
  }
  override def deleteByIds(phonenumbertypeids: Array[PhonenumbertypeId]): ConnectionIO[Int] = {
    delay(phonenumbertypeids.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: PhonenumbertypeRow): ConnectionIO[PhonenumbertypeRow] = {
    delay {
      val _ = if (map.contains(unsaved.phonenumbertypeid))
        sys.error(s"id ${unsaved.phonenumbertypeid} already exists")
      else
        map.put(unsaved.phonenumbertypeid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: PhonenumbertypeRowUnsaved): ConnectionIO[PhonenumbertypeRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PhonenumbertypeRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.phonenumbertypeid -> row)
        num += 1
      }
      num
    }
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PhonenumbertypeRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.phonenumbertypeid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    SelectBuilderMock(PhonenumbertypeFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, PhonenumbertypeRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(phonenumbertypeid: PhonenumbertypeId): ConnectionIO[Option[PhonenumbertypeRow]] = {
    delay(map.get(phonenumbertypeid))
  }
  override def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId]): Stream[ConnectionIO, PhonenumbertypeRow] = {
    Stream.emits(phonenumbertypeids.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(phonenumbertypeids: Array[PhonenumbertypeId]): ConnectionIO[Map[PhonenumbertypeId, PhonenumbertypeRow]] = {
    selectByIds(phonenumbertypeids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.phonenumbertypeid, x)).toMap
      phonenumbertypeids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[PhonenumbertypeFields, PhonenumbertypeRow] = {
    UpdateBuilderMock(UpdateParams.empty, PhonenumbertypeFields.structure, map)
  }
  override def update(row: PhonenumbertypeRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.phonenumbertypeid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.phonenumbertypeid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: PhonenumbertypeRow): ConnectionIO[PhonenumbertypeRow] = {
    delay {
      map.put(unsaved.phonenumbertypeid, unsaved): @nowarn
      unsaved
    }
  }
}
