/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats

import adventureworks.customtypes.TypoAnyArray
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatsViewRow(
  schemaname: Option[String],
  tablename: String,
  attname: String,
  inherited: Boolean,
  nullFrac: Float,
  avgWidth: Int,
  nDistinct: Float,
  mostCommonVals: TypoAnyArray,
  mostCommonFreqs: Array[Float],
  histogramBounds: TypoAnyArray,
  correlation: Float,
  mostCommonElems: TypoAnyArray,
  mostCommonElemFreqs: Array[Float],
  elemCountHistogram: Array[Float]
)

object PgStatsViewRow {
  implicit lazy val decoder: Decoder[PgStatsViewRow] = Decoder.forProduct14[PgStatsViewRow, Option[String], String, String, Boolean, Float, Int, Float, TypoAnyArray, Array[Float], TypoAnyArray, Float, TypoAnyArray, Array[Float], Array[Float]]("schemaname", "tablename", "attname", "inherited", "null_frac", "avg_width", "n_distinct", "most_common_vals", "most_common_freqs", "histogram_bounds", "correlation", "most_common_elems", "most_common_elem_freqs", "elem_count_histogram")(PgStatsViewRow.apply)(Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, Decoder.decodeString, Decoder.decodeBoolean, Decoder.decodeFloat, Decoder.decodeInt, Decoder.decodeFloat, TypoAnyArray.decoder, Decoder.decodeArray[Float](Decoder.decodeFloat, implicitly), TypoAnyArray.decoder, Decoder.decodeFloat, TypoAnyArray.decoder, Decoder.decodeArray[Float](Decoder.decodeFloat, implicitly), Decoder.decodeArray[Float](Decoder.decodeFloat, implicitly))
  implicit lazy val encoder: Encoder[PgStatsViewRow] = Encoder.forProduct14[PgStatsViewRow, Option[String], String, String, Boolean, Float, Int, Float, TypoAnyArray, Array[Float], TypoAnyArray, Float, TypoAnyArray, Array[Float], Array[Float]]("schemaname", "tablename", "attname", "inherited", "null_frac", "avg_width", "n_distinct", "most_common_vals", "most_common_freqs", "histogram_bounds", "correlation", "most_common_elems", "most_common_elem_freqs", "elem_count_histogram")(x => (x.schemaname, x.tablename, x.attname, x.inherited, x.nullFrac, x.avgWidth, x.nDistinct, x.mostCommonVals, x.mostCommonFreqs, x.histogramBounds, x.correlation, x.mostCommonElems, x.mostCommonElemFreqs, x.elemCountHistogram))(Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, Encoder.encodeString, Encoder.encodeBoolean, Encoder.encodeFloat, Encoder.encodeInt, Encoder.encodeFloat, TypoAnyArray.encoder, Encoder.encodeIterable[Float, Array](Encoder.encodeFloat, implicitly), TypoAnyArray.encoder, Encoder.encodeFloat, TypoAnyArray.encoder, Encoder.encodeIterable[Float, Array](Encoder.encodeFloat, implicitly), Encoder.encodeIterable[Float, Array](Encoder.encodeFloat, implicitly))
  implicit lazy val read: Read[PgStatsViewRow] = new Read[PgStatsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.FloatMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.FloatMeta.get, Nullability.NoNulls),
      (TypoAnyArray.get, Nullability.NoNulls),
      (adventureworks.FloatArrayMeta.get, Nullability.NoNulls),
      (TypoAnyArray.get, Nullability.NoNulls),
      (Meta.FloatMeta.get, Nullability.NoNulls),
      (TypoAnyArray.get, Nullability.NoNulls),
      (adventureworks.FloatArrayMeta.get, Nullability.NoNulls),
      (adventureworks.FloatArrayMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatsViewRow(
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 0),
      tablename = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      attname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      inherited = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 3),
      nullFrac = Meta.FloatMeta.get.unsafeGetNonNullable(rs, i + 4),
      avgWidth = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 5),
      nDistinct = Meta.FloatMeta.get.unsafeGetNonNullable(rs, i + 6),
      mostCommonVals = TypoAnyArray.get.unsafeGetNonNullable(rs, i + 7),
      mostCommonFreqs = adventureworks.FloatArrayMeta.get.unsafeGetNonNullable(rs, i + 8),
      histogramBounds = TypoAnyArray.get.unsafeGetNonNullable(rs, i + 9),
      correlation = Meta.FloatMeta.get.unsafeGetNonNullable(rs, i + 10),
      mostCommonElems = TypoAnyArray.get.unsafeGetNonNullable(rs, i + 11),
      mostCommonElemFreqs = adventureworks.FloatArrayMeta.get.unsafeGetNonNullable(rs, i + 12),
      elemCountHistogram = adventureworks.FloatArrayMeta.get.unsafeGetNonNullable(rs, i + 13)
    )
  )
}
