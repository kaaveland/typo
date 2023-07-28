/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithdemographics

import anorm.SqlStringInterpolation
import java.sql.Connection

object VstorewithdemographicsViewRepoImpl extends VstorewithdemographicsViewRepo {
  override def selectAll(implicit c: Connection): List[VstorewithdemographicsViewRow] = {
    SQL"""select businessentityid, "name", AnnualSales::numeric, AnnualRevenue::numeric, BankName, BusinessType, YearOpened, Specialty, SquareFeet, Brands, Internet, NumberEmployees
          from sales.vstorewithdemographics
       """.as(VstorewithdemographicsViewRow.rowParser(1).*)
  }
}
