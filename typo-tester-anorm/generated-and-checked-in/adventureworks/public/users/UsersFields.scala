/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoUnknownCitext
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait UsersFields[Row] {
  val userId: IdField[UsersId, Row]
  val name: Field[String, Row]
  val lastName: OptField[String, Row]
  val email: Field[TypoUnknownCitext, Row]
  val password: Field[String, Row]
  val createdAt: Field[TypoInstant, Row]
  val verifiedOn: OptField[TypoInstant, Row]
}

object UsersFields {
  val structure: Relation[UsersFields, UsersRow, UsersRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => UsersRow, val merge: (Row, UsersRow) => Row)
    extends Relation[UsersFields, UsersRow, Row] { 
  
    override val fields: UsersFields[Row] = new UsersFields[Row] {
      override val userId = new IdField[UsersId, Row](prefix, "user_id", None, Some("uuid"))(x => extract(x).userId, (row, value) => merge(row, extract(row).copy(userId = value)))
      override val name = new Field[String, Row](prefix, "name", None, None)(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
      override val lastName = new OptField[String, Row](prefix, "last_name", None, None)(x => extract(x).lastName, (row, value) => merge(row, extract(row).copy(lastName = value)))
      override val email = new Field[TypoUnknownCitext, Row](prefix, "email", Some("text"), Some("citext"))(x => extract(x).email, (row, value) => merge(row, extract(row).copy(email = value)))
      override val password = new Field[String, Row](prefix, "password", None, None)(x => extract(x).password, (row, value) => merge(row, extract(row).copy(password = value)))
      override val createdAt = new Field[TypoInstant, Row](prefix, "created_at", Some("text"), Some("timestamptz"))(x => extract(x).createdAt, (row, value) => merge(row, extract(row).copy(createdAt = value)))
      override val verifiedOn = new OptField[TypoInstant, Row](prefix, "verified_on", Some("text"), Some("timestamptz"))(x => extract(x).verifiedOn, (row, value) => merge(row, extract(row).copy(verifiedOn = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.userId, fields.name, fields.lastName, fields.email, fields.password, fields.createdAt, fields.verifiedOn)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => UsersRow, merge: (NewRow, UsersRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
