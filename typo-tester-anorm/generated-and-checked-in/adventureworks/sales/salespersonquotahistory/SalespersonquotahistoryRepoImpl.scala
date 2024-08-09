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
import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class SalespersonquotahistoryRepoImpl extends SalespersonquotahistoryRepo {
  override def delete: DeleteBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    DeleteBuilder(""""sales"."salespersonquotahistory"""", SalespersonquotahistoryFields.structure)
  }
  override def deleteById(compositeId: SalespersonquotahistoryId)(implicit c: Connection): Boolean = {
    SQL"""delete from "sales"."salespersonquotahistory" where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "quotadate" = ${ParameterValue(compositeId.quotadate, null, TypoLocalDateTime.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[SalespersonquotahistoryId])(implicit c: Connection): Int = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val quotadate = compositeIds.map(_.quotadate)
    SQL"""delete
          from "sales"."salespersonquotahistory"
          where ("businessentityid", "quotadate")
          in (select unnest(${businessentityid}), unnest(${quotadate}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: SalespersonquotahistoryRow)(implicit c: Connection): SalespersonquotahistoryRow = {
    SQL"""insert into "sales"."salespersonquotahistory"("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.quotadate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.salesquota, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalespersonquotahistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalespersonquotahistoryRowUnsaved)(implicit c: Connection): SalespersonquotahistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("quotadate", ParameterValue(unsaved.quotadate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("salesquota", ParameterValue(unsaved.salesquota, null, ToStatement.scalaBigDecimalToStatement)), "::numeric")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, TypoUUID.toStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into "sales"."salespersonquotahistory" default values
            returning "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
         """
        .executeInsert(SalespersonquotahistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into "sales"."salespersonquotahistory"(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SalespersonquotahistoryRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[SalespersonquotahistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."salespersonquotahistory"("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalespersonquotahistoryRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SalespersonquotahistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."salespersonquotahistory"("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalespersonquotahistoryRowUnsaved.text, c)
  }
  override def select: SelectBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    SelectBuilderSql(""""sales"."salespersonquotahistory"""", SalespersonquotahistoryFields.structure, SalespersonquotahistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalespersonquotahistoryRow] = {
    SQL"""select "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
          from "sales"."salespersonquotahistory"
       """.as(SalespersonquotahistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: SalespersonquotahistoryId)(implicit c: Connection): Option[SalespersonquotahistoryRow] = {
    SQL"""select "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
          from "sales"."salespersonquotahistory"
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "quotadate" = ${ParameterValue(compositeId.quotadate, null, TypoLocalDateTime.toStatement)}
       """.as(SalespersonquotahistoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[SalespersonquotahistoryId])(implicit c: Connection): List[SalespersonquotahistoryRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val quotadate = compositeIds.map(_.quotadate)
    SQL"""select "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
          from "sales"."salespersonquotahistory"
          where ("businessentityid", "quotadate") 
          in (select unnest(${businessentityid}), unnest(${quotadate}))
       """.as(SalespersonquotahistoryRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(compositeIds: Array[SalespersonquotahistoryId])(implicit c: Connection): Map[SalespersonquotahistoryId, SalespersonquotahistoryRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[SalespersonquotahistoryFields, SalespersonquotahistoryRow] = {
    UpdateBuilder(""""sales"."salespersonquotahistory"""", SalespersonquotahistoryFields.structure, SalespersonquotahistoryRow.rowParser)
  }
  override def update(row: SalespersonquotahistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update "sales"."salespersonquotahistory"
          set "salesquota" = ${ParameterValue(row.salesquota, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "quotadate" = ${ParameterValue(compositeId.quotadate, null, TypoLocalDateTime.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: SalespersonquotahistoryRow)(implicit c: Connection): SalespersonquotahistoryRow = {
    SQL"""insert into "sales"."salespersonquotahistory"("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.quotadate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.salesquota, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid", "quotadate")
          do update set
            "salesquota" = EXCLUDED."salesquota",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalespersonquotahistoryRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[SalespersonquotahistoryRow])(implicit c: Connection): List[SalespersonquotahistoryRow] = {
    def toNamedParameter(row: SalespersonquotahistoryRow): List[NamedParameter] = List(
      NamedParameter("businessentityid", ParameterValue(row.businessentityid, null, BusinessentityId.toStatement)),
      NamedParameter("quotadate", ParameterValue(row.quotadate, null, TypoLocalDateTime.toStatement)),
      NamedParameter("salesquota", ParameterValue(row.salesquota, null, ToStatement.scalaBigDecimalToStatement)),
      NamedParameter("rowguid", ParameterValue(row.rowguid, null, TypoUUID.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into "sales"."salespersonquotahistory"("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate")
                values ({businessentityid}::int4, {quotadate}::timestamp, {salesquota}::numeric, {rowguid}::uuid, {modifieddate}::timestamp)
                on conflict ("businessentityid", "quotadate")
                do update set
                  "salesquota" = EXCLUDED."salesquota",
                  "rowguid" = EXCLUDED."rowguid",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "businessentityid", "quotadate"::text, "salesquota", "rowguid", "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(SalespersonquotahistoryRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[SalespersonquotahistoryRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"""create temporary table salespersonquotahistory_TEMP (like "sales"."salespersonquotahistory") on commit drop""".execute(): @nowarn
    streamingInsert(s"""copy salespersonquotahistory_TEMP("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(SalespersonquotahistoryRow.text, c): @nowarn
    SQL"""insert into "sales"."salespersonquotahistory"("businessentityid", "quotadate", "salesquota", "rowguid", "modifieddate")
          select * from salespersonquotahistory_TEMP
          on conflict ("businessentityid", "quotadate")
          do update set
            "salesquota" = EXCLUDED."salesquota",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table salespersonquotahistory_TEMP;""".executeUpdate()
  }
}
