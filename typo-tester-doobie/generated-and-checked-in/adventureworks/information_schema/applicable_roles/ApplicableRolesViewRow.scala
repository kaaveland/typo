/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package applicable_roles

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ApplicableRolesViewRow(
  grantee: /* nullability unknown */ Option[String],
  roleName: /* nullability unknown */ Option[String],
  isGrantable: /* nullability unknown */ Option[/* max 3 chars */ String]
)

object ApplicableRolesViewRow {
  implicit lazy val decoder: Decoder[ApplicableRolesViewRow] = Decoder.forProduct3[ApplicableRolesViewRow, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[/* max 3 chars */ String]]("grantee", "role_name", "is_grantable")(ApplicableRolesViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[ApplicableRolesViewRow] = Encoder.forProduct3[ApplicableRolesViewRow, /* nullability unknown */ Option[String], /* nullability unknown */ Option[String], /* nullability unknown */ Option[/* max 3 chars */ String]]("grantee", "role_name", "is_grantable")(x => (x.grantee, x.roleName, x.isGrantable))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[ApplicableRolesViewRow] = new Read[ApplicableRolesViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ApplicableRolesViewRow(
      grantee = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      roleName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      isGrantable = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2)
    )
  )
}
