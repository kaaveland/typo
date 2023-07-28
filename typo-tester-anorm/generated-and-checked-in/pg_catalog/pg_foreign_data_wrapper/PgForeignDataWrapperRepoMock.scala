/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_data_wrapper

import java.sql.Connection

class PgForeignDataWrapperRepoMock(map: scala.collection.mutable.Map[PgForeignDataWrapperId, PgForeignDataWrapperRow] = scala.collection.mutable.Map.empty) extends PgForeignDataWrapperRepo {
  override def delete(oid: PgForeignDataWrapperId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def insert(unsaved: PgForeignDataWrapperRow)(implicit c: Connection): PgForeignDataWrapperRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def selectAll(implicit c: Connection): List[PgForeignDataWrapperRow] = {
    map.values.toList
  }
  override def selectById(oid: PgForeignDataWrapperId)(implicit c: Connection): Option[PgForeignDataWrapperRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgForeignDataWrapperId])(implicit c: Connection): List[PgForeignDataWrapperRow] = {
    oids.flatMap(map.get).toList
  }
  override def update(row: PgForeignDataWrapperRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def upsert(unsaved: PgForeignDataWrapperRow)(implicit c: Connection): PgForeignDataWrapperRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}