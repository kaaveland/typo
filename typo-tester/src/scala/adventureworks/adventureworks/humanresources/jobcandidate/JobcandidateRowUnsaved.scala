/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `humanresources.jobcandidate` which has not been persisted yet */
case class JobcandidateRowUnsaved(
  businessentityid: Option[BusinessentityId],
  resume: Option[/* xml */ String],
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(jobcandidateid: JobcandidateId): JobcandidateRow =
    JobcandidateRow(
      jobcandidateid = jobcandidateid,
      businessentityid = businessentityid,
      resume = resume,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object JobcandidateRowUnsaved {
  implicit val oFormat: OFormat[JobcandidateRowUnsaved] = new OFormat[JobcandidateRowUnsaved]{
    override def writes(o: JobcandidateRowUnsaved): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "resume" -> o.resume,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[JobcandidateRowUnsaved] = {
      JsResult.fromTry(
        Try(
          JobcandidateRowUnsaved(
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            resume = json.\("resume").toOption.map(_.as[/* xml */ String]),
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}