/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package element_types

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object ElementTypesViewRepoImpl extends ElementTypesViewRepo {
  override def select: SelectBuilder[ElementTypesViewFields, ElementTypesViewRow] = {
    SelectBuilderSql("information_schema.element_types", ElementTypesViewFields, ElementTypesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ElementTypesViewRow] = {
    sql"""select "object_catalog", "object_schema", "object_name", "object_type", "collection_type_identifier", "data_type", "character_maximum_length", "character_octet_length", "character_set_catalog", "character_set_schema", "character_set_name", "collation_catalog", "collation_schema", "collation_name", "numeric_precision", "numeric_precision_radix", "numeric_scale", "datetime_precision", "interval_type", "interval_precision", "domain_default", "udt_catalog", "udt_schema", "udt_name", "scope_catalog", "scope_schema", "scope_name", "maximum_cardinality", "dtd_identifier" from information_schema.element_types""".query(ElementTypesViewRow.jdbcDecoder).selectStream
  }
}
