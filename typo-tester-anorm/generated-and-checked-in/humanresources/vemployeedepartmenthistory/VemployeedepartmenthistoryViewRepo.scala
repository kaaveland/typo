/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartmenthistory

import java.sql.Connection

trait VemployeedepartmenthistoryViewRepo {
  def selectAll(implicit c: Connection): List[VemployeedepartmenthistoryViewRow]
}
