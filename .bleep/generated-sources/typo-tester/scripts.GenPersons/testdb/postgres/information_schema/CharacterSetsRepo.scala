package testdb
package postgres
package information_schema

import java.sql.Connection

trait CharacterSetsRepo {
  def selectAll(implicit c: Connection): List[CharacterSetsRow]
  def selectByFieldValues(fieldValues: List[CharacterSetsFieldValue[_]])(implicit c: Connection): List[CharacterSetsRow]
}