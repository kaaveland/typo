/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.Defaulted
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

object ProductcategoryRepoImpl extends ProductcategoryRepo {
  override def delete(productcategoryid: ProductcategoryId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productcategory where productcategoryid = $productcategoryid".executeUpdate() > 0
  }
  override def insert(unsaved: ProductcategoryRowUnsaved)(implicit c: Connection): ProductcategoryRow = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
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
      SQL"""insert into production.productcategory default values
            returning productcategoryid, "name", rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into production.productcategory(${namedParameters.map(_.name).mkString(", ")})
                  values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
                  returning productcategoryid, "name", rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ProductcategoryRow] = {
    SQL"""select productcategoryid, "name", rowguid, modifieddate
          from production.productcategory
       """.as(rowParser.*)
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
        val q = s"""select productcategoryid, "name", rowguid, modifieddate
                    from production.productcategory
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(productcategoryid: ProductcategoryId)(implicit c: Connection): Option[ProductcategoryRow] = {
    SQL"""select productcategoryid, "name", rowguid, modifieddate
          from production.productcategory
          where productcategoryid = $productcategoryid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(productcategoryids: Array[ProductcategoryId])(implicit c: Connection): List[ProductcategoryRow] = {
    implicit val arrayToSql: ToSql[Array[ProductcategoryId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[ProductcategoryId]] =
      (s: PreparedStatement, index: Int, v: Array[ProductcategoryId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select productcategoryid, "name", rowguid, modifieddate
          from production.productcategory
          where productcategoryid = ANY($productcategoryids)
       """.as(rowParser.*)
  
  }
  override def update(row: ProductcategoryRow)(implicit c: Connection): Boolean = {
    val productcategoryid = row.productcategoryid
    SQL"""update production.productcategory
          set "name" = ${row.name},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where productcategoryid = $productcategoryid
       """.executeUpdate() > 0
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
                    where productcategoryid = {productcategoryid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("productcategoryid", ParameterValue.from(productcategoryid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ProductcategoryRow] =
    RowParser[ProductcategoryRow] { row =>
      Success(
        ProductcategoryRow(
          productcategoryid = row[ProductcategoryId]("productcategoryid"),
          name = row[Name]("name"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
