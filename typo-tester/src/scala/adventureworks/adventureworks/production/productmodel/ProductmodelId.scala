/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

case class ProductmodelId(value: Int) extends AnyVal
object ProductmodelId {
  implicit val ordering: Ordering[ProductmodelId] = Ordering.by(_.value)
  implicit val format: Format[ProductmodelId] = implicitly[Format[Int]].bimap(ProductmodelId.apply, _.value)
  implicit val toStatement: ToStatement[ProductmodelId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val column: Column[ProductmodelId] = implicitly[Column[Int]].map(ProductmodelId.apply)
  implicit val parameterMetadata: ParameterMetaData[ProductmodelId] = new ParameterMetaData[ProductmodelId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }

}
