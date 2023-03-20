/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object ParametersRepoImpl extends ParametersRepo {
  override def selectAll(implicit c: Connection): List[ParametersRow] = {
    SQL"""select specific_catalog, specific_schema, specific_name, ordinal_position, parameter_mode, is_result, as_locator, parameter_name, data_type, character_maximum_length, character_octet_length, character_set_catalog, character_set_schema, character_set_name, collation_catalog, collation_schema, collation_name, numeric_precision, numeric_precision_radix, numeric_scale, datetime_precision, interval_type, interval_precision, udt_catalog, udt_schema, udt_name, scope_catalog, scope_schema, scope_name, maximum_cardinality, dtd_identifier, parameter_default from information_schema.parameters""".as(ParametersRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ParametersFieldValue[_]])(implicit c: Connection): List[ParametersRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ParametersFieldValue.specificCatalog(value) => NamedParameter("specific_catalog", ParameterValue.from(value))
          case ParametersFieldValue.specificSchema(value) => NamedParameter("specific_schema", ParameterValue.from(value))
          case ParametersFieldValue.specificName(value) => NamedParameter("specific_name", ParameterValue.from(value))
          case ParametersFieldValue.ordinalPosition(value) => NamedParameter("ordinal_position", ParameterValue.from(value))
          case ParametersFieldValue.parameterMode(value) => NamedParameter("parameter_mode", ParameterValue.from(value))
          case ParametersFieldValue.isResult(value) => NamedParameter("is_result", ParameterValue.from(value))
          case ParametersFieldValue.asLocator(value) => NamedParameter("as_locator", ParameterValue.from(value))
          case ParametersFieldValue.parameterName(value) => NamedParameter("parameter_name", ParameterValue.from(value))
          case ParametersFieldValue.dataType(value) => NamedParameter("data_type", ParameterValue.from(value))
          case ParametersFieldValue.characterMaximumLength(value) => NamedParameter("character_maximum_length", ParameterValue.from(value))
          case ParametersFieldValue.characterOctetLength(value) => NamedParameter("character_octet_length", ParameterValue.from(value))
          case ParametersFieldValue.characterSetCatalog(value) => NamedParameter("character_set_catalog", ParameterValue.from(value))
          case ParametersFieldValue.characterSetSchema(value) => NamedParameter("character_set_schema", ParameterValue.from(value))
          case ParametersFieldValue.characterSetName(value) => NamedParameter("character_set_name", ParameterValue.from(value))
          case ParametersFieldValue.collationCatalog(value) => NamedParameter("collation_catalog", ParameterValue.from(value))
          case ParametersFieldValue.collationSchema(value) => NamedParameter("collation_schema", ParameterValue.from(value))
          case ParametersFieldValue.collationName(value) => NamedParameter("collation_name", ParameterValue.from(value))
          case ParametersFieldValue.numericPrecision(value) => NamedParameter("numeric_precision", ParameterValue.from(value))
          case ParametersFieldValue.numericPrecisionRadix(value) => NamedParameter("numeric_precision_radix", ParameterValue.from(value))
          case ParametersFieldValue.numericScale(value) => NamedParameter("numeric_scale", ParameterValue.from(value))
          case ParametersFieldValue.datetimePrecision(value) => NamedParameter("datetime_precision", ParameterValue.from(value))
          case ParametersFieldValue.intervalType(value) => NamedParameter("interval_type", ParameterValue.from(value))
          case ParametersFieldValue.intervalPrecision(value) => NamedParameter("interval_precision", ParameterValue.from(value))
          case ParametersFieldValue.udtCatalog(value) => NamedParameter("udt_catalog", ParameterValue.from(value))
          case ParametersFieldValue.udtSchema(value) => NamedParameter("udt_schema", ParameterValue.from(value))
          case ParametersFieldValue.udtName(value) => NamedParameter("udt_name", ParameterValue.from(value))
          case ParametersFieldValue.scopeCatalog(value) => NamedParameter("scope_catalog", ParameterValue.from(value))
          case ParametersFieldValue.scopeSchema(value) => NamedParameter("scope_schema", ParameterValue.from(value))
          case ParametersFieldValue.scopeName(value) => NamedParameter("scope_name", ParameterValue.from(value))
          case ParametersFieldValue.maximumCardinality(value) => NamedParameter("maximum_cardinality", ParameterValue.from(value))
          case ParametersFieldValue.dtdIdentifier(value) => NamedParameter("dtd_identifier", ParameterValue.from(value))
          case ParametersFieldValue.parameterDefault(value) => NamedParameter("parameter_default", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.parameters where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(ParametersRow.rowParser.*)
    }

  }
}
