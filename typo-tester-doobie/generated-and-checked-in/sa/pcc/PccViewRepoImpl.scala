/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package pcc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PccViewRepoImpl extends PccViewRepo {
  override def selectAll: Stream[ConnectionIO, PccViewRow] = {
    sql"""select "id", businessentityid, creditcardid, modifieddate from sa.pcc""".query[PccViewRow].stream
  }
}
