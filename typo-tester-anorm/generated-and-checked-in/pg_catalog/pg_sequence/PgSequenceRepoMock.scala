/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequence

import java.sql.Connection

class PgSequenceRepoMock(map: scala.collection.mutable.Map[PgSequenceId, PgSequenceRow] = scala.collection.mutable.Map.empty) extends PgSequenceRepo {
  override def delete(seqrelid: PgSequenceId)(implicit c: Connection): Boolean = {
    map.remove(seqrelid).isDefined
  }
  override def insert(unsaved: PgSequenceRow)(implicit c: Connection): PgSequenceRow = {
    if (map.contains(unsaved.seqrelid))
      sys.error(s"id ${unsaved.seqrelid} already exists")
    else
      map.put(unsaved.seqrelid, unsaved)
    unsaved
  }
  override def selectAll(implicit c: Connection): List[PgSequenceRow] = {
    map.values.toList
  }
  override def selectById(seqrelid: PgSequenceId)(implicit c: Connection): Option[PgSequenceRow] = {
    map.get(seqrelid)
  }
  override def selectByIds(seqrelids: Array[PgSequenceId])(implicit c: Connection): List[PgSequenceRow] = {
    seqrelids.flatMap(map.get).toList
  }
  override def update(row: PgSequenceRow)(implicit c: Connection): Boolean = {
    map.get(row.seqrelid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.seqrelid, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: PgSequenceRow)(implicit c: Connection): PgSequenceRow = {
    map.put(unsaved.seqrelid, unsaved)
    unsaved
  }
}