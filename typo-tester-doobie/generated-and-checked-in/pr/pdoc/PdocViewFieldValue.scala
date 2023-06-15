/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pdoc

import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import java.time.LocalDateTime

sealed abstract class PdocViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PdocViewFieldValue[T](name: String, value: T) extends PdocViewFieldOrIdValue(name, value)

object PdocViewFieldValue {
  case class id(override val value: Option[Int]) extends PdocViewFieldValue("id", value)
  case class productid(override val value: Option[ProductId]) extends PdocViewFieldValue("productid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends PdocViewFieldValue("modifieddate", value)
  case class documentnode(override val value: Option[DocumentId]) extends PdocViewFieldValue("documentnode", value)
}