/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package spqh

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object SpqhViewRepoImpl extends SpqhViewRepo {
  override def select: SelectBuilder[SpqhViewFields, SpqhViewRow] = {
    SelectBuilderSql("sa.spqh", SpqhViewFields, SpqhViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SpqhViewRow] = {
    SQL"""select "id", businessentityid, quotadate::text, salesquota, rowguid, modifieddate::text
          from sa.spqh
       """.as(SpqhViewRow.rowParser(1).*)
  }
}