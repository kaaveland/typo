/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class SalesterritoryhistoryRepoImpl extends SalesterritoryhistoryRepo {
  override def delete: DeleteBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    DeleteBuilder("sales.salesterritoryhistory", SalesterritoryhistoryFields.structure)
  }
  override def deleteById(compositeId: SalesterritoryhistoryId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.salesterritoryhistory where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "startdate" = ${Segment.paramSegment(compositeId.startdate)(TypoLocalDateTime.setter)} AND "territoryid" = ${Segment.paramSegment(compositeId.territoryid)(SalesterritoryId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[SalesterritoryhistoryId]): ZIO[ZConnection, Throwable, Long] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val startdate = compositeIds.map(_.startdate)
    val territoryid = compositeIds.map(_.territoryid)
    sql"""delete
          from sales.salesterritoryhistory
          where ("businessentityid", "startdate", "territoryid")
          in (select unnest(${businessentityid}), unnest(${startdate}), unnest(${territoryid}))
       """.delete
    
  }
  override def insert(unsaved: SalesterritoryhistoryRow): ZIO[ZConnection, Throwable, SalesterritoryhistoryRow] = {
    sql"""insert into sales.salesterritoryhistory("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.territoryid)(SalesterritoryId.setter)}::int4, ${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
       """.insertReturning(using SalesterritoryhistoryRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: SalesterritoryhistoryRowUnsaved): ZIO[ZConnection, Throwable, SalesterritoryhistoryRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""territoryid"""", sql"${Segment.paramSegment(unsaved.territoryid)(SalesterritoryId.setter)}::int4")),
      Some((sql""""startdate"""", sql"${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""enddate"""", sql"${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.salesterritoryhistory default values
            returning "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.salesterritoryhistory($names) values ($values) returning "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using SalesterritoryhistoryRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesterritoryhistoryRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesterritoryhistory("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalesterritoryhistoryRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesterritoryhistoryRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesterritoryhistory("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalesterritoryhistoryRowUnsaved.text)
  }
  override def select: SelectBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    SelectBuilderSql("sales.salesterritoryhistory", SalesterritoryhistoryFields.structure, SalesterritoryhistoryRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalesterritoryhistoryRow] = {
    sql"""select "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text from sales.salesterritoryhistory""".query(using SalesterritoryhistoryRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: SalesterritoryhistoryId): ZIO[ZConnection, Throwable, Option[SalesterritoryhistoryRow]] = {
    sql"""select "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text from sales.salesterritoryhistory where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "startdate" = ${Segment.paramSegment(compositeId.startdate)(TypoLocalDateTime.setter)} AND "territoryid" = ${Segment.paramSegment(compositeId.territoryid)(SalesterritoryId.setter)}""".query(using SalesterritoryhistoryRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[SalesterritoryhistoryId]): ZStream[ZConnection, Throwable, SalesterritoryhistoryRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val startdate = compositeIds.map(_.startdate)
    val territoryid = compositeIds.map(_.territoryid)
    sql"""select "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
          from sales.salesterritoryhistory
          where ("businessentityid", "startdate", "territoryid")
          in (select unnest(${businessentityid}), unnest(${startdate}), unnest(${territoryid}))
       """.query(using SalesterritoryhistoryRow.jdbcDecoder).selectStream()
    
  }
  override def selectByIdsTracked(compositeIds: Array[SalesterritoryhistoryId]): ZIO[ZConnection, Throwable, Map[SalesterritoryhistoryId, SalesterritoryhistoryRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    UpdateBuilder("sales.salesterritoryhistory", SalesterritoryhistoryFields.structure, SalesterritoryhistoryRow.jdbcDecoder)
  }
  override def update(row: SalesterritoryhistoryRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.salesterritoryhistory
          set "enddate" = ${Segment.paramSegment(row.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "startdate" = ${Segment.paramSegment(compositeId.startdate)(TypoLocalDateTime.setter)} AND "territoryid" = ${Segment.paramSegment(compositeId.territoryid)(SalesterritoryId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: SalesterritoryhistoryRow): ZIO[ZConnection, Throwable, UpdateResult[SalesterritoryhistoryRow]] = {
    sql"""insert into sales.salesterritoryhistory("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.territoryid)(SalesterritoryId.setter)}::int4,
            ${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "startdate", "territoryid")
          do update set
            "enddate" = EXCLUDED."enddate",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text""".insertReturning(using SalesterritoryhistoryRow.jdbcDecoder)
  }
}
