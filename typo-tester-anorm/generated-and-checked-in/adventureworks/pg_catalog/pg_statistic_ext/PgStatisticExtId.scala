/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_statistic_ext` */
case class PgStatisticExtId(value: /* oid */ Long) extends AnyVal
object PgStatisticExtId {
  implicit lazy val arrayColumn: Column[Array[PgStatisticExtId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[PgStatisticExtId]] = adventureworks.LongArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgStatisticExtId, /* oid */ Long] = Bijection[PgStatisticExtId, /* oid */ Long](_.value)(PgStatisticExtId.apply)
  implicit lazy val column: Column[PgStatisticExtId] = Column.columnToLong.map(PgStatisticExtId.apply)
  implicit lazy val ordering: Ordering[PgStatisticExtId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgStatisticExtId] = new ParameterMetaData[PgStatisticExtId] {
    override def sqlType: String = ParameterMetaData.LongParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.LongParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[PgStatisticExtId] = Reads.LongReads.map(PgStatisticExtId.apply)
  implicit lazy val toStatement: ToStatement[PgStatisticExtId] = ToStatement.longToStatement.contramap(_.value)
  implicit lazy val writes: Writes[PgStatisticExtId] = Writes.LongWrites.contramap(_.value)
}