/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sr

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SrViewRepoImpl extends SrViewRepo {
  override def select: SelectBuilder[SrViewFields, SrViewRow] = {
    SelectBuilderSql("sa.sr", SrViewFields.structure, SrViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SrViewRow] = {
    SQL"""select "id", "salesreasonid", "name", "reasontype", "modifieddate"::text
          from sa.sr
       """.as(SrViewRow.rowParser(1).*)
  }
}
