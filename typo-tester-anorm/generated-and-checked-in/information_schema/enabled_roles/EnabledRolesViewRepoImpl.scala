/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package enabled_roles

import anorm.SqlStringInterpolation
import java.sql.Connection

object EnabledRolesViewRepoImpl extends EnabledRolesViewRepo {
  override def selectAll(implicit c: Connection): List[EnabledRolesViewRow] = {
    SQL"""select role_name
          from information_schema.enabled_roles
       """.as(EnabledRolesViewRow.rowParser(1).*)
  }
}