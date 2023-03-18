package testdb
package hardcoded

import play.api.libs.json.JsError
import play.api.libs.json.JsObject
import play.api.libs.json.JsString
import play.api.libs.json.JsSuccess
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import testdb.hardcoded.Defaulted.Provided
import testdb.hardcoded.Defaulted.UseDefault


/**
 * This signals a value where if you don't provide it, postgres will generate it for you
 */
sealed trait Defaulted[+T]

object Defaulted {
  case class Provided[T](value: T) extends Defaulted[T]
  case object UseDefault extends Defaulted[Nothing]
  implicit def reads[T: Reads]: Reads[Defaulted[T]] = {
    case JsString("defaulted") =>
      JsSuccess(UseDefault)
    case JsObject(Seq(("provided", providedJson: JsValue))) =>
      Json.fromJson[T](providedJson).map(Provided.apply)
    case _ =>
      JsError(s"Expected `Defaulted` json object structure")
  }

  implicit def writes[T: play.api.libs.json.Writes]: Writes[Defaulted[T]] = {
    case Provided(value) => Json.obj("provided" -> implicitly[Writes[T]].writes(value))
    case UseDefault      => JsString("defaulted")
  }

}