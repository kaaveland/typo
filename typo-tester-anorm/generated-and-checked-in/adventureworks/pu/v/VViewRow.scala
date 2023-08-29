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

case class VViewRow(
  /** Points to [[purchasing.vendor.VendorRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[purchasing.vendor.VendorRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[purchasing.vendor.VendorRow.accountnumber]] */
  accountnumber: AccountNumber,
  /** Points to [[purchasing.vendor.VendorRow.name]] */
  name: Name,
  /** Points to [[purchasing.vendor.VendorRow.creditrating]] */
  creditrating: Int,
  /** Points to [[purchasing.vendor.VendorRow.preferredvendorstatus]] */
  preferredvendorstatus: Flag,
  /** Points to [[purchasing.vendor.VendorRow.activeflag]] */
  activeflag: Flag,
  /** Points to [[purchasing.vendor.VendorRow.purchasingwebserviceurl]] */
  purchasingwebserviceurl: Option[/* max 1024 chars */ String],
  /** Points to [[purchasing.vendor.VendorRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VViewRow {
  implicit lazy val reads: Reads[VViewRow] = Reads[VViewRow](json => JsResult.fromTry(
      Try(
        VViewRow(
          id = json.\("id").as(BusinessentityId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          accountnumber = json.\("accountnumber").as(AccountNumber.reads),
          name = json.\("name").as(Name.reads),
          creditrating = json.\("creditrating").as(Reads.IntReads),
          preferredvendorstatus = json.\("preferredvendorstatus").as(Flag.reads),
          activeflag = json.\("activeflag").as(Flag.reads),
          purchasingwebserviceurl = json.\("purchasingwebserviceurl").toOption.map(_.as(Reads.StringReads)),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VViewRow] = RowParser[VViewRow] { row =>
    Success(
      VViewRow(
        id = row(idx + 0)(BusinessentityId.column),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        accountnumber = row(idx + 2)(AccountNumber.column),
        name = row(idx + 3)(Name.column),
        creditrating = row(idx + 4)(Column.columnToInt),
        preferredvendorstatus = row(idx + 5)(Flag.column),
        activeflag = row(idx + 6)(Flag.column),
        purchasingwebserviceurl = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        modifieddate = row(idx + 8)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[VViewRow] = OWrites[VViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> BusinessentityId.writes.writes(o.id),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "accountnumber" -> AccountNumber.writes.writes(o.accountnumber),
      "name" -> Name.writes.writes(o.name),
      "creditrating" -> Writes.IntWrites.writes(o.creditrating),
      "preferredvendorstatus" -> Flag.writes.writes(o.preferredvendorstatus),
      "activeflag" -> Flag.writes.writes(o.activeflag),
      "purchasingwebserviceurl" -> Writes.OptionWrites(Writes.StringWrites).writes(o.purchasingwebserviceurl),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
