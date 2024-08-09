/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package tha

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class ThaViewRepoImpl extends ThaViewRepo {
  override def select: SelectBuilder[ThaViewFields, ThaViewRow] = {
    SelectBuilderSql(""""pr"."tha"""", ThaViewFields.structure, ThaViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ThaViewRow] = {
    SQL"""select "id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text
          from "pr"."tha"
       """.as(ThaViewRow.rowParser(1).*)
  }
}
