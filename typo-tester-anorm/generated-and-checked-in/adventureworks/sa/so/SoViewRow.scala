/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package so

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.sales.specialoffer.SpecialofferId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** View: sa.so */
case class SoViewRow(
  /** Points to [[sales.specialoffer.SpecialofferRow.specialofferid]] */
  id: SpecialofferId,
  /** Points to [[sales.specialoffer.SpecialofferRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Points to [[sales.specialoffer.SpecialofferRow.description]] */
  description: /* max 255 chars */ String,
  /** Points to [[sales.specialoffer.SpecialofferRow.discountpct]] */
  discountpct: BigDecimal,
  /** Points to [[sales.specialoffer.SpecialofferRow.type]] */
  `type`: /* max 50 chars */ String,
  /** Points to [[sales.specialoffer.SpecialofferRow.category]] */
  category: /* max 50 chars */ String,
  /** Points to [[sales.specialoffer.SpecialofferRow.startdate]] */
  startdate: TypoLocalDateTime,
  /** Points to [[sales.specialoffer.SpecialofferRow.enddate]] */
  enddate: TypoLocalDateTime,
  /** Points to [[sales.specialoffer.SpecialofferRow.minqty]] */
  minqty: Int,
  /** Points to [[sales.specialoffer.SpecialofferRow.maxqty]] */
  maxqty: Option[Int],
  /** Points to [[sales.specialoffer.SpecialofferRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[sales.specialoffer.SpecialofferRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SoViewRow {
  implicit lazy val reads: Reads[SoViewRow] = Reads[SoViewRow](json => JsResult.fromTry(
      Try(
        SoViewRow(
          id = json.\("id").as(SpecialofferId.reads),
          specialofferid = json.\("specialofferid").as(SpecialofferId.reads),
          description = json.\("description").as(Reads.StringReads),
          discountpct = json.\("discountpct").as(Reads.bigDecReads),
          `type` = json.\("type").as(Reads.StringReads),
          category = json.\("category").as(Reads.StringReads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").as(TypoLocalDateTime.reads),
          minqty = json.\("minqty").as(Reads.IntReads),
          maxqty = json.\("maxqty").toOption.map(_.as(Reads.IntReads)),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SoViewRow] = RowParser[SoViewRow] { row =>
    Success(
      SoViewRow(
        id = row(idx + 0)(SpecialofferId.column),
        specialofferid = row(idx + 1)(SpecialofferId.column),
        description = row(idx + 2)(Column.columnToString),
        discountpct = row(idx + 3)(Column.columnToScalaBigDecimal),
        `type` = row(idx + 4)(Column.columnToString),
        category = row(idx + 5)(Column.columnToString),
        startdate = row(idx + 6)(TypoLocalDateTime.column),
        enddate = row(idx + 7)(TypoLocalDateTime.column),
        minqty = row(idx + 8)(Column.columnToInt),
        maxqty = row(idx + 9)(Column.columnToOption(Column.columnToInt)),
        rowguid = row(idx + 10)(TypoUUID.column),
        modifieddate = row(idx + 11)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[SoViewRow] = OWrites[SoViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> SpecialofferId.writes.writes(o.id),
      "specialofferid" -> SpecialofferId.writes.writes(o.specialofferid),
      "description" -> Writes.StringWrites.writes(o.description),
      "discountpct" -> Writes.BigDecimalWrites.writes(o.discountpct),
      "type" -> Writes.StringWrites.writes(o.`type`),
      "category" -> Writes.StringWrites.writes(o.category),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> TypoLocalDateTime.writes.writes(o.enddate),
      "minqty" -> Writes.IntWrites.writes(o.minqty),
      "maxqty" -> Writes.OptionWrites(Writes.IntWrites).writes(o.maxqty),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
