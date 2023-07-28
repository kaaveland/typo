/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package so

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object SoViewRepoImpl extends SoViewRepo {
  override def selectAll: Stream[ConnectionIO, SoViewRow] = {
    sql"""select "id", specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate from sa.so""".query[SoViewRow].stream
  }
}
