/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelinstructions

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VproductmodelinstructionsViewFields[Row] {
  val productmodelid: Field[ProductmodelId, Row]
  val name: Field[Name, Row]
  val instructions: OptField[String, Row]
  val LocationID: OptField[Int, Row]
  val SetupHours: OptField[BigDecimal, Row]
  val MachineHours: OptField[BigDecimal, Row]
  val LaborHours: OptField[BigDecimal, Row]
  val LotSize: OptField[Int, Row]
  val Step: OptField[/* max 1024 chars */ String, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object VproductmodelinstructionsViewFields {
  val structure: Relation[VproductmodelinstructionsViewFields, VproductmodelinstructionsViewRow, VproductmodelinstructionsViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => VproductmodelinstructionsViewRow, val merge: (Row, VproductmodelinstructionsViewRow) => Row)
    extends Relation[VproductmodelinstructionsViewFields, VproductmodelinstructionsViewRow, Row] { 
  
    override val fields: VproductmodelinstructionsViewFields[Row] = new VproductmodelinstructionsViewFields[Row] {
      override val productmodelid = new Field[ProductmodelId, Row](prefix, "productmodelid", None, None)(x => extract(x).productmodelid, (row, value) => merge(row, extract(row).copy(productmodelid = value)))
      override val name = new Field[Name, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
      override val instructions = new OptField[String, Row](prefix, "instructions", None, None)(x => extract(x).instructions, (row, value) => merge(row, extract(row).copy(instructions = value)))
      override val LocationID = new OptField[Int, Row](prefix, "LocationID", None, None)(x => extract(x).LocationID, (row, value) => merge(row, extract(row).copy(LocationID = value)))
      override val SetupHours = new OptField[BigDecimal, Row](prefix, "SetupHours", None, None)(x => extract(x).SetupHours, (row, value) => merge(row, extract(row).copy(SetupHours = value)))
      override val MachineHours = new OptField[BigDecimal, Row](prefix, "MachineHours", None, None)(x => extract(x).MachineHours, (row, value) => merge(row, extract(row).copy(MachineHours = value)))
      override val LaborHours = new OptField[BigDecimal, Row](prefix, "LaborHours", None, None)(x => extract(x).LaborHours, (row, value) => merge(row, extract(row).copy(LaborHours = value)))
      override val LotSize = new OptField[Int, Row](prefix, "LotSize", None, None)(x => extract(x).LotSize, (row, value) => merge(row, extract(row).copy(LotSize = value)))
      override val Step = new OptField[/* max 1024 chars */ String, Row](prefix, "Step", None, None)(x => extract(x).Step, (row, value) => merge(row, extract(row).copy(Step = value)))
      override val rowguid = new Field[TypoUUID, Row](prefix, "rowguid", None, None)(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.productmodelid, fields.name, fields.instructions, fields.LocationID, fields.SetupHours, fields.MachineHours, fields.LaborHours, fields.LotSize, fields.Step, fields.rowguid, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => VproductmodelinstructionsViewRow, merge: (NewRow, VproductmodelinstructionsViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
