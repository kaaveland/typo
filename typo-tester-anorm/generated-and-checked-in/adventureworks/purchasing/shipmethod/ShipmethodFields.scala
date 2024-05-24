/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ShipmethodFields {
  def shipmethodid: IdField[ShipmethodId, ShipmethodRow]
  def name: Field[Name, ShipmethodRow]
  def shipbase: Field[BigDecimal, ShipmethodRow]
  def shiprate: Field[BigDecimal, ShipmethodRow]
  def rowguid: Field[TypoUUID, ShipmethodRow]
  def modifieddate: Field[TypoLocalDateTime, ShipmethodRow]
}

object ShipmethodFields {
  lazy val structure: Relation[ShipmethodFields, ShipmethodRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[ShipmethodFields, ShipmethodRow] {
  
    override lazy val fields: ShipmethodFields = new ShipmethodFields {
      override def shipmethodid = IdField[ShipmethodId, ShipmethodRow](_path, "shipmethodid", None, Some("int4"), x => x.shipmethodid, (row, value) => row.copy(shipmethodid = value))
      override def name = Field[Name, ShipmethodRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def shipbase = Field[BigDecimal, ShipmethodRow](_path, "shipbase", None, Some("numeric"), x => x.shipbase, (row, value) => row.copy(shipbase = value))
      override def shiprate = Field[BigDecimal, ShipmethodRow](_path, "shiprate", None, Some("numeric"), x => x.shiprate, (row, value) => row.copy(shiprate = value))
      override def rowguid = Field[TypoUUID, ShipmethodRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, ShipmethodRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ShipmethodRow]] =
      List[FieldLikeNoHkt[?, ShipmethodRow]](fields.shipmethodid, fields.name, fields.shipbase, fields.shiprate, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
