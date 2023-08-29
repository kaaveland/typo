/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class VstorewithaddressesViewRow(
  /** Points to [[store.StoreRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[store.StoreRow.name]] */
  name: Name,
  /** Points to [[person.addresstype.AddresstypeRow.name]] */
  addresstype: Name,
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: /* max 60 chars */ String,
  /** Points to [[person.address.AddressRow.addressline2]] */
  addressline2: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.city]] */
  city: /* max 30 chars */ String,
  /** Points to [[person.stateprovince.StateprovinceRow.name]] */
  stateprovincename: Name,
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: /* max 15 chars */ String,
  /** Points to [[person.countryregion.CountryregionRow.name]] */
  countryregionname: Name
)

object VstorewithaddressesViewRow {
  implicit lazy val reads: Reads[VstorewithaddressesViewRow] = Reads[VstorewithaddressesViewRow](json => JsResult.fromTry(
      Try(
        VstorewithaddressesViewRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          name = json.\("name").as(Name.reads),
          addresstype = json.\("addresstype").as(Name.reads),
          addressline1 = json.\("addressline1").as(Reads.StringReads),
          addressline2 = json.\("addressline2").toOption.map(_.as(Reads.StringReads)),
          city = json.\("city").as(Reads.StringReads),
          stateprovincename = json.\("stateprovincename").as(Name.reads),
          postalcode = json.\("postalcode").as(Reads.StringReads),
          countryregionname = json.\("countryregionname").as(Name.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VstorewithaddressesViewRow] = RowParser[VstorewithaddressesViewRow] { row =>
    Success(
      VstorewithaddressesViewRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        name = row(idx + 1)(Name.column),
        addresstype = row(idx + 2)(Name.column),
        addressline1 = row(idx + 3)(Column.columnToString),
        addressline2 = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        city = row(idx + 5)(Column.columnToString),
        stateprovincename = row(idx + 6)(Name.column),
        postalcode = row(idx + 7)(Column.columnToString),
        countryregionname = row(idx + 8)(Name.column)
      )
    )
  }
  implicit lazy val writes: OWrites[VstorewithaddressesViewRow] = OWrites[VstorewithaddressesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "name" -> Name.writes.writes(o.name),
      "addresstype" -> Name.writes.writes(o.addresstype),
      "addressline1" -> Writes.StringWrites.writes(o.addressline1),
      "addressline2" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline2),
      "city" -> Writes.StringWrites.writes(o.city),
      "stateprovincename" -> Name.writes.writes(o.stateprovincename),
      "postalcode" -> Writes.StringWrites.writes(o.postalcode),
      "countryregionname" -> Name.writes.writes(o.countryregionname)
    ))
  )
}
