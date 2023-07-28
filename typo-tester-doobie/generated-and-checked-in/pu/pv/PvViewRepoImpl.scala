/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pv

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PvViewRepoImpl extends PvViewRepo {
  override def selectAll: Stream[ConnectionIO, PvViewRow] = {
    sql"""select "id", productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate from pu.pv""".query[PvViewRow].stream
  }
}
