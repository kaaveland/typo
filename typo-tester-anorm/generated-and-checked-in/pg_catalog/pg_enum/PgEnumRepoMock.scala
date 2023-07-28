/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_enum

import java.sql.Connection

class PgEnumRepoMock(map: scala.collection.mutable.Map[PgEnumId, PgEnumRow] = scala.collection.mutable.Map.empty) extends PgEnumRepo {
  override def delete(oid: PgEnumId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def insert(unsaved: PgEnumRow)(implicit c: Connection): PgEnumRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def selectAll(implicit c: Connection): List[PgEnumRow] = {
    map.values.toList
  }
  override def selectById(oid: PgEnumId)(implicit c: Connection): Option[PgEnumRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgEnumId])(implicit c: Connection): List[PgEnumRow] = {
    oids.flatMap(map.get).toList
  }
  override def update(row: PgEnumRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: PgEnumRow)(implicit c: Connection): PgEnumRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}