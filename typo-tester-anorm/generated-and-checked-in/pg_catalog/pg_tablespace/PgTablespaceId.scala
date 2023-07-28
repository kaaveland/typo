/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tablespace

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_tablespace` */
case class PgTablespaceId(value: /* oid */ Long) extends AnyVal
object PgTablespaceId {
  implicit val arrayToStatement: ToStatement[Array[PgTablespaceId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgTablespaceId] = implicitly[Column[/* oid */ Long]].map(PgTablespaceId.apply)
  implicit val ordering: Ordering[PgTablespaceId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgTablespaceId] = new ParameterMetaData[PgTablespaceId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgTablespaceId] = Reads.LongReads.map(PgTablespaceId.apply)
  implicit val toStatement: ToStatement[PgTablespaceId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgTablespaceId] = Writes.LongWrites.contramap(_.value)
}