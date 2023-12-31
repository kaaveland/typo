/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class CultureRow(
  /** Primary key for Culture records. */
  cultureid: CultureId,
  /** Culture description. */
  name: Name,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object CultureRow {
  implicit lazy val reads: Reads[CultureRow] = Reads[CultureRow](json => JsResult.fromTry(
      Try(
        CultureRow(
          cultureid = json.\("cultureid").as(CultureId.reads),
          name = json.\("name").as(Name.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CultureRow] = RowParser[CultureRow] { row =>
    Success(
      CultureRow(
        cultureid = row(idx + 0)(CultureId.column),
        name = row(idx + 1)(Name.column),
        modifieddate = row(idx + 2)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[CultureRow] = Text.instance[CultureRow]{ (row, sb) =>
    CultureId.text.unsafeEncode(row.cultureid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[CultureRow] = OWrites[CultureRow](o =>
    new JsObject(ListMap[String, JsValue](
      "cultureid" -> CultureId.writes.writes(o.cultureid),
      "name" -> Name.writes.writes(o.name),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
