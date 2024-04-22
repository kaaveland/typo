/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package edh

import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** View: hr.edh */
case class EdhViewRow(
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.departmentid]] */
  departmentid: DepartmentId,
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.shiftid]] */
  shiftid: ShiftId,
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]] */
  startdate: TypoLocalDate,
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.enddate]] */
  enddate: Option[TypoLocalDate],
  /** Points to [[humanresources.employeedepartmenthistory.EmployeedepartmenthistoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object EdhViewRow {
  implicit lazy val reads: Reads[EdhViewRow] = Reads[EdhViewRow](json => JsResult.fromTry(
      Try(
        EdhViewRow(
          id = json.\("id").as(BusinessentityId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          departmentid = json.\("departmentid").as(DepartmentId.reads),
          shiftid = json.\("shiftid").as(ShiftId.reads),
          startdate = json.\("startdate").as(TypoLocalDate.reads),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDate.reads)),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EdhViewRow] = RowParser[EdhViewRow] { row =>
    Success(
      EdhViewRow(
        id = row(idx + 0)(BusinessentityId.column),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        departmentid = row(idx + 2)(DepartmentId.column),
        shiftid = row(idx + 3)(ShiftId.column),
        startdate = row(idx + 4)(TypoLocalDate.column),
        enddate = row(idx + 5)(Column.columnToOption(TypoLocalDate.column)),
        modifieddate = row(idx + 6)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[EdhViewRow] = OWrites[EdhViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> BusinessentityId.writes.writes(o.id),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "departmentid" -> DepartmentId.writes.writes(o.departmentid),
      "shiftid" -> ShiftId.writes.writes(o.shiftid),
      "startdate" -> TypoLocalDate.writes.writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDate.writes).writes(o.enddate),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
