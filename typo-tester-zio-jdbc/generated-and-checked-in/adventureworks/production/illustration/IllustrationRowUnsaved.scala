/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.illustration` which has not been persisted yet */
case class IllustrationRowUnsaved(
  /** Illustrations used in manufacturing instructions. Stored as XML. */
  diagram: Option[TypoXml],
  /** Default: nextval('production.illustration_illustrationid_seq'::regclass)
      Primary key for Illustration records. */
  illustrationid: Defaulted[IllustrationId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(illustrationidDefault: => IllustrationId, modifieddateDefault: => TypoLocalDateTime): IllustrationRow =
    IllustrationRow(
      diagram = diagram,
      illustrationid = illustrationid match {
                         case Defaulted.UseDefault => illustrationidDefault
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object IllustrationRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[IllustrationRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val diagram = jsonObj.get("diagram").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(TypoXml.jsonDecoder)))
    val illustrationid = jsonObj.get("illustrationid").toRight("Missing field 'illustrationid'").flatMap(_.as(Defaulted.jsonDecoder(IllustrationId.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (diagram.isRight && illustrationid.isRight && modifieddate.isRight)
      Right(IllustrationRowUnsaved(diagram = diagram.toOption.get, illustrationid = illustrationid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](diagram, illustrationid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[IllustrationRowUnsaved] = new JsonEncoder[IllustrationRowUnsaved] {
    override def unsafeEncode(a: IllustrationRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""diagram":""")
      JsonEncoder.option(TypoXml.jsonEncoder).unsafeEncode(a.diagram, indent, out)
      out.write(",")
      out.write(""""illustrationid":""")
      Defaulted.jsonEncoder(IllustrationId.jsonEncoder).unsafeEncode(a.illustrationid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
