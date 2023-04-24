/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object ProductlistpricehistoryRepoImpl extends ProductlistpricehistoryRepo {
  override def delete(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productlistpricehistory where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}".executeUpdate() > 0
  }
  override def insert(compositeId: ProductlistpricehistoryId, unsaved: ProductlistpricehistoryRowUnsaved)(implicit c: Connection): ProductlistpricehistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
      Some((NamedParameter("listprice", ParameterValue.from(unsaved.listprice)), "::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    val q = s"""insert into production.productlistpricehistory(productid, startdate, ${namedParameters.map(x => quote + x._1.name + quote).mkString(", ")})
                values ({productid}::int4, {startdate}::timestamp, ${namedParameters.map{case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                returning productid, startdate, enddate, listprice, modifieddate
             """
    // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
    import anorm._
    SQL(q)
      .on(namedParameters.map(_._1) :_*)
      .on(NamedParameter("productid", ParameterValue.from(compositeId.productid)), NamedParameter("startdate", ParameterValue.from(compositeId.startdate)))
      .executeInsert(rowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[ProductlistpricehistoryRow] = {
    SQL"""select productid, startdate, enddate, listprice, modifieddate
          from production.productlistpricehistory
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductlistpricehistoryFieldOrIdValue[_]])(implicit c: Connection): List[ProductlistpricehistoryRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductlistpricehistoryFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case ProductlistpricehistoryFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case ProductlistpricehistoryFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case ProductlistpricehistoryFieldValue.listprice(value) => NamedParameter("listprice", ParameterValue.from(value))
          case ProductlistpricehistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select productid, startdate, enddate, listprice, modifieddate
                    from production.productlistpricehistory
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Option[ProductlistpricehistoryRow] = {
    SQL"""select productid, startdate, enddate, listprice, modifieddate
          from production.productlistpricehistory
          where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}
       """.as(rowParser.singleOpt)
  }
  override def update(row: ProductlistpricehistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productlistpricehistory
          set enddate = ${row.enddate}::timestamp,
              listprice = ${row.listprice}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: ProductlistpricehistoryId, fieldValues: List[ProductlistpricehistoryFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductlistpricehistoryFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case ProductlistpricehistoryFieldValue.listprice(value) => NamedParameter("listprice", ParameterValue.from(value))
          case ProductlistpricehistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production.productlistpricehistory
                    set ${namedParams.map(x => s"${quote}${x.name}${quote} = {${x.name}}").mkString(", ")}
                    where productid = {productid} AND startdate = {startdate}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("productid", ParameterValue.from(compositeId.productid)), NamedParameter("startdate", ParameterValue.from(compositeId.startdate)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ProductlistpricehistoryRow] =
    RowParser[ProductlistpricehistoryRow] { row =>
      Success(
        ProductlistpricehistoryRow(
          productid = row[ProductId]("productid"),
          startdate = row[LocalDateTime]("startdate"),
          enddate = row[Option[LocalDateTime]]("enddate"),
          listprice = row[BigDecimal]("listprice"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
