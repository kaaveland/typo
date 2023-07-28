/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object DepartmentRepoImpl extends DepartmentRepo {
  override def delete(departmentid: DepartmentId)(implicit c: Connection): Boolean = {
    SQL"delete from humanresources.department where departmentid = $departmentid".executeUpdate() > 0
  }
  override def insert(unsaved: DepartmentRow)(implicit c: Connection): DepartmentRow = {
    SQL"""insert into humanresources.department(departmentid, "name", groupname, modifieddate)
          values (${unsaved.departmentid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.groupname}::"public"."Name", ${unsaved.modifieddate}::timestamp)
          returning departmentid, "name", groupname, modifieddate
       """
      .executeInsert(DepartmentRow.rowParser(1).single)
  
  }
  override def insert(unsaved: DepartmentRowUnsaved)(implicit c: Connection): DepartmentRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      Some((NamedParameter("groupname", ParameterValue.from(unsaved.groupname)), """::"public"."Name"""")),
      unsaved.departmentid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("departmentid", ParameterValue.from[DepartmentId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into humanresources.department default values
            returning departmentid, "name", groupname, modifieddate
         """
        .executeInsert(DepartmentRow.rowParser(1).single)
    } else {
      val q = s"""insert into humanresources.department(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning departmentid, "name", groupname, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(DepartmentRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[DepartmentRow] = {
    SQL"""select departmentid, "name", groupname, modifieddate
          from humanresources.department
       """.as(DepartmentRow.rowParser(1).*)
  }
  override def selectById(departmentid: DepartmentId)(implicit c: Connection): Option[DepartmentRow] = {
    SQL"""select departmentid, "name", groupname, modifieddate
          from humanresources.department
          where departmentid = $departmentid
       """.as(DepartmentRow.rowParser(1).singleOpt)
  }
  override def selectByIds(departmentids: Array[DepartmentId])(implicit c: Connection): List[DepartmentRow] = {
    implicit val toStatement: ToStatement[Array[DepartmentId]] =
      (s: PreparedStatement, index: Int, v: Array[DepartmentId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select departmentid, "name", groupname, modifieddate
          from humanresources.department
          where departmentid = ANY($departmentids)
       """.as(DepartmentRow.rowParser(1).*)
  
  }
  override def update(row: DepartmentRow)(implicit c: Connection): Boolean = {
    val departmentid = row.departmentid
    SQL"""update humanresources.department
          set "name" = ${row.name}::"public"."Name",
              groupname = ${row.groupname}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where departmentid = $departmentid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: DepartmentRow)(implicit c: Connection): DepartmentRow = {
    SQL"""insert into humanresources.department(departmentid, "name", groupname, modifieddate)
          values (
            ${unsaved.departmentid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.groupname}::"public"."Name",
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (departmentid)
          do update set
            "name" = EXCLUDED."name",
            groupname = EXCLUDED.groupname,
            modifieddate = EXCLUDED.modifieddate
          returning departmentid, "name", groupname, modifieddate
       """
      .executeInsert(DepartmentRow.rowParser(1).single)
  
  }
}
