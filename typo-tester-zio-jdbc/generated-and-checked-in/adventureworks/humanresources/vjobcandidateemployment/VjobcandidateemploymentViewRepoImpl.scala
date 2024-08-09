/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateemployment

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VjobcandidateemploymentViewRepoImpl extends VjobcandidateemploymentViewRepo {
  override def select: SelectBuilder[VjobcandidateemploymentViewFields, VjobcandidateemploymentViewRow] = {
    SelectBuilderSql(""""humanresources"."vjobcandidateemployment"""", VjobcandidateemploymentViewFields.structure, VjobcandidateemploymentViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VjobcandidateemploymentViewRow] = {
    sql"""select "jobcandidateid", "Emp.StartDate"::text, "Emp.EndDate"::text, "Emp.OrgName", "Emp.JobTitle", "Emp.Responsibility", "Emp.FunctionCategory", "Emp.IndustryCategory", "Emp.Loc.CountryRegion", "Emp.Loc.State", "Emp.Loc.City" from "humanresources"."vjobcandidateemployment"""".query(using VjobcandidateemploymentViewRow.jdbcDecoder).selectStream()
  }
}
