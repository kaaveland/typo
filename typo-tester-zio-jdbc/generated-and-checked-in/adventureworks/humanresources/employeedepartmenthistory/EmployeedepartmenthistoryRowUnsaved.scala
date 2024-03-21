/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `humanresources.employeedepartmenthistory` which has not been persisted yet */
case class EmployeedepartmenthistoryRowUnsaved(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Department in which the employee worked including currently. Foreign key to Department.DepartmentID.
      Points to [[department.DepartmentRow.departmentid]] */
  departmentid: DepartmentId,
  /** Identifies which 8-hour shift the employee works. Foreign key to Shift.Shift.ID.
      Points to [[shift.ShiftRow.shiftid]] */
  shiftid: ShiftId,
  /** Date the employee started work in the department.
      Constraint CK_EmployeeDepartmentHistory_EndDate affecting columns e, n, d, d, a, t, e, ,,  , s, t, a, r, t, d, a, t, e:  (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDate,
  /** Date the employee left the department. NULL = Current department.
      Constraint CK_EmployeeDepartmentHistory_EndDate affecting columns e, n, d, d, a, t, e, ,,  , s, t, a, r, t, d, a, t, e:  (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDate],
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): EmployeedepartmenthistoryRow =
    EmployeedepartmenthistoryRow(
      businessentityid = businessentityid,
      departmentid = departmentid,
      shiftid = shiftid,
      startdate = startdate,
      enddate = enddate,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object EmployeedepartmenthistoryRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[EmployeedepartmenthistoryRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val departmentid = jsonObj.get("departmentid").toRight("Missing field 'departmentid'").flatMap(_.as(DepartmentId.jsonDecoder))
    val shiftid = jsonObj.get("shiftid").toRight("Missing field 'shiftid'").flatMap(_.as(ShiftId.jsonDecoder))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDate.jsonDecoder))
    val enddate = jsonObj.get("enddate").fold[Either[String, Option[TypoLocalDate]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDate.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (businessentityid.isRight && departmentid.isRight && shiftid.isRight && startdate.isRight && enddate.isRight && modifieddate.isRight)
      Right(EmployeedepartmenthistoryRowUnsaved(businessentityid = businessentityid.toOption.get, departmentid = departmentid.toOption.get, shiftid = shiftid.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, departmentid, shiftid, startdate, enddate, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[EmployeedepartmenthistoryRowUnsaved] = new JsonEncoder[EmployeedepartmenthistoryRowUnsaved] {
    override def unsafeEncode(a: EmployeedepartmenthistoryRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""departmentid":""")
      DepartmentId.jsonEncoder.unsafeEncode(a.departmentid, indent, out)
      out.write(",")
      out.write(""""shiftid":""")
      ShiftId.jsonEncoder.unsafeEncode(a.shiftid, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      TypoLocalDate.jsonEncoder.unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""enddate":""")
      JsonEncoder.option(using TypoLocalDate.jsonEncoder).unsafeEncode(a.enddate, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[EmployeedepartmenthistoryRowUnsaved] = Text.instance[EmployeedepartmenthistoryRowUnsaved]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    DepartmentId.text.unsafeEncode(row.departmentid, sb)
    sb.append(Text.DELIMETER)
    ShiftId.text.unsafeEncode(row.shiftid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDate.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDate.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
