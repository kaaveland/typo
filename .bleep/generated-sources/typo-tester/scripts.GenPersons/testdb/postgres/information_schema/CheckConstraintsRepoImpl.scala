package testdb
package postgres
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait CheckConstraintsRepoImpl extends CheckConstraintsRepo {
  override def selectAll(implicit c: Connection): List[CheckConstraintsRow] = {
    SQL"""select constraint_catalog, constraint_schema, constraint_name, check_clause from information_schema.check_constraints""".as(CheckConstraintsRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CheckConstraintsFieldValue[_]])(implicit c: Connection): List[CheckConstraintsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CheckConstraintsFieldValue.constraintCatalog(value) => NamedParameter("constraint_catalog", ParameterValue.from(value))
          case CheckConstraintsFieldValue.constraintSchema(value) => NamedParameter("constraint_schema", ParameterValue.from(value))
          case CheckConstraintsFieldValue.constraintName(value) => NamedParameter("constraint_name", ParameterValue.from(value))
          case CheckConstraintsFieldValue.checkClause(value) => NamedParameter("check_clause", ParameterValue.from(value))
        }
        SQL"""select * from information_schema.check_constraints where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(CheckConstraintsRow.rowParser.*)
    }

  }
}