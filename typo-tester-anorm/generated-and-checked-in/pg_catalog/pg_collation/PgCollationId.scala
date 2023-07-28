/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_collation

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_collation` */
case class PgCollationId(value: /* oid */ Long) extends AnyVal
object PgCollationId {
  implicit val arrayToStatement: ToStatement[Array[PgCollationId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgCollationId] = implicitly[Column[/* oid */ Long]].map(PgCollationId.apply)
  implicit val ordering: Ordering[PgCollationId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgCollationId] = new ParameterMetaData[PgCollationId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgCollationId] = Reads.LongReads.map(PgCollationId.apply)
  implicit val toStatement: ToStatement[PgCollationId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgCollationId] = Writes.LongWrites.contramap(_.value)
}