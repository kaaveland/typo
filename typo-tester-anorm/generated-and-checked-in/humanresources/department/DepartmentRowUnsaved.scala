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
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `humanresources.department` which has not been persisted yet */
case class DepartmentRowUnsaved(
  /** Name of the department. */
  name: Name,
  /** Name of the group to which the department belongs. */
  groupname: Name,
  /** Default: nextval('humanresources.department_departmentid_seq'::regclass)
      Primary key for Department records. */
  departmentid: Defaulted[DepartmentId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(departmentidDefault: => DepartmentId, modifieddateDefault: => LocalDateTime): DepartmentRow =
    DepartmentRow(
      name = name,
      groupname = groupname,
      departmentid = departmentid match {
                       case Defaulted.UseDefault => departmentidDefault
                       case Defaulted.Provided(value) => value
                     },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object DepartmentRowUnsaved {
  implicit val oFormat: OFormat[DepartmentRowUnsaved] = new OFormat[DepartmentRowUnsaved]{
    override def writes(o: DepartmentRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "groupname" -> o.groupname,
        "departmentid" -> o.departmentid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[DepartmentRowUnsaved] = {
      JsResult.fromTry(
        Try(
          DepartmentRowUnsaved(
            name = json.\("name").as[Name],
            groupname = json.\("groupname").as[Name],
            departmentid = json.\("departmentid").as[Defaulted[DepartmentId]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}