/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployee

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.NameDomain
import adventureworks.public.PhoneDomain

sealed abstract class VemployeeFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VemployeeFieldValue[T](name: String, value: T) extends VemployeeFieldOrIdValue(name, value)

object VemployeeFieldValue {
  case class businessentityid(override val value: Option[BusinessentityId]) extends VemployeeFieldValue("businessentityid", value)
  case class title(override val value: Option[String]) extends VemployeeFieldValue("title", value)
  case class firstname(override val value: Option[NameDomain]) extends VemployeeFieldValue("firstname", value)
  case class middlename(override val value: Option[NameDomain]) extends VemployeeFieldValue("middlename", value)
  case class lastname(override val value: Option[NameDomain]) extends VemployeeFieldValue("lastname", value)
  case class suffix(override val value: Option[String]) extends VemployeeFieldValue("suffix", value)
  case class jobtitle(override val value: Option[String]) extends VemployeeFieldValue("jobtitle", value)
  case class phonenumber(override val value: Option[PhoneDomain]) extends VemployeeFieldValue("phonenumber", value)
  case class phonenumbertype(override val value: Option[NameDomain]) extends VemployeeFieldValue("phonenumbertype", value)
  case class emailaddress(override val value: Option[String]) extends VemployeeFieldValue("emailaddress", value)
  case class emailpromotion(override val value: Option[Int]) extends VemployeeFieldValue("emailpromotion", value)
  case class addressline1(override val value: Option[String]) extends VemployeeFieldValue("addressline1", value)
  case class addressline2(override val value: Option[String]) extends VemployeeFieldValue("addressline2", value)
  case class city(override val value: Option[String]) extends VemployeeFieldValue("city", value)
  case class stateprovincename(override val value: Option[NameDomain]) extends VemployeeFieldValue("stateprovincename", value)
  case class postalcode(override val value: Option[String]) extends VemployeeFieldValue("postalcode", value)
  case class countryregionname(override val value: Option[NameDomain]) extends VemployeeFieldValue("countryregionname", value)
  case class additionalcontactinfo(override val value: Option[/* xml */ String]) extends VemployeeFieldValue("additionalcontactinfo", value)
}
