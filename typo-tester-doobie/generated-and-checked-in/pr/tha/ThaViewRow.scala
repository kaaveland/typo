/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package tha

import adventureworks.TypoLocalDateTime
import adventureworks.production.transactionhistoryarchive.TransactionhistoryarchiveId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ThaViewRow(
  id: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.transactionid]] */
  transactionid: Option[TransactionhistoryarchiveId],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.productid]] */
  productid: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.referenceorderid]] */
  referenceorderid: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.referenceorderlineid]] */
  referenceorderlineid: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.transactiondate]] */
  transactiondate: Option[TypoLocalDateTime],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.transactiontype]] */
  transactiontype: Option[/* bpchar */ String],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.quantity]] */
  quantity: Option[Int],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.actualcost]] */
  actualcost: Option[BigDecimal],
  /** Points to [[production.transactionhistoryarchive.TransactionhistoryarchiveRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object ThaViewRow {
  implicit lazy val decoder: Decoder[ThaViewRow] = Decoder.forProduct10[ThaViewRow, Option[Int], Option[TransactionhistoryarchiveId], Option[Int], Option[Int], Option[Int], Option[TypoLocalDateTime], Option[/* bpchar */ String], Option[Int], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(ThaViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(TransactionhistoryarchiveId.decoder), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ThaViewRow] = Encoder.forProduct10[ThaViewRow, Option[Int], Option[TransactionhistoryarchiveId], Option[Int], Option[Int], Option[Int], Option[TypoLocalDateTime], Option[/* bpchar */ String], Option[Int], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(x => (x.id, x.transactionid, x.productid, x.referenceorderid, x.referenceorderlineid, x.transactiondate, x.transactiontype, x.quantity, x.actualcost, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(TransactionhistoryarchiveId.encoder), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[ThaViewRow] = new Read[ThaViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (TransactionhistoryarchiveId.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ThaViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      transactionid = TransactionhistoryarchiveId.get.unsafeGetNullable(rs, i + 1),
      productid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 2),
      referenceorderid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 3),
      referenceorderlineid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 4),
      transactiondate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 5),
      transactiontype = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      quantity = Meta.IntMeta.get.unsafeGetNullable(rs, i + 7),
      actualcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 9)
    )
  )
}
