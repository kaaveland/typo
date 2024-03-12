/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidate

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VjobcandidateViewRepoImpl extends VjobcandidateViewRepo {
  override def select: SelectBuilder[VjobcandidateViewFields, VjobcandidateViewRow] = {
    SelectBuilderSql("humanresources.vjobcandidate", VjobcandidateViewFields.structure, VjobcandidateViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VjobcandidateViewRow] = {
    sql"""select "jobcandidateid", "businessentityid", "Name.Prefix", "Name.First", "Name.Middle", "Name.Last", "Name.Suffix", "Skills", "Addr.Type", "Addr.Loc.CountryRegion", "Addr.Loc.State", "Addr.Loc.City", "Addr.PostalCode", "EMail", "WebSite", "modifieddate"::text from humanresources.vjobcandidate""".query(VjobcandidateViewRow.jdbcDecoder).selectStream
  }
}
