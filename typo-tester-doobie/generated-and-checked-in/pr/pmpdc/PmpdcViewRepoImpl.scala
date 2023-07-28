/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmpdc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PmpdcViewRepoImpl extends PmpdcViewRepo {
  override def selectAll: Stream[ConnectionIO, PmpdcViewRow] = {
    sql"select productmodelid, productdescriptionid, cultureid, modifieddate from pr.pmpdc".query[PmpdcViewRow].stream
  }
}
