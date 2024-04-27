/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import testdb.hardcoded.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class MaritalStatusRepoImpl extends MaritalStatusRepo {
  override def delete: DeleteBuilder[MaritalStatusFields, MaritalStatusRow] = {
    DeleteBuilder("myschema.marital_status", MaritalStatusFields.structure)
  }
  override def deleteById(id: MaritalStatusId)(implicit c: Connection): Boolean = {
    SQL"""delete from myschema.marital_status where "id" = ${ParameterValue(id, null, MaritalStatusId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(ids: Array[MaritalStatusId])(implicit c: Connection): Int = {
    SQL"""delete
          from myschema.marital_status
          where "id" = ANY(${ids})
       """.executeUpdate()
    
  }
  override def insert(unsaved: MaritalStatusRow)(implicit c: Connection): MaritalStatusRow = {
    SQL"""insert into myschema.marital_status("id")
          values (${ParameterValue(unsaved.id, null, MaritalStatusId.toStatement)}::int8)
          returning "id"
       """
      .executeInsert(MaritalStatusRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[MaritalStatusRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY myschema.marital_status("id") FROM STDIN""", batchSize, unsaved)(MaritalStatusRow.text, c)
  }
  override def select: SelectBuilder[MaritalStatusFields, MaritalStatusRow] = {
    SelectBuilderSql("myschema.marital_status", MaritalStatusFields.structure, MaritalStatusRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[MaritalStatusRow] = {
    SQL"""select "id"
          from myschema.marital_status
       """.as(MaritalStatusRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[?]])(implicit c: Connection): List[MaritalStatusRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParameters = nonEmpty.map{
          case MaritalStatusFieldValue.id(value) => NamedParameter("id", ParameterValue(value, null, MaritalStatusId.toStatement))
        }
        val quote = '"'.toString
        val q = s"""select "id"
                    from myschema.marital_status
                    where ${namedParameters.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        SimpleSql(SQL(q), namedParameters.map(_.tupled).toMap, RowParser.successful)
          .as(MaritalStatusRow.rowParser(1).*)
    }
    
  }
  override def selectById(id: MaritalStatusId)(implicit c: Connection): Option[MaritalStatusRow] = {
    SQL"""select "id"
          from myschema.marital_status
          where "id" = ${ParameterValue(id, null, MaritalStatusId.toStatement)}
       """.as(MaritalStatusRow.rowParser(1).singleOpt)
  }
  override def selectByIds(ids: Array[MaritalStatusId])(implicit c: Connection): List[MaritalStatusRow] = {
    SQL"""select "id"
          from myschema.marital_status
          where "id" = ANY(${ids})
       """.as(MaritalStatusRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(ids: Array[MaritalStatusId])(implicit c: Connection): Map[MaritalStatusId, Option[MaritalStatusRow]] = {
    val byId = selectByIds(ids).view.map(x => (x.id, x)).toMap
    ids.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[MaritalStatusFields, MaritalStatusRow] = {
    UpdateBuilder("myschema.marital_status", MaritalStatusFields.structure, MaritalStatusRow.rowParser)
  }
  override def upsert(unsaved: MaritalStatusRow)(implicit c: Connection): MaritalStatusRow = {
    SQL"""insert into myschema.marital_status("id")
          values (
            ${ParameterValue(unsaved.id, null, MaritalStatusId.toStatement)}::int8
          )
          on conflict ("id")
          do update set
            
          returning "id"
       """
      .executeInsert(MaritalStatusRow.rowParser(1).single)
    
  }
}
