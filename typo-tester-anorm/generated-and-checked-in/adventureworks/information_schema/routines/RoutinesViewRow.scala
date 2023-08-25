/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routines

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.TimeStamp
import adventureworks.information_schema.YesOrNo
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class RoutinesViewRow(
  specificCatalog: SqlIdentifier,
  specificSchema: SqlIdentifier,
  specificName: SqlIdentifier,
  routineCatalog: SqlIdentifier,
  routineSchema: SqlIdentifier,
  routineName: SqlIdentifier,
  routineType: CharacterData,
  moduleCatalog: SqlIdentifier,
  moduleSchema: SqlIdentifier,
  moduleName: SqlIdentifier,
  udtCatalog: SqlIdentifier,
  udtSchema: SqlIdentifier,
  udtName: SqlIdentifier,
  dataType: CharacterData,
  characterMaximumLength: CardinalNumber,
  characterOctetLength: CardinalNumber,
  characterSetCatalog: SqlIdentifier,
  characterSetSchema: SqlIdentifier,
  characterSetName: SqlIdentifier,
  collationCatalog: SqlIdentifier,
  collationSchema: SqlIdentifier,
  collationName: SqlIdentifier,
  numericPrecision: CardinalNumber,
  numericPrecisionRadix: CardinalNumber,
  numericScale: CardinalNumber,
  datetimePrecision: CardinalNumber,
  intervalType: CharacterData,
  intervalPrecision: CardinalNumber,
  typeUdtCatalog: SqlIdentifier,
  typeUdtSchema: SqlIdentifier,
  typeUdtName: SqlIdentifier,
  scopeCatalog: SqlIdentifier,
  scopeSchema: SqlIdentifier,
  scopeName: SqlIdentifier,
  maximumCardinality: CardinalNumber,
  dtdIdentifier: SqlIdentifier,
  routineBody: CharacterData,
  routineDefinition: CharacterData,
  externalName: CharacterData,
  externalLanguage: CharacterData,
  parameterStyle: CharacterData,
  isDeterministic: YesOrNo,
  sqlDataAccess: CharacterData,
  isNullCall: YesOrNo,
  sqlPath: CharacterData,
  schemaLevelRoutine: YesOrNo,
  maxDynamicResultSets: CardinalNumber,
  isUserDefinedCast: YesOrNo,
  isImplicitlyInvocable: YesOrNo,
  securityType: CharacterData,
  toSqlSpecificCatalog: SqlIdentifier,
  toSqlSpecificSchema: SqlIdentifier,
  toSqlSpecificName: SqlIdentifier,
  asLocator: YesOrNo,
  created: TimeStamp,
  lastAltered: TimeStamp,
  newSavepointLevel: YesOrNo,
  isUdtDependent: YesOrNo,
  resultCastFromDataType: CharacterData,
  resultCastAsLocator: YesOrNo,
  resultCastCharMaxLength: CardinalNumber,
  resultCastCharOctetLength: CardinalNumber,
  resultCastCharSetCatalog: SqlIdentifier,
  resultCastCharSetSchema: SqlIdentifier,
  resultCastCharSetName: SqlIdentifier,
  resultCastCollationCatalog: SqlIdentifier,
  resultCastCollationSchema: SqlIdentifier,
  resultCastCollationName: SqlIdentifier,
  resultCastNumericPrecision: CardinalNumber,
  resultCastNumericPrecisionRadix: CardinalNumber,
  resultCastNumericScale: CardinalNumber,
  resultCastDatetimePrecision: CardinalNumber,
  resultCastIntervalType: CharacterData,
  resultCastIntervalPrecision: CardinalNumber,
  resultCastTypeUdtCatalog: SqlIdentifier,
  resultCastTypeUdtSchema: SqlIdentifier,
  resultCastTypeUdtName: SqlIdentifier,
  resultCastScopeCatalog: SqlIdentifier,
  resultCastScopeSchema: SqlIdentifier,
  resultCastScopeName: SqlIdentifier,
  resultCastMaximumCardinality: CardinalNumber,
  resultCastDtdIdentifier: SqlIdentifier
)

object RoutinesViewRow {
  implicit lazy val reads: Reads[RoutinesViewRow] = Reads[RoutinesViewRow](json => JsResult.fromTry(
      Try(
        RoutinesViewRow(
          specificCatalog = json.\("specific_catalog").as(SqlIdentifier.reads),
          specificSchema = json.\("specific_schema").as(SqlIdentifier.reads),
          specificName = json.\("specific_name").as(SqlIdentifier.reads),
          routineCatalog = json.\("routine_catalog").as(SqlIdentifier.reads),
          routineSchema = json.\("routine_schema").as(SqlIdentifier.reads),
          routineName = json.\("routine_name").as(SqlIdentifier.reads),
          routineType = json.\("routine_type").as(CharacterData.reads),
          moduleCatalog = json.\("module_catalog").as(SqlIdentifier.reads),
          moduleSchema = json.\("module_schema").as(SqlIdentifier.reads),
          moduleName = json.\("module_name").as(SqlIdentifier.reads),
          udtCatalog = json.\("udt_catalog").as(SqlIdentifier.reads),
          udtSchema = json.\("udt_schema").as(SqlIdentifier.reads),
          udtName = json.\("udt_name").as(SqlIdentifier.reads),
          dataType = json.\("data_type").as(CharacterData.reads),
          characterMaximumLength = json.\("character_maximum_length").as(CardinalNumber.reads),
          characterOctetLength = json.\("character_octet_length").as(CardinalNumber.reads),
          characterSetCatalog = json.\("character_set_catalog").as(SqlIdentifier.reads),
          characterSetSchema = json.\("character_set_schema").as(SqlIdentifier.reads),
          characterSetName = json.\("character_set_name").as(SqlIdentifier.reads),
          collationCatalog = json.\("collation_catalog").as(SqlIdentifier.reads),
          collationSchema = json.\("collation_schema").as(SqlIdentifier.reads),
          collationName = json.\("collation_name").as(SqlIdentifier.reads),
          numericPrecision = json.\("numeric_precision").as(CardinalNumber.reads),
          numericPrecisionRadix = json.\("numeric_precision_radix").as(CardinalNumber.reads),
          numericScale = json.\("numeric_scale").as(CardinalNumber.reads),
          datetimePrecision = json.\("datetime_precision").as(CardinalNumber.reads),
          intervalType = json.\("interval_type").as(CharacterData.reads),
          intervalPrecision = json.\("interval_precision").as(CardinalNumber.reads),
          typeUdtCatalog = json.\("type_udt_catalog").as(SqlIdentifier.reads),
          typeUdtSchema = json.\("type_udt_schema").as(SqlIdentifier.reads),
          typeUdtName = json.\("type_udt_name").as(SqlIdentifier.reads),
          scopeCatalog = json.\("scope_catalog").as(SqlIdentifier.reads),
          scopeSchema = json.\("scope_schema").as(SqlIdentifier.reads),
          scopeName = json.\("scope_name").as(SqlIdentifier.reads),
          maximumCardinality = json.\("maximum_cardinality").as(CardinalNumber.reads),
          dtdIdentifier = json.\("dtd_identifier").as(SqlIdentifier.reads),
          routineBody = json.\("routine_body").as(CharacterData.reads),
          routineDefinition = json.\("routine_definition").as(CharacterData.reads),
          externalName = json.\("external_name").as(CharacterData.reads),
          externalLanguage = json.\("external_language").as(CharacterData.reads),
          parameterStyle = json.\("parameter_style").as(CharacterData.reads),
          isDeterministic = json.\("is_deterministic").as(YesOrNo.reads),
          sqlDataAccess = json.\("sql_data_access").as(CharacterData.reads),
          isNullCall = json.\("is_null_call").as(YesOrNo.reads),
          sqlPath = json.\("sql_path").as(CharacterData.reads),
          schemaLevelRoutine = json.\("schema_level_routine").as(YesOrNo.reads),
          maxDynamicResultSets = json.\("max_dynamic_result_sets").as(CardinalNumber.reads),
          isUserDefinedCast = json.\("is_user_defined_cast").as(YesOrNo.reads),
          isImplicitlyInvocable = json.\("is_implicitly_invocable").as(YesOrNo.reads),
          securityType = json.\("security_type").as(CharacterData.reads),
          toSqlSpecificCatalog = json.\("to_sql_specific_catalog").as(SqlIdentifier.reads),
          toSqlSpecificSchema = json.\("to_sql_specific_schema").as(SqlIdentifier.reads),
          toSqlSpecificName = json.\("to_sql_specific_name").as(SqlIdentifier.reads),
          asLocator = json.\("as_locator").as(YesOrNo.reads),
          created = json.\("created").as(TimeStamp.reads),
          lastAltered = json.\("last_altered").as(TimeStamp.reads),
          newSavepointLevel = json.\("new_savepoint_level").as(YesOrNo.reads),
          isUdtDependent = json.\("is_udt_dependent").as(YesOrNo.reads),
          resultCastFromDataType = json.\("result_cast_from_data_type").as(CharacterData.reads),
          resultCastAsLocator = json.\("result_cast_as_locator").as(YesOrNo.reads),
          resultCastCharMaxLength = json.\("result_cast_char_max_length").as(CardinalNumber.reads),
          resultCastCharOctetLength = json.\("result_cast_char_octet_length").as(CardinalNumber.reads),
          resultCastCharSetCatalog = json.\("result_cast_char_set_catalog").as(SqlIdentifier.reads),
          resultCastCharSetSchema = json.\("result_cast_char_set_schema").as(SqlIdentifier.reads),
          resultCastCharSetName = json.\("result_cast_char_set_name").as(SqlIdentifier.reads),
          resultCastCollationCatalog = json.\("result_cast_collation_catalog").as(SqlIdentifier.reads),
          resultCastCollationSchema = json.\("result_cast_collation_schema").as(SqlIdentifier.reads),
          resultCastCollationName = json.\("result_cast_collation_name").as(SqlIdentifier.reads),
          resultCastNumericPrecision = json.\("result_cast_numeric_precision").as(CardinalNumber.reads),
          resultCastNumericPrecisionRadix = json.\("result_cast_numeric_precision_radix").as(CardinalNumber.reads),
          resultCastNumericScale = json.\("result_cast_numeric_scale").as(CardinalNumber.reads),
          resultCastDatetimePrecision = json.\("result_cast_datetime_precision").as(CardinalNumber.reads),
          resultCastIntervalType = json.\("result_cast_interval_type").as(CharacterData.reads),
          resultCastIntervalPrecision = json.\("result_cast_interval_precision").as(CardinalNumber.reads),
          resultCastTypeUdtCatalog = json.\("result_cast_type_udt_catalog").as(SqlIdentifier.reads),
          resultCastTypeUdtSchema = json.\("result_cast_type_udt_schema").as(SqlIdentifier.reads),
          resultCastTypeUdtName = json.\("result_cast_type_udt_name").as(SqlIdentifier.reads),
          resultCastScopeCatalog = json.\("result_cast_scope_catalog").as(SqlIdentifier.reads),
          resultCastScopeSchema = json.\("result_cast_scope_schema").as(SqlIdentifier.reads),
          resultCastScopeName = json.\("result_cast_scope_name").as(SqlIdentifier.reads),
          resultCastMaximumCardinality = json.\("result_cast_maximum_cardinality").as(CardinalNumber.reads),
          resultCastDtdIdentifier = json.\("result_cast_dtd_identifier").as(SqlIdentifier.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[RoutinesViewRow] = RowParser[RoutinesViewRow] { row =>
    Success(
      RoutinesViewRow(
        specificCatalog = row(idx + 0)(SqlIdentifier.column),
        specificSchema = row(idx + 1)(SqlIdentifier.column),
        specificName = row(idx + 2)(SqlIdentifier.column),
        routineCatalog = row(idx + 3)(SqlIdentifier.column),
        routineSchema = row(idx + 4)(SqlIdentifier.column),
        routineName = row(idx + 5)(SqlIdentifier.column),
        routineType = row(idx + 6)(CharacterData.column),
        moduleCatalog = row(idx + 7)(SqlIdentifier.column),
        moduleSchema = row(idx + 8)(SqlIdentifier.column),
        moduleName = row(idx + 9)(SqlIdentifier.column),
        udtCatalog = row(idx + 10)(SqlIdentifier.column),
        udtSchema = row(idx + 11)(SqlIdentifier.column),
        udtName = row(idx + 12)(SqlIdentifier.column),
        dataType = row(idx + 13)(CharacterData.column),
        characterMaximumLength = row(idx + 14)(CardinalNumber.column),
        characterOctetLength = row(idx + 15)(CardinalNumber.column),
        characterSetCatalog = row(idx + 16)(SqlIdentifier.column),
        characterSetSchema = row(idx + 17)(SqlIdentifier.column),
        characterSetName = row(idx + 18)(SqlIdentifier.column),
        collationCatalog = row(idx + 19)(SqlIdentifier.column),
        collationSchema = row(idx + 20)(SqlIdentifier.column),
        collationName = row(idx + 21)(SqlIdentifier.column),
        numericPrecision = row(idx + 22)(CardinalNumber.column),
        numericPrecisionRadix = row(idx + 23)(CardinalNumber.column),
        numericScale = row(idx + 24)(CardinalNumber.column),
        datetimePrecision = row(idx + 25)(CardinalNumber.column),
        intervalType = row(idx + 26)(CharacterData.column),
        intervalPrecision = row(idx + 27)(CardinalNumber.column),
        typeUdtCatalog = row(idx + 28)(SqlIdentifier.column),
        typeUdtSchema = row(idx + 29)(SqlIdentifier.column),
        typeUdtName = row(idx + 30)(SqlIdentifier.column),
        scopeCatalog = row(idx + 31)(SqlIdentifier.column),
        scopeSchema = row(idx + 32)(SqlIdentifier.column),
        scopeName = row(idx + 33)(SqlIdentifier.column),
        maximumCardinality = row(idx + 34)(CardinalNumber.column),
        dtdIdentifier = row(idx + 35)(SqlIdentifier.column),
        routineBody = row(idx + 36)(CharacterData.column),
        routineDefinition = row(idx + 37)(CharacterData.column),
        externalName = row(idx + 38)(CharacterData.column),
        externalLanguage = row(idx + 39)(CharacterData.column),
        parameterStyle = row(idx + 40)(CharacterData.column),
        isDeterministic = row(idx + 41)(YesOrNo.column),
        sqlDataAccess = row(idx + 42)(CharacterData.column),
        isNullCall = row(idx + 43)(YesOrNo.column),
        sqlPath = row(idx + 44)(CharacterData.column),
        schemaLevelRoutine = row(idx + 45)(YesOrNo.column),
        maxDynamicResultSets = row(idx + 46)(CardinalNumber.column),
        isUserDefinedCast = row(idx + 47)(YesOrNo.column),
        isImplicitlyInvocable = row(idx + 48)(YesOrNo.column),
        securityType = row(idx + 49)(CharacterData.column),
        toSqlSpecificCatalog = row(idx + 50)(SqlIdentifier.column),
        toSqlSpecificSchema = row(idx + 51)(SqlIdentifier.column),
        toSqlSpecificName = row(idx + 52)(SqlIdentifier.column),
        asLocator = row(idx + 53)(YesOrNo.column),
        created = row(idx + 54)(TimeStamp.column),
        lastAltered = row(idx + 55)(TimeStamp.column),
        newSavepointLevel = row(idx + 56)(YesOrNo.column),
        isUdtDependent = row(idx + 57)(YesOrNo.column),
        resultCastFromDataType = row(idx + 58)(CharacterData.column),
        resultCastAsLocator = row(idx + 59)(YesOrNo.column),
        resultCastCharMaxLength = row(idx + 60)(CardinalNumber.column),
        resultCastCharOctetLength = row(idx + 61)(CardinalNumber.column),
        resultCastCharSetCatalog = row(idx + 62)(SqlIdentifier.column),
        resultCastCharSetSchema = row(idx + 63)(SqlIdentifier.column),
        resultCastCharSetName = row(idx + 64)(SqlIdentifier.column),
        resultCastCollationCatalog = row(idx + 65)(SqlIdentifier.column),
        resultCastCollationSchema = row(idx + 66)(SqlIdentifier.column),
        resultCastCollationName = row(idx + 67)(SqlIdentifier.column),
        resultCastNumericPrecision = row(idx + 68)(CardinalNumber.column),
        resultCastNumericPrecisionRadix = row(idx + 69)(CardinalNumber.column),
        resultCastNumericScale = row(idx + 70)(CardinalNumber.column),
        resultCastDatetimePrecision = row(idx + 71)(CardinalNumber.column),
        resultCastIntervalType = row(idx + 72)(CharacterData.column),
        resultCastIntervalPrecision = row(idx + 73)(CardinalNumber.column),
        resultCastTypeUdtCatalog = row(idx + 74)(SqlIdentifier.column),
        resultCastTypeUdtSchema = row(idx + 75)(SqlIdentifier.column),
        resultCastTypeUdtName = row(idx + 76)(SqlIdentifier.column),
        resultCastScopeCatalog = row(idx + 77)(SqlIdentifier.column),
        resultCastScopeSchema = row(idx + 78)(SqlIdentifier.column),
        resultCastScopeName = row(idx + 79)(SqlIdentifier.column),
        resultCastMaximumCardinality = row(idx + 80)(CardinalNumber.column),
        resultCastDtdIdentifier = row(idx + 81)(SqlIdentifier.column)
      )
    )
  }
  implicit lazy val writes: OWrites[RoutinesViewRow] = OWrites[RoutinesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "specific_catalog" -> SqlIdentifier.writes.writes(o.specificCatalog),
      "specific_schema" -> SqlIdentifier.writes.writes(o.specificSchema),
      "specific_name" -> SqlIdentifier.writes.writes(o.specificName),
      "routine_catalog" -> SqlIdentifier.writes.writes(o.routineCatalog),
      "routine_schema" -> SqlIdentifier.writes.writes(o.routineSchema),
      "routine_name" -> SqlIdentifier.writes.writes(o.routineName),
      "routine_type" -> CharacterData.writes.writes(o.routineType),
      "module_catalog" -> SqlIdentifier.writes.writes(o.moduleCatalog),
      "module_schema" -> SqlIdentifier.writes.writes(o.moduleSchema),
      "module_name" -> SqlIdentifier.writes.writes(o.moduleName),
      "udt_catalog" -> SqlIdentifier.writes.writes(o.udtCatalog),
      "udt_schema" -> SqlIdentifier.writes.writes(o.udtSchema),
      "udt_name" -> SqlIdentifier.writes.writes(o.udtName),
      "data_type" -> CharacterData.writes.writes(o.dataType),
      "character_maximum_length" -> CardinalNumber.writes.writes(o.characterMaximumLength),
      "character_octet_length" -> CardinalNumber.writes.writes(o.characterOctetLength),
      "character_set_catalog" -> SqlIdentifier.writes.writes(o.characterSetCatalog),
      "character_set_schema" -> SqlIdentifier.writes.writes(o.characterSetSchema),
      "character_set_name" -> SqlIdentifier.writes.writes(o.characterSetName),
      "collation_catalog" -> SqlIdentifier.writes.writes(o.collationCatalog),
      "collation_schema" -> SqlIdentifier.writes.writes(o.collationSchema),
      "collation_name" -> SqlIdentifier.writes.writes(o.collationName),
      "numeric_precision" -> CardinalNumber.writes.writes(o.numericPrecision),
      "numeric_precision_radix" -> CardinalNumber.writes.writes(o.numericPrecisionRadix),
      "numeric_scale" -> CardinalNumber.writes.writes(o.numericScale),
      "datetime_precision" -> CardinalNumber.writes.writes(o.datetimePrecision),
      "interval_type" -> CharacterData.writes.writes(o.intervalType),
      "interval_precision" -> CardinalNumber.writes.writes(o.intervalPrecision),
      "type_udt_catalog" -> SqlIdentifier.writes.writes(o.typeUdtCatalog),
      "type_udt_schema" -> SqlIdentifier.writes.writes(o.typeUdtSchema),
      "type_udt_name" -> SqlIdentifier.writes.writes(o.typeUdtName),
      "scope_catalog" -> SqlIdentifier.writes.writes(o.scopeCatalog),
      "scope_schema" -> SqlIdentifier.writes.writes(o.scopeSchema),
      "scope_name" -> SqlIdentifier.writes.writes(o.scopeName),
      "maximum_cardinality" -> CardinalNumber.writes.writes(o.maximumCardinality),
      "dtd_identifier" -> SqlIdentifier.writes.writes(o.dtdIdentifier),
      "routine_body" -> CharacterData.writes.writes(o.routineBody),
      "routine_definition" -> CharacterData.writes.writes(o.routineDefinition),
      "external_name" -> CharacterData.writes.writes(o.externalName),
      "external_language" -> CharacterData.writes.writes(o.externalLanguage),
      "parameter_style" -> CharacterData.writes.writes(o.parameterStyle),
      "is_deterministic" -> YesOrNo.writes.writes(o.isDeterministic),
      "sql_data_access" -> CharacterData.writes.writes(o.sqlDataAccess),
      "is_null_call" -> YesOrNo.writes.writes(o.isNullCall),
      "sql_path" -> CharacterData.writes.writes(o.sqlPath),
      "schema_level_routine" -> YesOrNo.writes.writes(o.schemaLevelRoutine),
      "max_dynamic_result_sets" -> CardinalNumber.writes.writes(o.maxDynamicResultSets),
      "is_user_defined_cast" -> YesOrNo.writes.writes(o.isUserDefinedCast),
      "is_implicitly_invocable" -> YesOrNo.writes.writes(o.isImplicitlyInvocable),
      "security_type" -> CharacterData.writes.writes(o.securityType),
      "to_sql_specific_catalog" -> SqlIdentifier.writes.writes(o.toSqlSpecificCatalog),
      "to_sql_specific_schema" -> SqlIdentifier.writes.writes(o.toSqlSpecificSchema),
      "to_sql_specific_name" -> SqlIdentifier.writes.writes(o.toSqlSpecificName),
      "as_locator" -> YesOrNo.writes.writes(o.asLocator),
      "created" -> TimeStamp.writes.writes(o.created),
      "last_altered" -> TimeStamp.writes.writes(o.lastAltered),
      "new_savepoint_level" -> YesOrNo.writes.writes(o.newSavepointLevel),
      "is_udt_dependent" -> YesOrNo.writes.writes(o.isUdtDependent),
      "result_cast_from_data_type" -> CharacterData.writes.writes(o.resultCastFromDataType),
      "result_cast_as_locator" -> YesOrNo.writes.writes(o.resultCastAsLocator),
      "result_cast_char_max_length" -> CardinalNumber.writes.writes(o.resultCastCharMaxLength),
      "result_cast_char_octet_length" -> CardinalNumber.writes.writes(o.resultCastCharOctetLength),
      "result_cast_char_set_catalog" -> SqlIdentifier.writes.writes(o.resultCastCharSetCatalog),
      "result_cast_char_set_schema" -> SqlIdentifier.writes.writes(o.resultCastCharSetSchema),
      "result_cast_char_set_name" -> SqlIdentifier.writes.writes(o.resultCastCharSetName),
      "result_cast_collation_catalog" -> SqlIdentifier.writes.writes(o.resultCastCollationCatalog),
      "result_cast_collation_schema" -> SqlIdentifier.writes.writes(o.resultCastCollationSchema),
      "result_cast_collation_name" -> SqlIdentifier.writes.writes(o.resultCastCollationName),
      "result_cast_numeric_precision" -> CardinalNumber.writes.writes(o.resultCastNumericPrecision),
      "result_cast_numeric_precision_radix" -> CardinalNumber.writes.writes(o.resultCastNumericPrecisionRadix),
      "result_cast_numeric_scale" -> CardinalNumber.writes.writes(o.resultCastNumericScale),
      "result_cast_datetime_precision" -> CardinalNumber.writes.writes(o.resultCastDatetimePrecision),
      "result_cast_interval_type" -> CharacterData.writes.writes(o.resultCastIntervalType),
      "result_cast_interval_precision" -> CardinalNumber.writes.writes(o.resultCastIntervalPrecision),
      "result_cast_type_udt_catalog" -> SqlIdentifier.writes.writes(o.resultCastTypeUdtCatalog),
      "result_cast_type_udt_schema" -> SqlIdentifier.writes.writes(o.resultCastTypeUdtSchema),
      "result_cast_type_udt_name" -> SqlIdentifier.writes.writes(o.resultCastTypeUdtName),
      "result_cast_scope_catalog" -> SqlIdentifier.writes.writes(o.resultCastScopeCatalog),
      "result_cast_scope_schema" -> SqlIdentifier.writes.writes(o.resultCastScopeSchema),
      "result_cast_scope_name" -> SqlIdentifier.writes.writes(o.resultCastScopeName),
      "result_cast_maximum_cardinality" -> CardinalNumber.writes.writes(o.resultCastMaximumCardinality),
      "result_cast_dtd_identifier" -> SqlIdentifier.writes.writes(o.resultCastDtdIdentifier)
    ))
  )
}
