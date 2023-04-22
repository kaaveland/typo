/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import adventureworks.Defaulted
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToSql
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.util.UUID

object ProductRepoImpl extends ProductRepo {
  override def delete(productid: ProductId)(implicit c: Connection): Boolean = {
    SQL"delete from production.product where productid = $productid".executeUpdate() > 0
  }
  override def insert(unsaved: ProductRowUnsaved)(implicit c: Connection): ProductRow = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      Some(NamedParameter("productnumber", ParameterValue.from(unsaved.productnumber))),
      unsaved.makeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("makeflag", ParameterValue.from[Flag](value)))
      },
      unsaved.finishedgoodsflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("finishedgoodsflag", ParameterValue.from[Flag](value)))
      },
      Some(NamedParameter("color", ParameterValue.from(unsaved.color))),
      Some(NamedParameter("safetystocklevel", ParameterValue.from(unsaved.safetystocklevel))),
      Some(NamedParameter("reorderpoint", ParameterValue.from(unsaved.reorderpoint))),
      Some(NamedParameter("standardcost", ParameterValue.from(unsaved.standardcost))),
      Some(NamedParameter("listprice", ParameterValue.from(unsaved.listprice))),
      Some(NamedParameter("size", ParameterValue.from(unsaved.size))),
      Some(NamedParameter("sizeunitmeasurecode", ParameterValue.from(unsaved.sizeunitmeasurecode))),
      Some(NamedParameter("weightunitmeasurecode", ParameterValue.from(unsaved.weightunitmeasurecode))),
      Some(NamedParameter("weight", ParameterValue.from(unsaved.weight))),
      Some(NamedParameter("daystomanufacture", ParameterValue.from(unsaved.daystomanufacture))),
      Some(NamedParameter("productline", ParameterValue.from(unsaved.productline))),
      Some(NamedParameter("class", ParameterValue.from(unsaved.`class`))),
      Some(NamedParameter("style", ParameterValue.from(unsaved.style))),
      Some(NamedParameter("productsubcategoryid", ParameterValue.from(unsaved.productsubcategoryid))),
      Some(NamedParameter("productmodelid", ParameterValue.from(unsaved.productmodelid))),
      Some(NamedParameter("sellstartdate", ParameterValue.from(unsaved.sellstartdate))),
      Some(NamedParameter("sellenddate", ParameterValue.from(unsaved.sellenddate))),
      Some(NamedParameter("discontinueddate", ParameterValue.from(unsaved.discontinueddate))),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("rowguid", ParameterValue.from[UUID](value)))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    if (namedParameters.isEmpty) {
      SQL"""insert into production.product default values
            returning productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into production.product(${namedParameters.map(_.name).mkString(", ")})
                  values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
                  returning productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ProductRow] = {
    SQL"""select productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate
          from production.product
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductFieldOrIdValue[_]])(implicit c: Connection): List[ProductRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case ProductFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ProductFieldValue.productnumber(value) => NamedParameter("productnumber", ParameterValue.from(value))
          case ProductFieldValue.makeflag(value) => NamedParameter("makeflag", ParameterValue.from(value))
          case ProductFieldValue.finishedgoodsflag(value) => NamedParameter("finishedgoodsflag", ParameterValue.from(value))
          case ProductFieldValue.color(value) => NamedParameter("color", ParameterValue.from(value))
          case ProductFieldValue.safetystocklevel(value) => NamedParameter("safetystocklevel", ParameterValue.from(value))
          case ProductFieldValue.reorderpoint(value) => NamedParameter("reorderpoint", ParameterValue.from(value))
          case ProductFieldValue.standardcost(value) => NamedParameter("standardcost", ParameterValue.from(value))
          case ProductFieldValue.listprice(value) => NamedParameter("listprice", ParameterValue.from(value))
          case ProductFieldValue.size(value) => NamedParameter("size", ParameterValue.from(value))
          case ProductFieldValue.sizeunitmeasurecode(value) => NamedParameter("sizeunitmeasurecode", ParameterValue.from(value))
          case ProductFieldValue.weightunitmeasurecode(value) => NamedParameter("weightunitmeasurecode", ParameterValue.from(value))
          case ProductFieldValue.weight(value) => NamedParameter("weight", ParameterValue.from(value))
          case ProductFieldValue.daystomanufacture(value) => NamedParameter("daystomanufacture", ParameterValue.from(value))
          case ProductFieldValue.productline(value) => NamedParameter("productline", ParameterValue.from(value))
          case ProductFieldValue.`class`(value) => NamedParameter("class", ParameterValue.from(value))
          case ProductFieldValue.style(value) => NamedParameter("style", ParameterValue.from(value))
          case ProductFieldValue.productsubcategoryid(value) => NamedParameter("productsubcategoryid", ParameterValue.from(value))
          case ProductFieldValue.productmodelid(value) => NamedParameter("productmodelid", ParameterValue.from(value))
          case ProductFieldValue.sellstartdate(value) => NamedParameter("sellstartdate", ParameterValue.from(value))
          case ProductFieldValue.sellenddate(value) => NamedParameter("sellenddate", ParameterValue.from(value))
          case ProductFieldValue.discontinueddate(value) => NamedParameter("discontinueddate", ParameterValue.from(value))
          case ProductFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate
                    from production.product
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(productid: ProductId)(implicit c: Connection): Option[ProductRow] = {
    SQL"""select productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate
          from production.product
          where productid = $productid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(productids: Array[ProductId])(implicit c: Connection): List[ProductRow] = {
    implicit val arrayToSql: ToSql[Array[ProductId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[ProductId]] =
      (s: PreparedStatement, index: Int, v: Array[ProductId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select productid, "name", productnumber, makeflag, finishedgoodsflag, color, safetystocklevel, reorderpoint, standardcost, listprice, "size", sizeunitmeasurecode, weightunitmeasurecode, weight, daystomanufacture, productline, "class", "style", productsubcategoryid, productmodelid, sellstartdate, sellenddate, discontinueddate, rowguid, modifieddate
          from production.product
          where productid = ANY($productids)
       """.as(rowParser.*)
  
  }
  override def update(row: ProductRow)(implicit c: Connection): Boolean = {
    val productid = row.productid
    SQL"""update production.product
          set "name" = ${row.name},
              productnumber = ${row.productnumber},
              makeflag = ${row.makeflag},
              finishedgoodsflag = ${row.finishedgoodsflag},
              color = ${row.color},
              safetystocklevel = ${row.safetystocklevel},
              reorderpoint = ${row.reorderpoint},
              standardcost = ${row.standardcost},
              listprice = ${row.listprice},
              "size" = ${row.size},
              sizeunitmeasurecode = ${row.sizeunitmeasurecode},
              weightunitmeasurecode = ${row.weightunitmeasurecode},
              weight = ${row.weight},
              daystomanufacture = ${row.daystomanufacture},
              productline = ${row.productline},
              "class" = ${row.`class`},
              "style" = ${row.style},
              productsubcategoryid = ${row.productsubcategoryid},
              productmodelid = ${row.productmodelid},
              sellstartdate = ${row.sellstartdate},
              sellenddate = ${row.sellenddate},
              discontinueddate = ${row.discontinueddate},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where productid = $productid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(productid: ProductId, fieldValues: List[ProductFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ProductFieldValue.productnumber(value) => NamedParameter("productnumber", ParameterValue.from(value))
          case ProductFieldValue.makeflag(value) => NamedParameter("makeflag", ParameterValue.from(value))
          case ProductFieldValue.finishedgoodsflag(value) => NamedParameter("finishedgoodsflag", ParameterValue.from(value))
          case ProductFieldValue.color(value) => NamedParameter("color", ParameterValue.from(value))
          case ProductFieldValue.safetystocklevel(value) => NamedParameter("safetystocklevel", ParameterValue.from(value))
          case ProductFieldValue.reorderpoint(value) => NamedParameter("reorderpoint", ParameterValue.from(value))
          case ProductFieldValue.standardcost(value) => NamedParameter("standardcost", ParameterValue.from(value))
          case ProductFieldValue.listprice(value) => NamedParameter("listprice", ParameterValue.from(value))
          case ProductFieldValue.size(value) => NamedParameter("size", ParameterValue.from(value))
          case ProductFieldValue.sizeunitmeasurecode(value) => NamedParameter("sizeunitmeasurecode", ParameterValue.from(value))
          case ProductFieldValue.weightunitmeasurecode(value) => NamedParameter("weightunitmeasurecode", ParameterValue.from(value))
          case ProductFieldValue.weight(value) => NamedParameter("weight", ParameterValue.from(value))
          case ProductFieldValue.daystomanufacture(value) => NamedParameter("daystomanufacture", ParameterValue.from(value))
          case ProductFieldValue.productline(value) => NamedParameter("productline", ParameterValue.from(value))
          case ProductFieldValue.`class`(value) => NamedParameter("class", ParameterValue.from(value))
          case ProductFieldValue.style(value) => NamedParameter("style", ParameterValue.from(value))
          case ProductFieldValue.productsubcategoryid(value) => NamedParameter("productsubcategoryid", ParameterValue.from(value))
          case ProductFieldValue.productmodelid(value) => NamedParameter("productmodelid", ParameterValue.from(value))
          case ProductFieldValue.sellstartdate(value) => NamedParameter("sellstartdate", ParameterValue.from(value))
          case ProductFieldValue.sellenddate(value) => NamedParameter("sellenddate", ParameterValue.from(value))
          case ProductFieldValue.discontinueddate(value) => NamedParameter("discontinueddate", ParameterValue.from(value))
          case ProductFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.product
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where productid = {productid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("productid", ParameterValue.from(productid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ProductRow] =
    RowParser[ProductRow] { row =>
      Success(
        ProductRow(
          productid = row[ProductId]("productid"),
          name = row[Name]("name"),
          productnumber = row[String]("productnumber"),
          makeflag = row[Flag]("makeflag"),
          finishedgoodsflag = row[Flag]("finishedgoodsflag"),
          color = row[Option[String]]("color"),
          safetystocklevel = row[Int]("safetystocklevel"),
          reorderpoint = row[Int]("reorderpoint"),
          standardcost = row[BigDecimal]("standardcost"),
          listprice = row[BigDecimal]("listprice"),
          size = row[Option[String]]("size"),
          sizeunitmeasurecode = row[Option[UnitmeasureId]]("sizeunitmeasurecode"),
          weightunitmeasurecode = row[Option[UnitmeasureId]]("weightunitmeasurecode"),
          weight = row[Option[BigDecimal]]("weight"),
          daystomanufacture = row[Int]("daystomanufacture"),
          productline = row[Option[/* bpchar */ String]]("productline"),
          `class` = row[Option[/* bpchar */ String]]("class"),
          style = row[Option[/* bpchar */ String]]("style"),
          productsubcategoryid = row[Option[ProductsubcategoryId]]("productsubcategoryid"),
          productmodelid = row[Option[ProductmodelId]]("productmodelid"),
          sellstartdate = row[LocalDateTime]("sellstartdate"),
          sellenddate = row[Option[LocalDateTime]]("sellenddate"),
          discontinueddate = row[Option[LocalDateTime]]("discontinueddate"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
