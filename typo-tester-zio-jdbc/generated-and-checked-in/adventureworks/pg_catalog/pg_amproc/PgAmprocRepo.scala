/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amproc

import adventureworks.customtypes.TypoShort
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgAmprocRepo {
  def delete(oid: PgAmprocId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[PgAmprocFields, PgAmprocRow]
  def insert(unsaved: PgAmprocRow): ZIO[ZConnection, Throwable, PgAmprocRow]
  def select: SelectBuilder[PgAmprocFields, PgAmprocRow]
  def selectAll: ZStream[ZConnection, Throwable, PgAmprocRow]
  def selectById(oid: PgAmprocId): ZIO[ZConnection, Throwable, Option[PgAmprocRow]]
  def selectByIds(oids: Array[PgAmprocId]): ZStream[ZConnection, Throwable, PgAmprocRow]
  def selectByUnique(amprocfamily: /* oid */ Long, amproclefttype: /* oid */ Long, amprocrighttype: /* oid */ Long, amprocnum: TypoShort): ZIO[ZConnection, Throwable, Option[PgAmprocRow]]
  def update(row: PgAmprocRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[PgAmprocFields, PgAmprocRow]
  def upsert(unsaved: PgAmprocRow): ZIO[ZConnection, Throwable, UpdateResult[PgAmprocRow]]
}
