/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package issue142

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

class Issue142RepoMock(map: scala.collection.mutable.Map[Issue142Id, Issue142Row] = scala.collection.mutable.Map.empty) extends Issue142Repo {
  override def delete: DeleteBuilder[Issue142Fields, Issue142Row] = {
    DeleteBuilderMock(DeleteParams.empty, Issue142Fields.structure, map)
  }
  override def deleteById(tabellkode: Issue142Id): ConnectionIO[Boolean] = {
    delay(map.remove(tabellkode).isDefined)
  }
  override def deleteByIds(tabellkodes: Array[Issue142Id]): ConnectionIO[Int] = {
    delay(tabellkodes.map(id => map.remove(id)).count(_.isDefined))
  }
  override def insert(unsaved: Issue142Row): ConnectionIO[Issue142Row] = {
    delay {
      val _ = if (map.contains(unsaved.tabellkode))
        sys.error(s"id ${unsaved.tabellkode} already exists")
      else
        map.put(unsaved.tabellkode, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, Issue142Row], batchSize: Int = 10000): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.tabellkode -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[Issue142Fields, Issue142Row] = {
    SelectBuilderMock(Issue142Fields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, Issue142Row] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(tabellkode: Issue142Id): ConnectionIO[Option[Issue142Row]] = {
    delay(map.get(tabellkode))
  }
  override def selectByIds(tabellkodes: Array[Issue142Id]): Stream[ConnectionIO, Issue142Row] = {
    Stream.emits(tabellkodes.flatMap(map.get).toList)
  }
  override def selectByIdsTracked(tabellkodes: Array[Issue142Id]): ConnectionIO[Map[Issue142Id, Issue142Row]] = {
    selectByIds(tabellkodes).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.tabellkode, x)).toMap
      tabellkodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[Issue142Fields, Issue142Row] = {
    UpdateBuilderMock(UpdateParams.empty, Issue142Fields.structure, map)
  }
  override def upsert(unsaved: Issue142Row): ConnectionIO[Issue142Row] = {
    delay {
      map.put(unsaved.tabellkode, unsaved): @nowarn
      unsaved
    }
  }
  override def upsertBatch(unsaved: List[Issue142Row]): Stream[ConnectionIO, Issue142Row] = {
    Stream.emits {
      unsaved.map { row =>
        map += (row.tabellkode -> row)
        row
      }
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, Issue142Row], batchSize: Int = 10000): ConnectionIO[Int] = {
    unsaved.compile.toList.map { rows =>
      var num = 0
      rows.foreach { row =>
        map += (row.tabellkode -> row)
        num += 1
      }
      num
    }
  }
}