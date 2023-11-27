/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class SpecialofferRow(
  /** Primary key for SpecialOffer records. */
  specialofferid: SpecialofferId,
  /** Discount description. */
  description: /* max 255 chars */ String,
  /** Discount precentage.
      Constraint CK_SpecialOffer_DiscountPct affecting columns discountpct: ((discountpct >= 0.00)) */
  discountpct: BigDecimal,
  /** Discount type category. */
  `type`: /* max 50 chars */ String,
  /** Group the discount applies to such as Reseller or Customer. */
  category: /* max 50 chars */ String,
  /** Discount start date.
      Constraint CK_SpecialOffer_EndDate affecting columns enddate, startdate: ((enddate >= startdate)) */
  startdate: TypoLocalDateTime,
  /** Discount end date.
      Constraint CK_SpecialOffer_EndDate affecting columns enddate, startdate: ((enddate >= startdate)) */
  enddate: TypoLocalDateTime,
  /** Minimum discount percent allowed.
      Constraint CK_SpecialOffer_MinQty affecting columns minqty: ((minqty >= 0)) */
  minqty: Int,
  /** Maximum discount percent allowed.
      Constraint CK_SpecialOffer_MaxQty affecting columns maxqty: ((maxqty >= 0)) */
  maxqty: Option[Int],
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
)

object SpecialofferRow {
  implicit lazy val decoder: Decoder[SpecialofferRow] = Decoder.forProduct11[SpecialofferRow, SpecialofferId, /* max 255 chars */ String, BigDecimal, /* max 50 chars */ String, /* max 50 chars */ String, TypoLocalDateTime, TypoLocalDateTime, Int, Option[Int], TypoUUID, TypoLocalDateTime]("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")(SpecialofferRow.apply)(SpecialofferId.decoder, Decoder.decodeString, Decoder.decodeBigDecimal, Decoder.decodeString, Decoder.decodeString, TypoLocalDateTime.decoder, TypoLocalDateTime.decoder, Decoder.decodeInt, Decoder.decodeOption(Decoder.decodeInt), TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SpecialofferRow] = Encoder.forProduct11[SpecialofferRow, SpecialofferId, /* max 255 chars */ String, BigDecimal, /* max 50 chars */ String, /* max 50 chars */ String, TypoLocalDateTime, TypoLocalDateTime, Int, Option[Int], TypoUUID, TypoLocalDateTime]("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")(x => (x.specialofferid, x.description, x.discountpct, x.`type`, x.category, x.startdate, x.enddate, x.minqty, x.maxqty, x.rowguid, x.modifieddate))(SpecialofferId.encoder, Encoder.encodeString, Encoder.encodeBigDecimal, Encoder.encodeString, Encoder.encodeString, TypoLocalDateTime.encoder, TypoLocalDateTime.encoder, Encoder.encodeInt, Encoder.encodeOption(Encoder.encodeInt), TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SpecialofferRow] = new Read[SpecialofferRow](
    gets = List(
      (SpecialofferId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SpecialofferRow(
      specialofferid = SpecialofferId.get.unsafeGetNonNullable(rs, i + 0),
      description = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      discountpct = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 2),
      `type` = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      category = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 4),
      startdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5),
      enddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6),
      minqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 7),
      maxqty = Meta.IntMeta.get.unsafeGetNullable(rs, i + 8),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 9),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 10)
    )
  )
  implicit lazy val text: Text[SpecialofferRow] = Text.instance[SpecialofferRow]{ (row, sb) =>
    SpecialofferId.text.unsafeEncode(row.specialofferid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.description, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.discountpct, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.`type`, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.category, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.minqty, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.intInstance).unsafeEncode(row.maxqty, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
