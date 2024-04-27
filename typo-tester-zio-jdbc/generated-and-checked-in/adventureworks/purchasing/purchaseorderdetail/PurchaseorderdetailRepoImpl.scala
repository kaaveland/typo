/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.ZIO
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class PurchaseorderdetailRepoImpl extends PurchaseorderdetailRepo {
  override def select: SelectBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow] = {
    SelectBuilderSql("purchasing.purchaseorderdetail", PurchaseorderdetailFields.structure, PurchaseorderdetailRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PurchaseorderdetailRow] = {
    sql"""select "purchaseorderid", "purchaseorderdetailid", "duedate"::text, "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate"::text from purchasing.purchaseorderdetail""".query(using PurchaseorderdetailRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: PurchaseorderdetailId): ZIO[ZConnection, Throwable, Option[PurchaseorderdetailRow]] = {
    sql"""select "purchaseorderid", "purchaseorderdetailid", "duedate"::text, "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate"::text from purchasing.purchaseorderdetail where "purchaseorderid" = ${Segment.paramSegment(compositeId.purchaseorderid)(PurchaseorderheaderId.setter)} AND "purchaseorderdetailid" = ${Segment.paramSegment(compositeId.purchaseorderdetailid)(Setter.intSetter)}""".query(using PurchaseorderdetailRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[PurchaseorderdetailId]): ZStream[ZConnection, Throwable, PurchaseorderdetailRow] = {
    val purchaseorderid = compositeIds.map(_.purchaseorderid)
    val purchaseorderdetailid = compositeIds.map(_.purchaseorderdetailid)
    sql"""select "purchaseorderid", "purchaseorderdetailid", "duedate"::text, "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate"::text
          from purchasing.purchaseorderdetail
          where ("purchaseorderid", "purchaseorderdetailid")
          in (select unnest(${purchaseorderid}), unnest(${purchaseorderdetailid}))
       """.query(using PurchaseorderdetailRow.jdbcDecoder).selectStream()
    
  }
  override def selectByIdsTracked(compositeIds: Array[PurchaseorderdetailId]): ZIO[ZConnection, Throwable, Map[PurchaseorderdetailId, Option[PurchaseorderdetailRow]]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
}
