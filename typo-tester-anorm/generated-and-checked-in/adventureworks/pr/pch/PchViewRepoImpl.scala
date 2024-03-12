/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pch

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PchViewRepoImpl extends PchViewRepo {
  override def select: SelectBuilder[PchViewFields, PchViewRow] = {
    SelectBuilderSql("pr.pch", PchViewFields.structure, PchViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PchViewRow] = {
    SQL"""select "id", "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
          from pr.pch
       """.as(PchViewRow.rowParser(1).*)
  }
}
