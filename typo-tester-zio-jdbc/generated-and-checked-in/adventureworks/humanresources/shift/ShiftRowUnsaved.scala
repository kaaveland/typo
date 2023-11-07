/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoLocalTime
import adventureworks.public.Name
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `humanresources.shift` which has not been persisted yet */
case class ShiftRowUnsaved(
  /** Shift description. */
  name: Name,
  /** Shift start time. */
  starttime: TypoLocalTime,
  /** Shift end time. */
  endtime: TypoLocalTime,
  /** Default: nextval('humanresources.shift_shiftid_seq'::regclass)
      Primary key for Shift records. */
  shiftid: Defaulted[ShiftId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(shiftidDefault: => ShiftId, modifieddateDefault: => TypoLocalDateTime): ShiftRow =
    ShiftRow(
      name = name,
      starttime = starttime,
      endtime = endtime,
      shiftid = shiftid match {
                  case Defaulted.UseDefault => shiftidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ShiftRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ShiftRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val starttime = jsonObj.get("starttime").toRight("Missing field 'starttime'").flatMap(_.as(TypoLocalTime.jsonDecoder))
    val endtime = jsonObj.get("endtime").toRight("Missing field 'endtime'").flatMap(_.as(TypoLocalTime.jsonDecoder))
    val shiftid = jsonObj.get("shiftid").toRight("Missing field 'shiftid'").flatMap(_.as(Defaulted.jsonDecoder(ShiftId.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (name.isRight && starttime.isRight && endtime.isRight && shiftid.isRight && modifieddate.isRight)
      Right(ShiftRowUnsaved(name = name.toOption.get, starttime = starttime.toOption.get, endtime = endtime.toOption.get, shiftid = shiftid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](name, starttime, endtime, shiftid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ShiftRowUnsaved] = new JsonEncoder[ShiftRowUnsaved] {
    override def unsafeEncode(a: ShiftRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""starttime":""")
      TypoLocalTime.jsonEncoder.unsafeEncode(a.starttime, indent, out)
      out.write(",")
      out.write(""""endtime":""")
      TypoLocalTime.jsonEncoder.unsafeEncode(a.endtime, indent, out)
      out.write(",")
      out.write(""""shiftid":""")
      Defaulted.jsonEncoder(ShiftId.jsonEncoder).unsafeEncode(a.shiftid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
