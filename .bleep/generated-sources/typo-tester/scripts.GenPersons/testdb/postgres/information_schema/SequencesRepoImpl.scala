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

object SequencesRepoImpl extends SequencesRepo {
  override def selectAll(implicit c: Connection): List[SequencesRow] = {
    SQL"""select sequence_catalog, sequence_schema, sequence_name, data_type, numeric_precision, numeric_precision_radix, numeric_scale, start_value, minimum_value, maximum_value, increment, cycle_option from information_schema.sequences""".as(SequencesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SequencesFieldValue[_]])(implicit c: Connection): List[SequencesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SequencesFieldValue.sequenceCatalog(value) => NamedParameter("sequence_catalog", ParameterValue.from(value))
          case SequencesFieldValue.sequenceSchema(value) => NamedParameter("sequence_schema", ParameterValue.from(value))
          case SequencesFieldValue.sequenceName(value) => NamedParameter("sequence_name", ParameterValue.from(value))
          case SequencesFieldValue.dataType(value) => NamedParameter("data_type", ParameterValue.from(value))
          case SequencesFieldValue.numericPrecision(value) => NamedParameter("numeric_precision", ParameterValue.from(value))
          case SequencesFieldValue.numericPrecisionRadix(value) => NamedParameter("numeric_precision_radix", ParameterValue.from(value))
          case SequencesFieldValue.numericScale(value) => NamedParameter("numeric_scale", ParameterValue.from(value))
          case SequencesFieldValue.startValue(value) => NamedParameter("start_value", ParameterValue.from(value))
          case SequencesFieldValue.minimumValue(value) => NamedParameter("minimum_value", ParameterValue.from(value))
          case SequencesFieldValue.maximumValue(value) => NamedParameter("maximum_value", ParameterValue.from(value))
          case SequencesFieldValue.increment(value) => NamedParameter("increment", ParameterValue.from(value))
          case SequencesFieldValue.cycleOption(value) => NamedParameter("cycle_option", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.sequences where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(SequencesRow.rowParser.*)
    }

  }
}
