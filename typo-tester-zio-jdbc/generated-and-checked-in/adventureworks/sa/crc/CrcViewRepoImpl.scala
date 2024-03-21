/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package crc

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class CrcViewRepoImpl extends CrcViewRepo {
  override def select: SelectBuilder[CrcViewFields, CrcViewRow] = {
    SelectBuilderSql("sa.crc", CrcViewFields.structure, CrcViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CrcViewRow] = {
    sql"""select "countryregioncode", "currencycode", "modifieddate"::text from sa.crc""".query(using CrcViewRow.jdbcDecoder).selectStream()
  }
}
