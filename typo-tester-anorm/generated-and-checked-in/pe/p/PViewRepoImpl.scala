/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package p

import anorm.SqlStringInterpolation
import java.sql.Connection

object PViewRepoImpl extends PViewRepo {
  override def selectAll(implicit c: Connection): List[PViewRow] = {
    SQL"""select "id", businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate
          from pe."p"
       """.as(PViewRow.rowParser(1).*)
  }
}
