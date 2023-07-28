/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_rewrite

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_rewrite` */
case class PgRewriteId(value: /* oid */ Long) extends AnyVal
object PgRewriteId {
  implicit val arrayToStatement: ToStatement[Array[PgRewriteId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgRewriteId] = implicitly[Column[/* oid */ Long]].map(PgRewriteId.apply)
  implicit val ordering: Ordering[PgRewriteId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgRewriteId] = new ParameterMetaData[PgRewriteId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgRewriteId] = Reads.LongReads.map(PgRewriteId.apply)
  implicit val toStatement: ToStatement[PgRewriteId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgRewriteId] = Writes.LongWrites.contramap(_.value)
}