/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithdemographics

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VstorewithdemographicsViewRepoImpl extends VstorewithdemographicsViewRepo {
  override def select: SelectBuilder[VstorewithdemographicsViewFields, VstorewithdemographicsViewRow] = {
    SelectBuilderSql(""""sales"."vstorewithdemographics"""", VstorewithdemographicsViewFields.structure, VstorewithdemographicsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VstorewithdemographicsViewRow] = {
    sql"""select "businessentityid", "name", "AnnualSales"::numeric, "AnnualRevenue"::numeric, "BankName", "BusinessType", "YearOpened", "Specialty", "SquareFeet", "Brands", "Internet", "NumberEmployees" from "sales"."vstorewithdemographics"""".query(using VstorewithdemographicsViewRow.jdbcDecoder).selectStream()
  }
}
