/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductanddescription

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object VproductanddescriptionMVRepoImpl extends VproductanddescriptionMVRepo {
  override def select: SelectBuilder[VproductanddescriptionMVFields, VproductanddescriptionMVRow] = {
    SelectBuilderSql("production.vproductanddescription", VproductanddescriptionMVFields, VproductanddescriptionMVRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VproductanddescriptionMVRow] = {
    sql"""select "productid", "name", "productmodel", "cultureid", "description" from production.vproductanddescription""".query(VproductanddescriptionMVRow.jdbcDecoder).selectStream
  }
}
