/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

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

case class BeViewRow(
  /** Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.businessentity.BusinessentityRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[person.businessentity.BusinessentityRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object BeViewRow {
  implicit lazy val reads: Reads[BeViewRow] = Reads[BeViewRow](json => JsResult.fromTry(
      Try(
        BeViewRow(
          id = json.\("id").as(BusinessentityId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BeViewRow] = RowParser[BeViewRow] { row =>
    Success(
      BeViewRow(
        id = row(idx + 0)(BusinessentityId.column),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        rowguid = row(idx + 2)(Column.columnToUUID),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[BeViewRow] = OWrites[BeViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> BusinessentityId.writes.writes(o.id),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
