/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait StViewRepo {
  def selectAll: Stream[ConnectionIO, StViewRow]
}
