/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

case class StoreId(value: Int) extends AnyVal
object StoreId {
  implicit val ordering: Ordering[StoreId] = Ordering.by(_.value)
  implicit val format: Format[StoreId] = implicitly[Format[Int]].bimap(StoreId.apply, _.value)
  implicit val toStatement: ToStatement[StoreId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val column: Column[StoreId] = implicitly[Column[Int]].map(StoreId.apply)
  implicit val parameterMetadata: ParameterMetaData[StoreId] = new ParameterMetaData[StoreId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }

}
