/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams

class ProductRepoMock(toRow: Function1[ProductRowUnsaved, ProductRow],
                      map: scala.collection.mutable.Map[ProductId, ProductRow] = scala.collection.mutable.Map.empty) extends ProductRepo {
  override def delete: DeleteBuilder[ProductFields, ProductRow] = {
    DeleteBuilderMock(DeleteParams.empty, ProductFields.structure, map)
  }
  override def deleteById(productid: ProductId)(implicit c: Connection): Boolean = {
    map.remove(productid).isDefined
  }
  override def deleteByIds(productids: Array[ProductId])(implicit c: Connection): Int = {
    productids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: ProductRow)(implicit c: Connection): ProductRow = {
    val _ = if (map.contains(unsaved.productid))
      sys.error(s"id ${unsaved.productid} already exists")
    else
      map.put(unsaved.productid, unsaved)
    
    unsaved
  }
  override def insert(unsaved: ProductRowUnsaved)(implicit c: Connection): ProductRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[ProductRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.productid -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.productid -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[ProductFields, ProductRow] = {
    SelectBuilderMock(ProductFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[ProductRow] = {
    map.values.toList
  }
  override def selectById(productid: ProductId)(implicit c: Connection): Option[ProductRow] = {
    map.get(productid)
  }
  override def selectByIds(productids: Array[ProductId])(implicit c: Connection): List[ProductRow] = {
    productids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(productids: Array[ProductId])(implicit c: Connection): Map[ProductId, ProductRow] = {
    val byId = selectByIds(productids).view.map(x => (x.productid, x)).toMap
    productids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ProductFields, ProductRow] = {
    UpdateBuilderMock(UpdateParams.empty, ProductFields.structure, map)
  }
  override def update(row: ProductRow)(implicit c: Connection): Boolean = {
    map.get(row.productid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.productid, row): @nowarn
        true
      case None => false
    }
  }
  override def upsert(unsaved: ProductRow)(implicit c: Connection): ProductRow = {
    map.put(unsaved.productid, unsaved): @nowarn
    unsaved
  }
}
