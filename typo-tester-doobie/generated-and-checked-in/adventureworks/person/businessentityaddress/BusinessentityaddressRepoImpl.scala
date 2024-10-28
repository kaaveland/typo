/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class BusinessentityaddressRepoImpl extends BusinessentityaddressRepo {
  override def delete: DeleteBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    DeleteBuilder(""""person"."businessentityaddress"""", BusinessentityaddressFields.structure)
  }
  override def deleteById(compositeId: BusinessentityaddressId): ConnectionIO[Boolean] = {
    sql"""delete from "person"."businessentityaddress" where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "addressid" = ${fromWrite(compositeId.addressid)(Write.fromPut(AddressId.put))} AND "addresstypeid" = ${fromWrite(compositeId.addresstypeid)(Write.fromPut(AddresstypeId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[BusinessentityaddressId]): ConnectionIO[Int] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val addressid = compositeIds.map(_.addressid)
    val addresstypeid = compositeIds.map(_.addresstypeid)
    sql"""delete
          from "person"."businessentityaddress"
          where ("businessentityid", "addressid", "addresstypeid")
          in (select unnest(${businessentityid}), unnest(${addressid}), unnest(${addresstypeid}))
       """.update.run
    
  }
  override def insert(unsaved: BusinessentityaddressRow): ConnectionIO[BusinessentityaddressRow] = {
    sql"""insert into "person"."businessentityaddress"("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.addressid)(Write.fromPut(AddressId.put))}::int4, ${fromWrite(unsaved.addresstypeid)(Write.fromPut(AddresstypeId.put))}::int4, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
       """.query(using BusinessentityaddressRow.read).unique
  }
  override def insert(unsaved: BusinessentityaddressRowUnsaved): ConnectionIO[BusinessentityaddressRow] = {
    val fs = List(
      Some((Fragment.const0(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const0(s""""addressid""""), fr"${fromWrite(unsaved.addressid)(Write.fromPut(AddressId.put))}::int4")),
      Some((Fragment.const0(s""""addresstypeid""""), fr"${fromWrite(unsaved.addresstypeid)(Write.fromPut(AddresstypeId.put))}::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into "person"."businessentityaddress" default values
            returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into "person"."businessentityaddress"(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
         """
    }
    q.query(using BusinessentityaddressRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, BusinessentityaddressRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "person"."businessentityaddress"("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using BusinessentityaddressRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BusinessentityaddressRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "person"."businessentityaddress"("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using BusinessentityaddressRowUnsaved.text)
  }
  override def select: SelectBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    SelectBuilderSql(""""person"."businessentityaddress"""", BusinessentityaddressFields.structure, BusinessentityaddressRow.read)
  }
  override def selectAll: Stream[ConnectionIO, BusinessentityaddressRow] = {
    sql"""select "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text from "person"."businessentityaddress"""".query(using BusinessentityaddressRow.read).stream
  }
  override def selectById(compositeId: BusinessentityaddressId): ConnectionIO[Option[BusinessentityaddressRow]] = {
    sql"""select "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text from "person"."businessentityaddress" where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "addressid" = ${fromWrite(compositeId.addressid)(Write.fromPut(AddressId.put))} AND "addresstypeid" = ${fromWrite(compositeId.addresstypeid)(Write.fromPut(AddresstypeId.put))}""".query(using BusinessentityaddressRow.read).option
  }
  override def selectByIds(compositeIds: Array[BusinessentityaddressId]): Stream[ConnectionIO, BusinessentityaddressRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val addressid = compositeIds.map(_.addressid)
    val addresstypeid = compositeIds.map(_.addresstypeid)
    sql"""select "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
          from "person"."businessentityaddress"
          where ("businessentityid", "addressid", "addresstypeid")
          in (select unnest(${businessentityid}), unnest(${addressid}), unnest(${addresstypeid}))
       """.query(using BusinessentityaddressRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[BusinessentityaddressId]): ConnectionIO[Map[BusinessentityaddressId, BusinessentityaddressRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[BusinessentityaddressFields, BusinessentityaddressRow] = {
    UpdateBuilder(""""person"."businessentityaddress"""", BusinessentityaddressFields.structure, BusinessentityaddressRow.read)
  }
  override def update(row: BusinessentityaddressRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update "person"."businessentityaddress"
          set "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "addressid" = ${fromWrite(compositeId.addressid)(Write.fromPut(AddressId.put))} AND "addresstypeid" = ${fromWrite(compositeId.addresstypeid)(Write.fromPut(AddresstypeId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: BusinessentityaddressRow): ConnectionIO[BusinessentityaddressRow] = {
    sql"""insert into "person"."businessentityaddress"("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.addressid)(Write.fromPut(AddressId.put))}::int4,
            ${fromWrite(unsaved.addresstypeid)(Write.fromPut(AddresstypeId.put))}::int4,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid", "addressid", "addresstypeid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
       """.query(using BusinessentityaddressRow.read).unique
  }
  override def upsertBatch(unsaved: List[BusinessentityaddressRow]): Stream[ConnectionIO, BusinessentityaddressRow] = {
    Update[BusinessentityaddressRow](
      s"""insert into "person"."businessentityaddress"("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")
          values (?::int4,?::int4,?::int4,?::uuid,?::timestamp)
          on conflict ("businessentityid", "addressid", "addresstypeid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text"""
    )(using BusinessentityaddressRow.write)
    .updateManyWithGeneratedKeys[BusinessentityaddressRow]("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")(unsaved)(using catsStdInstancesForList, BusinessentityaddressRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, BusinessentityaddressRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"""create temporary table businessentityaddress_TEMP (like "person"."businessentityaddress") on commit drop""".update.run
      _ <- new FragmentOps(sql"""copy businessentityaddress_TEMP("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using BusinessentityaddressRow.text)
      res <- sql"""insert into "person"."businessentityaddress"("businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate")
                   select * from businessentityaddress_TEMP
                   on conflict ("businessentityid", "addressid", "addresstypeid")
                   do update set
                     "rowguid" = EXCLUDED."rowguid",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table businessentityaddress_TEMP;""".update.run
    } yield res
  }
}
