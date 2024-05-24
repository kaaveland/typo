/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait SalestaxrateFields {
  def salestaxrateid: IdField[SalestaxrateId, SalestaxrateRow]
  def stateprovinceid: Field[StateprovinceId, SalestaxrateRow]
  def taxtype: Field[TypoShort, SalestaxrateRow]
  def taxrate: Field[BigDecimal, SalestaxrateRow]
  def name: Field[Name, SalestaxrateRow]
  def rowguid: Field[TypoUUID, SalestaxrateRow]
  def modifieddate: Field[TypoLocalDateTime, SalestaxrateRow]
}

object SalestaxrateFields {
  lazy val structure: Relation[SalestaxrateFields, SalestaxrateRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[SalestaxrateFields, SalestaxrateRow] {
  
    override lazy val fields: SalestaxrateFields = new SalestaxrateFields {
      override def salestaxrateid = IdField[SalestaxrateId, SalestaxrateRow](_path, "salestaxrateid", None, Some("int4"), x => x.salestaxrateid, (row, value) => row.copy(salestaxrateid = value))
      override def stateprovinceid = Field[StateprovinceId, SalestaxrateRow](_path, "stateprovinceid", None, Some("int4"), x => x.stateprovinceid, (row, value) => row.copy(stateprovinceid = value))
      override def taxtype = Field[TypoShort, SalestaxrateRow](_path, "taxtype", None, Some("int2"), x => x.taxtype, (row, value) => row.copy(taxtype = value))
      override def taxrate = Field[BigDecimal, SalestaxrateRow](_path, "taxrate", None, Some("numeric"), x => x.taxrate, (row, value) => row.copy(taxrate = value))
      override def name = Field[Name, SalestaxrateRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def rowguid = Field[TypoUUID, SalestaxrateRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, SalestaxrateRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, SalestaxrateRow]] =
      List[FieldLikeNoHkt[?, SalestaxrateRow]](fields.salestaxrateid, fields.stateprovinceid, fields.taxtype, fields.taxrate, fields.name, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
