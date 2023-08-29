/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class EViewRow(
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddressid]] */
  id: Int,
  /** Points to [[person.emailaddress.EmailaddressRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddressid]] */
  emailaddressid: Int,
  /** Points to [[person.emailaddress.EmailaddressRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[person.emailaddress.EmailaddressRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[person.emailaddress.EmailaddressRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object EViewRow {
  implicit lazy val reads: Reads[EViewRow] = Reads[EViewRow](json => JsResult.fromTry(
      Try(
        EViewRow(
          id = json.\("id").as(Reads.IntReads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          emailaddressid = json.\("emailaddressid").as(Reads.IntReads),
          emailaddress = json.\("emailaddress").toOption.map(_.as(Reads.StringReads)),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[EViewRow] = RowParser[EViewRow] { row =>
    Success(
      EViewRow(
        id = row(idx + 0)(Column.columnToInt),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        emailaddressid = row(idx + 2)(Column.columnToInt),
        emailaddress = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        rowguid = row(idx + 4)(Column.columnToUUID),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[EViewRow] = OWrites[EViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.IntWrites.writes(o.id),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "emailaddressid" -> Writes.IntWrites.writes(o.emailaddressid),
      "emailaddress" -> Writes.OptionWrites(Writes.StringWrites).writes(o.emailaddress),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
