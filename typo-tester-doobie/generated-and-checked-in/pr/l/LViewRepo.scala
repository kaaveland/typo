/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package l

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait LViewRepo {
  def selectAll: Stream[ConnectionIO, LViewRow]
}
