/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `production.productcategory` */
case class ProductcategoryId(value: Int) extends AnyVal
object ProductcategoryId {
  implicit lazy val arraySetter: Setter[Array[ProductcategoryId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductcategoryId, Int] = Bijection[ProductcategoryId, Int](_.value)(ProductcategoryId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductcategoryId] = JdbcDecoder.intDecoder.map(ProductcategoryId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ProductcategoryId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ProductcategoryId] = JsonDecoder.int.map(ProductcategoryId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ProductcategoryId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[ProductcategoryId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ProductcategoryId] = ParameterMetaData.instance[ProductcategoryId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[ProductcategoryId] = Setter.intSetter.contramap(_.value)
}
