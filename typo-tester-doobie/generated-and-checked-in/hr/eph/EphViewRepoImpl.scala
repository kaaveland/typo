/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package eph

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object EphViewRepoImpl extends EphViewRepo {
  override def selectAll: Stream[ConnectionIO, EphViewRow] = {
    sql"""select "id", businessentityid, ratechangedate, rate, payfrequency, modifieddate from hr.eph""".query[EphViewRow].stream
  }
}
