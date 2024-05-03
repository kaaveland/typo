/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ShipmethodRepoImpl extends ShipmethodRepo {
  override def delete: DeleteBuilder[ShipmethodFields, ShipmethodRow] = {
    DeleteBuilder("purchasing.shipmethod", ShipmethodFields.structure)
  }
  override def deleteById(shipmethodid: ShipmethodId)(implicit c: Connection): Boolean = {
    SQL"""delete from purchasing.shipmethod where "shipmethodid" = ${ParameterValue(shipmethodid, null, ShipmethodId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(shipmethodids: Array[ShipmethodId])(implicit c: Connection): Int = {
    SQL"""delete
          from purchasing.shipmethod
          where "shipmethodid" = ANY(${shipmethodids})
       """.executeUpdate()
    
  }
  override def insert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow = {
    SQL"""insert into purchasing.shipmethod("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.shipmethodid, null, ShipmethodId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.shipbase, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.shiprate, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
       """
      .executeInsert(ShipmethodRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ShipmethodRowUnsaved)(implicit c: Connection): ShipmethodRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      unsaved.shipmethodid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shipmethodid", ParameterValue(value, null, ShipmethodId.toStatement)), "::int4"))
      },
      unsaved.shipbase match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shipbase", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.shiprate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shiprate", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
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
      SQL"""insert into purchasing.shipmethod default values
            returning "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
         """
        .executeInsert(ShipmethodRow.rowParser(1).single)
    } else {
      val q = s"""insert into purchasing.shipmethod(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ShipmethodRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[ShipmethodRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY purchasing.shipmethod("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ShipmethodRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ShipmethodRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY purchasing.shipmethod("name", "shipmethodid", "shipbase", "shiprate", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ShipmethodRowUnsaved.text, c)
  }
  override def select: SelectBuilder[ShipmethodFields, ShipmethodRow] = {
    SelectBuilderSql("purchasing.shipmethod", ShipmethodFields.structure, ShipmethodRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ShipmethodRow] = {
    SQL"""select "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
          from purchasing.shipmethod
       """.as(ShipmethodRow.rowParser(1).*)
  }
  override def selectById(shipmethodid: ShipmethodId)(implicit c: Connection): Option[ShipmethodRow] = {
    SQL"""select "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
          from purchasing.shipmethod
          where "shipmethodid" = ${ParameterValue(shipmethodid, null, ShipmethodId.toStatement)}
       """.as(ShipmethodRow.rowParser(1).singleOpt)
  }
  override def selectByIds(shipmethodids: Array[ShipmethodId])(implicit c: Connection): List[ShipmethodRow] = {
    SQL"""select "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
          from purchasing.shipmethod
          where "shipmethodid" = ANY(${shipmethodids})
       """.as(ShipmethodRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(shipmethodids: Array[ShipmethodId])(implicit c: Connection): Map[ShipmethodId, ShipmethodRow] = {
    val byId = selectByIds(shipmethodids).view.map(x => (x.shipmethodid, x)).toMap
    shipmethodids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ShipmethodFields, ShipmethodRow] = {
    UpdateBuilder("purchasing.shipmethod", ShipmethodFields.structure, ShipmethodRow.rowParser)
  }
  override def update(row: ShipmethodRow)(implicit c: Connection): Boolean = {
    val shipmethodid = row.shipmethodid
    SQL"""update purchasing.shipmethod
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "shipbase" = ${ParameterValue(row.shipbase, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "shiprate" = ${ParameterValue(row.shiprate, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "shipmethodid" = ${ParameterValue(shipmethodid, null, ShipmethodId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ShipmethodRow)(implicit c: Connection): ShipmethodRow = {
    SQL"""insert into purchasing.shipmethod("shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.shipmethodid, null, ShipmethodId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.shipbase, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.shiprate, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("shipmethodid")
          do update set
            "name" = EXCLUDED."name",
            "shipbase" = EXCLUDED."shipbase",
            "shiprate" = EXCLUDED."shiprate",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "shipmethodid", "name", "shipbase", "shiprate", "rowguid", "modifieddate"::text
       """
      .executeInsert(ShipmethodRow.rowParser(1).single)
    
  }
}
