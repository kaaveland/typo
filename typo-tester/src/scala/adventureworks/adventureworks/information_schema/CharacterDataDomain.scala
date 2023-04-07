/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

case class CharacterDataDomain(value: String) extends AnyVal
object CharacterDataDomain {
  implicit def ordering(implicit ev: Ordering[String]): Ordering[CharacterDataDomain] = Ordering.by(_.value)
  implicit val format: Format[CharacterDataDomain] = implicitly[Format[String]].bimap(CharacterDataDomain.apply, _.value)
  implicit val toStatement: ToStatement[CharacterDataDomain] = implicitly[ToStatement[String]].contramap(_.value)
  implicit val column: Column[CharacterDataDomain] = implicitly[Column[String]].map(CharacterDataDomain.apply)
  implicit val parameterMetadata: ParameterMetaData[CharacterDataDomain] = new ParameterMetaData[CharacterDataDomain] {
    override def sqlType: String = implicitly[ParameterMetaData[String]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[String]].jdbcType
  }

}
