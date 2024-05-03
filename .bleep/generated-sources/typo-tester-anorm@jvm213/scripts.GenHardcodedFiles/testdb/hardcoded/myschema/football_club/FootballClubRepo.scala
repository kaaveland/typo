/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait FootballClubRepo {
  def delete: DeleteBuilder[FootballClubFields, FootballClubRow]
  def deleteById(id: FootballClubId)(implicit c: Connection): Boolean
  def deleteByIds(ids: Array[FootballClubId])(implicit c: Connection): Int
  def insert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow
  def insertStreaming(unsaved: Iterator[FootballClubRow], batchSize: Int = 10000)(implicit c: Connection): Long
  def select: SelectBuilder[FootballClubFields, FootballClubRow]
  def selectAll(implicit c: Connection): List[FootballClubRow]
  def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[?]])(implicit c: Connection): List[FootballClubRow]
  def selectById(id: FootballClubId)(implicit c: Connection): Option[FootballClubRow]
  def selectByIds(ids: Array[FootballClubId])(implicit c: Connection): List[FootballClubRow]
  def selectByIdsTracked(ids: Array[FootballClubId])(implicit c: Connection): Map[FootballClubId, FootballClubRow]
  def update: UpdateBuilder[FootballClubFields, FootballClubRow]
  def update(row: FootballClubRow)(implicit c: Connection): Boolean
  def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[?]])(implicit c: Connection): Boolean
  def upsert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow
}
