/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `production.productcategory` */
case class ProductcategoryId(value: Int) extends AnyVal
object ProductcategoryId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[ProductcategoryId]] = adventureworks.IntArrayDecoder.map(_.map(ProductcategoryId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[ProductcategoryId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[ProductcategoryId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductcategoryId, Int] = Bijection[ProductcategoryId, Int](_.value)(ProductcategoryId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductcategoryId] = JdbcDecoder.intDecoder.map(ProductcategoryId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ProductcategoryId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ProductcategoryId] = JsonDecoder.int.map(ProductcategoryId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ProductcategoryId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[ProductcategoryId] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[ProductcategoryId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[ProductcategoryId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[ProductcategoryId] = new Text[ProductcategoryId] {
    override def unsafeEncode(v: ProductcategoryId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ProductcategoryId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
