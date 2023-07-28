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
  def delete(id: FootballClubId)(implicit c: Connection): Boolean
  def insert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow
  def selectAll(implicit c: Connection): List[FootballClubRow]
  def selectById(id: FootballClubId)(implicit c: Connection): Option[FootballClubRow]
  def selectByIds(ids: Array[FootballClubId])(implicit c: Connection): List[FootballClubRow]
  def update(row: FootballClubRow)(implicit c: Connection): Boolean
  def upsert(unsaved: FootballClubRow)(implicit c: Connection): FootballClubRow
}
