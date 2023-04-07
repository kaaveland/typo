/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

case class MaritalStatusId(value: Long) extends AnyVal
object MaritalStatusId {
  implicit val ordering: Ordering[MaritalStatusId] = Ordering.by(_.value)
  implicit val format: Format[MaritalStatusId] = implicitly[Format[Long]].bimap(MaritalStatusId.apply, _.value)
  implicit val toStatement: ToStatement[MaritalStatusId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[MaritalStatusId] = implicitly[Column[Long]].map(MaritalStatusId.apply)
  implicit val parameterMetadata: ParameterMetaData[MaritalStatusId] = new ParameterMetaData[MaritalStatusId] {
    override def sqlType: String = implicitly[ParameterMetaData[Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Long]].jdbcType
  }

}
