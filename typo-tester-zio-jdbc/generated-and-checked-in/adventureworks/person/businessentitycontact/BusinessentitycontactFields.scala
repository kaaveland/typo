/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait BusinessentitycontactFields {
  def businessentityid: IdField[BusinessentityId, BusinessentitycontactRow]
  def personid: IdField[BusinessentityId, BusinessentitycontactRow]
  def contacttypeid: IdField[ContacttypeId, BusinessentitycontactRow]
  def rowguid: Field[TypoUUID, BusinessentitycontactRow]
  def modifieddate: Field[TypoLocalDateTime, BusinessentitycontactRow]
}

object BusinessentitycontactFields {
  lazy val structure: Relation[BusinessentitycontactFields, BusinessentitycontactRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[BusinessentitycontactFields, BusinessentitycontactRow] {
  
    override lazy val fields: BusinessentitycontactFields = new BusinessentitycontactFields {
      override def businessentityid = IdField[BusinessentityId, BusinessentitycontactRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def personid = IdField[BusinessentityId, BusinessentitycontactRow](_path, "personid", None, Some("int4"), x => x.personid, (row, value) => row.copy(personid = value))
      override def contacttypeid = IdField[ContacttypeId, BusinessentitycontactRow](_path, "contacttypeid", None, Some("int4"), x => x.contacttypeid, (row, value) => row.copy(contacttypeid = value))
      override def rowguid = Field[TypoUUID, BusinessentitycontactRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, BusinessentitycontactRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, BusinessentitycontactRow]] =
      List[FieldLikeNoHkt[?, BusinessentitycontactRow]](fields.businessentityid, fields.personid, fields.contacttypeid, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
