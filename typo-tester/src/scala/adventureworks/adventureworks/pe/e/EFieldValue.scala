/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package e

import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class EFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class EFieldValue[T](name: String, value: T) extends EFieldOrIdValue(name, value)

object EFieldValue {
  case class id(override val value: Option[Int]) extends EFieldValue("id", value)
  case class businessentityid(override val value: Option[BusinessentityId]) extends EFieldValue("businessentityid", value)
  case class emailaddressid(override val value: Option[Int]) extends EFieldValue("emailaddressid", value)
  case class emailaddress(override val value: Option[String]) extends EFieldValue("emailaddress", value)
  case class rowguid(override val value: Option[UUID]) extends EFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends EFieldValue("modifieddate", value)
}