/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterMetaData
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

class SpecialofferRepoImpl extends SpecialofferRepo {
  override def delete: DeleteBuilder[SpecialofferFields, SpecialofferRow] = {
    DeleteBuilder(""""sales"."specialoffer"""", SpecialofferFields.structure)
  }
  override def deleteById(specialofferid: SpecialofferId)(implicit c: Connection): Boolean = {
    SQL"""delete from "sales"."specialoffer" where "specialofferid" = ${ParameterValue(specialofferid, null, SpecialofferId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(specialofferids: Array[SpecialofferId])(implicit c: Connection): Int = {
    SQL"""delete
          from "sales"."specialoffer"
          where "specialofferid" = ANY(${specialofferids})
       """.executeUpdate()
    
  }
  override def insert(unsaved: SpecialofferRow)(implicit c: Connection): SpecialofferRow = {
    SQL"""insert into "sales"."specialoffer"("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.specialofferid, null, SpecialofferId.toStatement)}::int4, ${ParameterValue(unsaved.description, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.discountpct, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.`type`, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.category, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.enddate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.minqty, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.maxqty, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))}::int4, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
       """
      .executeInsert(SpecialofferRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SpecialofferRowUnsaved)(implicit c: Connection): SpecialofferRow = {
    val namedParameters = List(
      Some((NamedParameter("description", ParameterValue(unsaved.description, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("type", ParameterValue(unsaved.`type`, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("category", ParameterValue(unsaved.category, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("startdate", ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue(unsaved.enddate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("maxqty", ParameterValue(unsaved.maxqty, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))), "::int4")),
      unsaved.specialofferid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("specialofferid", ParameterValue(value, null, SpecialofferId.toStatement)), "::int4"))
      },
      unsaved.discountpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("discountpct", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.minqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("minqty", ParameterValue(value, null, ToStatement.intToStatement)), "::int4"))
      },
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
      SQL"""insert into "sales"."specialoffer" default values
            returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
         """
        .executeInsert(SpecialofferRow.rowParser(1).single)
    } else {
      val q = s"""insert into "sales"."specialoffer"(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SpecialofferRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[SpecialofferRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."specialoffer"("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SpecialofferRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SpecialofferRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."specialoffer"("description", "type", "category", "startdate", "enddate", "maxqty", "specialofferid", "discountpct", "minqty", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SpecialofferRowUnsaved.text, c)
  }
  override def select: SelectBuilder[SpecialofferFields, SpecialofferRow] = {
    SelectBuilderSql(""""sales"."specialoffer"""", SpecialofferFields.structure, SpecialofferRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SpecialofferRow] = {
    SQL"""select "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
          from "sales"."specialoffer"
       """.as(SpecialofferRow.rowParser(1).*)
  }
  override def selectById(specialofferid: SpecialofferId)(implicit c: Connection): Option[SpecialofferRow] = {
    SQL"""select "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
          from "sales"."specialoffer"
          where "specialofferid" = ${ParameterValue(specialofferid, null, SpecialofferId.toStatement)}
       """.as(SpecialofferRow.rowParser(1).singleOpt)
  }
  override def selectByIds(specialofferids: Array[SpecialofferId])(implicit c: Connection): List[SpecialofferRow] = {
    SQL"""select "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
          from "sales"."specialoffer"
          where "specialofferid" = ANY(${specialofferids})
       """.as(SpecialofferRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(specialofferids: Array[SpecialofferId])(implicit c: Connection): Map[SpecialofferId, SpecialofferRow] = {
    val byId = selectByIds(specialofferids).view.map(x => (x.specialofferid, x)).toMap
    specialofferids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[SpecialofferFields, SpecialofferRow] = {
    UpdateBuilder(""""sales"."specialoffer"""", SpecialofferFields.structure, SpecialofferRow.rowParser)
  }
  override def update(row: SpecialofferRow)(implicit c: Connection): Boolean = {
    val specialofferid = row.specialofferid
    SQL"""update "sales"."specialoffer"
          set "description" = ${ParameterValue(row.description, null, ToStatement.stringToStatement)},
              "discountpct" = ${ParameterValue(row.discountpct, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "type" = ${ParameterValue(row.`type`, null, ToStatement.stringToStatement)},
              "category" = ${ParameterValue(row.category, null, ToStatement.stringToStatement)},
              "startdate" = ${ParameterValue(row.startdate, null, TypoLocalDateTime.toStatement)}::timestamp,
              "enddate" = ${ParameterValue(row.enddate, null, TypoLocalDateTime.toStatement)}::timestamp,
              "minqty" = ${ParameterValue(row.minqty, null, ToStatement.intToStatement)}::int4,
              "maxqty" = ${ParameterValue(row.maxqty, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))}::int4,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "specialofferid" = ${ParameterValue(specialofferid, null, SpecialofferId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: SpecialofferRow)(implicit c: Connection): SpecialofferRow = {
    SQL"""insert into "sales"."specialoffer"("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.specialofferid, null, SpecialofferId.toStatement)}::int4,
            ${ParameterValue(unsaved.description, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.discountpct, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.`type`, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.category, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.enddate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.minqty, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.maxqty, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))}::int4,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("specialofferid")
          do update set
            "description" = EXCLUDED."description",
            "discountpct" = EXCLUDED."discountpct",
            "type" = EXCLUDED."type",
            "category" = EXCLUDED."category",
            "startdate" = EXCLUDED."startdate",
            "enddate" = EXCLUDED."enddate",
            "minqty" = EXCLUDED."minqty",
            "maxqty" = EXCLUDED."maxqty",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
       """
      .executeInsert(SpecialofferRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[SpecialofferRow])(implicit c: Connection): List[SpecialofferRow] = {
    def toNamedParameter(row: SpecialofferRow): List[NamedParameter] = List(
      NamedParameter("specialofferid", ParameterValue(row.specialofferid, null, SpecialofferId.toStatement)),
      NamedParameter("description", ParameterValue(row.description, null, ToStatement.stringToStatement)),
      NamedParameter("discountpct", ParameterValue(row.discountpct, null, ToStatement.scalaBigDecimalToStatement)),
      NamedParameter("type", ParameterValue(row.`type`, null, ToStatement.stringToStatement)),
      NamedParameter("category", ParameterValue(row.category, null, ToStatement.stringToStatement)),
      NamedParameter("startdate", ParameterValue(row.startdate, null, TypoLocalDateTime.toStatement)),
      NamedParameter("enddate", ParameterValue(row.enddate, null, TypoLocalDateTime.toStatement)),
      NamedParameter("minqty", ParameterValue(row.minqty, null, ToStatement.intToStatement)),
      NamedParameter("maxqty", ParameterValue(row.maxqty, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))),
      NamedParameter("rowguid", ParameterValue(row.rowguid, null, TypoUUID.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into "sales"."specialoffer"("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")
                values ({specialofferid}::int4, {description}, {discountpct}::numeric, {type}, {category}, {startdate}::timestamp, {enddate}::timestamp, {minqty}::int4, {maxqty}::int4, {rowguid}::uuid, {modifieddate}::timestamp)
                on conflict ("specialofferid")
                do update set
                  "description" = EXCLUDED."description",
                  "discountpct" = EXCLUDED."discountpct",
                  "type" = EXCLUDED."type",
                  "category" = EXCLUDED."category",
                  "startdate" = EXCLUDED."startdate",
                  "enddate" = EXCLUDED."enddate",
                  "minqty" = EXCLUDED."minqty",
                  "maxqty" = EXCLUDED."maxqty",
                  "rowguid" = EXCLUDED."rowguid",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(SpecialofferRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[SpecialofferRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"""create temporary table specialoffer_TEMP (like "sales"."specialoffer") on commit drop""".execute(): @nowarn
    streamingInsert(s"""copy specialoffer_TEMP("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(SpecialofferRow.text, c): @nowarn
    SQL"""insert into "sales"."specialoffer"("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")
          select * from specialoffer_TEMP
          on conflict ("specialofferid")
          do update set
            "description" = EXCLUDED."description",
            "discountpct" = EXCLUDED."discountpct",
            "type" = EXCLUDED."type",
            "category" = EXCLUDED."category",
            "startdate" = EXCLUDED."startdate",
            "enddate" = EXCLUDED."enddate",
            "minqty" = EXCLUDED."minqty",
            "maxqty" = EXCLUDED."maxqty",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table specialoffer_TEMP;""".executeUpdate()
  }
}
