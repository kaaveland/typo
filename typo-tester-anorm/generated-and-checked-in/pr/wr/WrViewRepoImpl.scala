/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package wr

import anorm.SqlStringInterpolation
import java.sql.Connection

object WrViewRepoImpl extends WrViewRepo {
  override def selectAll(implicit c: Connection): List[WrViewRow] = {
    SQL"""select "id", workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate
          from pr.wr
       """.as(WrViewRow.rowParser(1).*)
  }
}
