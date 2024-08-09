/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithaddresses

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VvendorwithaddressesViewRepoImpl extends VvendorwithaddressesViewRepo {
  override def select: SelectBuilder[VvendorwithaddressesViewFields, VvendorwithaddressesViewRow] = {
    SelectBuilderSql(""""purchasing"."vvendorwithaddresses"""", VvendorwithaddressesViewFields.structure, VvendorwithaddressesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VvendorwithaddressesViewRow] = {
    sql"""select "businessentityid", "name", "addresstype", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname" from "purchasing"."vvendorwithaddresses"""".query(using VvendorwithaddressesViewRow.jdbcDecoder).selectStream()
  }
}
