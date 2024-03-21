/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

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

class SalespersonRepoImpl extends SalespersonRepo {
  override def delete(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.salesperson where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[SalespersonFields, SalespersonRow] = {
    DeleteBuilder("sales.salesperson", SalespersonFields.structure)
  }
  override def insert(unsaved: SalespersonRow): ZIO[ZConnection, Throwable, SalespersonRow] = {
    sql"""insert into sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4, ${Segment.paramSegment(unsaved.salesquota)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric, ${Segment.paramSegment(unsaved.bonus)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.commissionpct)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.salesytd)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.saleslastyear)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
       """.insertReturning(using SalespersonRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalespersonRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalespersonRow.text)
  }
  override def insert(unsaved: SalespersonRowUnsaved): ZIO[ZConnection, Throwable, SalespersonRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""territoryid"""", sql"${Segment.paramSegment(unsaved.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4")),
      Some((sql""""salesquota"""", sql"${Segment.paramSegment(unsaved.salesquota)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric")),
      unsaved.bonus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""bonus"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.commissionpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""commissionpct"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.salesytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""salesytd"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.saleslastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""saleslastyear"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
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
      sql"""insert into sales.salesperson default values
            returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.salesperson($names) values ($values) returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using SalespersonRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalespersonRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalespersonRowUnsaved.text)
  }
  override def select: SelectBuilder[SalespersonFields, SalespersonRow] = {
    SelectBuilderSql("sales.salesperson", SalespersonFields.structure, SalespersonRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalespersonRow] = {
    sql"""select "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text from sales.salesperson""".query(using SalespersonRow.jdbcDecoder).selectStream()
  }
  override def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[SalespersonRow]] = {
    sql"""select "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text from sales.salesperson where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".query(using SalespersonRow.jdbcDecoder).selectOne
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, SalespersonRow] = {
    sql"""select "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text from sales.salesperson where "businessentityid" = ANY(${Segment.paramSegment(businessentityids)(BusinessentityId.arraySetter)})""".query(using SalespersonRow.jdbcDecoder).selectStream()
  }
  override def update(row: SalespersonRow): ZIO[ZConnection, Throwable, Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update sales.salesperson
          set "territoryid" = ${Segment.paramSegment(row.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4,
              "salesquota" = ${Segment.paramSegment(row.salesquota)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
              "bonus" = ${Segment.paramSegment(row.bonus)(Setter.bigDecimalScalaSetter)}::numeric,
              "commissionpct" = ${Segment.paramSegment(row.commissionpct)(Setter.bigDecimalScalaSetter)}::numeric,
              "salesytd" = ${Segment.paramSegment(row.salesytd)(Setter.bigDecimalScalaSetter)}::numeric,
              "saleslastyear" = ${Segment.paramSegment(row.saleslastyear)(Setter.bigDecimalScalaSetter)}::numeric,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[SalespersonFields, SalespersonRow] = {
    UpdateBuilder("sales.salesperson", SalespersonFields.structure, SalespersonRow.jdbcDecoder)
  }
  override def upsert(unsaved: SalespersonRow): ZIO[ZConnection, Throwable, UpdateResult[SalespersonRow]] = {
    sql"""insert into sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4,
            ${Segment.paramSegment(unsaved.salesquota)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
            ${Segment.paramSegment(unsaved.bonus)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.commissionpct)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.salesytd)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.saleslastyear)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "territoryid" = EXCLUDED."territoryid",
            "salesquota" = EXCLUDED."salesquota",
            "bonus" = EXCLUDED."bonus",
            "commissionpct" = EXCLUDED."commissionpct",
            "salesytd" = EXCLUDED."salesytd",
            "saleslastyear" = EXCLUDED."saleslastyear",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text""".insertReturning(using SalespersonRow.jdbcDecoder)
  }
}
