/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cc

import anorm.SqlStringInterpolation
import java.sql.Connection

object CcViewRepoImpl extends CcViewRepo {
  override def selectAll(implicit c: Connection): List[CcViewRow] = {
    SQL"""select "id", creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate
          from sa.cc
       """.as(CcViewRow.rowParser(1).*)
  }
}
