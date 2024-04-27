/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class BusinessentitycontactRepoImpl extends BusinessentitycontactRepo {
  override def delete: DeleteBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    DeleteBuilder("person.businessentitycontact", BusinessentitycontactFields.structure)
  }
  override def deleteById(compositeId: BusinessentitycontactId): ConnectionIO[Boolean] = {
    sql"""delete from person.businessentitycontact where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "personid" = ${fromWrite(compositeId.personid)(Write.fromPut(BusinessentityId.put))} AND "contacttypeid" = ${fromWrite(compositeId.contacttypeid)(Write.fromPut(ContacttypeId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[BusinessentitycontactId]): ConnectionIO[Int] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val personid = compositeIds.map(_.personid)
    val contacttypeid = compositeIds.map(_.contacttypeid)
    sql"""delete
          from person.businessentitycontact
          where ("businessentityid", "personid", "contacttypeid")
          in (select unnest(${businessentityid}), unnest(${personid}), unnest(${contacttypeid}))
       """.update.run
    
  }
  override def insert(unsaved: BusinessentitycontactRow): ConnectionIO[BusinessentitycontactRow] = {
    sql"""insert into person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.personid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.contacttypeid)(Write.fromPut(ContacttypeId.put))}::int4, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
       """.query(using BusinessentitycontactRow.read).unique
  }
  override def insert(unsaved: BusinessentitycontactRowUnsaved): ConnectionIO[BusinessentitycontactRow] = {
    val fs = List(
      Some((Fragment.const(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""personid""""), fr"${fromWrite(unsaved.personid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""contacttypeid""""), fr"${fromWrite(unsaved.contacttypeid)(Write.fromPut(ContacttypeId.put))}::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.businessentitycontact default values
            returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into person.businessentitycontact(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
         """
    }
    q.query(using BusinessentitycontactRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, BusinessentitycontactRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using BusinessentitycontactRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BusinessentitycontactRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using BusinessentitycontactRowUnsaved.text)
  }
  override def select: SelectBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    SelectBuilderSql("person.businessentitycontact", BusinessentitycontactFields.structure, BusinessentitycontactRow.read)
  }
  override def selectAll: Stream[ConnectionIO, BusinessentitycontactRow] = {
    sql"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text from person.businessentitycontact""".query(using BusinessentitycontactRow.read).stream
  }
  override def selectById(compositeId: BusinessentitycontactId): ConnectionIO[Option[BusinessentitycontactRow]] = {
    sql"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text from person.businessentitycontact where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "personid" = ${fromWrite(compositeId.personid)(Write.fromPut(BusinessentityId.put))} AND "contacttypeid" = ${fromWrite(compositeId.contacttypeid)(Write.fromPut(ContacttypeId.put))}""".query(using BusinessentitycontactRow.read).option
  }
  override def selectByIds(compositeIds: Array[BusinessentitycontactId]): Stream[ConnectionIO, BusinessentitycontactRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val personid = compositeIds.map(_.personid)
    val contacttypeid = compositeIds.map(_.contacttypeid)
    sql"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
          from person.businessentitycontact
          where ("businessentityid", "personid", "contacttypeid") 
          in (select unnest(${businessentityid}), unnest(${personid}), unnest(${contacttypeid}))
       """.query(using BusinessentitycontactRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[BusinessentitycontactId]): ConnectionIO[Map[BusinessentitycontactId, Option[BusinessentitycontactRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    UpdateBuilder("person.businessentitycontact", BusinessentitycontactFields.structure, BusinessentitycontactRow.read)
  }
  override def update(row: BusinessentitycontactRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.businessentitycontact
          set "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "personid" = ${fromWrite(compositeId.personid)(Write.fromPut(BusinessentityId.put))} AND "contacttypeid" = ${fromWrite(compositeId.contacttypeid)(Write.fromPut(ContacttypeId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: BusinessentitycontactRow): ConnectionIO[BusinessentitycontactRow] = {
    sql"""insert into person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.personid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.contacttypeid)(Write.fromPut(ContacttypeId.put))}::int4,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid", "personid", "contacttypeid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
       """.query(using BusinessentitycontactRow.read).unique
  }
}
