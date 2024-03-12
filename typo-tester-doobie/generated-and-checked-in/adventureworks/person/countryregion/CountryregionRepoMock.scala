/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

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

class CountryregionRepoMock(toRow: Function1[CountryregionRowUnsaved, CountryregionRow],
                            map: scala.collection.mutable.Map[CountryregionId, CountryregionRow] = scala.collection.mutable.Map.empty) extends CountryregionRepo {
  override def delete(countryregioncode: CountryregionId): ConnectionIO[Boolean] = {
    delay(map.remove(countryregioncode).isDefined)
  }
  override def delete: DeleteBuilder[CountryregionFields, CountryregionRow] = {
    DeleteBuilderMock(DeleteParams.empty, CountryregionFields.structure.fields, map)
  }
  override def insert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow] = {
    delay {
      val _ = if (map.contains(unsaved.countryregioncode))
        sys.error(s"id ${unsaved.countryregioncode} already exists")
      else
        map.put(unsaved.countryregioncode, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CountryregionRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.countryregioncode -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: CountryregionRowUnsaved): ConnectionIO[CountryregionRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CountryregionRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.countryregioncode -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[CountryregionFields, CountryregionRow] = {
    SelectBuilderMock(CountryregionFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, CountryregionRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(countryregioncode: CountryregionId): ConnectionIO[Option[CountryregionRow]] = {
    delay(map.get(countryregioncode))
  }
  override def selectByIds(countryregioncodes: Array[CountryregionId]): Stream[ConnectionIO, CountryregionRow] = {
    Stream.emits(countryregioncodes.flatMap(map.get).toList)
  }
  override def update(row: CountryregionRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.countryregioncode) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.countryregioncode, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[CountryregionFields, CountryregionRow] = {
    UpdateBuilderMock(UpdateParams.empty, CountryregionFields.structure.fields, map)
  }
  override def upsert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow] = {
    delay {
      map.put(unsaved.countryregioncode, unsaved): @nowarn
      unsaved
    }
  }
}
