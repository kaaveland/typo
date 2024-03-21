/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
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

class WorkorderRepoImpl extends WorkorderRepo {
  override def delete(workorderid: WorkorderId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.workorder where "workorderid" = ${Segment.paramSegment(workorderid)(WorkorderId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[WorkorderFields, WorkorderRow] = {
    DeleteBuilder("production.workorder", WorkorderFields.structure)
  }
  override def insert(unsaved: WorkorderRow): ZIO[ZConnection, Throwable, WorkorderRow] = {
    sql"""insert into production.workorder("workorderid", "productid", "orderqty", "scrappedqty", "startdate", "enddate", "duedate", "scrapreasonid", "modifieddate")
          values (${Segment.paramSegment(unsaved.workorderid)(WorkorderId.setter)}::int4, ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.orderqty)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.scrappedqty)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.duedate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.scrapreasonid)(Setter.optionParamSetter(ScrapreasonId.setter))}::int2, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "workorderid", "productid", "orderqty", "scrappedqty", "startdate"::text, "enddate"::text, "duedate"::text, "scrapreasonid", "modifieddate"::text
       """.insertReturning(using WorkorderRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.workorder("workorderid", "productid", "orderqty", "scrappedqty", "startdate", "enddate", "duedate", "scrapreasonid", "modifieddate") FROM STDIN""", batchSize, unsaved)(WorkorderRow.text)
  }
  override def insert(unsaved: WorkorderRowUnsaved): ZIO[ZConnection, Throwable, WorkorderRow] = {
    val fs = List(
      Some((sql""""productid"""", sql"${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4")),
      Some((sql""""orderqty"""", sql"${Segment.paramSegment(unsaved.orderqty)(Setter.intSetter)}::int4")),
      Some((sql""""scrappedqty"""", sql"${Segment.paramSegment(unsaved.scrappedqty)(TypoShort.setter)}::int2")),
      Some((sql""""startdate"""", sql"${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""enddate"""", sql"${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
      Some((sql""""duedate"""", sql"${Segment.paramSegment(unsaved.duedate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""scrapreasonid"""", sql"${Segment.paramSegment(unsaved.scrapreasonid)(Setter.optionParamSetter(ScrapreasonId.setter))}::int2")),
      unsaved.workorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""workorderid"""", sql"${Segment.paramSegment(value: WorkorderId)(WorkorderId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.workorder default values
            returning "workorderid", "productid", "orderqty", "scrappedqty", "startdate"::text, "enddate"::text, "duedate"::text, "scrapreasonid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.workorder($names) values ($values) returning "workorderid", "productid", "orderqty", "scrappedqty", "startdate"::text, "enddate"::text, "duedate"::text, "scrapreasonid", "modifieddate"::text"""
    }
    q.insertReturning(using WorkorderRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.workorder("productid", "orderqty", "scrappedqty", "startdate", "enddate", "duedate", "scrapreasonid", "workorderid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(WorkorderRowUnsaved.text)
  }
  override def select: SelectBuilder[WorkorderFields, WorkorderRow] = {
    SelectBuilderSql("production.workorder", WorkorderFields.structure, WorkorderRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, WorkorderRow] = {
    sql"""select "workorderid", "productid", "orderqty", "scrappedqty", "startdate"::text, "enddate"::text, "duedate"::text, "scrapreasonid", "modifieddate"::text from production.workorder""".query(using WorkorderRow.jdbcDecoder).selectStream()
  }
  override def selectById(workorderid: WorkorderId): ZIO[ZConnection, Throwable, Option[WorkorderRow]] = {
    sql"""select "workorderid", "productid", "orderqty", "scrappedqty", "startdate"::text, "enddate"::text, "duedate"::text, "scrapreasonid", "modifieddate"::text from production.workorder where "workorderid" = ${Segment.paramSegment(workorderid)(WorkorderId.setter)}""".query(using WorkorderRow.jdbcDecoder).selectOne
  }
  override def selectByIds(workorderids: Array[WorkorderId]): ZStream[ZConnection, Throwable, WorkorderRow] = {
    sql"""select "workorderid", "productid", "orderqty", "scrappedqty", "startdate"::text, "enddate"::text, "duedate"::text, "scrapreasonid", "modifieddate"::text from production.workorder where "workorderid" = ANY(${Segment.paramSegment(workorderids)(WorkorderId.arraySetter)})""".query(using WorkorderRow.jdbcDecoder).selectStream()
  }
  override def update(row: WorkorderRow): ZIO[ZConnection, Throwable, Boolean] = {
    val workorderid = row.workorderid
    sql"""update production.workorder
          set "productid" = ${Segment.paramSegment(row.productid)(ProductId.setter)}::int4,
              "orderqty" = ${Segment.paramSegment(row.orderqty)(Setter.intSetter)}::int4,
              "scrappedqty" = ${Segment.paramSegment(row.scrappedqty)(TypoShort.setter)}::int2,
              "startdate" = ${Segment.paramSegment(row.startdate)(TypoLocalDateTime.setter)}::timestamp,
              "enddate" = ${Segment.paramSegment(row.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "duedate" = ${Segment.paramSegment(row.duedate)(TypoLocalDateTime.setter)}::timestamp,
              "scrapreasonid" = ${Segment.paramSegment(row.scrapreasonid)(Setter.optionParamSetter(ScrapreasonId.setter))}::int2,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "workorderid" = ${Segment.paramSegment(workorderid)(WorkorderId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[WorkorderFields, WorkorderRow] = {
    UpdateBuilder("production.workorder", WorkorderFields.structure, WorkorderRow.jdbcDecoder)
  }
  override def upsert(unsaved: WorkorderRow): ZIO[ZConnection, Throwable, UpdateResult[WorkorderRow]] = {
    sql"""insert into production.workorder("workorderid", "productid", "orderqty", "scrappedqty", "startdate", "enddate", "duedate", "scrapreasonid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.workorderid)(WorkorderId.setter)}::int4,
            ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.orderqty)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.scrappedqty)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.duedate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.scrapreasonid)(Setter.optionParamSetter(ScrapreasonId.setter))}::int2,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("workorderid")
          do update set
            "productid" = EXCLUDED."productid",
            "orderqty" = EXCLUDED."orderqty",
            "scrappedqty" = EXCLUDED."scrappedqty",
            "startdate" = EXCLUDED."startdate",
            "enddate" = EXCLUDED."enddate",
            "duedate" = EXCLUDED."duedate",
            "scrapreasonid" = EXCLUDED."scrapreasonid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "workorderid", "productid", "orderqty", "scrappedqty", "startdate"::text, "enddate"::text, "duedate"::text, "scrapreasonid", "modifieddate"::text""".insertReturning(using WorkorderRow.jdbcDecoder)
  }
}
