/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package th

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class ThViewRepoImpl extends ThViewRepo {
  override def select: SelectBuilder[ThViewFields, ThViewRow] = {
    SelectBuilderSql(""""pr"."th"""", ThViewFields.structure, ThViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ThViewRow] = {
    sql"""select "id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text from "pr"."th"""".query(using ThViewRow.jdbcDecoder).selectStream()
  }
}
