/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package ct

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object CtViewRepoImpl extends CtViewRepo {
  override def select: SelectBuilder[CtViewFields, CtViewRow] = {
    SelectBuilderSql("pe.ct", CtViewFields, CtViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CtViewRow] = {
    sql"""select "id", "contacttypeid", "name", "modifieddate"::text from pe.ct""".query(CtViewRow.jdbcDecoder).selectStream
  }
}