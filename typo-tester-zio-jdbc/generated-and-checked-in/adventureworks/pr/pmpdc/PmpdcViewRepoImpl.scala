/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmpdc

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class PmpdcViewRepoImpl extends PmpdcViewRepo {
  override def select: SelectBuilder[PmpdcViewFields, PmpdcViewRow] = {
    SelectBuilderSql(""""pr"."pmpdc"""", PmpdcViewFields.structure, PmpdcViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PmpdcViewRow] = {
    sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text from "pr"."pmpdc"""".query(using PmpdcViewRow.jdbcDecoder).selectStream()
  }
}
