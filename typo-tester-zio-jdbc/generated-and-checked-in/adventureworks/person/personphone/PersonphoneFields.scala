/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.person.PersonFields
import adventureworks.person.person.PersonRow
import adventureworks.person.phonenumbertype.PhonenumbertypeFields
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.person.phonenumbertype.PhonenumbertypeRow
import adventureworks.public.Phone
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait PersonphoneFields {
  def businessentityid: IdField[BusinessentityId, PersonphoneRow]
  def phonenumber: IdField[Phone, PersonphoneRow]
  def phonenumbertypeid: IdField[PhonenumbertypeId, PersonphoneRow]
  def modifieddate: Field[TypoLocalDateTime, PersonphoneRow]
  def fkPerson: ForeignKey[PersonFields, PersonRow] =
    ForeignKey[PersonFields, PersonRow]("person.FK_PersonPhone_Person_BusinessEntityID", Nil)
      .withColumnPair(businessentityid, _.businessentityid)
  def fkPhonenumbertype: ForeignKey[PhonenumbertypeFields, PhonenumbertypeRow] =
    ForeignKey[PhonenumbertypeFields, PhonenumbertypeRow]("person.FK_PersonPhone_PhoneNumberType_PhoneNumberTypeID", Nil)
      .withColumnPair(phonenumbertypeid, _.phonenumbertypeid)
}

object PersonphoneFields {
  lazy val structure: Relation[PersonphoneFields, PersonphoneRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[PersonphoneFields, PersonphoneRow] {
  
    override lazy val fields: PersonphoneFields = new PersonphoneFields {
      override def businessentityid = IdField[BusinessentityId, PersonphoneRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def phonenumber = IdField[Phone, PersonphoneRow](_path, "phonenumber", None, Some("varchar"), x => x.phonenumber, (row, value) => row.copy(phonenumber = value))
      override def phonenumbertypeid = IdField[PhonenumbertypeId, PersonphoneRow](_path, "phonenumbertypeid", None, Some("int4"), x => x.phonenumbertypeid, (row, value) => row.copy(phonenumbertypeid = value))
      override def modifieddate = Field[TypoLocalDateTime, PersonphoneRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PersonphoneRow]] =
      List[FieldLikeNoHkt[?, PersonphoneRow]](fields.businessentityid, fields.phonenumber, fields.phonenumbertypeid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
