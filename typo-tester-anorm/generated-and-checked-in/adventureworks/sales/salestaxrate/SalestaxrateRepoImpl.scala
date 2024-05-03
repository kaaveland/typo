/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.stateprovince.StateprovinceId
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

class SalestaxrateRepoImpl extends SalestaxrateRepo {
  override def delete: DeleteBuilder[SalestaxrateFields, SalestaxrateRow] = {
    DeleteBuilder("sales.salestaxrate", SalestaxrateFields.structure)
  }
  override def deleteById(salestaxrateid: SalestaxrateId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.salestaxrate where "salestaxrateid" = ${ParameterValue(salestaxrateid, null, SalestaxrateId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(salestaxrateids: Array[SalestaxrateId])(implicit c: Connection): Int = {
    SQL"""delete
          from sales.salestaxrate
          where "salestaxrateid" = ANY(${salestaxrateids})
       """.executeUpdate()
    
  }
  override def insert(unsaved: SalestaxrateRow)(implicit c: Connection): SalestaxrateRow = {
    SQL"""insert into sales.salestaxrate("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.salestaxrateid, null, SalestaxrateId.toStatement)}::int4, ${ParameterValue(unsaved.stateprovinceid, null, StateprovinceId.toStatement)}::int4, ${ParameterValue(unsaved.taxtype, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.taxrate, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalestaxrateRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalestaxrateRowUnsaved)(implicit c: Connection): SalestaxrateRow = {
    val namedParameters = List(
      Some((NamedParameter("stateprovinceid", ParameterValue(unsaved.stateprovinceid, null, StateprovinceId.toStatement)), "::int4")),
      Some((NamedParameter("taxtype", ParameterValue(unsaved.taxtype, null, TypoShort.toStatement)), "::int2")),
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      unsaved.salestaxrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salestaxrateid", ParameterValue(value, null, SalestaxrateId.toStatement)), "::int4"))
      },
      unsaved.taxrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("taxrate", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
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
      SQL"""insert into sales.salestaxrate default values
            returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
         """
        .executeInsert(SalestaxrateRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salestaxrate(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SalestaxrateRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[SalestaxrateRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.salestaxrate("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalestaxrateRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SalestaxrateRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.salestaxrate("stateprovinceid", "taxtype", "name", "salestaxrateid", "taxrate", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalestaxrateRowUnsaved.text, c)
  }
  override def select: SelectBuilder[SalestaxrateFields, SalestaxrateRow] = {
    SelectBuilderSql("sales.salestaxrate", SalestaxrateFields.structure, SalestaxrateRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalestaxrateRow] = {
    SQL"""select "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
          from sales.salestaxrate
       """.as(SalestaxrateRow.rowParser(1).*)
  }
  override def selectById(salestaxrateid: SalestaxrateId)(implicit c: Connection): Option[SalestaxrateRow] = {
    SQL"""select "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
          from sales.salestaxrate
          where "salestaxrateid" = ${ParameterValue(salestaxrateid, null, SalestaxrateId.toStatement)}
       """.as(SalestaxrateRow.rowParser(1).singleOpt)
  }
  override def selectByIds(salestaxrateids: Array[SalestaxrateId])(implicit c: Connection): List[SalestaxrateRow] = {
    SQL"""select "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
          from sales.salestaxrate
          where "salestaxrateid" = ANY(${salestaxrateids})
       """.as(SalestaxrateRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(salestaxrateids: Array[SalestaxrateId])(implicit c: Connection): Map[SalestaxrateId, SalestaxrateRow] = {
    val byId = selectByIds(salestaxrateids).view.map(x => (x.salestaxrateid, x)).toMap
    salestaxrateids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[SalestaxrateFields, SalestaxrateRow] = {
    UpdateBuilder("sales.salestaxrate", SalestaxrateFields.structure, SalestaxrateRow.rowParser)
  }
  override def update(row: SalestaxrateRow)(implicit c: Connection): Boolean = {
    val salestaxrateid = row.salestaxrateid
    SQL"""update sales.salestaxrate
          set "stateprovinceid" = ${ParameterValue(row.stateprovinceid, null, StateprovinceId.toStatement)}::int4,
              "taxtype" = ${ParameterValue(row.taxtype, null, TypoShort.toStatement)}::int2,
              "taxrate" = ${ParameterValue(row.taxrate, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "salestaxrateid" = ${ParameterValue(salestaxrateid, null, SalestaxrateId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: SalestaxrateRow)(implicit c: Connection): SalestaxrateRow = {
    SQL"""insert into sales.salestaxrate("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.salestaxrateid, null, SalestaxrateId.toStatement)}::int4,
            ${ParameterValue(unsaved.stateprovinceid, null, StateprovinceId.toStatement)}::int4,
            ${ParameterValue(unsaved.taxtype, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.taxrate, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("salestaxrateid")
          do update set
            "stateprovinceid" = EXCLUDED."stateprovinceid",
            "taxtype" = EXCLUDED."taxtype",
            "taxrate" = EXCLUDED."taxrate",
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalestaxrateRow.rowParser(1).single)
    
  }
}
