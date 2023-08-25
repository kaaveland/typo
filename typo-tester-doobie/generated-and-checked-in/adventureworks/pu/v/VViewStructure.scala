/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package v

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class VViewStructure[Row](val prefix: Option[String], val extract: Row => VViewRow, val merge: (Row, VViewRow) => Row)
  extends Relation[VViewFields, VViewRow, Row]
    with VViewFields[Row] { outer =>

  override val id = new Field[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val businessentityid = new Field[BusinessentityId, Row](prefix, "businessentityid", None, Some("int4"))(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val accountnumber = new Field[AccountNumber, Row](prefix, "accountnumber", None, Some(""""public".AccountNumber"""))(x => extract(x).accountnumber, (row, value) => merge(row, extract(row).copy(accountnumber = value)))
  override val name = new Field[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val creditrating = new Field[Int, Row](prefix, "creditrating", None, Some("int2"))(x => extract(x).creditrating, (row, value) => merge(row, extract(row).copy(creditrating = value)))
  override val preferredvendorstatus = new Field[Flag, Row](prefix, "preferredvendorstatus", None, Some(""""public"."Flag""""))(x => extract(x).preferredvendorstatus, (row, value) => merge(row, extract(row).copy(preferredvendorstatus = value)))
  override val activeflag = new Field[Flag, Row](prefix, "activeflag", None, Some(""""public"."Flag""""))(x => extract(x).activeflag, (row, value) => merge(row, extract(row).copy(activeflag = value)))
  override val purchasingwebserviceurl = new Field[/* max 1024 chars */ String, Row](prefix, "purchasingwebserviceurl", None, None)(x => extract(x).purchasingwebserviceurl, (row, value) => merge(row, extract(row).copy(purchasingwebserviceurl = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, businessentityid, accountnumber, name, creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => VViewRow, merge: (NewRow, VViewRow) => NewRow): VViewStructure[NewRow] =
    new VViewStructure(prefix, extract, merge)
}
