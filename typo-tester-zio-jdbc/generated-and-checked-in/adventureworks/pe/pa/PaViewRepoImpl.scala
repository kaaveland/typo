/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class PaViewRepoImpl extends PaViewRepo {
  override def select: SelectBuilder[PaViewFields, PaViewRow] = {
    SelectBuilderSql("pe.pa", PaViewFields.structure, PaViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PaViewRow] = {
    sql"""select "id", "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text from pe.pa""".query(using PaViewRow.jdbcDecoder).selectStream()
  }
}
