/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PurchaseorderdetailRepoImpl extends PurchaseorderdetailRepo {
  override def select: SelectBuilder[PurchaseorderdetailFields, PurchaseorderdetailRow] = {
    SelectBuilderSql("purchasing.purchaseorderdetail", PurchaseorderdetailFields.structure, PurchaseorderdetailRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PurchaseorderdetailRow] = {
    SQL"""select "purchaseorderid", "purchaseorderdetailid", "duedate"::text, "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate"::text
          from purchasing.purchaseorderdetail
       """.as(PurchaseorderdetailRow.rowParser(1).*)
  }
  override def selectById(compositeId: PurchaseorderdetailId)(implicit c: Connection): Option[PurchaseorderdetailRow] = {
    SQL"""select "purchaseorderid", "purchaseorderdetailid", "duedate"::text, "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate"::text
          from purchasing.purchaseorderdetail
          where "purchaseorderid" = ${ParameterValue(compositeId.purchaseorderid, null, PurchaseorderheaderId.toStatement)} AND "purchaseorderdetailid" = ${ParameterValue(compositeId.purchaseorderdetailid, null, ToStatement.intToStatement)}
       """.as(PurchaseorderdetailRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[PurchaseorderdetailId])(implicit c: Connection): List[PurchaseorderdetailRow] = {
    val purchaseorderid = compositeIds.map(_.purchaseorderid)
    val purchaseorderdetailid = compositeIds.map(_.purchaseorderdetailid)
    SQL"""select "purchaseorderid", "purchaseorderdetailid", "duedate"::text, "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate"::text
          from purchasing.purchaseorderdetail
          where ("purchaseorderid", "purchaseorderdetailid") 
          in (select unnest(${purchaseorderid}), unnest(${purchaseorderdetailid}))
       """.as(PurchaseorderdetailRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(compositeIds: Array[PurchaseorderdetailId])(implicit c: Connection): Map[PurchaseorderdetailId, PurchaseorderdetailRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
}
