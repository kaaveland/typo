/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmi

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait PmiViewFields {
  def productmodelid: Field[ProductmodelId, PmiViewRow]
  def illustrationid: Field[IllustrationId, PmiViewRow]
  def modifieddate: Field[TypoLocalDateTime, PmiViewRow]
}

object PmiViewFields {
  lazy val structure: Relation[PmiViewFields, PmiViewRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[PmiViewFields, PmiViewRow] {
  
    override lazy val fields: PmiViewFields = new PmiViewFields {
      override def productmodelid = Field[ProductmodelId, PmiViewRow](_path, "productmodelid", None, None, x => x.productmodelid, (row, value) => row.copy(productmodelid = value))
      override def illustrationid = Field[IllustrationId, PmiViewRow](_path, "illustrationid", None, None, x => x.illustrationid, (row, value) => row.copy(illustrationid = value))
      override def modifieddate = Field[TypoLocalDateTime, PmiViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PmiViewRow]] =
      List[FieldLikeNoHkt[?, PmiViewRow]](fields.productmodelid, fields.illustrationid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
