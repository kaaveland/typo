/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package ct

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.contacttype.ContacttypeId
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

case class CtViewRow(
  /** Points to [[person.contacttype.ContacttypeRow.contacttypeid]] */
  id: ContacttypeId,
  /** Points to [[person.contacttype.ContacttypeRow.contacttypeid]] */
  contacttypeid: ContacttypeId,
  /** Points to [[person.contacttype.ContacttypeRow.name]] */
  name: Name,
  /** Points to [[person.contacttype.ContacttypeRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object CtViewRow {
  implicit lazy val reads: Reads[CtViewRow] = Reads[CtViewRow](json => JsResult.fromTry(
      Try(
        CtViewRow(
          id = json.\("id").as(ContacttypeId.reads),
          contacttypeid = json.\("contacttypeid").as(ContacttypeId.reads),
          name = json.\("name").as(Name.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CtViewRow] = RowParser[CtViewRow] { row =>
    Success(
      CtViewRow(
        id = row(idx + 0)(ContacttypeId.column),
        contacttypeid = row(idx + 1)(ContacttypeId.column),
        name = row(idx + 2)(Name.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[CtViewRow] = OWrites[CtViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> ContacttypeId.writes.writes(o.id),
      "contacttypeid" -> ContacttypeId.writes.writes(o.contacttypeid),
      "name" -> Name.writes.writes(o.name),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
