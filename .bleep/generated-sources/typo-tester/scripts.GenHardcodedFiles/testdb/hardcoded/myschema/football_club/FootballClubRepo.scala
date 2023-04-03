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

trait FootballClubRepo {
  def selectAll(implicit c: Connection): List[FootballClubRow]
  def selectById(id: FootballClubId)(implicit c: Connection): Option[FootballClubRow]
  def selectByIds(ids: List[FootballClubId])(implicit c: Connection): List[FootballClubRow]
  def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[_]])(implicit c: Connection): List[FootballClubRow]
  def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[_]])(implicit c: Connection): Boolean
  def update(id: FootballClubId, row: FootballClubRow)(implicit c: Connection): Boolean
  def insert(id: FootballClubId, unsaved: FootballClubRowUnsaved)(implicit c: Connection): Boolean
  def delete(id: FootballClubId)(implicit c: Connection): Boolean
}
