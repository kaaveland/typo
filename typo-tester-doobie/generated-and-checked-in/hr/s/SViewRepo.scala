/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package s

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait SViewRepo {
  def selectAll: Stream[ConnectionIO, SViewRow]
}
