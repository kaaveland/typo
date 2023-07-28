/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package spqh

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object SpqhViewRepoImpl extends SpqhViewRepo {
  override def selectAll: Stream[ConnectionIO, SpqhViewRow] = {
    sql"""select "id", businessentityid, quotadate, salesquota, rowguid, modifieddate from sa.spqh""".query[SpqhViewRow].stream
  }
}
