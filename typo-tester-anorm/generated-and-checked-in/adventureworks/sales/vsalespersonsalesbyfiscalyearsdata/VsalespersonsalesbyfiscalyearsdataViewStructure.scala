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
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class VsalespersonsalesbyfiscalyearsdataViewStructure[Row](val prefix: Option[String], val extract: Row => VsalespersonsalesbyfiscalyearsdataViewRow, val merge: (Row, VsalespersonsalesbyfiscalyearsdataViewRow) => Row)
  extends Relation[VsalespersonsalesbyfiscalyearsdataViewFields, VsalespersonsalesbyfiscalyearsdataViewRow, Row]
    with VsalespersonsalesbyfiscalyearsdataViewFields[Row] { outer =>

  override val salespersonid = new OptField[BusinessentityId, Row](prefix, "salespersonid", None, None)(x => extract(x).salespersonid, (row, value) => merge(row, extract(row).copy(salespersonid = value)))
  override val fullname = new OptField[String, Row](prefix, "fullname", None, None)(x => extract(x).fullname, (row, value) => merge(row, extract(row).copy(fullname = value)))
  override val jobtitle = new Field[/* max 50 chars */ String, Row](prefix, "jobtitle", None, None)(x => extract(x).jobtitle, (row, value) => merge(row, extract(row).copy(jobtitle = value)))
  override val salesterritory = new Field[Name, Row](prefix, "salesterritory", None, None)(x => extract(x).salesterritory, (row, value) => merge(row, extract(row).copy(salesterritory = value)))
  override val salestotal = new OptField[BigDecimal, Row](prefix, "salestotal", None, None)(x => extract(x).salestotal, (row, value) => merge(row, extract(row).copy(salestotal = value)))
  override val fiscalyear = new OptField[BigDecimal, Row](prefix, "fiscalyear", None, None)(x => extract(x).fiscalyear, (row, value) => merge(row, extract(row).copy(fiscalyear = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](salespersonid, fullname, jobtitle, salesterritory, salestotal, fiscalyear)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => VsalespersonsalesbyfiscalyearsdataViewRow, merge: (NewRow, VsalespersonsalesbyfiscalyearsdataViewRow) => NewRow): VsalespersonsalesbyfiscalyearsdataViewStructure[NewRow] =
    new VsalespersonsalesbyfiscalyearsdataViewStructure(prefix, extract, merge)
}
