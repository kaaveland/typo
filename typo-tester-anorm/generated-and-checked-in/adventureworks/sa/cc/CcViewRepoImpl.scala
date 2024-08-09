/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cc

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class CcViewRepoImpl extends CcViewRepo {
  override def select: SelectBuilder[CcViewFields, CcViewRow] = {
    SelectBuilderSql(""""sa"."cc"""", CcViewFields.structure, CcViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CcViewRow] = {
    SQL"""select "id", "creditcardid", "cardtype", "cardnumber", "expmonth", "expyear", "modifieddate"::text
          from "sa"."cc"
       """.as(CcViewRow.rowParser(1).*)
  }
}
