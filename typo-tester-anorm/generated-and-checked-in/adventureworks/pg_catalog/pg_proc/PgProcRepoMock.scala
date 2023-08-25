/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import adventureworks.TypoOidVector
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class PgProcRepoMock(map: scala.collection.mutable.Map[PgProcId, PgProcRow] = scala.collection.mutable.Map.empty) extends PgProcRepo {
  override def delete(oid: PgProcId)(implicit c: Connection): Boolean = {
    map.remove(oid).isDefined
  }
  override def delete: DeleteBuilder[PgProcFields, PgProcRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgProcFields, map)
  }
  override def insert(unsaved: PgProcRow)(implicit c: Connection): PgProcRow = {
    if (map.contains(unsaved.oid))
      sys.error(s"id ${unsaved.oid} already exists")
    else
      map.put(unsaved.oid, unsaved)
    unsaved
  }
  override def select: SelectBuilder[PgProcFields, PgProcRow] = {
    SelectBuilderMock(PgProcFields, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PgProcRow] = {
    map.values.toList
  }
  override def selectById(oid: PgProcId)(implicit c: Connection): Option[PgProcRow] = {
    map.get(oid)
  }
  override def selectByIds(oids: Array[PgProcId])(implicit c: Connection): List[PgProcRow] = {
    oids.flatMap(map.get).toList
  }
  override def selectByUnique(proname: String, proargtypes: TypoOidVector, pronamespace: /* oid */ Long)(implicit c: Connection): Option[PgProcRow] = {
    map.values.find(v => proname == v.proname && proargtypes == v.proargtypes && pronamespace == v.pronamespace)
  }
  override def update(row: PgProcRow)(implicit c: Connection): Boolean = {
    map.get(row.oid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.oid, row)
        true
      case None => false
    }
  }
  override def update: UpdateBuilder[PgProcFields, PgProcRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgProcFields, map)
  }
  override def upsert(unsaved: PgProcRow)(implicit c: Connection): PgProcRow = {
    map.put(unsaved.oid, unsaved)
    unsaved
  }
}