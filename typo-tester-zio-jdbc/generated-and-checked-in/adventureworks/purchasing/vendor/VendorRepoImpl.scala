/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
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

class VendorRepoImpl extends VendorRepo {
  override def delete: DeleteBuilder[VendorFields, VendorRow] = {
    DeleteBuilder(""""purchasing"."vendor"""", VendorFields.structure)
  }
  override def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from "purchasing"."vendor" where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from "purchasing"."vendor" where "businessentityid" = ANY(${businessentityids})""".delete
  }
  override def insert(unsaved: VendorRow): ZIO[ZConnection, Throwable, VendorRow] = {
    sql"""insert into "purchasing"."vendor"("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.accountnumber)(AccountNumber.setter)}::varchar, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.creditrating)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.preferredvendorstatus)(Flag.setter)}::bool, ${Segment.paramSegment(unsaved.activeflag)(Flag.setter)}::bool, ${Segment.paramSegment(unsaved.purchasingwebserviceurl)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
       """.insertReturning(using VendorRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: VendorRowUnsaved): ZIO[ZConnection, Throwable, VendorRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""accountnumber"""", sql"${Segment.paramSegment(unsaved.accountnumber)(AccountNumber.setter)}::varchar")),
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      Some((sql""""creditrating"""", sql"${Segment.paramSegment(unsaved.creditrating)(TypoShort.setter)}::int2")),
      Some((sql""""purchasingwebserviceurl"""", sql"${Segment.paramSegment(unsaved.purchasingwebserviceurl)(Setter.optionParamSetter(Setter.stringSetter))}")),
      unsaved.preferredvendorstatus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""preferredvendorstatus"""", sql"${Segment.paramSegment(value: Flag)(Flag.setter)}::bool"))
      },
      unsaved.activeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""activeflag"""", sql"${Segment.paramSegment(value: Flag)(Flag.setter)}::bool"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into "purchasing"."vendor" default values
            returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into "purchasing"."vendor"($names) values ($values) returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text"""
    }
    q.insertReturning(using VendorRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, VendorRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "purchasing"."vendor"("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate") FROM STDIN""", batchSize, unsaved)(VendorRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, VendorRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "purchasing"."vendor"("businessentityid", "accountnumber", "name", "creditrating", "purchasingwebserviceurl", "preferredvendorstatus", "activeflag", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(VendorRowUnsaved.text)
  }
  override def select: SelectBuilder[VendorFields, VendorRow] = {
    SelectBuilderSql(""""purchasing"."vendor"""", VendorFields.structure, VendorRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VendorRow] = {
    sql"""select "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text from "purchasing"."vendor"""".query(using VendorRow.jdbcDecoder).selectStream()
  }
  override def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[VendorRow]] = {
    sql"""select "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text from "purchasing"."vendor" where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".query(using VendorRow.jdbcDecoder).selectOne
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, VendorRow] = {
    sql"""select "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text from "purchasing"."vendor" where "businessentityid" = ANY(${Segment.paramSegment(businessentityids)(BusinessentityId.arraySetter)})""".query(using VendorRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, VendorRow]] = {
    selectByIds(businessentityids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[VendorFields, VendorRow] = {
    UpdateBuilder(""""purchasing"."vendor"""", VendorFields.structure, VendorRow.jdbcDecoder)
  }
  override def update(row: VendorRow): ZIO[ZConnection, Throwable, Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update "purchasing"."vendor"
          set "accountnumber" = ${Segment.paramSegment(row.accountnumber)(AccountNumber.setter)}::varchar,
              "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "creditrating" = ${Segment.paramSegment(row.creditrating)(TypoShort.setter)}::int2,
              "preferredvendorstatus" = ${Segment.paramSegment(row.preferredvendorstatus)(Flag.setter)}::bool,
              "activeflag" = ${Segment.paramSegment(row.activeflag)(Flag.setter)}::bool,
              "purchasingwebserviceurl" = ${Segment.paramSegment(row.purchasingwebserviceurl)(Setter.optionParamSetter(Setter.stringSetter))},
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: VendorRow): ZIO[ZConnection, Throwable, UpdateResult[VendorRow]] = {
    sql"""insert into "purchasing"."vendor"("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.accountnumber)(AccountNumber.setter)}::varchar,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.creditrating)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.preferredvendorstatus)(Flag.setter)}::bool,
            ${Segment.paramSegment(unsaved.activeflag)(Flag.setter)}::bool,
            ${Segment.paramSegment(unsaved.purchasingwebserviceurl)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "accountnumber" = EXCLUDED."accountnumber",
            "name" = EXCLUDED."name",
            "creditrating" = EXCLUDED."creditrating",
            "preferredvendorstatus" = EXCLUDED."preferredvendorstatus",
            "activeflag" = EXCLUDED."activeflag",
            "purchasingwebserviceurl" = EXCLUDED."purchasingwebserviceurl",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text""".insertReturning(using VendorRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, VendorRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"""create temporary table vendor_TEMP (like "purchasing"."vendor") on commit drop""".execute
    val copied = streamingInsert(s"""copy vendor_TEMP("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate") from stdin""", batchSize, unsaved)(VendorRow.text)
    val merged = sql"""insert into "purchasing"."vendor"("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")
                       select * from vendor_TEMP
                       on conflict ("businessentityid")
                       do update set
                         "accountnumber" = EXCLUDED."accountnumber",
                         "name" = EXCLUDED."name",
                         "creditrating" = EXCLUDED."creditrating",
                         "preferredvendorstatus" = EXCLUDED."preferredvendorstatus",
                         "activeflag" = EXCLUDED."activeflag",
                         "purchasingwebserviceurl" = EXCLUDED."purchasingwebserviceurl",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table vendor_TEMP;""".update
    created *> copied *> merged
  }
}
