/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import testdb.hardcoded.myschema.Number
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait PersonFields[Row] {
  val id: IdField[PersonId, Row]
  val favouriteFootballClubId: Field[FootballClubId, Row]
  val name: Field[/* max 100 chars */ String, Row]
  val nickName: OptField[/* max 30 chars */ String, Row]
  val blogUrl: OptField[/* max 100 chars */ String, Row]
  val email: Field[/* max 254 chars */ String, Row]
  val phone: Field[/* max 8 chars */ String, Row]
  val likesPizza: Field[Boolean, Row]
  val maritalStatusId: Field[MaritalStatusId, Row]
  val workEmail: OptField[/* max 254 chars */ String, Row]
  val sector: Field[Sector, Row]
  val favoriteNumber: Field[Number, Row]
}

object PersonFields {
  val structure: Relation[PersonFields, PersonRow, PersonRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => PersonRow, val merge: (Row, PersonRow) => Row)
    extends Relation[PersonFields, PersonRow, Row] { 
  
    override val fields: PersonFields[Row] = new PersonFields[Row] {
      override val id = new IdField[PersonId, Row](prefix, "id", None, Some("int8"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
      override val favouriteFootballClubId = new Field[FootballClubId, Row](prefix, "favourite_football_club_id", None, None)(x => extract(x).favouriteFootballClubId, (row, value) => merge(row, extract(row).copy(favouriteFootballClubId = value)))
      override val name = new Field[/* max 100 chars */ String, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
      override val nickName = new OptField[/* max 30 chars */ String, Row](prefix, "nick_name", None, None)(x => extract(x).nickName, (row, value) => merge(row, extract(row).copy(nickName = value)))
      override val blogUrl = new OptField[/* max 100 chars */ String, Row](prefix, "blog_url", None, None)(x => extract(x).blogUrl, (row, value) => merge(row, extract(row).copy(blogUrl = value)))
      override val email = new Field[/* max 254 chars */ String, Row](prefix, "email", None, None)(x => extract(x).email, (row, value) => merge(row, extract(row).copy(email = value)))
      override val phone = new Field[/* max 8 chars */ String, Row](prefix, "phone", None, None)(x => extract(x).phone, (row, value) => merge(row, extract(row).copy(phone = value)))
      override val likesPizza = new Field[Boolean, Row](prefix, "likes_pizza", None, None)(x => extract(x).likesPizza, (row, value) => merge(row, extract(row).copy(likesPizza = value)))
      override val maritalStatusId = new Field[MaritalStatusId, Row](prefix, "marital_status_id", None, None)(x => extract(x).maritalStatusId, (row, value) => merge(row, extract(row).copy(maritalStatusId = value)))
      override val workEmail = new OptField[/* max 254 chars */ String, Row](prefix, "work_email", None, None)(x => extract(x).workEmail, (row, value) => merge(row, extract(row).copy(workEmail = value)))
      override val sector = new Field[Sector, Row](prefix, "sector", None, Some("myschema.sector"))(x => extract(x).sector, (row, value) => merge(row, extract(row).copy(sector = value)))
      override val favoriteNumber = new Field[Number, Row](prefix, "favorite_number", None, Some("myschema.number"))(x => extract(x).favoriteNumber, (row, value) => merge(row, extract(row).copy(favoriteNumber = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.id, fields.favouriteFootballClubId, fields.name, fields.nickName, fields.blogUrl, fields.email, fields.phone, fields.likesPizza, fields.maritalStatusId, fields.workEmail, fields.sector, fields.favoriteNumber)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => PersonRow, merge: (NewRow, PersonRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
