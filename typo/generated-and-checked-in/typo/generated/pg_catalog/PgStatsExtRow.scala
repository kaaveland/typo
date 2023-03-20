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

case class PgStatsExtRow(
  /** Points to [[PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[PgClassRow.relname]] */
  tablename: String,
  /** Points to [[PgNamespaceRow.nspname]] */
  statisticsSchemaname: String,
  /** Points to [[PgStatisticExtRow.stxname]] */
  statisticsName: String,
  statisticsOwner: /* unknown nullability */ Option[String],
  attnames: /* unknown nullability */ Option[Array[String]],
  exprs: /* unknown nullability */ Option[Array[String]],
  /** Points to [[PgStatisticExtRow.stxkind]] */
  kinds: Array[String],
  /** Points to [[PgStatisticExtDataRow.stxdndistinct]] */
  nDistinct: Option[/* pg_ndistinct */ String],
  /** Points to [[PgStatisticExtDataRow.stxddependencies]] */
  dependencies: Option[/* pg_dependencies */ String],
  mostCommonVals: /* unknown nullability */ Option[Array[String]],
  mostCommonValNulls: /* unknown nullability */ Option[Array[Boolean]],
  mostCommonFreqs: /* unknown nullability */ Option[Array[Double]],
  mostCommonBaseFreqs: /* unknown nullability */ Option[Array[Double]]
)

object PgStatsExtRow {
  implicit val rowParser: RowParser[PgStatsExtRow] = { row =>
    Success(
      PgStatsExtRow(
        schemaname = row[String]("schemaname"),
        tablename = row[String]("tablename"),
        statisticsSchemaname = row[String]("statistics_schemaname"),
        statisticsName = row[String]("statistics_name"),
        statisticsOwner = row[/* unknown nullability */ Option[String]]("statistics_owner"),
        attnames = row[/* unknown nullability */ Option[Array[String]]]("attnames"),
        exprs = row[/* unknown nullability */ Option[Array[String]]]("exprs"),
        kinds = row[Array[String]]("kinds"),
        nDistinct = row[Option[/* pg_ndistinct */ String]]("n_distinct"),
        dependencies = row[Option[/* pg_dependencies */ String]]("dependencies"),
        mostCommonVals = row[/* unknown nullability */ Option[Array[String]]]("most_common_vals"),
        mostCommonValNulls = row[/* unknown nullability */ Option[Array[Boolean]]]("most_common_val_nulls"),
        mostCommonFreqs = row[/* unknown nullability */ Option[Array[Double]]]("most_common_freqs"),
        mostCommonBaseFreqs = row[/* unknown nullability */ Option[Array[Double]]]("most_common_base_freqs")
      )
    )
  }

  
}