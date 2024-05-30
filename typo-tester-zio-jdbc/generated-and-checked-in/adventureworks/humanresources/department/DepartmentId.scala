/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `humanresources.department` */
case class DepartmentId(value: Int) extends AnyVal
object DepartmentId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[DepartmentId]] = adventureworks.IntArrayDecoder.map(_.map(DepartmentId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[DepartmentId]] = adventureworks.IntArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[DepartmentId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[DepartmentId, Int] = Bijection[DepartmentId, Int](_.value)(DepartmentId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[DepartmentId] = JdbcDecoder.intDecoder.map(DepartmentId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[DepartmentId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[DepartmentId] = JsonDecoder.int.map(DepartmentId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[DepartmentId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[DepartmentId] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[DepartmentId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[DepartmentId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[DepartmentId] = new Text[DepartmentId] {
    override def unsafeEncode(v: DepartmentId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: DepartmentId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
