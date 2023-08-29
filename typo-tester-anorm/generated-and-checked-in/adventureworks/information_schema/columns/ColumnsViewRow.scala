/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package columns

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

case class ColumnsViewRow(
  tableCatalog: /* nullability unknown */ Option[String],
  tableSchema: /* nullability unknown */ Option[String],
  tableName: /* nullability unknown */ Option[String],
  columnName: /* nullability unknown */ Option[String],
  ordinalPosition: /* nullability unknown */ Option[Int],
  columnDefault: /* nullability unknown */ Option[String],
  isNullable: /* nullability unknown */ Option[/* max 3 chars */ String],
  dataType: /* nullability unknown */ Option[String],
  characterMaximumLength: /* nullability unknown */ Option[Int],
  characterOctetLength: /* nullability unknown */ Option[Int],
  numericPrecision: /* nullability unknown */ Option[Int],
  numericPrecisionRadix: /* nullability unknown */ Option[Int],
  numericScale: /* nullability unknown */ Option[Int],
  datetimePrecision: /* nullability unknown */ Option[Int],
  intervalType: /* nullability unknown */ Option[String],
  intervalPrecision: /* nullability unknown */ Option[Int],
  characterSetCatalog: /* nullability unknown */ Option[String],
  characterSetSchema: /* nullability unknown */ Option[String],
  characterSetName: /* nullability unknown */ Option[String],
  collationCatalog: /* nullability unknown */ Option[String],
  collationSchema: /* nullability unknown */ Option[String],
  collationName: /* nullability unknown */ Option[String],
  domainCatalog: /* nullability unknown */ Option[String],
  domainSchema: /* nullability unknown */ Option[String],
  domainName: /* nullability unknown */ Option[String],
  udtCatalog: /* nullability unknown */ Option[String],
  udtSchema: /* nullability unknown */ Option[String],
  udtName: /* nullability unknown */ Option[String],
  scopeCatalog: /* nullability unknown */ Option[String],
  scopeSchema: /* nullability unknown */ Option[String],
  scopeName: /* nullability unknown */ Option[String],
  maximumCardinality: /* nullability unknown */ Option[Int],
  dtdIdentifier: /* nullability unknown */ Option[String],
  isSelfReferencing: /* nullability unknown */ Option[/* max 3 chars */ String],
  isIdentity: /* nullability unknown */ Option[/* max 3 chars */ String],
  identityGeneration: /* nullability unknown */ Option[String],
  identityStart: /* nullability unknown */ Option[String],
  identityIncrement: /* nullability unknown */ Option[String],
  identityMaximum: /* nullability unknown */ Option[String],
  identityMinimum: /* nullability unknown */ Option[String],
  identityCycle: /* nullability unknown */ Option[/* max 3 chars */ String],
  isGenerated: /* nullability unknown */ Option[String],
  generationExpression: /* nullability unknown */ Option[String],
  isUpdatable: /* nullability unknown */ Option[/* max 3 chars */ String]
)

object ColumnsViewRow {
  implicit lazy val reads: Reads[ColumnsViewRow] = Reads[ColumnsViewRow](json => JsResult.fromTry(
      Try(
        ColumnsViewRow(
          tableCatalog = json.\("table_catalog").toOption.map(_.as(Reads.StringReads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(Reads.StringReads)),
          tableName = json.\("table_name").toOption.map(_.as(Reads.StringReads)),
          columnName = json.\("column_name").toOption.map(_.as(Reads.StringReads)),
          ordinalPosition = json.\("ordinal_position").toOption.map(_.as(Reads.IntReads)),
          columnDefault = json.\("column_default").toOption.map(_.as(Reads.StringReads)),
          isNullable = json.\("is_nullable").toOption.map(_.as(Reads.StringReads)),
          dataType = json.\("data_type").toOption.map(_.as(Reads.StringReads)),
          characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as(Reads.IntReads)),
          characterOctetLength = json.\("character_octet_length").toOption.map(_.as(Reads.IntReads)),
          numericPrecision = json.\("numeric_precision").toOption.map(_.as(Reads.IntReads)),
          numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as(Reads.IntReads)),
          numericScale = json.\("numeric_scale").toOption.map(_.as(Reads.IntReads)),
          datetimePrecision = json.\("datetime_precision").toOption.map(_.as(Reads.IntReads)),
          intervalType = json.\("interval_type").toOption.map(_.as(Reads.StringReads)),
          intervalPrecision = json.\("interval_precision").toOption.map(_.as(Reads.IntReads)),
          characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as(Reads.StringReads)),
          characterSetSchema = json.\("character_set_schema").toOption.map(_.as(Reads.StringReads)),
          characterSetName = json.\("character_set_name").toOption.map(_.as(Reads.StringReads)),
          collationCatalog = json.\("collation_catalog").toOption.map(_.as(Reads.StringReads)),
          collationSchema = json.\("collation_schema").toOption.map(_.as(Reads.StringReads)),
          collationName = json.\("collation_name").toOption.map(_.as(Reads.StringReads)),
          domainCatalog = json.\("domain_catalog").toOption.map(_.as(Reads.StringReads)),
          domainSchema = json.\("domain_schema").toOption.map(_.as(Reads.StringReads)),
          domainName = json.\("domain_name").toOption.map(_.as(Reads.StringReads)),
          udtCatalog = json.\("udt_catalog").toOption.map(_.as(Reads.StringReads)),
          udtSchema = json.\("udt_schema").toOption.map(_.as(Reads.StringReads)),
          udtName = json.\("udt_name").toOption.map(_.as(Reads.StringReads)),
          scopeCatalog = json.\("scope_catalog").toOption.map(_.as(Reads.StringReads)),
          scopeSchema = json.\("scope_schema").toOption.map(_.as(Reads.StringReads)),
          scopeName = json.\("scope_name").toOption.map(_.as(Reads.StringReads)),
          maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as(Reads.IntReads)),
          dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as(Reads.StringReads)),
          isSelfReferencing = json.\("is_self_referencing").toOption.map(_.as(Reads.StringReads)),
          isIdentity = json.\("is_identity").toOption.map(_.as(Reads.StringReads)),
          identityGeneration = json.\("identity_generation").toOption.map(_.as(Reads.StringReads)),
          identityStart = json.\("identity_start").toOption.map(_.as(Reads.StringReads)),
          identityIncrement = json.\("identity_increment").toOption.map(_.as(Reads.StringReads)),
          identityMaximum = json.\("identity_maximum").toOption.map(_.as(Reads.StringReads)),
          identityMinimum = json.\("identity_minimum").toOption.map(_.as(Reads.StringReads)),
          identityCycle = json.\("identity_cycle").toOption.map(_.as(Reads.StringReads)),
          isGenerated = json.\("is_generated").toOption.map(_.as(Reads.StringReads)),
          generationExpression = json.\("generation_expression").toOption.map(_.as(Reads.StringReads)),
          isUpdatable = json.\("is_updatable").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ColumnsViewRow] = RowParser[ColumnsViewRow] { row =>
    Success(
      ColumnsViewRow(
        tableCatalog = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        tableSchema = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        tableName = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        columnName = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        ordinalPosition = row(idx + 4)(Column.columnToOption(Column.columnToInt)),
        columnDefault = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        isNullable = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        dataType = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        characterMaximumLength = row(idx + 8)(Column.columnToOption(Column.columnToInt)),
        characterOctetLength = row(idx + 9)(Column.columnToOption(Column.columnToInt)),
        numericPrecision = row(idx + 10)(Column.columnToOption(Column.columnToInt)),
        numericPrecisionRadix = row(idx + 11)(Column.columnToOption(Column.columnToInt)),
        numericScale = row(idx + 12)(Column.columnToOption(Column.columnToInt)),
        datetimePrecision = row(idx + 13)(Column.columnToOption(Column.columnToInt)),
        intervalType = row(idx + 14)(Column.columnToOption(Column.columnToString)),
        intervalPrecision = row(idx + 15)(Column.columnToOption(Column.columnToInt)),
        characterSetCatalog = row(idx + 16)(Column.columnToOption(Column.columnToString)),
        characterSetSchema = row(idx + 17)(Column.columnToOption(Column.columnToString)),
        characterSetName = row(idx + 18)(Column.columnToOption(Column.columnToString)),
        collationCatalog = row(idx + 19)(Column.columnToOption(Column.columnToString)),
        collationSchema = row(idx + 20)(Column.columnToOption(Column.columnToString)),
        collationName = row(idx + 21)(Column.columnToOption(Column.columnToString)),
        domainCatalog = row(idx + 22)(Column.columnToOption(Column.columnToString)),
        domainSchema = row(idx + 23)(Column.columnToOption(Column.columnToString)),
        domainName = row(idx + 24)(Column.columnToOption(Column.columnToString)),
        udtCatalog = row(idx + 25)(Column.columnToOption(Column.columnToString)),
        udtSchema = row(idx + 26)(Column.columnToOption(Column.columnToString)),
        udtName = row(idx + 27)(Column.columnToOption(Column.columnToString)),
        scopeCatalog = row(idx + 28)(Column.columnToOption(Column.columnToString)),
        scopeSchema = row(idx + 29)(Column.columnToOption(Column.columnToString)),
        scopeName = row(idx + 30)(Column.columnToOption(Column.columnToString)),
        maximumCardinality = row(idx + 31)(Column.columnToOption(Column.columnToInt)),
        dtdIdentifier = row(idx + 32)(Column.columnToOption(Column.columnToString)),
        isSelfReferencing = row(idx + 33)(Column.columnToOption(Column.columnToString)),
        isIdentity = row(idx + 34)(Column.columnToOption(Column.columnToString)),
        identityGeneration = row(idx + 35)(Column.columnToOption(Column.columnToString)),
        identityStart = row(idx + 36)(Column.columnToOption(Column.columnToString)),
        identityIncrement = row(idx + 37)(Column.columnToOption(Column.columnToString)),
        identityMaximum = row(idx + 38)(Column.columnToOption(Column.columnToString)),
        identityMinimum = row(idx + 39)(Column.columnToOption(Column.columnToString)),
        identityCycle = row(idx + 40)(Column.columnToOption(Column.columnToString)),
        isGenerated = row(idx + 41)(Column.columnToOption(Column.columnToString)),
        generationExpression = row(idx + 42)(Column.columnToOption(Column.columnToString)),
        isUpdatable = row(idx + 43)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[ColumnsViewRow] = OWrites[ColumnsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "table_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableName),
      "column_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.columnName),
      "ordinal_position" -> Writes.OptionWrites(Writes.IntWrites).writes(o.ordinalPosition),
      "column_default" -> Writes.OptionWrites(Writes.StringWrites).writes(o.columnDefault),
      "is_nullable" -> Writes.OptionWrites(Writes.StringWrites).writes(o.isNullable),
      "data_type" -> Writes.OptionWrites(Writes.StringWrites).writes(o.dataType),
      "character_maximum_length" -> Writes.OptionWrites(Writes.IntWrites).writes(o.characterMaximumLength),
      "character_octet_length" -> Writes.OptionWrites(Writes.IntWrites).writes(o.characterOctetLength),
      "numeric_precision" -> Writes.OptionWrites(Writes.IntWrites).writes(o.numericPrecision),
      "numeric_precision_radix" -> Writes.OptionWrites(Writes.IntWrites).writes(o.numericPrecisionRadix),
      "numeric_scale" -> Writes.OptionWrites(Writes.IntWrites).writes(o.numericScale),
      "datetime_precision" -> Writes.OptionWrites(Writes.IntWrites).writes(o.datetimePrecision),
      "interval_type" -> Writes.OptionWrites(Writes.StringWrites).writes(o.intervalType),
      "interval_precision" -> Writes.OptionWrites(Writes.IntWrites).writes(o.intervalPrecision),
      "character_set_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.characterSetCatalog),
      "character_set_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.characterSetSchema),
      "character_set_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.characterSetName),
      "collation_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.collationCatalog),
      "collation_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.collationSchema),
      "collation_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.collationName),
      "domain_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.domainCatalog),
      "domain_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.domainSchema),
      "domain_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.domainName),
      "udt_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.udtCatalog),
      "udt_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.udtSchema),
      "udt_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.udtName),
      "scope_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.scopeCatalog),
      "scope_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.scopeSchema),
      "scope_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.scopeName),
      "maximum_cardinality" -> Writes.OptionWrites(Writes.IntWrites).writes(o.maximumCardinality),
      "dtd_identifier" -> Writes.OptionWrites(Writes.StringWrites).writes(o.dtdIdentifier),
      "is_self_referencing" -> Writes.OptionWrites(Writes.StringWrites).writes(o.isSelfReferencing),
      "is_identity" -> Writes.OptionWrites(Writes.StringWrites).writes(o.isIdentity),
      "identity_generation" -> Writes.OptionWrites(Writes.StringWrites).writes(o.identityGeneration),
      "identity_start" -> Writes.OptionWrites(Writes.StringWrites).writes(o.identityStart),
      "identity_increment" -> Writes.OptionWrites(Writes.StringWrites).writes(o.identityIncrement),
      "identity_maximum" -> Writes.OptionWrites(Writes.StringWrites).writes(o.identityMaximum),
      "identity_minimum" -> Writes.OptionWrites(Writes.StringWrites).writes(o.identityMinimum),
      "identity_cycle" -> Writes.OptionWrites(Writes.StringWrites).writes(o.identityCycle),
      "is_generated" -> Writes.OptionWrites(Writes.StringWrites).writes(o.isGenerated),
      "generation_expression" -> Writes.OptionWrites(Writes.StringWrites).writes(o.generationExpression),
      "is_updatable" -> Writes.OptionWrites(Writes.StringWrites).writes(o.isUpdatable)
    ))
  )
}
