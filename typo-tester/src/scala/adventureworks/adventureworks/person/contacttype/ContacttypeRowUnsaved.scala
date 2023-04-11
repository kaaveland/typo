/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import adventureworks.Defaulted
import adventureworks.public.Name
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `person.contacttype` which has not been persisted yet */
case class ContacttypeRowUnsaved(
  name: Name,
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(contacttypeid: ContacttypeId): ContacttypeRow =
    ContacttypeRow(
      contacttypeid = contacttypeid,
      name = name,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ContacttypeRowUnsaved {
  implicit val oFormat: OFormat[ContacttypeRowUnsaved] = new OFormat[ContacttypeRowUnsaved]{
    override def writes(o: ContacttypeRowUnsaved): JsObject =
      Json.obj(
        "name" -> o.name,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ContacttypeRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ContacttypeRowUnsaved(
            name = json.\("name").as[Name],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}