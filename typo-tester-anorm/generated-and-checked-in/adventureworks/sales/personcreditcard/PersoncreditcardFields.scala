/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.person.PersonFields
import adventureworks.person.person.PersonRow
import adventureworks.sales.creditcard.CreditcardFields
import adventureworks.sales.creditcard.CreditcardRow
import adventureworks.userdefined.CustomCreditcardId
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.Required
import typo.dsl.SqlExpr
import typo.dsl.SqlExpr.CompositeIn
import typo.dsl.SqlExpr.CompositeIn.TuplePart
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait PersoncreditcardFields {
  def businessentityid: IdField[BusinessentityId, PersoncreditcardRow]
  def creditcardid: IdField[/* user-picked */ CustomCreditcardId, PersoncreditcardRow]
  def modifieddate: Field[TypoLocalDateTime, PersoncreditcardRow]
  def fkPersonPerson: ForeignKey[PersonFields, PersonRow] =
    ForeignKey[PersonFields, PersonRow]("sales.FK_PersonCreditCard_Person_BusinessEntityID", Nil)
      .withColumnPair(businessentityid, _.businessentityid)
  def fkCreditcard: ForeignKey[CreditcardFields, CreditcardRow] =
    ForeignKey[CreditcardFields, CreditcardRow]("sales.FK_PersonCreditCard_CreditCard_CreditCardID", Nil)
      .withColumnPair(creditcardid, _.creditcardid)
  def compositeIdIs(compositeId: PersoncreditcardId): SqlExpr[Boolean, Required] =
    businessentityid.isEqual(compositeId.businessentityid).and(creditcardid.isEqual(compositeId.creditcardid))
  def compositeIdIn(compositeIds: Array[PersoncreditcardId]): SqlExpr[Boolean, Required] =
    new CompositeIn(compositeIds)(TuplePart(businessentityid)(_.businessentityid), TuplePart(creditcardid)(_.creditcardid))
  
}

object PersoncreditcardFields {
  lazy val structure: Relation[PersoncreditcardFields, PersoncreditcardRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[PersoncreditcardFields, PersoncreditcardRow] {
  
    override lazy val fields: PersoncreditcardFields = new PersoncreditcardFields {
      override def businessentityid = IdField[BusinessentityId, PersoncreditcardRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def creditcardid = IdField[/* user-picked */ CustomCreditcardId, PersoncreditcardRow](_path, "creditcardid", None, Some("int4"), x => x.creditcardid, (row, value) => row.copy(creditcardid = value))
      override def modifieddate = Field[TypoLocalDateTime, PersoncreditcardRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PersoncreditcardRow]] =
      List[FieldLikeNoHkt[?, PersoncreditcardRow]](fields.businessentityid, fields.creditcardid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
