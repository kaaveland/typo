/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routines

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object RoutinesViewRepoImpl extends RoutinesViewRepo {
  override def select: SelectBuilder[RoutinesViewFields, RoutinesViewRow] = {
    SelectBuilderSql("information_schema.routines", RoutinesViewFields, RoutinesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, RoutinesViewRow] = {
    sql"""select "specific_catalog", "specific_schema", "specific_name", "routine_catalog", "routine_schema", "routine_name", "routine_type", "module_catalog", "module_schema", "module_name", "udt_catalog", "udt_schema", "udt_name", "data_type", "character_maximum_length", "character_octet_length", "character_set_catalog", "character_set_schema", "character_set_name", "collation_catalog", "collation_schema", "collation_name", "numeric_precision", "numeric_precision_radix", "numeric_scale", "datetime_precision", "interval_type", "interval_precision", "type_udt_catalog", "type_udt_schema", "type_udt_name", "scope_catalog", "scope_schema", "scope_name", "maximum_cardinality", "dtd_identifier", "routine_body", "routine_definition", "external_name", "external_language", "parameter_style", "is_deterministic", "sql_data_access", "is_null_call", "sql_path", "schema_level_routine", "max_dynamic_result_sets", "is_user_defined_cast", "is_implicitly_invocable", "security_type", "to_sql_specific_catalog", "to_sql_specific_schema", "to_sql_specific_name", "as_locator", "created"::text, "last_altered"::text, "new_savepoint_level", "is_udt_dependent", "result_cast_from_data_type", "result_cast_as_locator", "result_cast_char_max_length", "result_cast_char_octet_length", "result_cast_char_set_catalog", "result_cast_char_set_schema", "result_cast_char_set_name", "result_cast_collation_catalog", "result_cast_collation_schema", "result_cast_collation_name", "result_cast_numeric_precision", "result_cast_numeric_precision_radix", "result_cast_numeric_scale", "result_cast_datetime_precision", "result_cast_interval_type", "result_cast_interval_precision", "result_cast_type_udt_catalog", "result_cast_type_udt_schema", "result_cast_type_udt_name", "result_cast_scope_catalog", "result_cast_scope_schema", "result_cast_scope_name", "result_cast_maximum_cardinality", "result_cast_dtd_identifier" from information_schema.routines""".query(RoutinesViewRow.jdbcDecoder).selectStream
  }
}
