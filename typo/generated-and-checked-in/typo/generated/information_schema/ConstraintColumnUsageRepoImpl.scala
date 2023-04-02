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

object ConstraintColumnUsageRepoImpl extends ConstraintColumnUsageRepo {
  override def selectAll(implicit c: Connection): List[ConstraintColumnUsageRow] = {
    SQL"""select table_catalog, table_schema, table_name, column_name, constraint_catalog, constraint_schema, constraint_name from information_schema.constraint_column_usage""".as(ConstraintColumnUsageRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[ConstraintColumnUsageFieldValue[_]])(implicit c: Connection): List[ConstraintColumnUsageRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ConstraintColumnUsageFieldValue.tableCatalog(value) => NamedParameter("table_catalog", ParameterValue.from(value))
          case ConstraintColumnUsageFieldValue.tableSchema(value) => NamedParameter("table_schema", ParameterValue.from(value))
          case ConstraintColumnUsageFieldValue.tableName(value) => NamedParameter("table_name", ParameterValue.from(value))
          case ConstraintColumnUsageFieldValue.columnName(value) => NamedParameter("column_name", ParameterValue.from(value))
          case ConstraintColumnUsageFieldValue.constraintCatalog(value) => NamedParameter("constraint_catalog", ParameterValue.from(value))
          case ConstraintColumnUsageFieldValue.constraintSchema(value) => NamedParameter("constraint_schema", ParameterValue.from(value))
          case ConstraintColumnUsageFieldValue.constraintName(value) => NamedParameter("constraint_name", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema.constraint_column_usage where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(ConstraintColumnUsageRow.rowParser("").*)
    }

  }
}
