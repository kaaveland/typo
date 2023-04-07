/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

case class DocumentId(value: String) extends AnyVal
object DocumentId {
  implicit val ordering: Ordering[DocumentId] = Ordering.by(_.value)
  implicit val format: Format[DocumentId] = implicitly[Format[String]].bimap(DocumentId.apply, _.value)
  implicit val toStatement: ToStatement[DocumentId] = implicitly[ToStatement[String]].contramap(_.value)
  implicit val column: Column[DocumentId] = implicitly[Column[String]].map(DocumentId.apply)
  implicit val parameterMetadata: ParameterMetaData[DocumentId] = new ParameterMetaData[DocumentId] {
    override def sqlType: String = implicitly[ParameterMetaData[String]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[String]].jdbcType
  }

}
