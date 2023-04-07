/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.Defaulted.Provided
import adventureworks.Defaulted.UseDefault
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlParser
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object ProductcategoryRepoImpl extends ProductcategoryRepo {
  override def delete(productcategoryid: ProductcategoryId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productcategory where productcategoryid = $productcategoryid""".executeUpdate() > 0
  }
  override def insert(unsaved: ProductcategoryRowUnsaved)(implicit c: Connection): ProductcategoryId = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      unsaved.rowguid match {
        case UseDefault => None
        case Provided(value) => Some(NamedParameter("rowguid", ParameterValue.from[UUID](value)))
      },
      unsaved.modifieddate match {
        case UseDefault => None
        case Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.productcategory(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning productcategoryid
    """
      .on(namedParameters :_*)
      .executeInsert(SqlParser.get[ProductcategoryId]("productcategoryid").single)
  
  }
  override def selectAll(implicit c: Connection): List[ProductcategoryRow] = {
    SQL"""select productcategoryid, name, rowguid, modifieddate from production.productcategory""".as(ProductcategoryRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[ProductcategoryFieldOrIdValue[_]])(implicit c: Connection): List[ProductcategoryRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductcategoryFieldValue.productcategoryid(value) => NamedParameter("productcategoryid", ParameterValue.from(value))
          case ProductcategoryFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ProductcategoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductcategoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.productcategory where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(ProductcategoryRow.rowParser("").*)
    }
  
  }
  override def selectById(productcategoryid: ProductcategoryId)(implicit c: Connection): Option[ProductcategoryRow] = {
    SQL"""select productcategoryid, name, rowguid, modifieddate from production.productcategory where productcategoryid = $productcategoryid""".as(ProductcategoryRow.rowParser("").singleOpt)
  }
  override def selectByIds(productcategoryids: List[ProductcategoryId])(implicit c: Connection): List[ProductcategoryRow] = {
    SQL"""select productcategoryid, name, rowguid, modifieddate from production.productcategory where productcategoryid in $productcategoryids""".as(ProductcategoryRow.rowParser("").*)
  }
  override def update(productcategoryid: ProductcategoryId, row: ProductcategoryRow)(implicit c: Connection): Boolean = {
    SQL"""update production.productcategory
          set name = ${row.name},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where productcategoryid = $productcategoryid""".executeUpdate() > 0
  }
  override def updateFieldValues(productcategoryid: ProductcategoryId, fieldValues: List[ProductcategoryFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductcategoryFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ProductcategoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductcategoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.productcategory
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where productcategoryid = $productcategoryid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
}
