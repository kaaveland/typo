/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class CountryregionStructure[Row](val prefix: Option[String], val extract: Row => CountryregionRow, val merge: (Row, CountryregionRow) => Row)
  extends Relation[CountryregionFields, CountryregionRow, Row]
    with CountryregionFields[Row] { outer =>

  override val countryregioncode = new IdField[CountryregionId, Row](prefix, "countryregioncode", None, None)(x => extract(x).countryregioncode, (row, value) => merge(row, extract(row).copy(countryregioncode = value)))
  override val name = new Field[Name, Row](prefix, "name", None, Some("varchar"))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](countryregioncode, name, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => CountryregionRow, merge: (NewRow, CountryregionRow) => NewRow): CountryregionStructure[NewRow] =
    new CountryregionStructure(prefix, extract, merge)
}
