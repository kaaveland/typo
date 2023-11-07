/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoUnknownCitext
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `public.users` which has not been persisted yet */
case class UsersRowUnsaved(
  userId: UsersId,
  name: String,
  lastName: Option[String],
  email: TypoUnknownCitext,
  password: String,
  verifiedOn: Option[TypoInstant],
  /** Default: now() */
  createdAt: Defaulted[TypoInstant] = Defaulted.UseDefault
) {
  def toRow(createdAtDefault: => TypoInstant): UsersRow =
    UsersRow(
      userId = userId,
      name = name,
      lastName = lastName,
      email = email,
      password = password,
      verifiedOn = verifiedOn,
      createdAt = createdAt match {
                    case Defaulted.UseDefault => createdAtDefault
                    case Defaulted.Provided(value) => value
                  }
    )
}
object UsersRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[UsersRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val userId = jsonObj.get("user_id").toRight("Missing field 'user_id'").flatMap(_.as(UsersId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(JsonDecoder.string))
    val lastName = jsonObj.get("last_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val email = jsonObj.get("email").toRight("Missing field 'email'").flatMap(_.as(TypoUnknownCitext.jsonDecoder))
    val password = jsonObj.get("password").toRight("Missing field 'password'").flatMap(_.as(JsonDecoder.string))
    val verifiedOn = jsonObj.get("verified_on").fold[Either[String, Option[TypoInstant]]](Right(None))(_.as(JsonDecoder.option(TypoInstant.jsonDecoder)))
    val createdAt = jsonObj.get("created_at").toRight("Missing field 'created_at'").flatMap(_.as(Defaulted.jsonDecoder(TypoInstant.jsonDecoder)))
    if (userId.isRight && name.isRight && lastName.isRight && email.isRight && password.isRight && verifiedOn.isRight && createdAt.isRight)
      Right(UsersRowUnsaved(userId = userId.toOption.get, name = name.toOption.get, lastName = lastName.toOption.get, email = email.toOption.get, password = password.toOption.get, verifiedOn = verifiedOn.toOption.get, createdAt = createdAt.toOption.get))
    else Left(List[Either[String, Any]](userId, name, lastName, email, password, verifiedOn, createdAt).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[UsersRowUnsaved] = new JsonEncoder[UsersRowUnsaved] {
    override def unsafeEncode(a: UsersRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""user_id":""")
      UsersId.jsonEncoder.unsafeEncode(a.userId, indent, out)
      out.write(",")
      out.write(""""name":""")
      JsonEncoder.string.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""last_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.lastName, indent, out)
      out.write(",")
      out.write(""""email":""")
      TypoUnknownCitext.jsonEncoder.unsafeEncode(a.email, indent, out)
      out.write(",")
      out.write(""""password":""")
      JsonEncoder.string.unsafeEncode(a.password, indent, out)
      out.write(",")
      out.write(""""verified_on":""")
      JsonEncoder.option(TypoInstant.jsonEncoder).unsafeEncode(a.verifiedOn, indent, out)
      out.write(",")
      out.write(""""created_at":""")
      Defaulted.jsonEncoder(TypoInstant.jsonEncoder).unsafeEncode(a.createdAt, indent, out)
      out.write("}")
    }
  }
}
