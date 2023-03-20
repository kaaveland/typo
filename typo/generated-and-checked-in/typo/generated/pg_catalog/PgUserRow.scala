/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime

case class PgUserRow(
  /** Points to [[PgShadowRow.usename]] */
  usename: Option[String],
  /** Points to [[PgShadowRow.usesysid]] */
  usesysid: Option[Long],
  /** Points to [[PgShadowRow.usecreatedb]] */
  usecreatedb: Option[Boolean],
  /** Points to [[PgShadowRow.usesuper]] */
  usesuper: Option[Boolean],
  /** Points to [[PgShadowRow.userepl]] */
  userepl: Option[Boolean],
  /** Points to [[PgShadowRow.usebypassrls]] */
  usebypassrls: Option[Boolean],
  passwd: /* unknown nullability */ Option[String],
  /** Points to [[PgShadowRow.valuntil]] */
  valuntil: Option[LocalDateTime],
  /** Points to [[PgShadowRow.useconfig]] */
  useconfig: Option[Array[String]]
)

object PgUserRow {
  implicit val rowParser: RowParser[PgUserRow] = { row =>
    Success(
      PgUserRow(
        usename = row[Option[String]]("usename"),
        usesysid = row[Option[Long]]("usesysid"),
        usecreatedb = row[Option[Boolean]]("usecreatedb"),
        usesuper = row[Option[Boolean]]("usesuper"),
        userepl = row[Option[Boolean]]("userepl"),
        usebypassrls = row[Option[Boolean]]("usebypassrls"),
        passwd = row[/* unknown nullability */ Option[String]]("passwd"),
        valuntil = row[Option[LocalDateTime]]("valuntil"),
        useconfig = row[Option[Array[String]]]("useconfig")
      )
    )
  }

  
}