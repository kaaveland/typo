/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package l

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait LViewFields {
  def id: Field[LocationId, LViewRow]
  def locationid: Field[LocationId, LViewRow]
  def name: Field[Name, LViewRow]
  def costrate: Field[BigDecimal, LViewRow]
  def availability: Field[BigDecimal, LViewRow]
  def modifieddate: Field[TypoLocalDateTime, LViewRow]
}

object LViewFields {
  lazy val structure: Relation[LViewFields, LViewRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[LViewFields, LViewRow] {
  
    override lazy val fields: LViewFields = new LViewFields {
      override def id = Field[LocationId, LViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def locationid = Field[LocationId, LViewRow](_path, "locationid", None, None, x => x.locationid, (row, value) => row.copy(locationid = value))
      override def name = Field[Name, LViewRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
      override def costrate = Field[BigDecimal, LViewRow](_path, "costrate", None, None, x => x.costrate, (row, value) => row.copy(costrate = value))
      override def availability = Field[BigDecimal, LViewRow](_path, "availability", None, None, x => x.availability, (row, value) => row.copy(availability = value))
      override def modifieddate = Field[TypoLocalDateTime, LViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, LViewRow]] =
      List[FieldLikeNoHkt[?, LViewRow]](fields.id, fields.locationid, fields.name, fields.costrate, fields.availability, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
