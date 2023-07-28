/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_operator` */
case class PgOperatorId(value: /* oid */ Long) extends AnyVal
object PgOperatorId {
  implicit val arrayToStatement: ToStatement[Array[PgOperatorId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgOperatorId] = implicitly[Column[/* oid */ Long]].map(PgOperatorId.apply)
  implicit val ordering: Ordering[PgOperatorId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgOperatorId] = new ParameterMetaData[PgOperatorId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgOperatorId] = Reads.LongReads.map(PgOperatorId.apply)
  implicit val toStatement: ToStatement[PgOperatorId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgOperatorId] = Writes.LongWrites.contramap(_.value)
}