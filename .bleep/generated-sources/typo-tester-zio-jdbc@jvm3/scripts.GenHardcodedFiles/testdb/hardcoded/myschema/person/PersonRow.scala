/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import java.sql.ResultSet
import testdb.hardcoded.Text
import testdb.hardcoded.myschema.Number
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PersonRow(
  /** Default: auto-increment */
  id: PersonId,
  /** Points to [[football_club.FootballClubRow.id]] */
  favouriteFootballClubId: FootballClubId,
  name: /* max 100 chars */ String,
  nickName: Option[/* max 30 chars */ String],
  blogUrl: Option[/* max 100 chars */ String],
  email: /* max 254 chars */ String,
  phone: /* max 8 chars */ String,
  likesPizza: Boolean,
  /** Default: some-value
      Points to [[marital_status.MaritalStatusRow.id]] */
  maritalStatusId: MaritalStatusId,
  workEmail: Option[/* max 254 chars */ String],
  /** Default: PUBLIC */
  sector: Sector,
  /** Default: one */
  favoriteNumber: Number
)

object PersonRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PersonRow] = new JdbcDecoder[PersonRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PersonRow) =
      columIndex + 11 ->
        PersonRow(
          id = PersonId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          favouriteFootballClubId = FootballClubId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          name = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          nickName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          blogUrl = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          email = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 5, rs)._2,
          phone = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 6, rs)._2,
          likesPizza = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 7, rs)._2,
          maritalStatusId = MaritalStatusId.jdbcDecoder.unsafeDecode(columIndex + 8, rs)._2,
          workEmail = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 9, rs)._2,
          sector = Sector.jdbcDecoder.unsafeDecode(columIndex + 10, rs)._2,
          favoriteNumber = Number.jdbcDecoder.unsafeDecode(columIndex + 11, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PersonRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(PersonId.jsonDecoder))
    val favouriteFootballClubId = jsonObj.get("favourite_football_club_id").toRight("Missing field 'favourite_football_club_id'").flatMap(_.as(FootballClubId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(JsonDecoder.string))
    val nickName = jsonObj.get("nick_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val blogUrl = jsonObj.get("blog_url").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val email = jsonObj.get("email").toRight("Missing field 'email'").flatMap(_.as(JsonDecoder.string))
    val phone = jsonObj.get("phone").toRight("Missing field 'phone'").flatMap(_.as(JsonDecoder.string))
    val likesPizza = jsonObj.get("likes_pizza").toRight("Missing field 'likes_pizza'").flatMap(_.as(JsonDecoder.boolean))
    val maritalStatusId = jsonObj.get("marital_status_id").toRight("Missing field 'marital_status_id'").flatMap(_.as(MaritalStatusId.jsonDecoder))
    val workEmail = jsonObj.get("work_email").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val sector = jsonObj.get("sector").toRight("Missing field 'sector'").flatMap(_.as(Sector.jsonDecoder))
    val favoriteNumber = jsonObj.get("favorite_number").toRight("Missing field 'favorite_number'").flatMap(_.as(Number.jsonDecoder))
    if (id.isRight && favouriteFootballClubId.isRight && name.isRight && nickName.isRight && blogUrl.isRight && email.isRight && phone.isRight && likesPizza.isRight && maritalStatusId.isRight && workEmail.isRight && sector.isRight && favoriteNumber.isRight)
      Right(PersonRow(id = id.toOption.get, favouriteFootballClubId = favouriteFootballClubId.toOption.get, name = name.toOption.get, nickName = nickName.toOption.get, blogUrl = blogUrl.toOption.get, email = email.toOption.get, phone = phone.toOption.get, likesPizza = likesPizza.toOption.get, maritalStatusId = maritalStatusId.toOption.get, workEmail = workEmail.toOption.get, sector = sector.toOption.get, favoriteNumber = favoriteNumber.toOption.get))
    else Left(List[Either[String, Any]](id, favouriteFootballClubId, name, nickName, blogUrl, email, phone, likesPizza, maritalStatusId, workEmail, sector, favoriteNumber).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersonRow] = new JsonEncoder[PersonRow] {
    override def unsafeEncode(a: PersonRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      PersonId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""favourite_football_club_id":""")
      FootballClubId.jsonEncoder.unsafeEncode(a.favouriteFootballClubId, indent, out)
      out.write(",")
      out.write(""""name":""")
      JsonEncoder.string.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""nick_name":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.nickName, indent, out)
      out.write(",")
      out.write(""""blog_url":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.blogUrl, indent, out)
      out.write(",")
      out.write(""""email":""")
      JsonEncoder.string.unsafeEncode(a.email, indent, out)
      out.write(",")
      out.write(""""phone":""")
      JsonEncoder.string.unsafeEncode(a.phone, indent, out)
      out.write(",")
      out.write(""""likes_pizza":""")
      JsonEncoder.boolean.unsafeEncode(a.likesPizza, indent, out)
      out.write(",")
      out.write(""""marital_status_id":""")
      MaritalStatusId.jsonEncoder.unsafeEncode(a.maritalStatusId, indent, out)
      out.write(",")
      out.write(""""work_email":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.workEmail, indent, out)
      out.write(",")
      out.write(""""sector":""")
      Sector.jsonEncoder.unsafeEncode(a.sector, indent, out)
      out.write(",")
      out.write(""""favorite_number":""")
      Number.jsonEncoder.unsafeEncode(a.favoriteNumber, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[PersonRow] = Text.instance[PersonRow]{ (row, sb) =>
    PersonId.text.unsafeEncode(row.id, sb)
    sb.append(Text.DELIMETER)
    FootballClubId.text.unsafeEncode(row.favouriteFootballClubId, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.nickName, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.blogUrl, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.email, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.phone, sb)
    sb.append(Text.DELIMETER)
    Text.booleanInstance.unsafeEncode(row.likesPizza, sb)
    sb.append(Text.DELIMETER)
    MaritalStatusId.text.unsafeEncode(row.maritalStatusId, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.workEmail, sb)
    sb.append(Text.DELIMETER)
    Sector.text.unsafeEncode(row.sector, sb)
    sb.append(Text.DELIMETER)
    Number.text.unsafeEncode(row.favoriteNumber, sb)
  }
}
