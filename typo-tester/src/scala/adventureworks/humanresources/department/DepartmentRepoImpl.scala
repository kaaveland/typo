/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

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

object DepartmentRepoImpl extends DepartmentRepo {
  override def delete(departmentid: DepartmentId)(implicit c: Connection): Boolean = {
    SQL"delete from humanresources.department where departmentid = $departmentid".executeUpdate() > 0
  }
  override def insert(unsaved: DepartmentRowUnsaved)(implicit c: Connection): DepartmentRow = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      Some(NamedParameter("groupname", ParameterValue.from(unsaved.groupname))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    if (namedParameters.isEmpty) {
      SQL"""insert into humanresources.department default values
            returning departmentid, "name", groupname, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into humanresources.department(${namedParameters.map(_.name).mkString(", ")})
                  values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
                  returning departmentid, "name", groupname, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[DepartmentRow] = {
    SQL"""select departmentid, "name", groupname, modifieddate
          from humanresources.department
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[DepartmentFieldOrIdValue[_]])(implicit c: Connection): List[DepartmentRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case DepartmentFieldValue.departmentid(value) => NamedParameter("departmentid", ParameterValue.from(value))
          case DepartmentFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case DepartmentFieldValue.groupname(value) => NamedParameter("groupname", ParameterValue.from(value))
          case DepartmentFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select departmentid, "name", groupname, modifieddate
                    from humanresources.department
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(departmentid: DepartmentId)(implicit c: Connection): Option[DepartmentRow] = {
    SQL"""select departmentid, "name", groupname, modifieddate
          from humanresources.department
          where departmentid = $departmentid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(departmentids: Array[DepartmentId])(implicit c: Connection): List[DepartmentRow] = {
    implicit val arrayToSql: ToSql[Array[DepartmentId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[DepartmentId]] =
      (s: PreparedStatement, index: Int, v: Array[DepartmentId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select departmentid, "name", groupname, modifieddate
          from humanresources.department
          where departmentid = ANY($departmentids)
       """.as(rowParser.*)
  
  }
  override def update(row: DepartmentRow)(implicit c: Connection): Boolean = {
    val departmentid = row.departmentid
    SQL"""update humanresources.department
          set "name" = ${row.name},
              groupname = ${row.groupname},
              modifieddate = ${row.modifieddate}
          where departmentid = $departmentid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(departmentid: DepartmentId, fieldValues: List[DepartmentFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case DepartmentFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case DepartmentFieldValue.groupname(value) => NamedParameter("groupname", ParameterValue.from(value))
          case DepartmentFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update humanresources.department
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where departmentid = {departmentid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("departmentid", ParameterValue.from(departmentid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[DepartmentRow] =
    RowParser[DepartmentRow] { row =>
      Success(
        DepartmentRow(
          departmentid = row[DepartmentId]("departmentid"),
          name = row[Name]("name"),
          groupname = row[Name]("groupname"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
