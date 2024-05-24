/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.countryregion.CountryregionFields
import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.countryregion.CountryregionRow
import adventureworks.public.Name
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait SalesterritoryFields {
  def territoryid: IdField[SalesterritoryId, SalesterritoryRow]
  def name: Field[Name, SalesterritoryRow]
  def countryregioncode: Field[CountryregionId, SalesterritoryRow]
  def group: Field[/* max 50 chars */ String, SalesterritoryRow]
  def salesytd: Field[BigDecimal, SalesterritoryRow]
  def saleslastyear: Field[BigDecimal, SalesterritoryRow]
  def costytd: Field[BigDecimal, SalesterritoryRow]
  def costlastyear: Field[BigDecimal, SalesterritoryRow]
  def rowguid: Field[TypoUUID, SalesterritoryRow]
  def modifieddate: Field[TypoLocalDateTime, SalesterritoryRow]
  def fkPersonCountryregion: ForeignKey[CountryregionFields, CountryregionRow] =
    ForeignKey[CountryregionFields, CountryregionRow]("sales.FK_SalesTerritory_CountryRegion_CountryRegionCode", Nil)
      .withColumnPair(countryregioncode, _.countryregioncode)
}

object SalesterritoryFields {
  lazy val structure: Relation[SalesterritoryFields, SalesterritoryRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[SalesterritoryFields, SalesterritoryRow] {
  
    override lazy val fields: SalesterritoryFields = new SalesterritoryFields {
      override def territoryid = IdField[SalesterritoryId, SalesterritoryRow](_path, "territoryid", None, Some("int4"), x => x.territoryid, (row, value) => row.copy(territoryid = value))
      override def name = Field[Name, SalesterritoryRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def countryregioncode = Field[CountryregionId, SalesterritoryRow](_path, "countryregioncode", None, None, x => x.countryregioncode, (row, value) => row.copy(countryregioncode = value))
      override def group = Field[/* max 50 chars */ String, SalesterritoryRow](_path, "group", None, None, x => x.group, (row, value) => row.copy(group = value))
      override def salesytd = Field[BigDecimal, SalesterritoryRow](_path, "salesytd", None, Some("numeric"), x => x.salesytd, (row, value) => row.copy(salesytd = value))
      override def saleslastyear = Field[BigDecimal, SalesterritoryRow](_path, "saleslastyear", None, Some("numeric"), x => x.saleslastyear, (row, value) => row.copy(saleslastyear = value))
      override def costytd = Field[BigDecimal, SalesterritoryRow](_path, "costytd", None, Some("numeric"), x => x.costytd, (row, value) => row.copy(costytd = value))
      override def costlastyear = Field[BigDecimal, SalesterritoryRow](_path, "costlastyear", None, Some("numeric"), x => x.costlastyear, (row, value) => row.copy(costlastyear = value))
      override def rowguid = Field[TypoUUID, SalesterritoryRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, SalesterritoryRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, SalesterritoryRow]] =
      List[FieldLikeNoHkt[?, SalesterritoryRow]](fields.territoryid, fields.name, fields.countryregioncode, fields.group, fields.salesytd, fields.saleslastyear, fields.costytd, fields.costlastyear, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
