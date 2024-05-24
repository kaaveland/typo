/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ScrapreasonFields {
  def scrapreasonid: IdField[ScrapreasonId, ScrapreasonRow]
  def name: Field[Name, ScrapreasonRow]
  def modifieddate: Field[TypoLocalDateTime, ScrapreasonRow]
}

object ScrapreasonFields {
  lazy val structure: Relation[ScrapreasonFields, ScrapreasonRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[ScrapreasonFields, ScrapreasonRow] {
  
    override lazy val fields: ScrapreasonFields = new ScrapreasonFields {
      override def scrapreasonid = IdField[ScrapreasonId, ScrapreasonRow](_path, "scrapreasonid", None, Some("int4"), x => x.scrapreasonid, (row, value) => row.copy(scrapreasonid = value))
      override def name = Field[Name, ScrapreasonRow](_path, "name", None, Some("varchar"), x => x.name, (row, value) => row.copy(name = value))
      override def modifieddate = Field[TypoLocalDateTime, ScrapreasonRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ScrapreasonRow]] =
      List[FieldLikeNoHkt[?, ScrapreasonRow]](fields.scrapreasonid, fields.name, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
