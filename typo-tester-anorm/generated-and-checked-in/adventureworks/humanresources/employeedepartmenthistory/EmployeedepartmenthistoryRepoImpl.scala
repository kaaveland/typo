/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
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

class EmployeedepartmenthistoryRepoImpl extends EmployeedepartmenthistoryRepo {
  override def delete: DeleteBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    DeleteBuilder("humanresources.employeedepartmenthistory", EmployeedepartmenthistoryFields.structure)
  }
  override def deleteById(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Boolean = {
    SQL"""delete from humanresources.employeedepartmenthistory where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDate.toStatement)} AND "departmentid" = ${ParameterValue(compositeId.departmentid, null, DepartmentId.toStatement)} AND "shiftid" = ${ParameterValue(compositeId.shiftid, null, ShiftId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[EmployeedepartmenthistoryId])(implicit c: Connection): Int = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val startdate = compositeIds.map(_.startdate)
    val departmentid = compositeIds.map(_.departmentid)
    val shiftid = compositeIds.map(_.shiftid)
    SQL"""delete
          from humanresources.employeedepartmenthistory
          where ("businessentityid", "startdate", "departmentid", "shiftid")
          in (select unnest(${businessentityid}), unnest(${startdate}), unnest(${departmentid}), unnest(${shiftid}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    SQL"""insert into humanresources.employeedepartmenthistory("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.departmentid, null, DepartmentId.toStatement)}::int2, ${ParameterValue(unsaved.shiftid, null, ShiftId.toStatement)}::int2, ${ParameterValue(unsaved.startdate, null, TypoLocalDate.toStatement)}::date, ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDate.toStatement, TypoLocalDate.parameterMetadata))}::date, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
       """
      .executeInsert(EmployeedepartmenthistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: EmployeedepartmenthistoryRowUnsaved)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("departmentid", ParameterValue(unsaved.departmentid, null, DepartmentId.toStatement)), "::int2")),
      Some((NamedParameter("shiftid", ParameterValue(unsaved.shiftid, null, ShiftId.toStatement)), "::int2")),
      Some((NamedParameter("startdate", ParameterValue(unsaved.startdate, null, TypoLocalDate.toStatement)), "::date")),
      Some((NamedParameter("enddate", ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDate.toStatement, TypoLocalDate.parameterMetadata))), "::date")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into humanresources.employeedepartmenthistory default values
            returning "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
         """
        .executeInsert(EmployeedepartmenthistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into humanresources.employeedepartmenthistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(EmployeedepartmenthistoryRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[EmployeedepartmenthistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY humanresources.employeedepartmenthistory("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate") FROM STDIN""", batchSize, unsaved)(EmployeedepartmenthistoryRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[EmployeedepartmenthistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY humanresources.employeedepartmenthistory("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(EmployeedepartmenthistoryRowUnsaved.text, c)
  }
  override def select: SelectBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    SelectBuilderSql("humanresources.employeedepartmenthistory", EmployeedepartmenthistoryFields.structure, EmployeedepartmenthistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[EmployeedepartmenthistoryRow] = {
    SQL"""select "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
          from humanresources.employeedepartmenthistory
       """.as(EmployeedepartmenthistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Option[EmployeedepartmenthistoryRow] = {
    SQL"""select "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
          from humanresources.employeedepartmenthistory
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDate.toStatement)} AND "departmentid" = ${ParameterValue(compositeId.departmentid, null, DepartmentId.toStatement)} AND "shiftid" = ${ParameterValue(compositeId.shiftid, null, ShiftId.toStatement)}
       """.as(EmployeedepartmenthistoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[EmployeedepartmenthistoryId])(implicit c: Connection): List[EmployeedepartmenthistoryRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val startdate = compositeIds.map(_.startdate)
    val departmentid = compositeIds.map(_.departmentid)
    val shiftid = compositeIds.map(_.shiftid)
    SQL"""select "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
          from humanresources.employeedepartmenthistory
          where ("businessentityid", "startdate", "departmentid", "shiftid") 
          in (select unnest(${businessentityid}), unnest(${startdate}), unnest(${departmentid}), unnest(${shiftid}))
       """.as(EmployeedepartmenthistoryRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(compositeIds: Array[EmployeedepartmenthistoryId])(implicit c: Connection): Map[EmployeedepartmenthistoryId, EmployeedepartmenthistoryRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    UpdateBuilder("humanresources.employeedepartmenthistory", EmployeedepartmenthistoryFields.structure, EmployeedepartmenthistoryRow.rowParser)
  }
  override def update(row: EmployeedepartmenthistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update humanresources.employeedepartmenthistory
          set "enddate" = ${ParameterValue(row.enddate, null, ToStatement.optionToStatement(TypoLocalDate.toStatement, TypoLocalDate.parameterMetadata))}::date,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDate.toStatement)} AND "departmentid" = ${ParameterValue(compositeId.departmentid, null, DepartmentId.toStatement)} AND "shiftid" = ${ParameterValue(compositeId.shiftid, null, ShiftId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    SQL"""insert into humanresources.employeedepartmenthistory("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.departmentid, null, DepartmentId.toStatement)}::int2,
            ${ParameterValue(unsaved.shiftid, null, ShiftId.toStatement)}::int2,
            ${ParameterValue(unsaved.startdate, null, TypoLocalDate.toStatement)}::date,
            ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDate.toStatement, TypoLocalDate.parameterMetadata))}::date,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid", "startdate", "departmentid", "shiftid")
          do update set
            "enddate" = EXCLUDED."enddate",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
       """
      .executeInsert(EmployeedepartmenthistoryRow.rowParser(1).single)
    
  }
}
