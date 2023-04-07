/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import adventureworks.public.NameDomain
import java.time.LocalDateTime

sealed abstract class CountryregionFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class CountryregionFieldValue[T](name: String, value: T) extends CountryregionFieldOrIdValue(name, value)

object CountryregionFieldValue {
  case class countryregioncode(override val value: CountryregionId) extends CountryregionFieldOrIdValue("countryregioncode", value)
  case class name(override val value: NameDomain) extends CountryregionFieldValue("name", value)
  case class modifieddate(override val value: LocalDateTime) extends CountryregionFieldValue("modifieddate", value)
}
