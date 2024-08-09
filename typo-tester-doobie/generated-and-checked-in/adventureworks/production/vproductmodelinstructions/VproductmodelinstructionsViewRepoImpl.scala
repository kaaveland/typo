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
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class VproductmodelinstructionsViewRepoImpl extends VproductmodelinstructionsViewRepo {
  override def select: SelectBuilder[VproductmodelinstructionsViewFields, VproductmodelinstructionsViewRow] = {
    SelectBuilderSql(""""production"."vproductmodelinstructions"""", VproductmodelinstructionsViewFields.structure, VproductmodelinstructionsViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VproductmodelinstructionsViewRow] = {
    sql"""select "productmodelid", "name", "instructions", "LocationID", "SetupHours", "MachineHours", "LaborHours", "LotSize", "Step", "rowguid", "modifieddate"::text from "production"."vproductmodelinstructions"""".query(using VproductmodelinstructionsViewRow.read).stream
  }
}
