/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package poh

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PohViewRepoImpl extends PohViewRepo {
  override def select: SelectBuilder[PohViewFields, PohViewRow] = {
    SelectBuilderSql("pu.poh", PohViewFields, PohViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PohViewRow] = {
    sql"""select "id", "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text from pu.poh""".query(PohViewRow.jdbcDecoder).selectStream
  }
}