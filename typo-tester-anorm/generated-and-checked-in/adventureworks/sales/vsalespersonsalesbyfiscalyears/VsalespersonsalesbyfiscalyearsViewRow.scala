/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyears

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

case class VsalespersonsalesbyfiscalyearsViewRow(
  SalesPersonID: /* nullability unknown */ Option[Int],
  FullName: /* nullability unknown */ Option[String],
  JobTitle: /* nullability unknown */ Option[String],
  SalesTerritory: /* nullability unknown */ Option[String],
  `2012`: /* nullability unknown */ Option[BigDecimal],
  `2013`: /* nullability unknown */ Option[BigDecimal],
  `2014`: /* nullability unknown */ Option[BigDecimal]
)

object VsalespersonsalesbyfiscalyearsViewRow {
  implicit lazy val reads: Reads[VsalespersonsalesbyfiscalyearsViewRow] = Reads[VsalespersonsalesbyfiscalyearsViewRow](json => JsResult.fromTry(
      Try(
        VsalespersonsalesbyfiscalyearsViewRow(
          SalesPersonID = json.\("SalesPersonID").toOption.map(_.as(Reads.IntReads)),
          FullName = json.\("FullName").toOption.map(_.as(Reads.StringReads)),
          JobTitle = json.\("JobTitle").toOption.map(_.as(Reads.StringReads)),
          SalesTerritory = json.\("SalesTerritory").toOption.map(_.as(Reads.StringReads)),
          `2012` = json.\("2012").toOption.map(_.as(Reads.bigDecReads)),
          `2013` = json.\("2013").toOption.map(_.as(Reads.bigDecReads)),
          `2014` = json.\("2014").toOption.map(_.as(Reads.bigDecReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VsalespersonsalesbyfiscalyearsViewRow] = RowParser[VsalespersonsalesbyfiscalyearsViewRow] { row =>
    Success(
      VsalespersonsalesbyfiscalyearsViewRow(
        SalesPersonID = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        FullName = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        JobTitle = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        SalesTerritory = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        `2012` = row(idx + 4)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        `2013` = row(idx + 5)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        `2014` = row(idx + 6)(Column.columnToOption(Column.columnToScalaBigDecimal))
      )
    )
  }
  implicit lazy val writes: OWrites[VsalespersonsalesbyfiscalyearsViewRow] = OWrites[VsalespersonsalesbyfiscalyearsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "SalesPersonID" -> Writes.OptionWrites(Writes.IntWrites).writes(o.SalesPersonID),
      "FullName" -> Writes.OptionWrites(Writes.StringWrites).writes(o.FullName),
      "JobTitle" -> Writes.OptionWrites(Writes.StringWrites).writes(o.JobTitle),
      "SalesTerritory" -> Writes.OptionWrites(Writes.StringWrites).writes(o.SalesTerritory),
      "2012" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.`2012`),
      "2013" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.`2013`),
      "2014" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.`2014`)
    ))
  )
}
