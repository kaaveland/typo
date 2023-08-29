/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package data_type_privileges

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

case class DataTypePrivilegesViewRow(
  objectCatalog: /* nullability unknown */ Option[String],
  objectSchema: /* nullability unknown */ Option[String],
  objectName: /* nullability unknown */ Option[String],
  objectType: /* nullability unknown */ Option[String],
  dtdIdentifier: /* nullability unknown */ Option[String]
)

object DataTypePrivilegesViewRow {
  implicit lazy val reads: Reads[DataTypePrivilegesViewRow] = Reads[DataTypePrivilegesViewRow](json => JsResult.fromTry(
      Try(
        DataTypePrivilegesViewRow(
          objectCatalog = json.\("object_catalog").toOption.map(_.as(Reads.StringReads)),
          objectSchema = json.\("object_schema").toOption.map(_.as(Reads.StringReads)),
          objectName = json.\("object_name").toOption.map(_.as(Reads.StringReads)),
          objectType = json.\("object_type").toOption.map(_.as(Reads.StringReads)),
          dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[DataTypePrivilegesViewRow] = RowParser[DataTypePrivilegesViewRow] { row =>
    Success(
      DataTypePrivilegesViewRow(
        objectCatalog = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        objectSchema = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        objectName = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        objectType = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        dtdIdentifier = row(idx + 4)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[DataTypePrivilegesViewRow] = OWrites[DataTypePrivilegesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "object_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.objectCatalog),
      "object_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.objectSchema),
      "object_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.objectName),
      "object_type" -> Writes.OptionWrites(Writes.StringWrites).writes(o.objectType),
      "dtd_identifier" -> Writes.OptionWrites(Writes.StringWrites).writes(o.dtdIdentifier)
    ))
  )
}
