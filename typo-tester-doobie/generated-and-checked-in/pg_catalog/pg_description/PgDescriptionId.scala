/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_description

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `pg_catalog.pg_description` */
case class PgDescriptionId(objoid: /* oid */ Long, classoid: /* oid */ Long, objsubid: Int)
object PgDescriptionId {
  implicit lazy val decoder: Decoder[PgDescriptionId] = Decoder.forProduct3[PgDescriptionId, /* oid */ Long, /* oid */ Long, Int]("objoid", "classoid", "objsubid")(PgDescriptionId.apply)(Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeInt)
  implicit lazy val encoder: Encoder[PgDescriptionId] = Encoder.forProduct3[PgDescriptionId, /* oid */ Long, /* oid */ Long, Int]("objoid", "classoid", "objsubid")(x => (x.objoid, x.classoid, x.objsubid))(Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeInt)
  implicit lazy val ordering: Ordering[PgDescriptionId] = Ordering.by(x => (x.objoid, x.classoid, x.objsubid))
}
