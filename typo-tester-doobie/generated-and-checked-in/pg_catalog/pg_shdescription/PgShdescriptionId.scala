/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdescription

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `pg_catalog.pg_shdescription` */
case class PgShdescriptionId(objoid: /* oid */ Long, classoid: /* oid */ Long)
object PgShdescriptionId {
  implicit val decoder: Decoder[PgShdescriptionId] = Decoder.forProduct2[PgShdescriptionId, /* oid */ Long, /* oid */ Long]("objoid", "classoid")(PgShdescriptionId.apply)(Decoder.decodeLong, Decoder.decodeLong)
  implicit val encoder: Encoder[PgShdescriptionId] = Encoder.forProduct2[PgShdescriptionId, /* oid */ Long, /* oid */ Long]("objoid", "classoid")(x => (x.objoid, x.classoid))(Encoder.encodeLong, Encoder.encodeLong)
  implicit val ordering: Ordering[PgShdescriptionId] = Ordering.by(x => (x.objoid, x.classoid))
}