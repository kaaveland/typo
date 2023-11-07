/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object EViewRepoImpl extends EViewRepo {
  override def select: SelectBuilder[EViewFields, EViewRow] = {
    SelectBuilderSql("pe.e", EViewFields, EViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, EViewRow] = {
    sql"""select "id", "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text from pe.e""".query(EViewRow.jdbcDecoder).selectStream
  }
}
