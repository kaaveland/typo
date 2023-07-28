/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_domain_usage

import adventureworks.information_schema.SqlIdentifier
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

case class ColumnDomainUsageViewRow(
  domainCatalog: Option[SqlIdentifier],
  domainSchema: Option[SqlIdentifier],
  domainName: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier]
)

object ColumnDomainUsageViewRow {
  implicit val reads: Reads[ColumnDomainUsageViewRow] = Reads[ColumnDomainUsageViewRow](json => JsResult.fromTry(
      Try(
        ColumnDomainUsageViewRow(
          domainCatalog = json.\("domain_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          domainSchema = json.\("domain_schema").toOption.map(_.as(SqlIdentifier.reads)),
          domainName = json.\("domain_name").toOption.map(_.as(SqlIdentifier.reads)),
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          columnName = json.\("column_name").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ColumnDomainUsageViewRow] = RowParser[ColumnDomainUsageViewRow] { row =>
    Success(
      ColumnDomainUsageViewRow(
        domainCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        domainSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        domainName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        tableCatalog = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column)),
        columnName = row(idx + 6)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit val writes: OWrites[ColumnDomainUsageViewRow] = OWrites[ColumnDomainUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "domain_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.domainCatalog),
      "domain_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.domainSchema),
      "domain_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.domainName),
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "column_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.columnName)
    ))
  )
}