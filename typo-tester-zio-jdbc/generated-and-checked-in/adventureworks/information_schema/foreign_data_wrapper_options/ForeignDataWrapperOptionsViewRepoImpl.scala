/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_data_wrapper_options

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object ForeignDataWrapperOptionsViewRepoImpl extends ForeignDataWrapperOptionsViewRepo {
  override def select: SelectBuilder[ForeignDataWrapperOptionsViewFields, ForeignDataWrapperOptionsViewRow] = {
    SelectBuilderSql("information_schema.foreign_data_wrapper_options", ForeignDataWrapperOptionsViewFields, ForeignDataWrapperOptionsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ForeignDataWrapperOptionsViewRow] = {
    sql"""select "foreign_data_wrapper_catalog", "foreign_data_wrapper_name", "option_name", "option_value" from information_schema.foreign_data_wrapper_options""".query(ForeignDataWrapperOptionsViewRow.jdbcDecoder).selectStream
  }
}
