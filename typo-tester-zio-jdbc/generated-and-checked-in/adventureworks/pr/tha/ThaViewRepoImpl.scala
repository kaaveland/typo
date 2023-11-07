/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package tha

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object ThaViewRepoImpl extends ThaViewRepo {
  override def select: SelectBuilder[ThaViewFields, ThaViewRow] = {
    SelectBuilderSql("pr.tha", ThaViewFields, ThaViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ThaViewRow] = {
    sql"""select "id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text from pr.tha""".query(ThaViewRow.jdbcDecoder).selectStream
  }
}
