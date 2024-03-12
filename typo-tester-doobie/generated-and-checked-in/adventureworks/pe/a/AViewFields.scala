/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package a

import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.stateprovince.StateprovinceId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait AViewFields[Row] {
  val id: Field[AddressId, Row]
  val addressid: Field[AddressId, Row]
  val addressline1: Field[/* max 60 chars */ String, Row]
  val addressline2: OptField[/* max 60 chars */ String, Row]
  val city: Field[/* max 30 chars */ String, Row]
  val stateprovinceid: Field[StateprovinceId, Row]
  val postalcode: Field[/* max 15 chars */ String, Row]
  val spatiallocation: OptField[TypoBytea, Row]
  val rowguid: Field[TypoUUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object AViewFields {
  val structure: Relation[AViewFields, AViewRow, AViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => AViewRow, val merge: (Row, AViewRow) => Row)
    extends Relation[AViewFields, AViewRow, Row] { 
  
    override val fields: AViewFields[Row] = new AViewFields[Row] {
      override val id = new Field[AddressId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
      override val addressid = new Field[AddressId, Row](prefix, "addressid", None, None)(x => extract(x).addressid, (row, value) => merge(row, extract(row).copy(addressid = value)))
      override val addressline1 = new Field[/* max 60 chars */ String, Row](prefix, "addressline1", None, None)(x => extract(x).addressline1, (row, value) => merge(row, extract(row).copy(addressline1 = value)))
      override val addressline2 = new OptField[/* max 60 chars */ String, Row](prefix, "addressline2", None, None)(x => extract(x).addressline2, (row, value) => merge(row, extract(row).copy(addressline2 = value)))
      override val city = new Field[/* max 30 chars */ String, Row](prefix, "city", None, None)(x => extract(x).city, (row, value) => merge(row, extract(row).copy(city = value)))
      override val stateprovinceid = new Field[StateprovinceId, Row](prefix, "stateprovinceid", None, None)(x => extract(x).stateprovinceid, (row, value) => merge(row, extract(row).copy(stateprovinceid = value)))
      override val postalcode = new Field[/* max 15 chars */ String, Row](prefix, "postalcode", None, None)(x => extract(x).postalcode, (row, value) => merge(row, extract(row).copy(postalcode = value)))
      override val spatiallocation = new OptField[TypoBytea, Row](prefix, "spatiallocation", None, None)(x => extract(x).spatiallocation, (row, value) => merge(row, extract(row).copy(spatiallocation = value)))
      override val rowguid = new Field[TypoUUID, Row](prefix, "rowguid", None, None)(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.id, fields.addressid, fields.addressline1, fields.addressline2, fields.city, fields.stateprovinceid, fields.postalcode, fields.spatiallocation, fields.rowguid, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => AViewRow, merge: (NewRow, AViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
