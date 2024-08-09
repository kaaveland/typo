/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
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

class SalesterritoryhistoryRepoImpl extends SalesterritoryhistoryRepo {
  override def delete: DeleteBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    DeleteBuilder(""""sales"."salesterritoryhistory"""", SalesterritoryhistoryFields.structure)
  }
  override def deleteById(compositeId: SalesterritoryhistoryId)(implicit c: Connection): Boolean = {
    SQL"""delete from "sales"."salesterritoryhistory" where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDateTime.toStatement)} AND "territoryid" = ${ParameterValue(compositeId.territoryid, null, SalesterritoryId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[SalesterritoryhistoryId])(implicit c: Connection): Int = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val startdate = compositeIds.map(_.startdate)
    val territoryid = compositeIds.map(_.territoryid)
    SQL"""delete
          from "sales"."salesterritoryhistory"
          where ("businessentityid", "startdate", "territoryid")
          in (select unnest(${businessentityid}), unnest(${startdate}), unnest(${territoryid}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: SalesterritoryhistoryRow)(implicit c: Connection): SalesterritoryhistoryRow = {
    SQL"""insert into "sales"."salesterritoryhistory"("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.territoryid, null, SalesterritoryId.toStatement)}::int4, ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
       """
      .executeInsert(SalesterritoryhistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalesterritoryhistoryRowUnsaved)(implicit c: Connection): SalesterritoryhistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue(unsaved.territoryid, null, SalesterritoryId.toStatement)), "::int4")),
      Some((NamedParameter("startdate", ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
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
      SQL"""insert into "sales"."salesterritoryhistory" default values
            returning "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
         """
        .executeInsert(SalesterritoryhistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into "sales"."salesterritoryhistory"(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SalesterritoryhistoryRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[SalesterritoryhistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."salesterritoryhistory"("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalesterritoryhistoryRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SalesterritoryhistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."salesterritoryhistory"("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalesterritoryhistoryRowUnsaved.text, c)
  }
  override def select: SelectBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    SelectBuilderSql(""""sales"."salesterritoryhistory"""", SalesterritoryhistoryFields.structure, SalesterritoryhistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalesterritoryhistoryRow] = {
    SQL"""select "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
          from "sales"."salesterritoryhistory"
       """.as(SalesterritoryhistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: SalesterritoryhistoryId)(implicit c: Connection): Option[SalesterritoryhistoryRow] = {
    SQL"""select "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
          from "sales"."salesterritoryhistory"
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDateTime.toStatement)} AND "territoryid" = ${ParameterValue(compositeId.territoryid, null, SalesterritoryId.toStatement)}
       """.as(SalesterritoryhistoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[SalesterritoryhistoryId])(implicit c: Connection): List[SalesterritoryhistoryRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val startdate = compositeIds.map(_.startdate)
    val territoryid = compositeIds.map(_.territoryid)
    SQL"""select "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
          from "sales"."salesterritoryhistory"
          where ("businessentityid", "startdate", "territoryid") 
          in (select unnest(${businessentityid}), unnest(${startdate}), unnest(${territoryid}))
       """.as(SalesterritoryhistoryRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(compositeIds: Array[SalesterritoryhistoryId])(implicit c: Connection): Map[SalesterritoryhistoryId, SalesterritoryhistoryRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[SalesterritoryhistoryFields, SalesterritoryhistoryRow] = {
    UpdateBuilder(""""sales"."salesterritoryhistory"""", SalesterritoryhistoryFields.structure, SalesterritoryhistoryRow.rowParser)
  }
  override def update(row: SalesterritoryhistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update "sales"."salesterritoryhistory"
          set "enddate" = ${ParameterValue(row.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDateTime.toStatement)} AND "territoryid" = ${ParameterValue(compositeId.territoryid, null, SalesterritoryId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: SalesterritoryhistoryRow)(implicit c: Connection): SalesterritoryhistoryRow = {
    SQL"""insert into "sales"."salesterritoryhistory"("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.territoryid, null, SalesterritoryId.toStatement)}::int4,
            ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid", "startdate", "territoryid")
          do update set
            "enddate" = EXCLUDED."enddate",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
       """
      .executeInsert(SalesterritoryhistoryRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[SalesterritoryhistoryRow])(implicit c: Connection): List[SalesterritoryhistoryRow] = {
    def toNamedParameter(row: SalesterritoryhistoryRow): List[NamedParameter] = List(
      NamedParameter("businessentityid", ParameterValue(row.businessentityid, null, BusinessentityId.toStatement)),
      NamedParameter("territoryid", ParameterValue(row.territoryid, null, SalesterritoryId.toStatement)),
      NamedParameter("startdate", ParameterValue(row.startdate, null, TypoLocalDateTime.toStatement)),
      NamedParameter("enddate", ParameterValue(row.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))),
      NamedParameter("rowguid", ParameterValue(row.rowguid, null, TypoUUID.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into "sales"."salesterritoryhistory"("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")
                values ({businessentityid}::int4, {territoryid}::int4, {startdate}::timestamp, {enddate}::timestamp, {rowguid}::uuid, {modifieddate}::timestamp)
                on conflict ("businessentityid", "startdate", "territoryid")
                do update set
                  "enddate" = EXCLUDED."enddate",
                  "rowguid" = EXCLUDED."rowguid",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(SalesterritoryhistoryRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[SalesterritoryhistoryRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"""create temporary table salesterritoryhistory_TEMP (like "sales"."salesterritoryhistory") on commit drop""".execute(): @nowarn
    streamingInsert(s"""copy salesterritoryhistory_TEMP("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(SalesterritoryhistoryRow.text, c): @nowarn
    SQL"""insert into "sales"."salesterritoryhistory"("businessentityid", "territoryid", "startdate", "enddate", "rowguid", "modifieddate")
          select * from salesterritoryhistory_TEMP
          on conflict ("businessentityid", "startdate", "territoryid")
          do update set
            "enddate" = EXCLUDED."enddate",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table salesterritoryhistory_TEMP;""".executeUpdate()
  }
}
