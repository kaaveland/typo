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

object CheckConstraintsRepoImpl extends CheckConstraintsRepo {
  override def selectAll(implicit c: Connection): List[CheckConstraintsRow] = {
    SQL"""select constraint_catalog, constraint_schema, constraint_name, check_clause from information_schema.check_constraints""".as(CheckConstraintsRow.rowParser("").*)
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
        val q = s"""select * from information_schema.check_constraints where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(CheckConstraintsRow.rowParser("").*)
    }

  }
}
