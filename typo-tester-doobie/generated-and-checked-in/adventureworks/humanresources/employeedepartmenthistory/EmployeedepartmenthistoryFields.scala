/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentFields
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.department.DepartmentRow
import adventureworks.humanresources.employee.EmployeeFields
import adventureworks.humanresources.employee.EmployeeRow
import adventureworks.humanresources.shift.ShiftFields
import adventureworks.humanresources.shift.ShiftId
import adventureworks.humanresources.shift.ShiftRow
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.Required
import typo.dsl.SqlExpr
import typo.dsl.SqlExpr.CompositeIn
import typo.dsl.SqlExpr.CompositeIn.TuplePart
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait EmployeedepartmenthistoryFields {
  def businessentityid: IdField[BusinessentityId, EmployeedepartmenthistoryRow]
  def departmentid: IdField[DepartmentId, EmployeedepartmenthistoryRow]
  def shiftid: IdField[ShiftId, EmployeedepartmenthistoryRow]
  def startdate: IdField[TypoLocalDate, EmployeedepartmenthistoryRow]
  def enddate: OptField[TypoLocalDate, EmployeedepartmenthistoryRow]
  def modifieddate: Field[TypoLocalDateTime, EmployeedepartmenthistoryRow]
  def fkDepartment: ForeignKey[DepartmentFields, DepartmentRow] =
    ForeignKey[DepartmentFields, DepartmentRow]("humanresources.FK_EmployeeDepartmentHistory_Department_DepartmentID", Nil)
      .withColumnPair(departmentid, _.departmentid)
  def fkEmployee: ForeignKey[EmployeeFields, EmployeeRow] =
    ForeignKey[EmployeeFields, EmployeeRow]("humanresources.FK_EmployeeDepartmentHistory_Employee_BusinessEntityID", Nil)
      .withColumnPair(businessentityid, _.businessentityid)
  def fkShift: ForeignKey[ShiftFields, ShiftRow] =
    ForeignKey[ShiftFields, ShiftRow]("humanresources.FK_EmployeeDepartmentHistory_Shift_ShiftID", Nil)
      .withColumnPair(shiftid, _.shiftid)
  def compositeIdIs(compositeId: EmployeedepartmenthistoryId): SqlExpr[Boolean, Required] =
    businessentityid.isEqual(compositeId.businessentityid).and(startdate.isEqual(compositeId.startdate)).and(departmentid.isEqual(compositeId.departmentid)).and(shiftid.isEqual(compositeId.shiftid))
  def compositeIdIn(compositeIds: Array[EmployeedepartmenthistoryId]): SqlExpr[Boolean, Required] =
    new CompositeIn(compositeIds)(TuplePart(businessentityid)(_.businessentityid), TuplePart(startdate)(_.startdate), TuplePart(departmentid)(_.departmentid), TuplePart(shiftid)(_.shiftid))
  
}

object EmployeedepartmenthistoryFields {
  lazy val structure: Relation[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] {
  
    override lazy val fields: EmployeedepartmenthistoryFields = new EmployeedepartmenthistoryFields {
      override def businessentityid = IdField[BusinessentityId, EmployeedepartmenthistoryRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def departmentid = IdField[DepartmentId, EmployeedepartmenthistoryRow](_path, "departmentid", None, Some("int2"), x => x.departmentid, (row, value) => row.copy(departmentid = value))
      override def shiftid = IdField[ShiftId, EmployeedepartmenthistoryRow](_path, "shiftid", None, Some("int2"), x => x.shiftid, (row, value) => row.copy(shiftid = value))
      override def startdate = IdField[TypoLocalDate, EmployeedepartmenthistoryRow](_path, "startdate", Some("text"), Some("date"), x => x.startdate, (row, value) => row.copy(startdate = value))
      override def enddate = OptField[TypoLocalDate, EmployeedepartmenthistoryRow](_path, "enddate", Some("text"), Some("date"), x => x.enddate, (row, value) => row.copy(enddate = value))
      override def modifieddate = Field[TypoLocalDateTime, EmployeedepartmenthistoryRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, EmployeedepartmenthistoryRow]] =
      List[FieldLikeNoHkt[?, EmployeedepartmenthistoryRow]](fields.businessentityid, fields.departmentid, fields.shiftid, fields.startdate, fields.enddate, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
