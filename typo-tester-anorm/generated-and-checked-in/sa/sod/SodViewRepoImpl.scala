/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sod

import anorm.SqlStringInterpolation
import java.sql.Connection

object SodViewRepoImpl extends SodViewRepo {
  override def selectAll(implicit c: Connection): List[SodViewRow] = {
    SQL"""select "id", salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate
          from sa.sod
       """.as(SodViewRow.rowParser(1).*)
  }
}
