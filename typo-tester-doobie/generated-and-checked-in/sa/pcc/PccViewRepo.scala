/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package pcc

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PccViewRepo {
  def selectAll: Stream[ConnectionIO, PccViewRow]
}
