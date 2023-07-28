/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelinstructions

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object VproductmodelinstructionsViewRepoImpl extends VproductmodelinstructionsViewRepo {
  override def selectAll: Stream[ConnectionIO, VproductmodelinstructionsViewRow] = {
    sql"""select productmodelid, "name", instructions, LocationID, SetupHours, MachineHours, LaborHours, LotSize, Step, rowguid, modifieddate from production.vproductmodelinstructions""".query[VproductmodelinstructionsViewRow].stream
  }
}
