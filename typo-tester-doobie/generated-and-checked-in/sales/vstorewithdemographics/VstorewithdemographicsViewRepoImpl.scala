/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithdemographics

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object VstorewithdemographicsViewRepoImpl extends VstorewithdemographicsViewRepo {
  override def selectAll: Stream[ConnectionIO, VstorewithdemographicsViewRow] = {
    sql"""select businessentityid, "name", AnnualSales, AnnualRevenue, BankName, BusinessType, YearOpened, Specialty, SquareFeet, Brands, Internet, NumberEmployees from sales.vstorewithdemographics""".query[VstorewithdemographicsViewRow].stream
  }
}
