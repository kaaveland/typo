/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import testdb.hardcoded.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class FootballClubRepoImpl extends FootballClubRepo {
  override def delete(id: FootballClubId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.football_club where "id" = ${ParameterValue(id, null, FootballClubId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[FootballClubFields, FootballClubRow] = {
    DeleteBuilder("myschema.football_club", FootballClubFields.structure)
  }
  override def insert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow = {
    SQL"""insert into myschema.football_club("id", "name")
          values (${ParameterValue(unsaved.id, null, FootballClubId.toStatement)}::int8, ${ParameterValue(unsaved.name, null, ToStatement.stringToStatement)})
          returning "id", "name"
       """
      .executeInsert(FootballClubRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[FootballClubRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY myschema.football_club("id", "name") FROM STDIN""", batchSize, unsaved)(FootballClubRow.text, c)
  }
  override def select: SelectBuilder[FootballClubFields, FootballClubRow] = {
    SelectBuilderSql("myschema.football_club", FootballClubFields.structure, FootballClubRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[FootballClubRow] = {
    SQL"""select "id", "name"
          from myschema.football_club
       """.as(FootballClubRow.rowParser(1).*)
  }
  override def selectById(id: FootballClubId)(implicit c: Connection): Option[FootballClubRow] = {
    SQL"""select "id", "name"
          from myschema.football_club
          where "id" = ${ParameterValue(id, null, FootballClubId.toStatement)}
       """.as(FootballClubRow.rowParser(1).singleOpt)
  }
  override def selectByIds(ids: Array[FootballClubId])(implicit c: Connection): List[FootballClubRow] = {
    SQL"""select "id", "name"
          from myschema.football_club
          where "id" = ANY(${ids})
       """.as(FootballClubRow.rowParser(1).*)
    
  }
  override def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[?]])(implicit c: Connection): List[FootballClubRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParameters = nonEmpty.map{
          case FootballClubFieldValue.id(value) => NamedParameter("id", ParameterValue(value, null, FootballClubId.toStatement))
          case FootballClubFieldValue.name(value) => NamedParameter("name", ParameterValue(value, null, ToStatement.stringToStatement))
        }
        val quote = '"'.toString
        val q = s"""select "id", "name"
                    from myschema.football_club
                    where ${namedParameters.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        SimpleSql(SQL(q), namedParameters.map(_.tupled).toMap, RowParser.successful)
          .as(FootballClubRow.rowParser(1).*)
    }
    
  }
  override def update(row: FootballClubRow)(implicit c: Connection): Boolean = {
    val id = row.id
    SQL"""update myschema.football_club
          set "name" = ${ParameterValue(row.name, null, ToStatement.stringToStatement)}
          where "id" = ${ParameterValue(id, null, FootballClubId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[FootballClubFields, FootballClubRow] = {
    UpdateBuilder("myschema.football_club", FootballClubFields.structure, FootballClubRow.rowParser)
  }
  override def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[?]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParameters = nonEmpty.map{
          case FootballClubFieldValue.name(value) => NamedParameter("name", ParameterValue(value, null, ToStatement.stringToStatement))
        }
        val quote = '"'.toString
        val q = s"""update myschema.football_club
                    set ${namedParameters.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where "id" = {id}
                 """
        SimpleSql(SQL(q), namedParameters.map(_.tupled).toMap ++ List(("id", ParameterValue(id, null, FootballClubId.toStatement))), RowParser.successful)
          .executeUpdate() > 0
    }
    
  }
  override def upsert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow = {
    SQL"""insert into myschema.football_club("id", "name")
          values (
            ${ParameterValue(unsaved.id, null, FootballClubId.toStatement)}::int8,
            ${ParameterValue(unsaved.name, null, ToStatement.stringToStatement)}
          )
          on conflict ("id")
          do update set
            "name" = EXCLUDED."name"
          returning "id", "name"
       """
      .executeInsert(FootballClubRow.rowParser(1).single)
    
  }
}
