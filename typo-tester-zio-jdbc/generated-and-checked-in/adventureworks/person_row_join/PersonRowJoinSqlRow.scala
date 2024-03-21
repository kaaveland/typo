/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_row_join

import adventureworks.customtypes.TypoRecord
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PersonRowJoinSqlRow(
  /** Points to [[sales.salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  email: /* nullability unknown */ Option[Array[TypoRecord]],
  emails: /* nullability unknown */ Option[Array[TypoRecord]]
)

object PersonRowJoinSqlRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PersonRowJoinSqlRow] = new JdbcDecoder[PersonRowJoinSqlRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PersonRowJoinSqlRow) =
      columIndex + 2 ->
        PersonRowJoinSqlRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          email = JdbcDecoder.optionDecoder(JdbcDecoder[Array[TypoRecord]]).unsafeDecode(columIndex + 1, rs)._2,
          emails = JdbcDecoder.optionDecoder(JdbcDecoder[Array[TypoRecord]]).unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PersonRowJoinSqlRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val email = jsonObj.get("email").fold[Either[String, Option[Array[TypoRecord]]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.array[TypoRecord](using TypoRecord.jsonDecoder, implicitly))))
    val emails = jsonObj.get("emails").fold[Either[String, Option[Array[TypoRecord]]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.array[TypoRecord](using TypoRecord.jsonDecoder, implicitly))))
    if (businessentityid.isRight && email.isRight && emails.isRight)
      Right(PersonRowJoinSqlRow(businessentityid = businessentityid.toOption.get, email = email.toOption.get, emails = emails.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, email, emails).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersonRowJoinSqlRow] = new JsonEncoder[PersonRowJoinSqlRow] {
    override def unsafeEncode(a: PersonRowJoinSqlRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""email":""")
      JsonEncoder.option(using JsonEncoder.array[TypoRecord](using TypoRecord.jsonEncoder, implicitly)).unsafeEncode(a.email, indent, out)
      out.write(",")
      out.write(""""emails":""")
      JsonEncoder.option(using JsonEncoder.array[TypoRecord](using TypoRecord.jsonEncoder, implicitly)).unsafeEncode(a.emails, indent, out)
      out.write("}")
    }
  }
}
