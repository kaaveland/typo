/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
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

object StoreRepoImpl extends StoreRepo {
  override def delete(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.store where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[StoreFields, StoreRow] = {
    DeleteBuilder("sales.store", StoreFields)
  }
  override def insert(unsaved: StoreRow): ZIO[ZConnection, Throwable, StoreRow] = {
    sql"""insert into sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4, ${Segment.paramSegment(unsaved.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text
       """.insertReturning(StoreRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: StoreRowUnsaved): ZIO[ZConnection, Throwable, StoreRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      Some((sql""""salespersonid"""", sql"${Segment.paramSegment(unsaved.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4")),
      Some((sql""""demographics"""", sql"${Segment.paramSegment(unsaved.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml")),
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
      sql"""insert into sales.store default values
            returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.store($names) values ($values) returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(StoreRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def select: SelectBuilder[StoreFields, StoreRow] = {
    SelectBuilderSql("sales.store", StoreFields, StoreRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, StoreRow] = {
    sql"""select "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text from sales.store""".query(StoreRow.jdbcDecoder).selectStream
  }
  override def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[StoreRow]] = {
    sql"""select "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text from sales.store where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".query(StoreRow.jdbcDecoder).selectOne
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, StoreRow] = {
    sql"""select "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text from sales.store where "businessentityid" = ANY(${Segment.paramSegment(businessentityids)(BusinessentityId.arraySetter)})""".query(StoreRow.jdbcDecoder).selectStream
  }
  override def update(row: StoreRow): ZIO[ZConnection, Throwable, Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update sales.store
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "salespersonid" = ${Segment.paramSegment(row.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
              "demographics" = ${Segment.paramSegment(row.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[StoreFields, StoreRow] = {
    UpdateBuilder("sales.store", StoreFields, StoreRow.jdbcDecoder)
  }
  override def upsert(unsaved: StoreRow): ZIO[ZConnection, Throwable, UpdateResult[StoreRow]] = {
    sql"""insert into sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
            ${Segment.paramSegment(unsaved.demographics)(Setter.optionParamSetter(TypoXml.setter))}::xml,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "name" = EXCLUDED."name",
            "salespersonid" = EXCLUDED."salespersonid",
            "demographics" = EXCLUDED."demographics",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text""".insertReturning(StoreRow.jdbcDecoder)
  }
}
