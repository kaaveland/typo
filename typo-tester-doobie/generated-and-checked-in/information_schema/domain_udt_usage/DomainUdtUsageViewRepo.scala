/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package domain_udt_usage

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait DomainUdtUsageViewRepo {
  def selectAll: Stream[ConnectionIO, DomainUdtUsageViewRow]
}