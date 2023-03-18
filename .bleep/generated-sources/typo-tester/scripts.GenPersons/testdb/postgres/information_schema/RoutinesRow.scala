package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class RoutinesRow(
  specificCatalog: /* unknown nullability */ Option[String],
  specificSchema: /* unknown nullability */ Option[String],
  specificName: /* unknown nullability */ Option[String],
  routineCatalog: /* unknown nullability */ Option[String],
  routineSchema: /* unknown nullability */ Option[String],
  routineName: /* unknown nullability */ Option[String],
  routineType: /* unknown nullability */ Option[String],
  moduleCatalog: /* unknown nullability */ Option[String],
  moduleSchema: /* unknown nullability */ Option[String],
  moduleName: /* unknown nullability */ Option[String],
  udtCatalog: /* unknown nullability */ Option[String],
  udtSchema: /* unknown nullability */ Option[String],
  udtName: /* unknown nullability */ Option[String],
  dataType: /* unknown nullability */ Option[String],
  characterMaximumLength: /* unknown nullability */ Option[Int],
  characterOctetLength: /* unknown nullability */ Option[Int],
  characterSetCatalog: /* unknown nullability */ Option[String],
  characterSetSchema: /* unknown nullability */ Option[String],
  characterSetName: /* unknown nullability */ Option[String],
  collationCatalog: /* unknown nullability */ Option[String],
  collationSchema: /* unknown nullability */ Option[String],
  collationName: /* unknown nullability */ Option[String],
  numericPrecision: /* unknown nullability */ Option[Int],
  numericPrecisionRadix: /* unknown nullability */ Option[Int],
  numericScale: /* unknown nullability */ Option[Int],
  datetimePrecision: /* unknown nullability */ Option[Int],
  intervalType: /* unknown nullability */ Option[String],
  intervalPrecision: /* unknown nullability */ Option[Int],
  typeUdtCatalog: /* unknown nullability */ Option[String],
  typeUdtSchema: /* unknown nullability */ Option[String],
  typeUdtName: /* unknown nullability */ Option[String],
  scopeCatalog: /* unknown nullability */ Option[String],
  scopeSchema: /* unknown nullability */ Option[String],
  scopeName: /* unknown nullability */ Option[String],
  maximumCardinality: /* unknown nullability */ Option[Int],
  dtdIdentifier: /* unknown nullability */ Option[String],
  routineBody: /* unknown nullability */ Option[String],
  routineDefinition: /* unknown nullability */ Option[String],
  externalName: /* unknown nullability */ Option[String],
  externalLanguage: /* unknown nullability */ Option[String],
  parameterStyle: /* unknown nullability */ Option[String],
  isDeterministic: /* unknown nullability */ Option[String],
  sqlDataAccess: /* unknown nullability */ Option[String],
  isNullCall: /* unknown nullability */ Option[String],
  sqlPath: /* unknown nullability */ Option[String],
  schemaLevelRoutine: /* unknown nullability */ Option[String],
  maxDynamicResultSets: /* unknown nullability */ Option[Int],
  isUserDefinedCast: /* unknown nullability */ Option[String],
  isImplicitlyInvocable: /* unknown nullability */ Option[String],
  securityType: /* unknown nullability */ Option[String],
  toSqlSpecificCatalog: /* unknown nullability */ Option[String],
  toSqlSpecificSchema: /* unknown nullability */ Option[String],
  toSqlSpecificName: /* unknown nullability */ Option[String],
  asLocator: /* unknown nullability */ Option[String],
  created: /* unknown nullability */ Option[LocalDateTime],
  lastAltered: /* unknown nullability */ Option[LocalDateTime],
  newSavepointLevel: /* unknown nullability */ Option[String],
  isUdtDependent: /* unknown nullability */ Option[String],
  resultCastFromDataType: /* unknown nullability */ Option[String],
  resultCastAsLocator: /* unknown nullability */ Option[String],
  resultCastCharMaxLength: /* unknown nullability */ Option[Int],
  resultCastCharOctetLength: /* unknown nullability */ Option[Int],
  resultCastCharSetCatalog: /* unknown nullability */ Option[String],
  resultCastCharSetSchema: /* unknown nullability */ Option[String],
  resultCastCharSetName: /* unknown nullability */ Option[String],
  resultCastCollationCatalog: /* unknown nullability */ Option[String],
  resultCastCollationSchema: /* unknown nullability */ Option[String],
  resultCastCollationName: /* unknown nullability */ Option[String],
  resultCastNumericPrecision: /* unknown nullability */ Option[Int],
  resultCastNumericPrecisionRadix: /* unknown nullability */ Option[Int],
  resultCastNumericScale: /* unknown nullability */ Option[Int],
  resultCastDatetimePrecision: /* unknown nullability */ Option[Int],
  resultCastIntervalType: /* unknown nullability */ Option[String],
  resultCastIntervalPrecision: /* unknown nullability */ Option[Int],
  resultCastTypeUdtCatalog: /* unknown nullability */ Option[String],
  resultCastTypeUdtSchema: /* unknown nullability */ Option[String],
  resultCastTypeUdtName: /* unknown nullability */ Option[String],
  resultCastScopeCatalog: /* unknown nullability */ Option[String],
  resultCastScopeSchema: /* unknown nullability */ Option[String],
  resultCastScopeName: /* unknown nullability */ Option[String],
  resultCastMaximumCardinality: /* unknown nullability */ Option[Int],
  resultCastDtdIdentifier: /* unknown nullability */ Option[String]
)

object RoutinesRow {
  implicit val rowParser: RowParser[RoutinesRow] = { row =>
    Success(
      RoutinesRow(
        specificCatalog = row[/* unknown nullability */ Option[String]]("specific_catalog"),
        specificSchema = row[/* unknown nullability */ Option[String]]("specific_schema"),
        specificName = row[/* unknown nullability */ Option[String]]("specific_name"),
        routineCatalog = row[/* unknown nullability */ Option[String]]("routine_catalog"),
        routineSchema = row[/* unknown nullability */ Option[String]]("routine_schema"),
        routineName = row[/* unknown nullability */ Option[String]]("routine_name"),
        routineType = row[/* unknown nullability */ Option[String]]("routine_type"),
        moduleCatalog = row[/* unknown nullability */ Option[String]]("module_catalog"),
        moduleSchema = row[/* unknown nullability */ Option[String]]("module_schema"),
        moduleName = row[/* unknown nullability */ Option[String]]("module_name"),
        udtCatalog = row[/* unknown nullability */ Option[String]]("udt_catalog"),
        udtSchema = row[/* unknown nullability */ Option[String]]("udt_schema"),
        udtName = row[/* unknown nullability */ Option[String]]("udt_name"),
        dataType = row[/* unknown nullability */ Option[String]]("data_type"),
        characterMaximumLength = row[/* unknown nullability */ Option[Int]]("character_maximum_length"),
        characterOctetLength = row[/* unknown nullability */ Option[Int]]("character_octet_length"),
        characterSetCatalog = row[/* unknown nullability */ Option[String]]("character_set_catalog"),
        characterSetSchema = row[/* unknown nullability */ Option[String]]("character_set_schema"),
        characterSetName = row[/* unknown nullability */ Option[String]]("character_set_name"),
        collationCatalog = row[/* unknown nullability */ Option[String]]("collation_catalog"),
        collationSchema = row[/* unknown nullability */ Option[String]]("collation_schema"),
        collationName = row[/* unknown nullability */ Option[String]]("collation_name"),
        numericPrecision = row[/* unknown nullability */ Option[Int]]("numeric_precision"),
        numericPrecisionRadix = row[/* unknown nullability */ Option[Int]]("numeric_precision_radix"),
        numericScale = row[/* unknown nullability */ Option[Int]]("numeric_scale"),
        datetimePrecision = row[/* unknown nullability */ Option[Int]]("datetime_precision"),
        intervalType = row[/* unknown nullability */ Option[String]]("interval_type"),
        intervalPrecision = row[/* unknown nullability */ Option[Int]]("interval_precision"),
        typeUdtCatalog = row[/* unknown nullability */ Option[String]]("type_udt_catalog"),
        typeUdtSchema = row[/* unknown nullability */ Option[String]]("type_udt_schema"),
        typeUdtName = row[/* unknown nullability */ Option[String]]("type_udt_name"),
        scopeCatalog = row[/* unknown nullability */ Option[String]]("scope_catalog"),
        scopeSchema = row[/* unknown nullability */ Option[String]]("scope_schema"),
        scopeName = row[/* unknown nullability */ Option[String]]("scope_name"),
        maximumCardinality = row[/* unknown nullability */ Option[Int]]("maximum_cardinality"),
        dtdIdentifier = row[/* unknown nullability */ Option[String]]("dtd_identifier"),
        routineBody = row[/* unknown nullability */ Option[String]]("routine_body"),
        routineDefinition = row[/* unknown nullability */ Option[String]]("routine_definition"),
        externalName = row[/* unknown nullability */ Option[String]]("external_name"),
        externalLanguage = row[/* unknown nullability */ Option[String]]("external_language"),
        parameterStyle = row[/* unknown nullability */ Option[String]]("parameter_style"),
        isDeterministic = row[/* unknown nullability */ Option[String]]("is_deterministic"),
        sqlDataAccess = row[/* unknown nullability */ Option[String]]("sql_data_access"),
        isNullCall = row[/* unknown nullability */ Option[String]]("is_null_call"),
        sqlPath = row[/* unknown nullability */ Option[String]]("sql_path"),
        schemaLevelRoutine = row[/* unknown nullability */ Option[String]]("schema_level_routine"),
        maxDynamicResultSets = row[/* unknown nullability */ Option[Int]]("max_dynamic_result_sets"),
        isUserDefinedCast = row[/* unknown nullability */ Option[String]]("is_user_defined_cast"),
        isImplicitlyInvocable = row[/* unknown nullability */ Option[String]]("is_implicitly_invocable"),
        securityType = row[/* unknown nullability */ Option[String]]("security_type"),
        toSqlSpecificCatalog = row[/* unknown nullability */ Option[String]]("to_sql_specific_catalog"),
        toSqlSpecificSchema = row[/* unknown nullability */ Option[String]]("to_sql_specific_schema"),
        toSqlSpecificName = row[/* unknown nullability */ Option[String]]("to_sql_specific_name"),
        asLocator = row[/* unknown nullability */ Option[String]]("as_locator"),
        created = row[/* unknown nullability */ Option[LocalDateTime]]("created"),
        lastAltered = row[/* unknown nullability */ Option[LocalDateTime]]("last_altered"),
        newSavepointLevel = row[/* unknown nullability */ Option[String]]("new_savepoint_level"),
        isUdtDependent = row[/* unknown nullability */ Option[String]]("is_udt_dependent"),
        resultCastFromDataType = row[/* unknown nullability */ Option[String]]("result_cast_from_data_type"),
        resultCastAsLocator = row[/* unknown nullability */ Option[String]]("result_cast_as_locator"),
        resultCastCharMaxLength = row[/* unknown nullability */ Option[Int]]("result_cast_char_max_length"),
        resultCastCharOctetLength = row[/* unknown nullability */ Option[Int]]("result_cast_char_octet_length"),
        resultCastCharSetCatalog = row[/* unknown nullability */ Option[String]]("result_cast_char_set_catalog"),
        resultCastCharSetSchema = row[/* unknown nullability */ Option[String]]("result_cast_char_set_schema"),
        resultCastCharSetName = row[/* unknown nullability */ Option[String]]("result_cast_char_set_name"),
        resultCastCollationCatalog = row[/* unknown nullability */ Option[String]]("result_cast_collation_catalog"),
        resultCastCollationSchema = row[/* unknown nullability */ Option[String]]("result_cast_collation_schema"),
        resultCastCollationName = row[/* unknown nullability */ Option[String]]("result_cast_collation_name"),
        resultCastNumericPrecision = row[/* unknown nullability */ Option[Int]]("result_cast_numeric_precision"),
        resultCastNumericPrecisionRadix = row[/* unknown nullability */ Option[Int]]("result_cast_numeric_precision_radix"),
        resultCastNumericScale = row[/* unknown nullability */ Option[Int]]("result_cast_numeric_scale"),
        resultCastDatetimePrecision = row[/* unknown nullability */ Option[Int]]("result_cast_datetime_precision"),
        resultCastIntervalType = row[/* unknown nullability */ Option[String]]("result_cast_interval_type"),
        resultCastIntervalPrecision = row[/* unknown nullability */ Option[Int]]("result_cast_interval_precision"),
        resultCastTypeUdtCatalog = row[/* unknown nullability */ Option[String]]("result_cast_type_udt_catalog"),
        resultCastTypeUdtSchema = row[/* unknown nullability */ Option[String]]("result_cast_type_udt_schema"),
        resultCastTypeUdtName = row[/* unknown nullability */ Option[String]]("result_cast_type_udt_name"),
        resultCastScopeCatalog = row[/* unknown nullability */ Option[String]]("result_cast_scope_catalog"),
        resultCastScopeSchema = row[/* unknown nullability */ Option[String]]("result_cast_scope_schema"),
        resultCastScopeName = row[/* unknown nullability */ Option[String]]("result_cast_scope_name"),
        resultCastMaximumCardinality = row[/* unknown nullability */ Option[Int]]("result_cast_maximum_cardinality"),
        resultCastDtdIdentifier = row[/* unknown nullability */ Option[String]]("result_cast_dtd_identifier")
      )
    )
  }

  implicit val oFormat: OFormat[RoutinesRow] = new OFormat[RoutinesRow]{
    override def writes(o: RoutinesRow): JsObject =
      Json.obj(
        "specific_catalog" -> o.specificCatalog,
      "specific_schema" -> o.specificSchema,
      "specific_name" -> o.specificName,
      "routine_catalog" -> o.routineCatalog,
      "routine_schema" -> o.routineSchema,
      "routine_name" -> o.routineName,
      "routine_type" -> o.routineType,
      "module_catalog" -> o.moduleCatalog,
      "module_schema" -> o.moduleSchema,
      "module_name" -> o.moduleName,
      "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "data_type" -> o.dataType,
      "character_maximum_length" -> o.characterMaximumLength,
      "character_octet_length" -> o.characterOctetLength,
      "character_set_catalog" -> o.characterSetCatalog,
      "character_set_schema" -> o.characterSetSchema,
      "character_set_name" -> o.characterSetName,
      "collation_catalog" -> o.collationCatalog,
      "collation_schema" -> o.collationSchema,
      "collation_name" -> o.collationName,
      "numeric_precision" -> o.numericPrecision,
      "numeric_precision_radix" -> o.numericPrecisionRadix,
      "numeric_scale" -> o.numericScale,
      "datetime_precision" -> o.datetimePrecision,
      "interval_type" -> o.intervalType,
      "interval_precision" -> o.intervalPrecision,
      "type_udt_catalog" -> o.typeUdtCatalog,
      "type_udt_schema" -> o.typeUdtSchema,
      "type_udt_name" -> o.typeUdtName,
      "scope_catalog" -> o.scopeCatalog,
      "scope_schema" -> o.scopeSchema,
      "scope_name" -> o.scopeName,
      "maximum_cardinality" -> o.maximumCardinality,
      "dtd_identifier" -> o.dtdIdentifier,
      "routine_body" -> o.routineBody,
      "routine_definition" -> o.routineDefinition,
      "external_name" -> o.externalName,
      "external_language" -> o.externalLanguage,
      "parameter_style" -> o.parameterStyle,
      "is_deterministic" -> o.isDeterministic,
      "sql_data_access" -> o.sqlDataAccess,
      "is_null_call" -> o.isNullCall,
      "sql_path" -> o.sqlPath,
      "schema_level_routine" -> o.schemaLevelRoutine,
      "max_dynamic_result_sets" -> o.maxDynamicResultSets,
      "is_user_defined_cast" -> o.isUserDefinedCast,
      "is_implicitly_invocable" -> o.isImplicitlyInvocable,
      "security_type" -> o.securityType,
      "to_sql_specific_catalog" -> o.toSqlSpecificCatalog,
      "to_sql_specific_schema" -> o.toSqlSpecificSchema,
      "to_sql_specific_name" -> o.toSqlSpecificName,
      "as_locator" -> o.asLocator,
      "created" -> o.created,
      "last_altered" -> o.lastAltered,
      "new_savepoint_level" -> o.newSavepointLevel,
      "is_udt_dependent" -> o.isUdtDependent,
      "result_cast_from_data_type" -> o.resultCastFromDataType,
      "result_cast_as_locator" -> o.resultCastAsLocator,
      "result_cast_char_max_length" -> o.resultCastCharMaxLength,
      "result_cast_char_octet_length" -> o.resultCastCharOctetLength,
      "result_cast_char_set_catalog" -> o.resultCastCharSetCatalog,
      "result_cast_char_set_schema" -> o.resultCastCharSetSchema,
      "result_cast_char_set_name" -> o.resultCastCharSetName,
      "result_cast_collation_catalog" -> o.resultCastCollationCatalog,
      "result_cast_collation_schema" -> o.resultCastCollationSchema,
      "result_cast_collation_name" -> o.resultCastCollationName,
      "result_cast_numeric_precision" -> o.resultCastNumericPrecision,
      "result_cast_numeric_precision_radix" -> o.resultCastNumericPrecisionRadix,
      "result_cast_numeric_scale" -> o.resultCastNumericScale,
      "result_cast_datetime_precision" -> o.resultCastDatetimePrecision,
      "result_cast_interval_type" -> o.resultCastIntervalType,
      "result_cast_interval_precision" -> o.resultCastIntervalPrecision,
      "result_cast_type_udt_catalog" -> o.resultCastTypeUdtCatalog,
      "result_cast_type_udt_schema" -> o.resultCastTypeUdtSchema,
      "result_cast_type_udt_name" -> o.resultCastTypeUdtName,
      "result_cast_scope_catalog" -> o.resultCastScopeCatalog,
      "result_cast_scope_schema" -> o.resultCastScopeSchema,
      "result_cast_scope_name" -> o.resultCastScopeName,
      "result_cast_maximum_cardinality" -> o.resultCastMaximumCardinality,
      "result_cast_dtd_identifier" -> o.resultCastDtdIdentifier
      )

    override def reads(json: JsValue): JsResult[RoutinesRow] = {
      JsResult.fromTry(
        Try(
          RoutinesRow(
            specificCatalog = json.\("specific_catalog").toOption.map(_.as[String]),
            specificSchema = json.\("specific_schema").toOption.map(_.as[String]),
            specificName = json.\("specific_name").toOption.map(_.as[String]),
            routineCatalog = json.\("routine_catalog").toOption.map(_.as[String]),
            routineSchema = json.\("routine_schema").toOption.map(_.as[String]),
            routineName = json.\("routine_name").toOption.map(_.as[String]),
            routineType = json.\("routine_type").toOption.map(_.as[String]),
            moduleCatalog = json.\("module_catalog").toOption.map(_.as[String]),
            moduleSchema = json.\("module_schema").toOption.map(_.as[String]),
            moduleName = json.\("module_name").toOption.map(_.as[String]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            dataType = json.\("data_type").toOption.map(_.as[String]),
            characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as[Int]),
            characterOctetLength = json.\("character_octet_length").toOption.map(_.as[Int]),
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[String]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[String]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[String]),
            collationCatalog = json.\("collation_catalog").toOption.map(_.as[String]),
            collationSchema = json.\("collation_schema").toOption.map(_.as[String]),
            collationName = json.\("collation_name").toOption.map(_.as[String]),
            numericPrecision = json.\("numeric_precision").toOption.map(_.as[Int]),
            numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as[Int]),
            numericScale = json.\("numeric_scale").toOption.map(_.as[Int]),
            datetimePrecision = json.\("datetime_precision").toOption.map(_.as[Int]),
            intervalType = json.\("interval_type").toOption.map(_.as[String]),
            intervalPrecision = json.\("interval_precision").toOption.map(_.as[Int]),
            typeUdtCatalog = json.\("type_udt_catalog").toOption.map(_.as[String]),
            typeUdtSchema = json.\("type_udt_schema").toOption.map(_.as[String]),
            typeUdtName = json.\("type_udt_name").toOption.map(_.as[String]),
            scopeCatalog = json.\("scope_catalog").toOption.map(_.as[String]),
            scopeSchema = json.\("scope_schema").toOption.map(_.as[String]),
            scopeName = json.\("scope_name").toOption.map(_.as[String]),
            maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as[Int]),
            dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[String]),
            routineBody = json.\("routine_body").toOption.map(_.as[String]),
            routineDefinition = json.\("routine_definition").toOption.map(_.as[String]),
            externalName = json.\("external_name").toOption.map(_.as[String]),
            externalLanguage = json.\("external_language").toOption.map(_.as[String]),
            parameterStyle = json.\("parameter_style").toOption.map(_.as[String]),
            isDeterministic = json.\("is_deterministic").toOption.map(_.as[String]),
            sqlDataAccess = json.\("sql_data_access").toOption.map(_.as[String]),
            isNullCall = json.\("is_null_call").toOption.map(_.as[String]),
            sqlPath = json.\("sql_path").toOption.map(_.as[String]),
            schemaLevelRoutine = json.\("schema_level_routine").toOption.map(_.as[String]),
            maxDynamicResultSets = json.\("max_dynamic_result_sets").toOption.map(_.as[Int]),
            isUserDefinedCast = json.\("is_user_defined_cast").toOption.map(_.as[String]),
            isImplicitlyInvocable = json.\("is_implicitly_invocable").toOption.map(_.as[String]),
            securityType = json.\("security_type").toOption.map(_.as[String]),
            toSqlSpecificCatalog = json.\("to_sql_specific_catalog").toOption.map(_.as[String]),
            toSqlSpecificSchema = json.\("to_sql_specific_schema").toOption.map(_.as[String]),
            toSqlSpecificName = json.\("to_sql_specific_name").toOption.map(_.as[String]),
            asLocator = json.\("as_locator").toOption.map(_.as[String]),
            created = json.\("created").toOption.map(_.as[LocalDateTime]),
            lastAltered = json.\("last_altered").toOption.map(_.as[LocalDateTime]),
            newSavepointLevel = json.\("new_savepoint_level").toOption.map(_.as[String]),
            isUdtDependent = json.\("is_udt_dependent").toOption.map(_.as[String]),
            resultCastFromDataType = json.\("result_cast_from_data_type").toOption.map(_.as[String]),
            resultCastAsLocator = json.\("result_cast_as_locator").toOption.map(_.as[String]),
            resultCastCharMaxLength = json.\("result_cast_char_max_length").toOption.map(_.as[Int]),
            resultCastCharOctetLength = json.\("result_cast_char_octet_length").toOption.map(_.as[Int]),
            resultCastCharSetCatalog = json.\("result_cast_char_set_catalog").toOption.map(_.as[String]),
            resultCastCharSetSchema = json.\("result_cast_char_set_schema").toOption.map(_.as[String]),
            resultCastCharSetName = json.\("result_cast_char_set_name").toOption.map(_.as[String]),
            resultCastCollationCatalog = json.\("result_cast_collation_catalog").toOption.map(_.as[String]),
            resultCastCollationSchema = json.\("result_cast_collation_schema").toOption.map(_.as[String]),
            resultCastCollationName = json.\("result_cast_collation_name").toOption.map(_.as[String]),
            resultCastNumericPrecision = json.\("result_cast_numeric_precision").toOption.map(_.as[Int]),
            resultCastNumericPrecisionRadix = json.\("result_cast_numeric_precision_radix").toOption.map(_.as[Int]),
            resultCastNumericScale = json.\("result_cast_numeric_scale").toOption.map(_.as[Int]),
            resultCastDatetimePrecision = json.\("result_cast_datetime_precision").toOption.map(_.as[Int]),
            resultCastIntervalType = json.\("result_cast_interval_type").toOption.map(_.as[String]),
            resultCastIntervalPrecision = json.\("result_cast_interval_precision").toOption.map(_.as[Int]),
            resultCastTypeUdtCatalog = json.\("result_cast_type_udt_catalog").toOption.map(_.as[String]),
            resultCastTypeUdtSchema = json.\("result_cast_type_udt_schema").toOption.map(_.as[String]),
            resultCastTypeUdtName = json.\("result_cast_type_udt_name").toOption.map(_.as[String]),
            resultCastScopeCatalog = json.\("result_cast_scope_catalog").toOption.map(_.as[String]),
            resultCastScopeSchema = json.\("result_cast_scope_schema").toOption.map(_.as[String]),
            resultCastScopeName = json.\("result_cast_scope_name").toOption.map(_.as[String]),
            resultCastMaximumCardinality = json.\("result_cast_maximum_cardinality").toOption.map(_.as[Int]),
            resultCastDtdIdentifier = json.\("result_cast_dtd_identifier").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}