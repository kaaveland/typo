/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalesperson

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait VsalespersonViewRepo {
  def selectAll: Stream[ConnectionIO, VsalespersonViewRow]
}
