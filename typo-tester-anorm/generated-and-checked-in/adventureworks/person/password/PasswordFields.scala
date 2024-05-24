/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.person.PersonFields
import adventureworks.person.person.PersonRow
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait PasswordFields {
  def businessentityid: IdField[BusinessentityId, PasswordRow]
  def passwordhash: Field[/* max 128 chars */ String, PasswordRow]
  def passwordsalt: Field[/* max 10 chars */ String, PasswordRow]
  def rowguid: Field[TypoUUID, PasswordRow]
  def modifieddate: Field[TypoLocalDateTime, PasswordRow]
  def fkPerson: ForeignKey[PersonFields, PersonRow] =
    ForeignKey[PersonFields, PersonRow]("person.FK_Password_Person_BusinessEntityID", Nil)
      .withColumnPair(businessentityid, _.businessentityid)
}

object PasswordFields {
  lazy val structure: Relation[PasswordFields, PasswordRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[PasswordFields, PasswordRow] {
  
    override lazy val fields: PasswordFields = new PasswordFields {
      override def businessentityid = IdField[BusinessentityId, PasswordRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def passwordhash = Field[/* max 128 chars */ String, PasswordRow](_path, "passwordhash", None, None, x => x.passwordhash, (row, value) => row.copy(passwordhash = value))
      override def passwordsalt = Field[/* max 10 chars */ String, PasswordRow](_path, "passwordsalt", None, None, x => x.passwordsalt, (row, value) => row.copy(passwordsalt = value))
      override def rowguid = Field[TypoUUID, PasswordRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, PasswordRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PasswordRow]] =
      List[FieldLikeNoHkt[?, PasswordRow]](fields.businessentityid, fields.passwordhash, fields.passwordsalt, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
