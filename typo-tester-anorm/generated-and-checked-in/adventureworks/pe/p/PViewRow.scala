/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package p

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.customtype.FirstName
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PViewRow(
  id: Option[Int],
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.person.PersonRow.persontype]] */
  persontype: Option[/* bpchar, max 2 chars */ String],
  /** Points to [[person.person.PersonRow.namestyle]] */
  namestyle: NameStyle,
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: Option[/* user-picked */ FirstName],
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[person.person.PersonRow.emailpromotion]] */
  emailpromotion: Option[Int],
  /** Points to [[person.person.PersonRow.additionalcontactinfo]] */
  additionalcontactinfo: Option[TypoXml],
  /** Points to [[person.person.PersonRow.demographics]] */
  demographics: Option[TypoXml],
  /** Points to [[person.person.PersonRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.person.PersonRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PViewRow {
  implicit lazy val reads: Reads[PViewRow] = Reads[PViewRow](json => JsResult.fromTry(
      Try(
        PViewRow(
          id = json.\("id").toOption.map(_.as(Reads.IntReads)),
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          persontype = json.\("persontype").toOption.map(_.as(Reads.StringReads)),
          namestyle = json.\("namestyle").as(NameStyle.reads),
          title = json.\("title").toOption.map(_.as(Reads.StringReads)),
          firstname = json.\("firstname").toOption.map(_.as(FirstName.reads)),
          middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
          lastname = json.\("lastname").toOption.map(_.as(Name.reads)),
          suffix = json.\("suffix").toOption.map(_.as(Reads.StringReads)),
          emailpromotion = json.\("emailpromotion").toOption.map(_.as(Reads.IntReads)),
          additionalcontactinfo = json.\("additionalcontactinfo").toOption.map(_.as(TypoXml.reads)),
          demographics = json.\("demographics").toOption.map(_.as(TypoXml.reads)),
          rowguid = json.\("rowguid").toOption.map(_.as(Reads.uuidReads)),
          modifieddate = json.\("modifieddate").toOption.map(_.as(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PViewRow] = RowParser[PViewRow] { row =>
    Success(
      PViewRow(
        id = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        businessentityid = row(idx + 1)(Column.columnToOption(BusinessentityId.column)),
        persontype = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        namestyle = row(idx + 3)(NameStyle.column),
        title = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        firstname = row(idx + 5)(Column.columnToOption(FirstName.column)),
        middlename = row(idx + 6)(Column.columnToOption(Name.column)),
        lastname = row(idx + 7)(Column.columnToOption(Name.column)),
        suffix = row(idx + 8)(Column.columnToOption(Column.columnToString)),
        emailpromotion = row(idx + 9)(Column.columnToOption(Column.columnToInt)),
        additionalcontactinfo = row(idx + 10)(Column.columnToOption(TypoXml.column)),
        demographics = row(idx + 11)(Column.columnToOption(TypoXml.column)),
        rowguid = row(idx + 12)(Column.columnToOption(Column.columnToUUID)),
        modifieddate = row(idx + 13)(Column.columnToOption(TypoLocalDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PViewRow] = OWrites[PViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.OptionWrites(Writes.IntWrites).writes(o.id),
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "persontype" -> Writes.OptionWrites(Writes.StringWrites).writes(o.persontype),
      "namestyle" -> NameStyle.writes.writes(o.namestyle),
      "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
      "firstname" -> Writes.OptionWrites(FirstName.writes).writes(o.firstname),
      "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
      "lastname" -> Writes.OptionWrites(Name.writes).writes(o.lastname),
      "suffix" -> Writes.OptionWrites(Writes.StringWrites).writes(o.suffix),
      "emailpromotion" -> Writes.OptionWrites(Writes.IntWrites).writes(o.emailpromotion),
      "additionalcontactinfo" -> Writes.OptionWrites(TypoXml.writes).writes(o.additionalcontactinfo),
      "demographics" -> Writes.OptionWrites(TypoXml.writes).writes(o.demographics),
      "rowguid" -> Writes.OptionWrites(Writes.UuidWrites).writes(o.rowguid),
      "modifieddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}