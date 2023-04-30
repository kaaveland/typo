/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import java.sql.Connection
import scala.Function1

class ProductRepoMock(toRow: Function1[ProductRowUnsaved, ProductRow],
                      map: scala.collection.mutable.Map[ProductId, ProductRow] = scala.collection.mutable.Map.empty) extends ProductRepo {
  override def delete(productid: ProductId)(implicit c: Connection): Boolean = {
    map.remove(productid).isDefined
  }
  override def insert(unsaved: ProductRow)(implicit c: Connection): ProductRow = {
    if (map.contains(unsaved.productid))
      sys.error(s"id ${unsaved.productid} already exists")
    else
      map.put(unsaved.productid, unsaved)
    unsaved
  }
  override def insert(unsaved: ProductRowUnsaved)(implicit c: Connection): ProductRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[ProductRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[ProductFieldOrIdValue[_]])(implicit c: Connection): List[ProductRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, ProductFieldValue.productid(value)) => acc.filter(_.productid == value)
      case (acc, ProductFieldValue.name(value)) => acc.filter(_.name == value)
      case (acc, ProductFieldValue.productnumber(value)) => acc.filter(_.productnumber == value)
      case (acc, ProductFieldValue.makeflag(value)) => acc.filter(_.makeflag == value)
      case (acc, ProductFieldValue.finishedgoodsflag(value)) => acc.filter(_.finishedgoodsflag == value)
      case (acc, ProductFieldValue.color(value)) => acc.filter(_.color == value)
      case (acc, ProductFieldValue.safetystocklevel(value)) => acc.filter(_.safetystocklevel == value)
      case (acc, ProductFieldValue.reorderpoint(value)) => acc.filter(_.reorderpoint == value)
      case (acc, ProductFieldValue.standardcost(value)) => acc.filter(_.standardcost == value)
      case (acc, ProductFieldValue.listprice(value)) => acc.filter(_.listprice == value)
      case (acc, ProductFieldValue.size(value)) => acc.filter(_.size == value)
      case (acc, ProductFieldValue.sizeunitmeasurecode(value)) => acc.filter(_.sizeunitmeasurecode == value)
      case (acc, ProductFieldValue.weightunitmeasurecode(value)) => acc.filter(_.weightunitmeasurecode == value)
      case (acc, ProductFieldValue.weight(value)) => acc.filter(_.weight == value)
      case (acc, ProductFieldValue.daystomanufacture(value)) => acc.filter(_.daystomanufacture == value)
      case (acc, ProductFieldValue.productline(value)) => acc.filter(_.productline == value)
      case (acc, ProductFieldValue.`class`(value)) => acc.filter(_.`class` == value)
      case (acc, ProductFieldValue.style(value)) => acc.filter(_.style == value)
      case (acc, ProductFieldValue.productsubcategoryid(value)) => acc.filter(_.productsubcategoryid == value)
      case (acc, ProductFieldValue.productmodelid(value)) => acc.filter(_.productmodelid == value)
      case (acc, ProductFieldValue.sellstartdate(value)) => acc.filter(_.sellstartdate == value)
      case (acc, ProductFieldValue.sellenddate(value)) => acc.filter(_.sellenddate == value)
      case (acc, ProductFieldValue.discontinueddate(value)) => acc.filter(_.discontinueddate == value)
      case (acc, ProductFieldValue.rowguid(value)) => acc.filter(_.rowguid == value)
      case (acc, ProductFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
    }.toList
  }
  override def selectById(productid: ProductId)(implicit c: Connection): Option[ProductRow] = {
    map.get(productid)
  }
  override def selectByIds(productids: Array[ProductId])(implicit c: Connection): List[ProductRow] = {
    productids.flatMap(map.get).toList
  }
  override def update(row: ProductRow)(implicit c: Connection): Boolean = {
    map.get(row.productid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.productid, row)
        true
      case None => false
    }
  }
  override def updateFieldValues(productid: ProductId, fieldValues: List[ProductFieldValue[_]])(implicit c: Connection): Boolean = {
    map.get(productid) match {
      case Some(oldRow) =>
        val updatedRow = fieldValues.foldLeft(oldRow) {
          case (acc, ProductFieldValue.name(value)) => acc.copy(name = value)
          case (acc, ProductFieldValue.productnumber(value)) => acc.copy(productnumber = value)
          case (acc, ProductFieldValue.makeflag(value)) => acc.copy(makeflag = value)
          case (acc, ProductFieldValue.finishedgoodsflag(value)) => acc.copy(finishedgoodsflag = value)
          case (acc, ProductFieldValue.color(value)) => acc.copy(color = value)
          case (acc, ProductFieldValue.safetystocklevel(value)) => acc.copy(safetystocklevel = value)
          case (acc, ProductFieldValue.reorderpoint(value)) => acc.copy(reorderpoint = value)
          case (acc, ProductFieldValue.standardcost(value)) => acc.copy(standardcost = value)
          case (acc, ProductFieldValue.listprice(value)) => acc.copy(listprice = value)
          case (acc, ProductFieldValue.size(value)) => acc.copy(size = value)
          case (acc, ProductFieldValue.sizeunitmeasurecode(value)) => acc.copy(sizeunitmeasurecode = value)
          case (acc, ProductFieldValue.weightunitmeasurecode(value)) => acc.copy(weightunitmeasurecode = value)
          case (acc, ProductFieldValue.weight(value)) => acc.copy(weight = value)
          case (acc, ProductFieldValue.daystomanufacture(value)) => acc.copy(daystomanufacture = value)
          case (acc, ProductFieldValue.productline(value)) => acc.copy(productline = value)
          case (acc, ProductFieldValue.`class`(value)) => acc.copy(`class` = value)
          case (acc, ProductFieldValue.style(value)) => acc.copy(style = value)
          case (acc, ProductFieldValue.productsubcategoryid(value)) => acc.copy(productsubcategoryid = value)
          case (acc, ProductFieldValue.productmodelid(value)) => acc.copy(productmodelid = value)
          case (acc, ProductFieldValue.sellstartdate(value)) => acc.copy(sellstartdate = value)
          case (acc, ProductFieldValue.sellenddate(value)) => acc.copy(sellenddate = value)
          case (acc, ProductFieldValue.discontinueddate(value)) => acc.copy(discontinueddate = value)
          case (acc, ProductFieldValue.rowguid(value)) => acc.copy(rowguid = value)
          case (acc, ProductFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
        }
        if (updatedRow != oldRow) {
          map.put(productid, updatedRow)
          true
        } else {
          false
        }
      case None => false
    }
  }
}