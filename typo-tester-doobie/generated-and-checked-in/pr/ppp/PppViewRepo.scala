/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package ppp

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PppViewRepo {
  def selectAll: Stream[ConnectionIO, PppViewRow]
}
