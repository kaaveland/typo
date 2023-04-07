/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.NameDomain
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class ProductsubcategoryFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class ProductsubcategoryFieldValue[T](name: String, value: T) extends ProductsubcategoryFieldOrIdValue(name, value)

object ProductsubcategoryFieldValue {
  case class productsubcategoryid(override val value: ProductsubcategoryId) extends ProductsubcategoryFieldOrIdValue("productsubcategoryid", value)
  case class productcategoryid(override val value: ProductcategoryId) extends ProductsubcategoryFieldValue("productcategoryid", value)
  case class name(override val value: NameDomain) extends ProductsubcategoryFieldValue("name", value)
  case class rowguid(override val value: UUID) extends ProductsubcategoryFieldValue("rowguid", value)
  case class modifieddate(override val value: LocalDateTime) extends ProductsubcategoryFieldValue("modifieddate", value)
}
