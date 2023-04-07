/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

case class ProductcategoryId(value: Int) extends AnyVal
object ProductcategoryId {
  implicit val ordering: Ordering[ProductcategoryId] = Ordering.by(_.value)
  implicit val format: Format[ProductcategoryId] = implicitly[Format[Int]].bimap(ProductcategoryId.apply, _.value)
  implicit val toStatement: ToStatement[ProductcategoryId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val column: Column[ProductcategoryId] = implicitly[Column[Int]].map(ProductcategoryId.apply)
  implicit val parameterMetadata: ParameterMetaData[ProductcategoryId] = new ParameterMetaData[ProductcategoryId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }

}
