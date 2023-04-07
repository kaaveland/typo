/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.NameDomain

sealed abstract class VstorewithaddressesFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VstorewithaddressesFieldValue[T](name: String, value: T) extends VstorewithaddressesFieldOrIdValue(name, value)

object VstorewithaddressesFieldValue {
  case class businessentityid(override val value: Option[BusinessentityId]) extends VstorewithaddressesFieldValue("businessentityid", value)
  case class name(override val value: Option[NameDomain]) extends VstorewithaddressesFieldValue("name", value)
  case class addresstype(override val value: Option[NameDomain]) extends VstorewithaddressesFieldValue("addresstype", value)
  case class addressline1(override val value: Option[String]) extends VstorewithaddressesFieldValue("addressline1", value)
  case class addressline2(override val value: Option[String]) extends VstorewithaddressesFieldValue("addressline2", value)
  case class city(override val value: Option[String]) extends VstorewithaddressesFieldValue("city", value)
  case class stateprovincename(override val value: Option[NameDomain]) extends VstorewithaddressesFieldValue("stateprovincename", value)
  case class postalcode(override val value: Option[String]) extends VstorewithaddressesFieldValue("postalcode", value)
  case class countryregionname(override val value: Option[NameDomain]) extends VstorewithaddressesFieldValue("countryregionname", value)
}
