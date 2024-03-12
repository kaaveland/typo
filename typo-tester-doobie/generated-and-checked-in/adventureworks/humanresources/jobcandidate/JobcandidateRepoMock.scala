/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

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

class JobcandidateRepoMock(toRow: Function1[JobcandidateRowUnsaved, JobcandidateRow],
                           map: scala.collection.mutable.Map[JobcandidateId, JobcandidateRow] = scala.collection.mutable.Map.empty) extends JobcandidateRepo {
  override def delete(jobcandidateid: JobcandidateId): ConnectionIO[Boolean] = {
    delay(map.remove(jobcandidateid).isDefined)
  }
  override def delete: DeleteBuilder[JobcandidateFields, JobcandidateRow] = {
    DeleteBuilderMock(DeleteParams.empty, JobcandidateFields.structure.fields, map)
  }
  override def insert(unsaved: JobcandidateRow): ConnectionIO[JobcandidateRow] = {
    delay {
      val _ = if (map.contains(unsaved.jobcandidateid))
        sys.error(s"id ${unsaved.jobcandidateid} already exists")
      else
        map.put(unsaved.jobcandidateid, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, JobcandidateRow], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { rows =>
      var num = 0L
      rows.foreach { row =>
        map += (row.jobcandidateid -> row)
        num += 1
      }
      num
    }
  }
  override def insert(unsaved: JobcandidateRowUnsaved): ConnectionIO[JobcandidateRow] = {
    insert(toRow(unsaved))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, JobcandidateRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    unsaved.compile.toList.map { unsavedRows =>
      var num = 0L
      unsavedRows.foreach { unsavedRow =>
        val row = toRow(unsavedRow)
        map += (row.jobcandidateid -> row)
        num += 1
      }
      num
    }
  }
  override def select: SelectBuilder[JobcandidateFields, JobcandidateRow] = {
    SelectBuilderMock(JobcandidateFields.structure, delay(map.values.toList), SelectParams.empty)
  }
  override def selectAll: Stream[ConnectionIO, JobcandidateRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectById(jobcandidateid: JobcandidateId): ConnectionIO[Option[JobcandidateRow]] = {
    delay(map.get(jobcandidateid))
  }
  override def selectByIds(jobcandidateids: Array[JobcandidateId]): Stream[ConnectionIO, JobcandidateRow] = {
    Stream.emits(jobcandidateids.flatMap(map.get).toList)
  }
  override def update(row: JobcandidateRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.jobcandidateid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.jobcandidateid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[JobcandidateFields, JobcandidateRow] = {
    UpdateBuilderMock(UpdateParams.empty, JobcandidateFields.structure.fields, map)
  }
  override def upsert(unsaved: JobcandidateRow): ConnectionIO[JobcandidateRow] = {
    delay {
      map.put(unsaved.jobcandidateid, unsaved): @nowarn
      unsaved
    }
  }
}
