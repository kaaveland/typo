/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sod

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object SodViewRepoImpl extends SodViewRepo {
  override def selectAll: Stream[ConnectionIO, SodViewRow] = {
    sql"""select "id", salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate from sa.sod""".query[SodViewRow].stream
  }
}
