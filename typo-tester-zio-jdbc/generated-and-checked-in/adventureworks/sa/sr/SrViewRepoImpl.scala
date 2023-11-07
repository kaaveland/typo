/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sr

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object SrViewRepoImpl extends SrViewRepo {
  override def select: SelectBuilder[SrViewFields, SrViewRow] = {
    SelectBuilderSql("sa.sr", SrViewFields, SrViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SrViewRow] = {
    sql"""select "id", "salesreasonid", "name", "reasontype", "modifieddate"::text from sa.sr""".query(SrViewRow.jdbcDecoder).selectStream
  }
}
