/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesreason

import adventureworks.public.Name
import java.time.LocalDateTime

sealed abstract class SalesreasonFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class SalesreasonFieldValue[T](name: String, value: T) extends SalesreasonFieldOrIdValue(name, value)

object SalesreasonFieldValue {
  case class salesreasonid(override val value: SalesreasonId) extends SalesreasonFieldOrIdValue("salesreasonid", value)
  case class name(override val value: Name) extends SalesreasonFieldValue("name", value)
  case class reasontype(override val value: Name) extends SalesreasonFieldValue("reasontype", value)
  case class modifieddate(override val value: LocalDateTime) extends SalesreasonFieldValue("modifieddate", value)
}