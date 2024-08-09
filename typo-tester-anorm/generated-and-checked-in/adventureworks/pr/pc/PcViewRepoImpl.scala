/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PcViewRepoImpl extends PcViewRepo {
  override def select: SelectBuilder[PcViewFields, PcViewRow] = {
    SelectBuilderSql(""""pr"."pc"""", PcViewFields.structure, PcViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PcViewRow] = {
    SQL"""select "id", "productcategoryid", "name", "rowguid", "modifieddate"::text
          from "pr"."pc"
       """.as(PcViewRow.rowParser(1).*)
  }
}
