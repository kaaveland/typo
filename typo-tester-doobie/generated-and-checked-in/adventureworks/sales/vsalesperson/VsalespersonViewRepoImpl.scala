/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalesperson

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class VsalespersonViewRepoImpl extends VsalespersonViewRepo {
  override def select: SelectBuilder[VsalespersonViewFields, VsalespersonViewRow] = {
    SelectBuilderSql("sales.vsalesperson", VsalespersonViewFields.structure, VsalespersonViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VsalespersonViewRow] = {
    sql"""select "businessentityid", "title", "firstname", "middlename", "lastname", "suffix", "jobtitle", "phonenumber", "phonenumbertype", "emailaddress", "emailpromotion", "addressline1", "addressline2", "city", "stateprovincename", "postalcode", "countryregionname", "territoryname", "territorygroup", "salesquota", "salesytd", "saleslastyear" from sales.vsalesperson""".query(using VsalespersonViewRow.read).stream
  }
}
