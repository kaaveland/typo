/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package domain_udt_usage

import adventureworks.information_schema.SqlIdentifier
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class DomainUdtUsageViewRow(
  udtCatalog: SqlIdentifier,
  udtSchema: SqlIdentifier,
  udtName: SqlIdentifier,
  domainCatalog: SqlIdentifier,
  domainSchema: SqlIdentifier,
  domainName: SqlIdentifier
)

object DomainUdtUsageViewRow {
  implicit lazy val reads: Reads[DomainUdtUsageViewRow] = Reads[DomainUdtUsageViewRow](json => JsResult.fromTry(
      Try(
        DomainUdtUsageViewRow(
          udtCatalog = json.\("udt_catalog").as(SqlIdentifier.reads),
          udtSchema = json.\("udt_schema").as(SqlIdentifier.reads),
          udtName = json.\("udt_name").as(SqlIdentifier.reads),
          domainCatalog = json.\("domain_catalog").as(SqlIdentifier.reads),
          domainSchema = json.\("domain_schema").as(SqlIdentifier.reads),
          domainName = json.\("domain_name").as(SqlIdentifier.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[DomainUdtUsageViewRow] = RowParser[DomainUdtUsageViewRow] { row =>
    Success(
      DomainUdtUsageViewRow(
        udtCatalog = row(idx + 0)(SqlIdentifier.column),
        udtSchema = row(idx + 1)(SqlIdentifier.column),
        udtName = row(idx + 2)(SqlIdentifier.column),
        domainCatalog = row(idx + 3)(SqlIdentifier.column),
        domainSchema = row(idx + 4)(SqlIdentifier.column),
        domainName = row(idx + 5)(SqlIdentifier.column)
      )
    )
  }
  implicit lazy val writes: OWrites[DomainUdtUsageViewRow] = OWrites[DomainUdtUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "udt_catalog" -> SqlIdentifier.writes.writes(o.udtCatalog),
      "udt_schema" -> SqlIdentifier.writes.writes(o.udtSchema),
      "udt_name" -> SqlIdentifier.writes.writes(o.udtName),
      "domain_catalog" -> SqlIdentifier.writes.writes(o.domainCatalog),
      "domain_schema" -> SqlIdentifier.writes.writes(o.domainSchema),
      "domain_name" -> SqlIdentifier.writes.writes(o.domainName)
    ))
  )
}
