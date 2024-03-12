/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package w

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class WViewRepoImpl extends WViewRepo {
  override def select: SelectBuilder[WViewFields, WViewRow] = {
    SelectBuilderSql("pr.w", WViewFields.structure, WViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[WViewRow] = {
    SQL"""select "id", "workorderid", "productid", "orderqty", "scrappedqty", "startdate"::text, "enddate"::text, "duedate"::text, "scrapreasonid", "modifieddate"::text
          from pr.w
       """.as(WViewRow.rowParser(1).*)
  }
}
