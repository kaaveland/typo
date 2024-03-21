/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployee

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class VemployeeViewRepoImpl extends VemployeeViewRepo {
  override def select: SelectBuilder[VemployeeViewFields, VemployeeViewRow] = {
    SelectBuilderSql("humanresources.vemployee", VemployeeViewFields.structure, VemployeeViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, VemployeeViewRow] = {
    sql"""select "businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "jobtitle", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname", "additionalcontactinfo" from humanresources.vemployee""".query(using VemployeeViewRow.jdbcDecoder).selectStream()
  }
}
