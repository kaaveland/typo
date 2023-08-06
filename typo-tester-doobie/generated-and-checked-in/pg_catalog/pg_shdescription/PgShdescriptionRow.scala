/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdescription

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgShdescriptionRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  description: String
){
   val compositeId: PgShdescriptionId = PgShdescriptionId(objoid, classoid)
 }

object PgShdescriptionRow {
  implicit lazy val decoder: Decoder[PgShdescriptionRow] = Decoder.forProduct3[PgShdescriptionRow, /* oid */ Long, /* oid */ Long, String]("objoid", "classoid", "description")(PgShdescriptionRow.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeString)
  implicit lazy val encoder: Encoder[PgShdescriptionRow] = Encoder.forProduct3[PgShdescriptionRow, /* oid */ Long, /* oid */ Long, String]("objoid", "classoid", "description")(x => (x.objoid, x.classoid, x.description))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeString)
  implicit lazy val read: Read[PgShdescriptionRow] = new Read[PgShdescriptionRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgShdescriptionRow(
      objoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      classoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      description = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
}
