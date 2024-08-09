/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package psc

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PscViewRepoImpl extends PscViewRepo {
  override def select: SelectBuilder[PscViewFields, PscViewRow] = {
    SelectBuilderSql(""""pr"."psc"""", PscViewFields.structure, PscViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PscViewRow] = {
    SQL"""select "id", "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text
          from "pr"."psc"
       """.as(PscViewRow.rowParser(1).*)
  }
}
