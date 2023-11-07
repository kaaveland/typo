/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amop

import adventureworks.customtypes.TypoShort
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

object PgAmopRepoImpl extends PgAmopRepo {
  override def delete(oid: PgAmopId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from pg_catalog.pg_amop where "oid" = ${Segment.paramSegment(oid)(PgAmopId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgAmopFields, PgAmopRow] = {
    DeleteBuilder("pg_catalog.pg_amop", PgAmopFields)
  }
  override def insert(unsaved: PgAmopRow): ZIO[ZConnection, Throwable, PgAmopRow] = {
    sql"""insert into pg_catalog.pg_amop("oid", "amopfamily", "amoplefttype", "amoprighttype", "amopstrategy", "amoppurpose", "amopopr", "amopmethod", "amopsortfamily")
          values (${Segment.paramSegment(unsaved.oid)(PgAmopId.setter)}::oid, ${Segment.paramSegment(unsaved.amopfamily)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.amoplefttype)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.amoprighttype)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.amopstrategy)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.amoppurpose)(Setter.stringSetter)}::char, ${Segment.paramSegment(unsaved.amopopr)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.amopmethod)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.amopsortfamily)(Setter.longSetter)}::oid)
          returning "oid", "amopfamily", "amoplefttype", "amoprighttype", "amopstrategy", "amoppurpose", "amopopr", "amopmethod", "amopsortfamily"
       """.insertReturning(PgAmopRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def select: SelectBuilder[PgAmopFields, PgAmopRow] = {
    SelectBuilderSql("pg_catalog.pg_amop", PgAmopFields, PgAmopRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgAmopRow] = {
    sql"""select "oid", "amopfamily", "amoplefttype", "amoprighttype", "amopstrategy", "amoppurpose", "amopopr", "amopmethod", "amopsortfamily" from pg_catalog.pg_amop""".query(PgAmopRow.jdbcDecoder).selectStream
  }
  override def selectById(oid: PgAmopId): ZIO[ZConnection, Throwable, Option[PgAmopRow]] = {
    sql"""select "oid", "amopfamily", "amoplefttype", "amoprighttype", "amopstrategy", "amoppurpose", "amopopr", "amopmethod", "amopsortfamily" from pg_catalog.pg_amop where "oid" = ${Segment.paramSegment(oid)(PgAmopId.setter)}""".query(PgAmopRow.jdbcDecoder).selectOne
  }
  override def selectByIds(oids: Array[PgAmopId]): ZStream[ZConnection, Throwable, PgAmopRow] = {
    sql"""select "oid", "amopfamily", "amoplefttype", "amoprighttype", "amopstrategy", "amoppurpose", "amopopr", "amopmethod", "amopsortfamily" from pg_catalog.pg_amop where "oid" = ANY(${Segment.paramSegment(oids)(PgAmopId.arraySetter)})""".query(PgAmopRow.jdbcDecoder).selectStream
  }
  override def selectByUnique(amopfamily: /* oid */ Long, amoplefttype: /* oid */ Long, amoprighttype: /* oid */ Long, amopstrategy: TypoShort): ZIO[ZConnection, Throwable, Option[PgAmopRow]] = {
    sql"""select "amopfamily", "amoplefttype", "amoprighttype", "amopstrategy"
          from pg_catalog.pg_amop
          where "amopfamily" = ${Segment.paramSegment(amopfamily)(Setter.longSetter)} AND "amoplefttype" = ${Segment.paramSegment(amoplefttype)(Setter.longSetter)} AND "amoprighttype" = ${Segment.paramSegment(amoprighttype)(Setter.longSetter)} AND "amopstrategy" = ${Segment.paramSegment(amopstrategy)(TypoShort.setter)}
       """.query(PgAmopRow.jdbcDecoder).selectOne
  }
  override def selectByUnique(amopopr: /* oid */ Long, amoppurpose: String, amopfamily: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgAmopRow]] = {
    sql"""select "amopopr", "amoppurpose", "amopfamily"
          from pg_catalog.pg_amop
          where "amopopr" = ${Segment.paramSegment(amopopr)(Setter.longSetter)} AND "amoppurpose" = ${Segment.paramSegment(amoppurpose)(Setter.stringSetter)} AND "amopfamily" = ${Segment.paramSegment(amopfamily)(Setter.longSetter)}
       """.query(PgAmopRow.jdbcDecoder).selectOne
  }
  override def update(row: PgAmopRow): ZIO[ZConnection, Throwable, Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_amop
          set "amopfamily" = ${Segment.paramSegment(row.amopfamily)(Setter.longSetter)}::oid,
              "amoplefttype" = ${Segment.paramSegment(row.amoplefttype)(Setter.longSetter)}::oid,
              "amoprighttype" = ${Segment.paramSegment(row.amoprighttype)(Setter.longSetter)}::oid,
              "amopstrategy" = ${Segment.paramSegment(row.amopstrategy)(TypoShort.setter)}::int2,
              "amoppurpose" = ${Segment.paramSegment(row.amoppurpose)(Setter.stringSetter)}::char,
              "amopopr" = ${Segment.paramSegment(row.amopopr)(Setter.longSetter)}::oid,
              "amopmethod" = ${Segment.paramSegment(row.amopmethod)(Setter.longSetter)}::oid,
              "amopsortfamily" = ${Segment.paramSegment(row.amopsortfamily)(Setter.longSetter)}::oid
          where "oid" = ${Segment.paramSegment(oid)(PgAmopId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[PgAmopFields, PgAmopRow] = {
    UpdateBuilder("pg_catalog.pg_amop", PgAmopFields, PgAmopRow.jdbcDecoder)
  }
  override def upsert(unsaved: PgAmopRow): ZIO[ZConnection, Throwable, UpdateResult[PgAmopRow]] = {
    sql"""insert into pg_catalog.pg_amop("oid", "amopfamily", "amoplefttype", "amoprighttype", "amopstrategy", "amoppurpose", "amopopr", "amopmethod", "amopsortfamily")
          values (
            ${Segment.paramSegment(unsaved.oid)(PgAmopId.setter)}::oid,
            ${Segment.paramSegment(unsaved.amopfamily)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.amoplefttype)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.amoprighttype)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.amopstrategy)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.amoppurpose)(Setter.stringSetter)}::char,
            ${Segment.paramSegment(unsaved.amopopr)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.amopmethod)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.amopsortfamily)(Setter.longSetter)}::oid
          )
          on conflict ("oid")
          do update set
            "amopfamily" = EXCLUDED."amopfamily",
            "amoplefttype" = EXCLUDED."amoplefttype",
            "amoprighttype" = EXCLUDED."amoprighttype",
            "amopstrategy" = EXCLUDED."amopstrategy",
            "amoppurpose" = EXCLUDED."amoppurpose",
            "amopopr" = EXCLUDED."amopopr",
            "amopmethod" = EXCLUDED."amopmethod",
            "amopsortfamily" = EXCLUDED."amopsortfamily"
          returning "oid", "amopfamily", "amoplefttype", "amoprighttype", "amopstrategy", "amoppurpose", "amopopr", "amopmethod", "amopsortfamily"""".insertReturning(PgAmopRow.jdbcDecoder)
  }
}
