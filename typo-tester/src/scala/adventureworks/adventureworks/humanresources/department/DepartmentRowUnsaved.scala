/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.Defaulted
import adventureworks.public.NameDomain
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class DepartmentRowUnsaved(
  name: NameDomain,
  groupname: NameDomain,
  modifieddate: Defaulted[LocalDateTime]
)
object DepartmentRowUnsaved {
  implicit val oFormat: OFormat[DepartmentRowUnsaved] = new OFormat[DepartmentRowUnsaved]{
    override def writes(o: DepartmentRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "groupname" -> o.groupname,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[DepartmentRowUnsaved] = {
      JsResult.fromTry(
        Try(
          DepartmentRowUnsaved(
            name = json.\("name").as[NameDomain],
            groupname = json.\("groupname").as[NameDomain],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}
