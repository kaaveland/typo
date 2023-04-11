/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

/** Type for the primary key of table `person.businessentity` */
case class BusinessentityId(value: Int) extends AnyVal
object BusinessentityId {
  implicit val ordering: Ordering[BusinessentityId] = Ordering.by(_.value)
  implicit val format: Format[BusinessentityId] = implicitly[Format[Int]].bimap(BusinessentityId.apply, _.value)
  implicit val toStatement: ToStatement[BusinessentityId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val column: Column[BusinessentityId] = implicitly[Column[Int]].map(BusinessentityId.apply)
  implicit val parameterMetadata: ParameterMetaData[BusinessentityId] = new ParameterMetaData[BusinessentityId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }

}