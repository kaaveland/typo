/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
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

object CustomerRepoImpl extends CustomerRepo {
  override def delete(customerid: CustomerId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.customer where "customerid" = ${Segment.paramSegment(customerid)(CustomerId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[CustomerFields, CustomerRow] = {
    DeleteBuilder("sales.customer", CustomerFields)
  }
  override def insert(unsaved: CustomerRow): ZIO[ZConnection, Throwable, CustomerRow] = {
    sql"""insert into sales.customer("customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.customerid)(CustomerId.setter)}::int4, ${Segment.paramSegment(unsaved.personid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4, ${Segment.paramSegment(unsaved.storeid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4, ${Segment.paramSegment(unsaved.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
       """.insertReturning(CustomerRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: CustomerRowUnsaved): ZIO[ZConnection, Throwable, CustomerRow] = {
    val fs = List(
      Some((sql""""personid"""", sql"${Segment.paramSegment(unsaved.personid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4")),
      Some((sql""""storeid"""", sql"${Segment.paramSegment(unsaved.storeid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4")),
      Some((sql""""territoryid"""", sql"${Segment.paramSegment(unsaved.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4")),
      unsaved.customerid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""customerid"""", sql"${Segment.paramSegment(value: CustomerId)(CustomerId.setter)}::int4"))
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
      sql"""insert into sales.customer default values
            returning "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.customer($names) values ($values) returning "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(CustomerRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def select: SelectBuilder[CustomerFields, CustomerRow] = {
    SelectBuilderSql("sales.customer", CustomerFields, CustomerRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CustomerRow] = {
    sql"""select "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text from sales.customer""".query(CustomerRow.jdbcDecoder).selectStream
  }
  override def selectById(customerid: CustomerId): ZIO[ZConnection, Throwable, Option[CustomerRow]] = {
    sql"""select "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text from sales.customer where "customerid" = ${Segment.paramSegment(customerid)(CustomerId.setter)}""".query(CustomerRow.jdbcDecoder).selectOne
  }
  override def selectByIds(customerids: Array[CustomerId]): ZStream[ZConnection, Throwable, CustomerRow] = {
    sql"""select "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text from sales.customer where "customerid" = ANY(${Segment.paramSegment(customerids)(CustomerId.arraySetter)})""".query(CustomerRow.jdbcDecoder).selectStream
  }
  override def update(row: CustomerRow): ZIO[ZConnection, Throwable, Boolean] = {
    val customerid = row.customerid
    sql"""update sales.customer
          set "personid" = ${Segment.paramSegment(row.personid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
              "storeid" = ${Segment.paramSegment(row.storeid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
              "territoryid" = ${Segment.paramSegment(row.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "customerid" = ${Segment.paramSegment(customerid)(CustomerId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[CustomerFields, CustomerRow] = {
    UpdateBuilder("sales.customer", CustomerFields, CustomerRow.jdbcDecoder)
  }
  override def upsert(unsaved: CustomerRow): ZIO[ZConnection, Throwable, UpdateResult[CustomerRow]] = {
    sql"""insert into sales.customer("customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.customerid)(CustomerId.setter)}::int4,
            ${Segment.paramSegment(unsaved.personid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
            ${Segment.paramSegment(unsaved.storeid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
            ${Segment.paramSegment(unsaved.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("customerid")
          do update set
            "personid" = EXCLUDED."personid",
            "storeid" = EXCLUDED."storeid",
            "territoryid" = EXCLUDED."territoryid",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text""".insertReturning(CustomerRow.jdbcDecoder)
  }
}
