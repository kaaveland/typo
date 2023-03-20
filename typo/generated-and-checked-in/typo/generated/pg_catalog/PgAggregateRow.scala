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

case class PgAggregateRow(
  aggfnoid: PgAggregateId,
  aggkind: String,
  aggnumdirectargs: Short,
  aggtransfn: String,
  aggfinalfn: String,
  aggcombinefn: String,
  aggserialfn: String,
  aggdeserialfn: String,
  aggmtransfn: String,
  aggminvtransfn: String,
  aggmfinalfn: String,
  aggfinalextra: Boolean,
  aggmfinalextra: Boolean,
  aggfinalmodify: String,
  aggmfinalmodify: String,
  aggsortop: Long,
  aggtranstype: Long,
  aggtransspace: Int,
  aggmtranstype: Long,
  aggmtransspace: Int,
  agginitval: Option[String],
  aggminitval: Option[String]
)

object PgAggregateRow {
  implicit val rowParser: RowParser[PgAggregateRow] = { row =>
    Success(
      PgAggregateRow(
        aggfnoid = row[PgAggregateId]("aggfnoid"),
        aggkind = row[String]("aggkind"),
        aggnumdirectargs = row[Short]("aggnumdirectargs"),
        aggtransfn = row[String]("aggtransfn"),
        aggfinalfn = row[String]("aggfinalfn"),
        aggcombinefn = row[String]("aggcombinefn"),
        aggserialfn = row[String]("aggserialfn"),
        aggdeserialfn = row[String]("aggdeserialfn"),
        aggmtransfn = row[String]("aggmtransfn"),
        aggminvtransfn = row[String]("aggminvtransfn"),
        aggmfinalfn = row[String]("aggmfinalfn"),
        aggfinalextra = row[Boolean]("aggfinalextra"),
        aggmfinalextra = row[Boolean]("aggmfinalextra"),
        aggfinalmodify = row[String]("aggfinalmodify"),
        aggmfinalmodify = row[String]("aggmfinalmodify"),
        aggsortop = row[Long]("aggsortop"),
        aggtranstype = row[Long]("aggtranstype"),
        aggtransspace = row[Int]("aggtransspace"),
        aggmtranstype = row[Long]("aggmtranstype"),
        aggmtransspace = row[Int]("aggmtransspace"),
        agginitval = row[Option[String]]("agginitval"),
        aggminitval = row[Option[String]]("aggminitval")
      )
    )
  }

  
}