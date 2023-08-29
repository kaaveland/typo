/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package referential_constraints

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

case class ReferentialConstraintsViewRow(
  constraintCatalog: /* nullability unknown */ Option[String],
  constraintSchema: /* nullability unknown */ Option[String],
  constraintName: /* nullability unknown */ Option[String],
  uniqueConstraintCatalog: /* nullability unknown */ Option[String],
  uniqueConstraintSchema: /* nullability unknown */ Option[String],
  uniqueConstraintName: /* nullability unknown */ Option[String],
  matchOption: /* nullability unknown */ Option[String],
  updateRule: /* nullability unknown */ Option[String],
  deleteRule: /* nullability unknown */ Option[String]
)

object ReferentialConstraintsViewRow {
  implicit lazy val reads: Reads[ReferentialConstraintsViewRow] = Reads[ReferentialConstraintsViewRow](json => JsResult.fromTry(
      Try(
        ReferentialConstraintsViewRow(
          constraintCatalog = json.\("constraint_catalog").toOption.map(_.as(Reads.StringReads)),
          constraintSchema = json.\("constraint_schema").toOption.map(_.as(Reads.StringReads)),
          constraintName = json.\("constraint_name").toOption.map(_.as(Reads.StringReads)),
          uniqueConstraintCatalog = json.\("unique_constraint_catalog").toOption.map(_.as(Reads.StringReads)),
          uniqueConstraintSchema = json.\("unique_constraint_schema").toOption.map(_.as(Reads.StringReads)),
          uniqueConstraintName = json.\("unique_constraint_name").toOption.map(_.as(Reads.StringReads)),
          matchOption = json.\("match_option").toOption.map(_.as(Reads.StringReads)),
          updateRule = json.\("update_rule").toOption.map(_.as(Reads.StringReads)),
          deleteRule = json.\("delete_rule").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ReferentialConstraintsViewRow] = RowParser[ReferentialConstraintsViewRow] { row =>
    Success(
      ReferentialConstraintsViewRow(
        constraintCatalog = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        constraintSchema = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        constraintName = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        uniqueConstraintCatalog = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        uniqueConstraintSchema = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        uniqueConstraintName = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        matchOption = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        updateRule = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        deleteRule = row(idx + 8)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[ReferentialConstraintsViewRow] = OWrites[ReferentialConstraintsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "constraint_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintCatalog),
      "constraint_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintSchema),
      "constraint_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintName),
      "unique_constraint_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.uniqueConstraintCatalog),
      "unique_constraint_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.uniqueConstraintSchema),
      "unique_constraint_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.uniqueConstraintName),
      "match_option" -> Writes.OptionWrites(Writes.StringWrites).writes(o.matchOption),
      "update_rule" -> Writes.OptionWrites(Writes.StringWrites).writes(o.updateRule),
      "delete_rule" -> Writes.OptionWrites(Writes.StringWrites).writes(o.deleteRule)
    ))
  )
}
