/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded

import java.sql.Connection
import scala.util.Random
import testdb.hardcoded.compositepk.person.PersonRepoImpl
import testdb.hardcoded.compositepk.person.PersonRow
import testdb.hardcoded.compositepk.person.PersonRowUnsaved
import testdb.hardcoded.customtypes.Defaulted
import testdb.hardcoded.myschema.Number
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.football_club.FootballClubRepoImpl
import testdb.hardcoded.myschema.football_club.FootballClubRow
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import testdb.hardcoded.myschema.marital_status.MaritalStatusRepoImpl
import testdb.hardcoded.myschema.marital_status.MaritalStatusRow
import testdb.hardcoded.myschema.person.PersonId

class TestInsert(random: Random) {
  def compositepkPerson(name: Option[String] = if (random.nextBoolean()) None else Some(random.alphanumeric.take(20).mkString),
                        one: Defaulted[Long] = Defaulted.UseDefault,
                        two: Defaulted[Option[String]] = Defaulted.UseDefault
                       )(implicit c: Connection): PersonRow = (new PersonRepoImpl).insert(new PersonRowUnsaved(name = name, one = one, two = two))
  def myschemaFootballClub(id: FootballClubId, name: /* max 100 chars */ String = random.alphanumeric.take(20).mkString)(implicit c: Connection): FootballClubRow = (new FootballClubRepoImpl).insert(new FootballClubRow(id = id, name = name))
  def myschemaMaritalStatus(id: MaritalStatusId)(implicit c: Connection): MaritalStatusRow = (new MaritalStatusRepoImpl).insert(new MaritalStatusRow(id = id))
  def myschemaPerson(favouriteFootballClubId: FootballClubId,
                     name: /* max 100 chars */ String = random.alphanumeric.take(20).mkString,
                     nickName: Option[/* max 30 chars */ String] = if (random.nextBoolean()) None else Some(random.alphanumeric.take(20).mkString),
                     blogUrl: Option[/* max 100 chars */ String] = if (random.nextBoolean()) None else Some(random.alphanumeric.take(20).mkString),
                     email: /* max 254 chars */ String = random.alphanumeric.take(20).mkString,
                     phone: /* max 8 chars */ String = random.alphanumeric.take(8).mkString,
                     likesPizza: Boolean = random.nextBoolean(),
                     workEmail: Option[/* max 254 chars */ String] = if (random.nextBoolean()) None else Some(random.alphanumeric.take(20).mkString),
                     id: Defaulted[PersonId] = Defaulted.UseDefault,
                     maritalStatusId: Defaulted[MaritalStatusId] = Defaulted.UseDefault,
                     sector: Defaulted[Sector] = Defaulted.UseDefault,
                     favoriteNumber: Defaulted[Number] = Defaulted.UseDefault
                    )(implicit c: Connection): testdb.hardcoded.myschema.person.PersonRow = (new testdb.hardcoded.myschema.person.PersonRepoImpl).insert(new testdb.hardcoded.myschema.person.PersonRowUnsaved(favouriteFootballClubId = favouriteFootballClubId, name = name, nickName = nickName, blogUrl = blogUrl, email = email, phone = phone, likesPizza = likesPizza, workEmail = workEmail, id = id, maritalStatusId = maritalStatusId, sector = sector, favoriteNumber = favoriteNumber))
}