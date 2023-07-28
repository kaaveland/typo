/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package poh

import anorm.SqlStringInterpolation
import java.sql.Connection

object PohViewRepoImpl extends PohViewRepo {
  override def selectAll(implicit c: Connection): List[PohViewRow] = {
    SQL"""select "id", purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate, shipdate, subtotal, taxamt, freight, modifieddate
          from pu.poh
       """.as(PohViewRow.rowParser(1).*)
  }
}
