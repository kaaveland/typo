/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object RoutineColumnUsageRepoImpl extends RoutineColumnUsageRepo {
  override def selectAll(implicit c: Connection): List[RoutineColumnUsageRow] = {
    SQL"""select specific_catalog, specific_schema, specific_name, routine_catalog, routine_schema, routine_name, table_catalog, table_schema, table_name, column_name from information_schema.routine_column_usage""".as(RoutineColumnUsageRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[RoutineColumnUsageFieldValue[_]])(implicit c: Connection): List[RoutineColumnUsageRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case RoutineColumnUsageFieldValue.specificCatalog(value) => NamedParameter("specific_catalog", ParameterValue.from(value))
          case RoutineColumnUsageFieldValue.specificSchema(value) => NamedParameter("specific_schema", ParameterValue.from(value))
          case RoutineColumnUsageFieldValue.specificName(value) => NamedParameter("specific_name", ParameterValue.from(value))
          case RoutineColumnUsageFieldValue.routineCatalog(value) => NamedParameter("routine_catalog", ParameterValue.from(value))
          case RoutineColumnUsageFieldValue.routineSchema(value) => NamedParameter("routine_schema", ParameterValue.from(value))
          case RoutineColumnUsageFieldValue.routineName(value) => NamedParameter("routine_name", ParameterValue.from(value))
          case RoutineColumnUsageFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case RoutineColumnUsageFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case RoutineColumnUsageFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case RoutineColumnUsageFieldValue.columnName(value) => NamedParameter("column_name", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.routine_column_usage where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(RoutineColumnUsageRow.rowParser("").*)
    }

  }
}
