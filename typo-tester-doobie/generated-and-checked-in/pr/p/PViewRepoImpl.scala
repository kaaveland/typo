/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package p

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PViewRepoImpl extends PViewRepo {
  override def selectAll: Stream[ConnectionIO, PViewRow] = {
    sql"""select "id", productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate from pr."p"""".query[PViewRow].stream
  }
}
