/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bea

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class BeaViewRepoImpl extends BeaViewRepo {
  override def select: SelectBuilder[BeaViewFields, BeaViewRow] = {
    SelectBuilderSql("pe.bea", BeaViewFields.structure, BeaViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[BeaViewRow] = {
    SQL"""select "id", "businessentityid", "addressid", "addresstypeid", "rowguid", "modifieddate"::text
          from pe.bea
       """.as(BeaViewRow.rowParser(1).*)
  }
}
