/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidate

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object VjobcandidateViewRepoImpl extends VjobcandidateViewRepo {
  override def selectAll: Stream[ConnectionIO, VjobcandidateViewRow] = {
    sql"""select jobcandidateid, businessentityid, "Name.Prefix", "Name.First", "Name.Middle", "Name.Last", "Name.Suffix", Skills, "Addr.Type", "Addr.Loc.CountryRegion", "Addr.Loc.State", "Addr.Loc.City", "Addr.PostalCode", EMail, WebSite, modifieddate from humanresources.vjobcandidate""".query[VjobcandidateViewRow].stream
  }
}
