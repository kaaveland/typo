/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelinstructions

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
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

case class VproductmodelinstructionsViewRow(
  /** Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Points to [[productmodel.ProductmodelRow.name]] */
  name: Name,
  instructions: /* nullability unknown */ Option[String],
  LocationID: /* nullability unknown */ Option[Int],
  SetupHours: /* nullability unknown */ Option[BigDecimal],
  MachineHours: /* nullability unknown */ Option[BigDecimal],
  LaborHours: /* nullability unknown */ Option[BigDecimal],
  LotSize: /* nullability unknown */ Option[Int],
  Step: /* nullability unknown */ Option[/* max 1024 chars */ String],
  /** Points to [[productmodel.ProductmodelRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VproductmodelinstructionsViewRow {
  implicit lazy val reads: Reads[VproductmodelinstructionsViewRow] = Reads[VproductmodelinstructionsViewRow](json => JsResult.fromTry(
      Try(
        VproductmodelinstructionsViewRow(
          productmodelid = json.\("productmodelid").as(ProductmodelId.reads),
          name = json.\("name").as(Name.reads),
          instructions = json.\("instructions").toOption.map(_.as(Reads.StringReads)),
          LocationID = json.\("LocationID").toOption.map(_.as(Reads.IntReads)),
          SetupHours = json.\("SetupHours").toOption.map(_.as(Reads.bigDecReads)),
          MachineHours = json.\("MachineHours").toOption.map(_.as(Reads.bigDecReads)),
          LaborHours = json.\("LaborHours").toOption.map(_.as(Reads.bigDecReads)),
          LotSize = json.\("LotSize").toOption.map(_.as(Reads.IntReads)),
          Step = json.\("Step").toOption.map(_.as(Reads.StringReads)),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VproductmodelinstructionsViewRow] = RowParser[VproductmodelinstructionsViewRow] { row =>
    Success(
      VproductmodelinstructionsViewRow(
        productmodelid = row(idx + 0)(ProductmodelId.column),
        name = row(idx + 1)(Name.column),
        instructions = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        LocationID = row(idx + 3)(Column.columnToOption(Column.columnToInt)),
        SetupHours = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        MachineHours = row(idx + 5)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        LaborHours = row(idx + 6)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        LotSize = row(idx + 7)(Column.columnToOption(Column.columnToInt)),
        Step = row(idx + 8)(Column.columnToOption(Column.columnToString)),
        rowguid = row(idx + 9)(Column.columnToUUID),
        modifieddate = row(idx + 10)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[VproductmodelinstructionsViewRow] = OWrites[VproductmodelinstructionsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> ProductmodelId.writes.writes(o.productmodelid),
      "name" -> Name.writes.writes(o.name),
      "instructions" -> Writes.OptionWrites(Writes.StringWrites).writes(o.instructions),
      "LocationID" -> Writes.OptionWrites(Writes.IntWrites).writes(o.LocationID),
      "SetupHours" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.SetupHours),
      "MachineHours" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.MachineHours),
      "LaborHours" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.LaborHours),
      "LotSize" -> Writes.OptionWrites(Writes.IntWrites).writes(o.LotSize),
      "Step" -> Writes.OptionWrites(Writes.StringWrites).writes(o.Step),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
