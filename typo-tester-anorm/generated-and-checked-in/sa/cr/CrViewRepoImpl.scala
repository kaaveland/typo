/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cr

import anorm.SqlStringInterpolation
import java.sql.Connection

object CrViewRepoImpl extends CrViewRepo {
  override def selectAll(implicit c: Connection): List[CrViewRow] = {
    SQL"""select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
          from sa.cr
       """.as(CrViewRow.rowParser(1).*)
  }
}
