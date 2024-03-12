/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pp

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PpViewRepoImpl extends PpViewRepo {
  override def select: SelectBuilder[PpViewFields, PpViewRow] = {
    SelectBuilderSql("pe.pp", PpViewFields.structure, PpViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PpViewRow] = {
    SQL"""select "id", "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
          from pe.pp
       """.as(PpViewRow.rowParser(1).*)
  }
}
