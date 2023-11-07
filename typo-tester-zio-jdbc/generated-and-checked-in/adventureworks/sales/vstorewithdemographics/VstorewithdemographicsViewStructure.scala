/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithdemographics

import adventureworks.customtypes.TypoMoney
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class VstorewithdemographicsViewStructure[Row](val prefix: Option[String], val extract: Row => VstorewithdemographicsViewRow, val merge: (Row, VstorewithdemographicsViewRow) => Row)
  extends Relation[VstorewithdemographicsViewFields, VstorewithdemographicsViewRow, Row]
    with VstorewithdemographicsViewFields[Row] { outer =>

  override val businessentityid = new Field[BusinessentityId, Row](prefix, "businessentityid", None, None)(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val name = new Field[Name, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val AnnualSales = new OptField[TypoMoney, Row](prefix, "AnnualSales", Some("numeric"), None)(x => extract(x).AnnualSales, (row, value) => merge(row, extract(row).copy(AnnualSales = value)))
  override val AnnualRevenue = new OptField[TypoMoney, Row](prefix, "AnnualRevenue", Some("numeric"), None)(x => extract(x).AnnualRevenue, (row, value) => merge(row, extract(row).copy(AnnualRevenue = value)))
  override val BankName = new OptField[/* max 50 chars */ String, Row](prefix, "BankName", None, None)(x => extract(x).BankName, (row, value) => merge(row, extract(row).copy(BankName = value)))
  override val BusinessType = new OptField[/* max 5 chars */ String, Row](prefix, "BusinessType", None, None)(x => extract(x).BusinessType, (row, value) => merge(row, extract(row).copy(BusinessType = value)))
  override val YearOpened = new OptField[Int, Row](prefix, "YearOpened", None, None)(x => extract(x).YearOpened, (row, value) => merge(row, extract(row).copy(YearOpened = value)))
  override val Specialty = new OptField[/* max 50 chars */ String, Row](prefix, "Specialty", None, None)(x => extract(x).Specialty, (row, value) => merge(row, extract(row).copy(Specialty = value)))
  override val SquareFeet = new OptField[Int, Row](prefix, "SquareFeet", None, None)(x => extract(x).SquareFeet, (row, value) => merge(row, extract(row).copy(SquareFeet = value)))
  override val Brands = new OptField[/* max 30 chars */ String, Row](prefix, "Brands", None, None)(x => extract(x).Brands, (row, value) => merge(row, extract(row).copy(Brands = value)))
  override val Internet = new OptField[/* max 30 chars */ String, Row](prefix, "Internet", None, None)(x => extract(x).Internet, (row, value) => merge(row, extract(row).copy(Internet = value)))
  override val NumberEmployees = new OptField[Int, Row](prefix, "NumberEmployees", None, None)(x => extract(x).NumberEmployees, (row, value) => merge(row, extract(row).copy(NumberEmployees = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](businessentityid, name, AnnualSales, AnnualRevenue, BankName, BusinessType, YearOpened, Specialty, SquareFeet, Brands, Internet, NumberEmployees)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => VstorewithdemographicsViewRow, merge: (NewRow, VstorewithdemographicsViewRow) => NewRow): VstorewithdemographicsViewStructure[NewRow] =
    new VstorewithdemographicsViewStructure(prefix, extract, merge)
}
