/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opclass

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

object PgOpclassRepoImpl extends PgOpclassRepo {
  override def delete(oid: PgOpclassId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from pg_catalog.pg_opclass where "oid" = ${Segment.paramSegment(oid)(PgOpclassId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgOpclassFields, PgOpclassRow] = {
    DeleteBuilder("pg_catalog.pg_opclass", PgOpclassFields)
  }
  override def insert(unsaved: PgOpclassRow): ZIO[ZConnection, Throwable, PgOpclassRow] = {
    sql"""insert into pg_catalog.pg_opclass("oid", "opcmethod", "opcname", "opcnamespace", "opcowner", "opcfamily", "opcintype", "opcdefault", "opckeytype")
          values (${Segment.paramSegment(unsaved.oid)(PgOpclassId.setter)}::oid, ${Segment.paramSegment(unsaved.opcmethod)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.opcname)(Setter.stringSetter)}::name, ${Segment.paramSegment(unsaved.opcnamespace)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.opcowner)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.opcfamily)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.opcintype)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.opcdefault)(Setter.booleanSetter)}, ${Segment.paramSegment(unsaved.opckeytype)(Setter.longSetter)}::oid)
          returning "oid", "opcmethod", "opcname", "opcnamespace", "opcowner", "opcfamily", "opcintype", "opcdefault", "opckeytype"
       """.insertReturning(PgOpclassRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def select: SelectBuilder[PgOpclassFields, PgOpclassRow] = {
    SelectBuilderSql("pg_catalog.pg_opclass", PgOpclassFields, PgOpclassRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgOpclassRow] = {
    sql"""select "oid", "opcmethod", "opcname", "opcnamespace", "opcowner", "opcfamily", "opcintype", "opcdefault", "opckeytype" from pg_catalog.pg_opclass""".query(PgOpclassRow.jdbcDecoder).selectStream
  }
  override def selectById(oid: PgOpclassId): ZIO[ZConnection, Throwable, Option[PgOpclassRow]] = {
    sql"""select "oid", "opcmethod", "opcname", "opcnamespace", "opcowner", "opcfamily", "opcintype", "opcdefault", "opckeytype" from pg_catalog.pg_opclass where "oid" = ${Segment.paramSegment(oid)(PgOpclassId.setter)}""".query(PgOpclassRow.jdbcDecoder).selectOne
  }
  override def selectByIds(oids: Array[PgOpclassId]): ZStream[ZConnection, Throwable, PgOpclassRow] = {
    sql"""select "oid", "opcmethod", "opcname", "opcnamespace", "opcowner", "opcfamily", "opcintype", "opcdefault", "opckeytype" from pg_catalog.pg_opclass where "oid" = ANY(${Segment.paramSegment(oids)(PgOpclassId.arraySetter)})""".query(PgOpclassRow.jdbcDecoder).selectStream
  }
  override def selectByUnique(opcmethod: /* oid */ Long, opcname: String, opcnamespace: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgOpclassRow]] = {
    sql"""select "opcmethod", "opcname", "opcnamespace"
          from pg_catalog.pg_opclass
          where "opcmethod" = ${Segment.paramSegment(opcmethod)(Setter.longSetter)} AND "opcname" = ${Segment.paramSegment(opcname)(Setter.stringSetter)} AND "opcnamespace" = ${Segment.paramSegment(opcnamespace)(Setter.longSetter)}
       """.query(PgOpclassRow.jdbcDecoder).selectOne
  }
  override def update(row: PgOpclassRow): ZIO[ZConnection, Throwable, Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_opclass
          set "opcmethod" = ${Segment.paramSegment(row.opcmethod)(Setter.longSetter)}::oid,
              "opcname" = ${Segment.paramSegment(row.opcname)(Setter.stringSetter)}::name,
              "opcnamespace" = ${Segment.paramSegment(row.opcnamespace)(Setter.longSetter)}::oid,
              "opcowner" = ${Segment.paramSegment(row.opcowner)(Setter.longSetter)}::oid,
              "opcfamily" = ${Segment.paramSegment(row.opcfamily)(Setter.longSetter)}::oid,
              "opcintype" = ${Segment.paramSegment(row.opcintype)(Setter.longSetter)}::oid,
              "opcdefault" = ${Segment.paramSegment(row.opcdefault)(Setter.booleanSetter)},
              "opckeytype" = ${Segment.paramSegment(row.opckeytype)(Setter.longSetter)}::oid
          where "oid" = ${Segment.paramSegment(oid)(PgOpclassId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[PgOpclassFields, PgOpclassRow] = {
    UpdateBuilder("pg_catalog.pg_opclass", PgOpclassFields, PgOpclassRow.jdbcDecoder)
  }
  override def upsert(unsaved: PgOpclassRow): ZIO[ZConnection, Throwable, UpdateResult[PgOpclassRow]] = {
    sql"""insert into pg_catalog.pg_opclass("oid", "opcmethod", "opcname", "opcnamespace", "opcowner", "opcfamily", "opcintype", "opcdefault", "opckeytype")
          values (
            ${Segment.paramSegment(unsaved.oid)(PgOpclassId.setter)}::oid,
            ${Segment.paramSegment(unsaved.opcmethod)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.opcname)(Setter.stringSetter)}::name,
            ${Segment.paramSegment(unsaved.opcnamespace)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.opcowner)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.opcfamily)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.opcintype)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.opcdefault)(Setter.booleanSetter)},
            ${Segment.paramSegment(unsaved.opckeytype)(Setter.longSetter)}::oid
          )
          on conflict ("oid")
          do update set
            "opcmethod" = EXCLUDED."opcmethod",
            "opcname" = EXCLUDED."opcname",
            "opcnamespace" = EXCLUDED."opcnamespace",
            "opcowner" = EXCLUDED."opcowner",
            "opcfamily" = EXCLUDED."opcfamily",
            "opcintype" = EXCLUDED."opcintype",
            "opcdefault" = EXCLUDED."opcdefault",
            "opckeytype" = EXCLUDED."opckeytype"
          returning "oid", "opcmethod", "opcname", "opcnamespace", "opcowner", "opcfamily", "opcintype", "opcdefault", "opckeytype"""".insertReturning(PgOpclassRow.jdbcDecoder)
  }
}
