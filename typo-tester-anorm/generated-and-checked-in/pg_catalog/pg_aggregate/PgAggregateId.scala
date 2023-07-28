/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_aggregate

import adventureworks.TypoRegproc
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_aggregate` */
case class PgAggregateId(value: TypoRegproc) extends AnyVal
object PgAggregateId {
  implicit val arrayToStatement: ToStatement[Array[PgAggregateId]] = implicitly[ToStatement[Array[TypoRegproc]]].contramap(_.map(_.value))
  implicit val column: Column[PgAggregateId] = implicitly[Column[TypoRegproc]].map(PgAggregateId.apply)
  implicit def ordering(implicit O0: Ordering[TypoRegproc]): Ordering[PgAggregateId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgAggregateId] = new ParameterMetaData[PgAggregateId] {
    override def sqlType: String = implicitly[ParameterMetaData[TypoRegproc]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[TypoRegproc]].jdbcType
  }
  implicit val reads: Reads[PgAggregateId] = TypoRegproc.reads.map(PgAggregateId.apply)
  implicit val toStatement: ToStatement[PgAggregateId] = implicitly[ToStatement[TypoRegproc]].contramap(_.value)
  implicit val writes: Writes[PgAggregateId] = TypoRegproc.writes.contramap(_.value)
}