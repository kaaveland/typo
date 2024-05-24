/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyearsdata

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait VsalespersonsalesbyfiscalyearsdataViewFields {
  def salespersonid: OptField[BusinessentityId, VsalespersonsalesbyfiscalyearsdataViewRow]
  def fullname: OptField[String, VsalespersonsalesbyfiscalyearsdataViewRow]
  def jobtitle: Field[/* max 50 chars */ String, VsalespersonsalesbyfiscalyearsdataViewRow]
  def salesterritory: Field[Name, VsalespersonsalesbyfiscalyearsdataViewRow]
  def salestotal: OptField[BigDecimal, VsalespersonsalesbyfiscalyearsdataViewRow]
  def fiscalyear: OptField[BigDecimal, VsalespersonsalesbyfiscalyearsdataViewRow]
}

object VsalespersonsalesbyfiscalyearsdataViewFields {
  lazy val structure: Relation[VsalespersonsalesbyfiscalyearsdataViewFields, VsalespersonsalesbyfiscalyearsdataViewRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[VsalespersonsalesbyfiscalyearsdataViewFields, VsalespersonsalesbyfiscalyearsdataViewRow] {
  
    override lazy val fields: VsalespersonsalesbyfiscalyearsdataViewFields = new VsalespersonsalesbyfiscalyearsdataViewFields {
      override def salespersonid = OptField[BusinessentityId, VsalespersonsalesbyfiscalyearsdataViewRow](_path, "salespersonid", None, None, x => x.salespersonid, (row, value) => row.copy(salespersonid = value))
      override def fullname = OptField[String, VsalespersonsalesbyfiscalyearsdataViewRow](_path, "fullname", None, None, x => x.fullname, (row, value) => row.copy(fullname = value))
      override def jobtitle = Field[/* max 50 chars */ String, VsalespersonsalesbyfiscalyearsdataViewRow](_path, "jobtitle", None, None, x => x.jobtitle, (row, value) => row.copy(jobtitle = value))
      override def salesterritory = Field[Name, VsalespersonsalesbyfiscalyearsdataViewRow](_path, "salesterritory", None, None, x => x.salesterritory, (row, value) => row.copy(salesterritory = value))
      override def salestotal = OptField[BigDecimal, VsalespersonsalesbyfiscalyearsdataViewRow](_path, "salestotal", None, None, x => x.salestotal, (row, value) => row.copy(salestotal = value))
      override def fiscalyear = OptField[BigDecimal, VsalespersonsalesbyfiscalyearsdataViewRow](_path, "fiscalyear", None, None, x => x.fiscalyear, (row, value) => row.copy(fiscalyear = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, VsalespersonsalesbyfiscalyearsdataViewRow]] =
      List[FieldLikeNoHkt[?, VsalespersonsalesbyfiscalyearsdataViewRow]](fields.salespersonid, fields.fullname, fields.jobtitle, fields.salesterritory, fields.salestotal, fields.fiscalyear)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
