/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package vadditionalcontactinfo

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object VadditionalcontactinfoViewRepoImpl extends VadditionalcontactinfoViewRepo {
  override def selectAll: Stream[ConnectionIO, VadditionalcontactinfoViewRow] = {
    sql"select businessentityid, firstname, middlename, lastname, telephonenumber, telephonespecialinstructions, street, city, stateprovince, postalcode, countryregion, homeaddressspecialinstructions, emailaddress, emailspecialinstructions, emailtelephonenumber, rowguid, modifieddate from person.vadditionalcontactinfo".query[VadditionalcontactinfoViewRow].stream
  }
}
