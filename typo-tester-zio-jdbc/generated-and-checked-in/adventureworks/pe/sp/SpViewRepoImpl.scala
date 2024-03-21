/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class SpViewRepoImpl extends SpViewRepo {
  override def select: SelectBuilder[SpViewFields, SpViewRow] = {
    SelectBuilderSql("pe.sp", SpViewFields.structure, SpViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SpViewRow] = {
    sql"""select "id", "stateprovinceid", "stateprovincecode", "countryregioncode", "isonlystateprovinceflag", "name", "territoryid", "rowguid", "modifieddate"::text from pe.sp""".query(using SpViewRow.jdbcDecoder).selectStream()
  }
}
