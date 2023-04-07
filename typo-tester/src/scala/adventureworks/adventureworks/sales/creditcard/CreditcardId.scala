/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

case class CreditcardId(value: Int) extends AnyVal
object CreditcardId {
  implicit val ordering: Ordering[CreditcardId] = Ordering.by(_.value)
  implicit val format: Format[CreditcardId] = implicitly[Format[Int]].bimap(CreditcardId.apply, _.value)
  implicit val toStatement: ToStatement[CreditcardId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val column: Column[CreditcardId] = implicitly[Column[Int]].map(CreditcardId.apply)
  implicit val parameterMetadata: ParameterMetaData[CreditcardId] = new ParameterMetaData[CreditcardId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }

}
