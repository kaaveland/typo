/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bec

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object BecViewRepoImpl extends BecViewRepo {
  override def selectAll: Stream[ConnectionIO, BecViewRow] = {
    sql"""select "id", businessentityid, personid, contacttypeid, rowguid, modifieddate from pe.bec""".query[BecViewRow].stream
  }
}
