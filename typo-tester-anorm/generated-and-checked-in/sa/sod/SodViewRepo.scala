/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sod

import java.sql.Connection

trait SodViewRepo {
  def selectAll(implicit c: Connection): List[SodViewRow]
}
