/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
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

class LocationRepoImpl extends LocationRepo {
  override def delete: DeleteBuilder[LocationFields, LocationRow] = {
    DeleteBuilder(""""production"."location"""", LocationFields.structure)
  }
  override def deleteById(locationid: LocationId)(implicit c: Connection): Boolean = {
    SQL"""delete from "production"."location" where "locationid" = ${ParameterValue(locationid, null, LocationId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(locationids: Array[LocationId])(implicit c: Connection): Int = {
    SQL"""delete
          from "production"."location"
          where "locationid" = ANY(${locationids})
       """.executeUpdate()
    
  }
  override def insert(unsaved: LocationRow)(implicit c: Connection): LocationRow = {
    SQL"""insert into "production"."location"("locationid", "name", "costrate", "availability", "modifieddate")
          values (${ParameterValue(unsaved.locationid, null, LocationId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.costrate, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.availability, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "locationid", "name", "costrate", "availability", "modifieddate"::text
       """
      .executeInsert(LocationRow.rowParser(1).single)
    
  }
  override def insert(unsaved: LocationRowUnsaved)(implicit c: Connection): LocationRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      unsaved.locationid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("locationid", ParameterValue(value, null, LocationId.toStatement)), "::int4"))
      },
      unsaved.costrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("costrate", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.availability match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("availability", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into "production"."location" default values
            returning "locationid", "name", "costrate", "availability", "modifieddate"::text
         """
        .executeInsert(LocationRow.rowParser(1).single)
    } else {
      val q = s"""insert into "production"."location"(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "locationid", "name", "costrate", "availability", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(LocationRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[LocationRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "production"."location"("locationid", "name", "costrate", "availability", "modifieddate") FROM STDIN""", batchSize, unsaved)(LocationRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[LocationRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "production"."location"("name", "locationid", "costrate", "availability", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(LocationRowUnsaved.text, c)
  }
  override def select: SelectBuilder[LocationFields, LocationRow] = {
    SelectBuilderSql(""""production"."location"""", LocationFields.structure, LocationRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[LocationRow] = {
    SQL"""select "locationid", "name", "costrate", "availability", "modifieddate"::text
          from "production"."location"
       """.as(LocationRow.rowParser(1).*)
  }
  override def selectById(locationid: LocationId)(implicit c: Connection): Option[LocationRow] = {
    SQL"""select "locationid", "name", "costrate", "availability", "modifieddate"::text
          from "production"."location"
          where "locationid" = ${ParameterValue(locationid, null, LocationId.toStatement)}
       """.as(LocationRow.rowParser(1).singleOpt)
  }
  override def selectByIds(locationids: Array[LocationId])(implicit c: Connection): List[LocationRow] = {
    SQL"""select "locationid", "name", "costrate", "availability", "modifieddate"::text
          from "production"."location"
          where "locationid" = ANY(${locationids})
       """.as(LocationRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(locationids: Array[LocationId])(implicit c: Connection): Map[LocationId, LocationRow] = {
    val byId = selectByIds(locationids).view.map(x => (x.locationid, x)).toMap
    locationids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[LocationFields, LocationRow] = {
    UpdateBuilder(""""production"."location"""", LocationFields.structure, LocationRow.rowParser)
  }
  override def update(row: LocationRow)(implicit c: Connection): Boolean = {
    val locationid = row.locationid
    SQL"""update "production"."location"
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "costrate" = ${ParameterValue(row.costrate, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "availability" = ${ParameterValue(row.availability, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "locationid" = ${ParameterValue(locationid, null, LocationId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: LocationRow)(implicit c: Connection): LocationRow = {
    SQL"""insert into "production"."location"("locationid", "name", "costrate", "availability", "modifieddate")
          values (
            ${ParameterValue(unsaved.locationid, null, LocationId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.costrate, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.availability, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("locationid")
          do update set
            "name" = EXCLUDED."name",
            "costrate" = EXCLUDED."costrate",
            "availability" = EXCLUDED."availability",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "locationid", "name", "costrate", "availability", "modifieddate"::text
       """
      .executeInsert(LocationRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[LocationRow])(implicit c: Connection): List[LocationRow] = {
    def toNamedParameter(row: LocationRow): List[NamedParameter] = List(
      NamedParameter("locationid", ParameterValue(row.locationid, null, LocationId.toStatement)),
      NamedParameter("name", ParameterValue(row.name, null, Name.toStatement)),
      NamedParameter("costrate", ParameterValue(row.costrate, null, ToStatement.scalaBigDecimalToStatement)),
      NamedParameter("availability", ParameterValue(row.availability, null, ToStatement.scalaBigDecimalToStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into "production"."location"("locationid", "name", "costrate", "availability", "modifieddate")
                values ({locationid}::int4, {name}::varchar, {costrate}::numeric, {availability}::numeric, {modifieddate}::timestamp)
                on conflict ("locationid")
                do update set
                  "name" = EXCLUDED."name",
                  "costrate" = EXCLUDED."costrate",
                  "availability" = EXCLUDED."availability",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "locationid", "name", "costrate", "availability", "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(LocationRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[LocationRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"""create temporary table location_TEMP (like "production"."location") on commit drop""".execute(): @nowarn
    streamingInsert(s"""copy location_TEMP("locationid", "name", "costrate", "availability", "modifieddate") from stdin""", batchSize, unsaved)(LocationRow.text, c): @nowarn
    SQL"""insert into "production"."location"("locationid", "name", "costrate", "availability", "modifieddate")
          select * from location_TEMP
          on conflict ("locationid")
          do update set
            "name" = EXCLUDED."name",
            "costrate" = EXCLUDED."costrate",
            "availability" = EXCLUDED."availability",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table location_TEMP;""".executeUpdate()
  }
}
