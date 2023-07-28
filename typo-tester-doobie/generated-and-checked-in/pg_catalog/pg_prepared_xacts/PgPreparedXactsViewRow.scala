/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_xacts

import adventureworks.TypoOffsetDateTime
import adventureworks.TypoXid
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgPreparedXactsViewRow(
  transaction: Option[TypoXid],
  gid: Option[String],
  prepared: Option[TypoOffsetDateTime],
  owner: Option[String],
  database: Option[String]
)

object PgPreparedXactsViewRow {
  implicit val decoder: Decoder[PgPreparedXactsViewRow] = Decoder.forProduct5[PgPreparedXactsViewRow, Option[TypoXid], Option[String], Option[TypoOffsetDateTime], Option[String], Option[String]]("transaction", "gid", "prepared", "owner", "database")(PgPreparedXactsViewRow.apply)(Decoder.decodeOption(TypoXid.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeString))
  implicit val encoder: Encoder[PgPreparedXactsViewRow] = Encoder.forProduct5[PgPreparedXactsViewRow, Option[TypoXid], Option[String], Option[TypoOffsetDateTime], Option[String], Option[String]]("transaction", "gid", "prepared", "owner", "database")(x => (x.transaction, x.gid, x.prepared, x.owner, x.database))(Encoder.encodeOption(TypoXid.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeString))
  implicit val read: Read[PgPreparedXactsViewRow] = new Read[PgPreparedXactsViewRow](
    gets = List(
      (TypoXid.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgPreparedXactsViewRow(
      transaction = TypoXid.get.unsafeGetNullable(rs, i + 0),
      gid = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      prepared = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 2),
      owner = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      database = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4)
    )
  )
}