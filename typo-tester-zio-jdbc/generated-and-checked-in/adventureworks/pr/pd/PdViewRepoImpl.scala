/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pd

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class PdViewRepoImpl extends PdViewRepo {
  override def select: SelectBuilder[PdViewFields, PdViewRow] = {
    SelectBuilderSql(""""pr"."pd"""", PdViewFields.structure, PdViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PdViewRow] = {
    sql"""select "id", "productdescriptionid", "description", "rowguid", "modifieddate"::text from "pr"."pd"""".query(using PdViewRow.jdbcDecoder).selectStream()
  }
}
