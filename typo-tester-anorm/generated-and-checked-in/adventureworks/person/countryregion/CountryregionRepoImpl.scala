/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class CountryregionRepoImpl extends CountryregionRepo {
  override def delete: DeleteBuilder[CountryregionFields, CountryregionRow] = {
    DeleteBuilder("person.countryregion", CountryregionFields.structure)
  }
  override def deleteById(countryregioncode: CountryregionId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.countryregion where "countryregioncode" = ${ParameterValue(countryregioncode, null, CountryregionId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(countryregioncodes: Array[CountryregionId])(implicit c: Connection): Int = {
    SQL"""delete
          from person.countryregion
          where "countryregioncode" = ANY(${countryregioncodes})
       """.executeUpdate()
    
  }
  override def insert(unsaved: CountryregionRow)(implicit c: Connection): CountryregionRow = {
    SQL"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
          values (${ParameterValue(unsaved.countryregioncode, null, CountryregionId.toStatement)}, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "countryregioncode", "name", "modifieddate"::text
       """
      .executeInsert(CountryregionRow.rowParser(1).single)
    
  }
  override def insert(unsaved: CountryregionRowUnsaved)(implicit c: Connection): CountryregionRow = {
    val namedParameters = List(
      Some((NamedParameter("countryregioncode", ParameterValue(unsaved.countryregioncode, null, CountryregionId.toStatement)), "")),
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.countryregion default values
            returning "countryregioncode", "name", "modifieddate"::text
         """
        .executeInsert(CountryregionRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.countryregion(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "countryregioncode", "name", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(CountryregionRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[CountryregionRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.countryregion("countryregioncode", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(CountryregionRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[CountryregionRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.countryregion("countryregioncode", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(CountryregionRowUnsaved.text, c)
  }
  override def select: SelectBuilder[CountryregionFields, CountryregionRow] = {
    SelectBuilderSql("person.countryregion", CountryregionFields.structure, CountryregionRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CountryregionRow] = {
    SQL"""select "countryregioncode", "name", "modifieddate"::text
          from person.countryregion
       """.as(CountryregionRow.rowParser(1).*)
  }
  override def selectById(countryregioncode: CountryregionId)(implicit c: Connection): Option[CountryregionRow] = {
    SQL"""select "countryregioncode", "name", "modifieddate"::text
          from person.countryregion
          where "countryregioncode" = ${ParameterValue(countryregioncode, null, CountryregionId.toStatement)}
       """.as(CountryregionRow.rowParser(1).singleOpt)
  }
  override def selectByIds(countryregioncodes: Array[CountryregionId])(implicit c: Connection): List[CountryregionRow] = {
    SQL"""select "countryregioncode", "name", "modifieddate"::text
          from person.countryregion
          where "countryregioncode" = ANY(${countryregioncodes})
       """.as(CountryregionRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(countryregioncodes: Array[CountryregionId])(implicit c: Connection): Map[CountryregionId, Option[CountryregionRow]] = {
    val byId = selectByIds(countryregioncodes).view.map(x => (x.countryregioncode, x)).toMap
    countryregioncodes.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[CountryregionFields, CountryregionRow] = {
    UpdateBuilder("person.countryregion", CountryregionFields.structure, CountryregionRow.rowParser)
  }
  override def update(row: CountryregionRow)(implicit c: Connection): Boolean = {
    val countryregioncode = row.countryregioncode
    SQL"""update person.countryregion
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "countryregioncode" = ${ParameterValue(countryregioncode, null, CountryregionId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: CountryregionRow)(implicit c: Connection): CountryregionRow = {
    SQL"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
          values (
            ${ParameterValue(unsaved.countryregioncode, null, CountryregionId.toStatement)},
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("countryregioncode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "countryregioncode", "name", "modifieddate"::text
       """
      .executeInsert(CountryregionRow.rowParser(1).single)
    
  }
}
