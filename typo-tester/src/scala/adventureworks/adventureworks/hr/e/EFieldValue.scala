/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package e

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.FlagDomain
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class EFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class EFieldValue[T](name: String, value: T) extends EFieldOrIdValue(name, value)

object EFieldValue {
  case class id(override val value: Option[Int]) extends EFieldValue("id", value)
  case class businessentityid(override val value: Option[BusinessentityId]) extends EFieldValue("businessentityid", value)
  case class nationalidnumber(override val value: Option[String]) extends EFieldValue("nationalidnumber", value)
  case class loginid(override val value: Option[String]) extends EFieldValue("loginid", value)
  case class jobtitle(override val value: Option[String]) extends EFieldValue("jobtitle", value)
  case class birthdate(override val value: Option[LocalDate]) extends EFieldValue("birthdate", value)
  case class maritalstatus(override val value: Option[/* bpchar */ String]) extends EFieldValue("maritalstatus", value)
  case class gender(override val value: Option[/* bpchar */ String]) extends EFieldValue("gender", value)
  case class hiredate(override val value: Option[LocalDate]) extends EFieldValue("hiredate", value)
  case class salariedflag(override val value: FlagDomain) extends EFieldValue("salariedflag", value)
  case class vacationhours(override val value: Option[Int]) extends EFieldValue("vacationhours", value)
  case class sickleavehours(override val value: Option[Int]) extends EFieldValue("sickleavehours", value)
  case class currentflag(override val value: FlagDomain) extends EFieldValue("currentflag", value)
  case class rowguid(override val value: Option[UUID]) extends EFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends EFieldValue("modifieddate", value)
  case class organizationnode(override val value: Option[String]) extends EFieldValue("organizationnode", value)
}
