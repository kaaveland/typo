/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait CountryregionRepo {
  def delete: DeleteBuilder[CountryregionFields, CountryregionRow]
  def deleteById(countryregioncode: CountryregionId): ConnectionIO[Boolean]
  def deleteByIds(countryregioncodes: Array[CountryregionId]): ConnectionIO[Int]
  def insert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow]
  def insert(unsaved: CountryregionRowUnsaved): ConnectionIO[CountryregionRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, CountryregionRow], batchSize: Int = 10000): ConnectionIO[Long]
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CountryregionRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[CountryregionFields, CountryregionRow]
  def selectAll: Stream[ConnectionIO, CountryregionRow]
  def selectById(countryregioncode: CountryregionId): ConnectionIO[Option[CountryregionRow]]
  def selectByIds(countryregioncodes: Array[CountryregionId]): Stream[ConnectionIO, CountryregionRow]
  def selectByIdsTracked(countryregioncodes: Array[CountryregionId]): ConnectionIO[Map[CountryregionId, CountryregionRow]]
  def update: UpdateBuilder[CountryregionFields, CountryregionRow]
  def update(row: CountryregionRow): ConnectionIO[Boolean]
  def upsert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow]
}
