/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package c

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class CViewRepoImpl extends CViewRepo {
  override def select: SelectBuilder[CViewFields, CViewRow] = {
    SelectBuilderSql(""""sa"."c"""", CViewFields.structure, CViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CViewRow] = {
    sql"""select "id", "customerid", "personid", "storeid", "territoryid", "rowguid", "modifieddate"::text from "sa"."c"""".query(using CViewRow.jdbcDecoder).selectStream()
  }
}
