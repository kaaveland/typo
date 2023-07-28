/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_collation

import java.sql.Connection

class PgCollationRepoMock(map: scala.collection.mutable.Map[PgCollationId, PgCollationRow] = scala.collection.mutable.Map.empty) extends PgCollationRepo {
  override def delete(oid: PgCollationId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def insert(unsaved: PgCollationRow)(implicit c: Connection): PgCollationRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def selectAll(implicit c: Connection): List[PgCollationRow] = {
    map.values.toList
  }
  override def selectById(oid: PgCollationId)(implicit c: Connection): Option[PgCollationRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgCollationId])(implicit c: Connection): List[PgCollationRow] = {
    oids.flatMap(map.get).toList
  }
  override def update(row: PgCollationRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: PgCollationRow)(implicit c: Connection): PgCollationRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}