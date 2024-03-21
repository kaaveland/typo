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
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class BusinessentitycontactRepoImpl extends BusinessentitycontactRepo {
  override def delete(compositeId: BusinessentitycontactId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from person.businessentitycontact where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "personid" = ${Segment.paramSegment(compositeId.personid)(BusinessentityId.setter)} AND "contacttypeid" = ${Segment.paramSegment(compositeId.contacttypeid)(ContacttypeId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    DeleteBuilder("person.businessentitycontact", BusinessentitycontactFields.structure)
  }
  override def insert(unsaved: BusinessentitycontactRow): ZIO[ZConnection, Throwable, BusinessentitycontactRow] = {
    sql"""insert into person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.personid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.contacttypeid)(ContacttypeId.setter)}::int4, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
       """.insertReturning(using BusinessentitycontactRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentitycontactRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(BusinessentitycontactRow.text)
  }
  override def insert(unsaved: BusinessentitycontactRowUnsaved): ZIO[ZConnection, Throwable, BusinessentitycontactRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""personid"""", sql"${Segment.paramSegment(unsaved.personid)(BusinessentityId.setter)}::int4")),
      Some((sql""""contacttypeid"""", sql"${Segment.paramSegment(unsaved.contacttypeid)(ContacttypeId.setter)}::int4")),
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
      sql"""insert into person.businessentitycontact default values
            returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.businessentitycontact($names) values ($values) returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using BusinessentitycontactRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, BusinessentitycontactRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(BusinessentitycontactRowUnsaved.text)
  }
  override def select: SelectBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    SelectBuilderSql("person.businessentitycontact", BusinessentitycontactFields.structure, BusinessentitycontactRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, BusinessentitycontactRow] = {
    sql"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text from person.businessentitycontact""".query(using BusinessentitycontactRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: BusinessentitycontactId): ZIO[ZConnection, Throwable, Option[BusinessentitycontactRow]] = {
    sql"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text from person.businessentitycontact where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "personid" = ${Segment.paramSegment(compositeId.personid)(BusinessentityId.setter)} AND "contacttypeid" = ${Segment.paramSegment(compositeId.contacttypeid)(ContacttypeId.setter)}""".query(using BusinessentitycontactRow.jdbcDecoder).selectOne
  }
  override def update(row: BusinessentitycontactRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.businessentitycontact
          set "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "personid" = ${Segment.paramSegment(compositeId.personid)(BusinessentityId.setter)} AND "contacttypeid" = ${Segment.paramSegment(compositeId.contacttypeid)(ContacttypeId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    UpdateBuilder("person.businessentitycontact", BusinessentitycontactFields.structure, BusinessentitycontactRow.jdbcDecoder)
  }
  override def upsert(unsaved: BusinessentitycontactRow): ZIO[ZConnection, Throwable, UpdateResult[BusinessentitycontactRow]] = {
    sql"""insert into person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.personid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.contacttypeid)(ContacttypeId.setter)}::int4,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "personid", "contacttypeid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text""".insertReturning(using BusinessentitycontactRow.jdbcDecoder)
  }
}
