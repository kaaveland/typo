/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sohsr

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class SohsrViewRepoImpl extends SohsrViewRepo {
  override def select: SelectBuilder[SohsrViewFields, SohsrViewRow] = {
    SelectBuilderSql(""""sa"."sohsr"""", SohsrViewFields.structure, SohsrViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SohsrViewRow] = {
    sql"""select "salesorderid", "salesreasonid", "modifieddate"::text from "sa"."sohsr"""".query(using SohsrViewRow.jdbcDecoder).selectStream()
  }
}
