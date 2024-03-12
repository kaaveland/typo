/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
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

class SalespersonquotahistoryRepoImpl extends SalespersonquotahistoryRepo {
  override def delete(compositeId: SalespersonquotahistoryId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.salespersonquotahistory where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "quotadate" = ${Segment.paramSegment(compositeId.quotadate)(TypoLocalDateTime.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    DeleteBuilder("sales.salespersonquotahistory", SalespersonquotahistoryFields.structure)
  }
  override def insert(unsaved: SalespersonquotahistoryRow): ZIO[ZConnection, Throwable, SalespersonquotahistoryRow] = {
    sql"""insert into sales.salespersonquotahistory("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.quotadate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.salesquota)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
       """.insertReturning(SalespersonquotahistoryRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalespersonquotahistoryRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salespersonquotahistory("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalespersonquotahistoryRow.text)
  }
  override def insert(unsaved: SalespersonquotahistoryRowUnsaved): ZIO[ZConnection, Throwable, SalespersonquotahistoryRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""quotadate"""", sql"${Segment.paramSegment(unsaved.quotadate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""salesquota"""", sql"${Segment.paramSegment(unsaved.salesquota)(Setter.bigDecimalScalaSetter)}::numeric")),
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
      sql"""insert into sales.salespersonquotahistory default values
            returning "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.salespersonquotahistory($names) values ($values) returning "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(SalespersonquotahistoryRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalespersonquotahistoryRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salespersonquotahistory("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalespersonquotahistoryRowUnsaved.text)
  }
  override def select: SelectBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    SelectBuilderSql("sales.salespersonquotahistory", SalespersonquotahistoryFields.structure, SalespersonquotahistoryRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalespersonquotahistoryRow] = {
    sql"""select "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text from sales.salespersonquotahistory""".query(SalespersonquotahistoryRow.jdbcDecoder).selectStream
  }
  override def selectById(compositeId: SalespersonquotahistoryId): ZIO[ZConnection, Throwable, Option[SalespersonquotahistoryRow]] = {
    sql"""select "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text from sales.salespersonquotahistory where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "quotadate" = ${Segment.paramSegment(compositeId.quotadate)(TypoLocalDateTime.setter)}""".query(SalespersonquotahistoryRow.jdbcDecoder).selectOne
  }
  override def update(row: SalespersonquotahistoryRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.salespersonquotahistory
          set "salesquota" = ${Segment.paramSegment(row.salesquota)(Setter.bigDecimalScalaSetter)}::numeric,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "quotadate" = ${Segment.paramSegment(compositeId.quotadate)(TypoLocalDateTime.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    UpdateBuilder("sales.salespersonquotahistory", SalespersonquotahistoryFields.structure, SalespersonquotahistoryRow.jdbcDecoder)
  }
  override def upsert(unsaved: SalespersonquotahistoryRow): ZIO[ZConnection, Throwable, UpdateResult[SalespersonquotahistoryRow]] = {
    sql"""insert into sales.salespersonquotahistory("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.quotadate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.salesquota)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "quotadate")
          do update set
            "salesquota" = EXCLUDED."salesquota",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text""".insertReturning(SalespersonquotahistoryRow.jdbcDecoder)
  }
}
