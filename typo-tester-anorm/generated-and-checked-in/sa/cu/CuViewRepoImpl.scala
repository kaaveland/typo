/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cu

import anorm.SqlStringInterpolation
import java.sql.Connection

object CuViewRepoImpl extends CuViewRepo {
  override def selectAll(implicit c: Connection): List[CuViewRow] = {
    SQL"""select "id", currencycode, "name", modifieddate
          from sa.cu
       """.as(CuViewRow.rowParser(1).*)
  }
}
