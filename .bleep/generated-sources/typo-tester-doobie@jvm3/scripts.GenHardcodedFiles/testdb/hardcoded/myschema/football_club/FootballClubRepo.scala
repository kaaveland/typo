/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait FootballClubRepo {
  def delete(id: FootballClubId): ConnectionIO[Boolean]
  def insert(unsaved: FootballClubRow): ConnectionIO[FootballClubRow]
  def selectAll: Stream[ConnectionIO, FootballClubRow]
  def selectById(id: FootballClubId): ConnectionIO[Option[FootballClubRow]]
  def selectByIds(ids: Array[FootballClubId]): Stream[ConnectionIO, FootballClubRow]
  def update(row: FootballClubRow): ConnectionIO[Boolean]
  def upsert(unsaved: FootballClubRow): ConnectionIO[FootballClubRow]
}
