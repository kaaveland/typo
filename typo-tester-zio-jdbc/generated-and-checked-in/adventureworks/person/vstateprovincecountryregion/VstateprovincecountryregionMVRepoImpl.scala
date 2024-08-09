/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vstateprovincecountryregion

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VstateprovincecountryregionMVRepoImpl extends VstateprovincecountryregionMVRepo {
  override def select: SelectBuilder[VstateprovincecountryregionMVFields, VstateprovincecountryregionMVRow] = {
    SelectBuilderSql(""""person"."vstateprovincecountryregion"""", VstateprovincecountryregionMVFields.structure, VstateprovincecountryregionMVRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VstateprovincecountryregionMVRow] = {
    sql"""select "stateprovinceid", "stateprovincecode", "isonlystateprovinceflag", "stateprovincename", "territoryid", "countryregioncode", "countryregionname" from "person"."vstateprovincecountryregion"""".query(using VstateprovincecountryregionMVRow.jdbcDecoder).selectStream()
  }
}
