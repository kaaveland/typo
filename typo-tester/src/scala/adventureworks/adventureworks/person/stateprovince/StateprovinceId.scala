/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

case class StateprovinceId(value: Int) extends AnyVal
object StateprovinceId {
  implicit val ordering: Ordering[StateprovinceId] = Ordering.by(_.value)
  implicit val format: Format[StateprovinceId] = implicitly[Format[Int]].bimap(StateprovinceId.apply, _.value)
  implicit val toStatement: ToStatement[StateprovinceId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val column: Column[StateprovinceId] = implicitly[Column[Int]].map(StateprovinceId.apply)
  implicit val parameterMetadata: ParameterMetaData[StateprovinceId] = new ParameterMetaData[StateprovinceId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }

}
