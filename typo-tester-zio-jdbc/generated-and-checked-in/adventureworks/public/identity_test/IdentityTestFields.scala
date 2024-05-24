/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait IdentityTestFields {
  def alwaysGenerated: Field[Int, IdentityTestRow]
  def defaultGenerated: Field[Int, IdentityTestRow]
  def name: IdField[IdentityTestId, IdentityTestRow]
}

object IdentityTestFields {
  lazy val structure: Relation[IdentityTestFields, IdentityTestRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[IdentityTestFields, IdentityTestRow] {
  
    override lazy val fields: IdentityTestFields = new IdentityTestFields {
      override def alwaysGenerated = Field[Int, IdentityTestRow](_path, "always_generated", None, Some("int4"), x => x.alwaysGenerated, (row, value) => row.copy(alwaysGenerated = value))
      override def defaultGenerated = Field[Int, IdentityTestRow](_path, "default_generated", None, Some("int4"), x => x.defaultGenerated, (row, value) => row.copy(defaultGenerated = value))
      override def name = IdField[IdentityTestId, IdentityTestRow](_path, "name", None, None, x => x.name, (row, value) => row.copy(name = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, IdentityTestRow]] =
      List[FieldLikeNoHkt[?, IdentityTestRow]](fields.alwaysGenerated, fields.defaultGenerated, fields.name)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
