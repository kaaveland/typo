/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package role_usage_grants

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class RoleUsageGrantsViewRow(
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.grantor]] */
  grantor: Option[/* nullability unknown */ String],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.grantee]] */
  grantee: Option[/* nullability unknown */ String],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.objectCatalog]] */
  objectCatalog: Option[/* nullability unknown */ String],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.objectSchema]] */
  objectSchema: Option[/* nullability unknown */ String],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.objectName]] */
  objectName: Option[/* nullability unknown */ String],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.objectType]] */
  objectType: Option[/* nullability unknown */ String],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.privilegeType]] */
  privilegeType: Option[/* nullability unknown */ String],
  /** Points to [[usage_privileges.UsagePrivilegesViewRow.isGrantable]] */
  isGrantable: Option[/* nullability unknown */ /* max 3 chars */ String]
)

object RoleUsageGrantsViewRow {
  implicit lazy val decoder: Decoder[RoleUsageGrantsViewRow] = Decoder.forProduct8[RoleUsageGrantsViewRow, Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ /* max 3 chars */ String]]("grantor", "grantee", "object_catalog", "object_schema", "object_name", "object_type", "privilege_type", "is_grantable")(RoleUsageGrantsViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit lazy val encoder: Encoder[RoleUsageGrantsViewRow] = Encoder.forProduct8[RoleUsageGrantsViewRow, Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ String], Option[/* nullability unknown */ /* max 3 chars */ String]]("grantor", "grantee", "object_catalog", "object_schema", "object_name", "object_type", "privilege_type", "is_grantable")(x => (x.grantor, x.grantee, x.objectCatalog, x.objectSchema, x.objectName, x.objectType, x.privilegeType, x.isGrantable))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit lazy val read: Read[RoleUsageGrantsViewRow] = new Read[RoleUsageGrantsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => RoleUsageGrantsViewRow(
      grantor = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      grantee = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      objectCatalog = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      objectSchema = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      objectName = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      objectType = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      privilegeType = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      isGrantable = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7)
    )
  )
}
