/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package c

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object CViewRepoImpl extends CViewRepo {
  override def selectAll: Stream[ConnectionIO, CViewRow] = {
    sql"""select "id", customerid, personid, storeid, territoryid, rowguid, modifieddate from sa."c"""".query[CViewRow].stream
  }
}
