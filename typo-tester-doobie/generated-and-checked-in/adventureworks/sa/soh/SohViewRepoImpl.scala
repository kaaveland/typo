/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package soh

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SohViewRepoImpl extends SohViewRepo {
  override def select: SelectBuilder[SohViewFields, SohViewRow] = {
    SelectBuilderSql(""""sa"."soh"""", SohViewFields.structure, SohViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SohViewRow] = {
    sql"""select "id", "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text from "sa"."soh"""".query(using SohViewRow.read).stream
  }
}
