/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_row_join

import anorm.SqlStringInterpolation
import java.sql.Connection

object PersonRowJoinSqlRepoImpl extends PersonRowJoinSqlRepo {
  override def apply()(implicit c: Connection): List[PersonRowJoinSqlRow] = {
    val sql =
      SQL"""SELECT s.businessentityid,
                   (select array_agg(ROW(a.emailaddress, a.rowguid)) from person.emailaddress a where a.businessentityid = s.businessentityid) as email,
                   (select ARRAY[ROW(a.emailaddress, a.rowguid)] from person.emailaddress a where a.businessentityid = s.businessentityid) as emails
            FROM sales.salesperson s
      """
    sql.as(PersonRowJoinSqlRow.rowParser(1).*)
  }
}
