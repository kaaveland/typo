/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

case class ShoppingcartitemId(value: Int) extends AnyVal
object ShoppingcartitemId {
  implicit val ordering: Ordering[ShoppingcartitemId] = Ordering.by(_.value)
  implicit val format: Format[ShoppingcartitemId] = implicitly[Format[Int]].bimap(ShoppingcartitemId.apply, _.value)
  implicit val toStatement: ToStatement[ShoppingcartitemId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val column: Column[ShoppingcartitemId] = implicitly[Column[Int]].map(ShoppingcartitemId.apply)
  implicit val parameterMetadata: ParameterMetaData[ShoppingcartitemId] = new ParameterMetaData[ShoppingcartitemId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }

}
