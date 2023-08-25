/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package c

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
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

case class CViewRow(
  id: Int,
  /** Points to [[sales.customer.CustomerRow.customerid]] */
  customerid: CustomerId,
  /** Points to [[sales.customer.CustomerRow.personid]] */
  personid: BusinessentityId,
  /** Points to [[sales.customer.CustomerRow.storeid]] */
  storeid: BusinessentityId,
  /** Points to [[sales.customer.CustomerRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Points to [[sales.customer.CustomerRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[sales.customer.CustomerRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object CViewRow {
  implicit lazy val reads: Reads[CViewRow] = Reads[CViewRow](json => JsResult.fromTry(
      Try(
        CViewRow(
          id = json.\("id").as(Reads.IntReads),
          customerid = json.\("customerid").as(CustomerId.reads),
          personid = json.\("personid").as(BusinessentityId.reads),
          storeid = json.\("storeid").as(BusinessentityId.reads),
          territoryid = json.\("territoryid").as(SalesterritoryId.reads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CViewRow] = RowParser[CViewRow] { row =>
    Success(
      CViewRow(
        id = row(idx + 0)(Column.columnToInt),
        customerid = row(idx + 1)(CustomerId.column),
        personid = row(idx + 2)(BusinessentityId.column),
        storeid = row(idx + 3)(BusinessentityId.column),
        territoryid = row(idx + 4)(SalesterritoryId.column),
        rowguid = row(idx + 5)(Column.columnToUUID),
        modifieddate = row(idx + 6)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[CViewRow] = OWrites[CViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.IntWrites.writes(o.id),
      "customerid" -> CustomerId.writes.writes(o.customerid),
      "personid" -> BusinessentityId.writes.writes(o.personid),
      "storeid" -> BusinessentityId.writes.writes(o.storeid),
      "territoryid" -> SalesterritoryId.writes.writes(o.territoryid),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
