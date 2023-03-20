/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement

case class PgAggregateId(value: String) extends AnyVal
object PgAggregateId {
  implicit val ordering: Ordering[PgAggregateId] = Ordering.by(_.value)
  
  implicit val toStatement: ToStatement[PgAggregateId] = implicitly[ToStatement[String]].contramap(_.value)
  implicit val column: Column[PgAggregateId] = implicitly[Column[String]].map(PgAggregateId.apply)
  implicit val rowParser: RowParser[PgAggregateId] = SqlParser.get[PgAggregateId]("aggfnoid")
}