/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opfamily

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgOpfamilyRepoImpl extends PgOpfamilyRepo {
  override def delete(oid: PgOpfamilyId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from pg_catalog.pg_opfamily where "oid" = ${Segment.paramSegment(oid)(PgOpfamilyId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgOpfamilyFields, PgOpfamilyRow] = {
    DeleteBuilder("pg_catalog.pg_opfamily", PgOpfamilyFields)
  }
  override def insert(unsaved: PgOpfamilyRow): ZIO[ZConnection, Throwable, PgOpfamilyRow] = {
    sql"""insert into pg_catalog.pg_opfamily("oid", "opfmethod", "opfname", "opfnamespace", "opfowner")
          values (${Segment.paramSegment(unsaved.oid)(PgOpfamilyId.setter)}::oid, ${Segment.paramSegment(unsaved.opfmethod)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.opfname)(Setter.stringSetter)}::name, ${Segment.paramSegment(unsaved.opfnamespace)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.opfowner)(Setter.longSetter)}::oid)
          returning "oid", "opfmethod", "opfname", "opfnamespace", "opfowner"
       """.insertReturning(PgOpfamilyRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def select: SelectBuilder[PgOpfamilyFields, PgOpfamilyRow] = {
    SelectBuilderSql("pg_catalog.pg_opfamily", PgOpfamilyFields, PgOpfamilyRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgOpfamilyRow] = {
    sql"""select "oid", "opfmethod", "opfname", "opfnamespace", "opfowner" from pg_catalog.pg_opfamily""".query(PgOpfamilyRow.jdbcDecoder).selectStream
  }
  override def selectById(oid: PgOpfamilyId): ZIO[ZConnection, Throwable, Option[PgOpfamilyRow]] = {
    sql"""select "oid", "opfmethod", "opfname", "opfnamespace", "opfowner" from pg_catalog.pg_opfamily where "oid" = ${Segment.paramSegment(oid)(PgOpfamilyId.setter)}""".query(PgOpfamilyRow.jdbcDecoder).selectOne
  }
  override def selectByIds(oids: Array[PgOpfamilyId]): ZStream[ZConnection, Throwable, PgOpfamilyRow] = {
    sql"""select "oid", "opfmethod", "opfname", "opfnamespace", "opfowner" from pg_catalog.pg_opfamily where "oid" = ANY(${Segment.paramSegment(oids)(PgOpfamilyId.arraySetter)})""".query(PgOpfamilyRow.jdbcDecoder).selectStream
  }
  override def selectByUnique(opfmethod: /* oid */ Long, opfname: String, opfnamespace: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgOpfamilyRow]] = {
    sql"""select "opfmethod", "opfname", "opfnamespace"
          from pg_catalog.pg_opfamily
          where "opfmethod" = ${Segment.paramSegment(opfmethod)(Setter.longSetter)} AND "opfname" = ${Segment.paramSegment(opfname)(Setter.stringSetter)} AND "opfnamespace" = ${Segment.paramSegment(opfnamespace)(Setter.longSetter)}
       """.query(PgOpfamilyRow.jdbcDecoder).selectOne
  }
  override def update(row: PgOpfamilyRow): ZIO[ZConnection, Throwable, Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_opfamily
          set "opfmethod" = ${Segment.paramSegment(row.opfmethod)(Setter.longSetter)}::oid,
              "opfname" = ${Segment.paramSegment(row.opfname)(Setter.stringSetter)}::name,
              "opfnamespace" = ${Segment.paramSegment(row.opfnamespace)(Setter.longSetter)}::oid,
              "opfowner" = ${Segment.paramSegment(row.opfowner)(Setter.longSetter)}::oid
          where "oid" = ${Segment.paramSegment(oid)(PgOpfamilyId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[PgOpfamilyFields, PgOpfamilyRow] = {
    UpdateBuilder("pg_catalog.pg_opfamily", PgOpfamilyFields, PgOpfamilyRow.jdbcDecoder)
  }
  override def upsert(unsaved: PgOpfamilyRow): ZIO[ZConnection, Throwable, UpdateResult[PgOpfamilyRow]] = {
    sql"""insert into pg_catalog.pg_opfamily("oid", "opfmethod", "opfname", "opfnamespace", "opfowner")
          values (
            ${Segment.paramSegment(unsaved.oid)(PgOpfamilyId.setter)}::oid,
            ${Segment.paramSegment(unsaved.opfmethod)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.opfname)(Setter.stringSetter)}::name,
            ${Segment.paramSegment(unsaved.opfnamespace)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.opfowner)(Setter.longSetter)}::oid
          )
          on conflict ("oid")
          do update set
            "opfmethod" = EXCLUDED."opfmethod",
            "opfname" = EXCLUDED."opfname",
            "opfnamespace" = EXCLUDED."opfnamespace",
            "opfowner" = EXCLUDED."opfowner"
          returning "oid", "opfmethod", "opfname", "opfnamespace", "opfowner"""".insertReturning(PgOpfamilyRow.jdbcDecoder)
  }
}
