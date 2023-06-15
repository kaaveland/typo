/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bec

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class BecViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class BecViewFieldValue[T](name: String, value: T) extends BecViewFieldOrIdValue(name, value)

object BecViewFieldValue {
  case class id(override val value: Option[Int]) extends BecViewFieldValue("id", value)
  case class businessentityid(override val value: Option[BusinessentityId]) extends BecViewFieldValue("businessentityid", value)
  case class personid(override val value: Option[BusinessentityId]) extends BecViewFieldValue("personid", value)
  case class contacttypeid(override val value: Option[ContacttypeId]) extends BecViewFieldValue("contacttypeid", value)
  case class rowguid(override val value: Option[UUID]) extends BecViewFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends BecViewFieldValue("modifieddate", value)
}