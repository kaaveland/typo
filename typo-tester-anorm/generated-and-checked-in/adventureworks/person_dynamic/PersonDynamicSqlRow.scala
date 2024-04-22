/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_dynamic

import adventureworks.public.Name
import adventureworks.userdefined.FirstName
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

/** SQL file: person_dynamic.sql */
case class PersonDynamicSqlRow(
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Name
)

object PersonDynamicSqlRow {
  implicit lazy val reads: Reads[PersonDynamicSqlRow] = Reads[PersonDynamicSqlRow](json => JsResult.fromTry(
      Try(
        PersonDynamicSqlRow(
          title = json.\("title").toOption.map(_.as(Reads.StringReads)),
          firstname = json.\("firstname").as(FirstName.reads),
          middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
          lastname = json.\("lastname").as(Name.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PersonDynamicSqlRow] = RowParser[PersonDynamicSqlRow] { row =>
    Success(
      PersonDynamicSqlRow(
        title = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        firstname = row(idx + 1)(/* user-picked */ FirstName.column),
        middlename = row(idx + 2)(Column.columnToOption(Name.column)),
        lastname = row(idx + 3)(Name.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PersonDynamicSqlRow] = OWrites[PersonDynamicSqlRow](o =>
    new JsObject(ListMap[String, JsValue](
      "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
      "firstname" -> FirstName.writes.writes(o.firstname),
      "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
      "lastname" -> Name.writes.writes(o.lastname)
    ))
  )
}
