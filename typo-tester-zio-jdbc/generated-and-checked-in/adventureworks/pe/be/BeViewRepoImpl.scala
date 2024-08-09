/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class BeViewRepoImpl extends BeViewRepo {
  override def select: SelectBuilder[BeViewFields, BeViewRow] = {
    SelectBuilderSql(""""pe"."be"""", BeViewFields.structure, BeViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, BeViewRow] = {
    sql"""select "id", "businessentityid", "rowguid", "modifieddate"::text from "pe"."be"""".query(using BeViewRow.jdbcDecoder).selectStream()
  }
}
