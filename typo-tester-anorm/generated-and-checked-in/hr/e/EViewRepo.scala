/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package e

import java.sql.Connection

trait EViewRepo {
  def selectAll(implicit c: Connection): List[EViewRow]
}
