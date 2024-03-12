/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package um

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class UmViewRepoImpl extends UmViewRepo {
  override def select: SelectBuilder[UmViewFields, UmViewRow] = {
    SelectBuilderSql("pr.um", UmViewFields.structure, UmViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[UmViewRow] = {
    SQL"""select "id", "unitmeasurecode", "name", "modifieddate"::text
          from pr.um
       """.as(UmViewRow.rowParser(1).*)
  }
}
