/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartment

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object VemployeedepartmentViewRepoImpl extends VemployeedepartmentViewRepo {
  override def selectAll: Stream[ConnectionIO, VemployeedepartmentViewRow] = {
    sql"select businessentityid, title, firstname, middlename, lastname, suffix, jobtitle, department, groupname, startdate from humanresources.vemployeedepartment".query[VemployeedepartmentViewRow].stream
  }
}
