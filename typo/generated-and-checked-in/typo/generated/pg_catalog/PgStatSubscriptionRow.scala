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

case class PgStatSubscriptionRow(
  /** Points to [[PgSubscriptionRow.oid]] */
  subid: Long,
  /** Points to [[PgSubscriptionRow.subname]] */
  subname: String,
  pid: /* unknown nullability */ Option[Int],
  relid: /* unknown nullability */ Option[Long],
  receivedLsn: /* unknown nullability */ Option[/* pg_lsn */ String],
  lastMsgSendTime: /* unknown nullability */ Option[LocalDateTime],
  lastMsgReceiptTime: /* unknown nullability */ Option[LocalDateTime],
  latestEndLsn: /* unknown nullability */ Option[/* pg_lsn */ String],
  latestEndTime: /* unknown nullability */ Option[LocalDateTime]
)

object PgStatSubscriptionRow {
  implicit val rowParser: RowParser[PgStatSubscriptionRow] = { row =>
    Success(
      PgStatSubscriptionRow(
        subid = row[Long]("subid"),
        subname = row[String]("subname"),
        pid = row[/* unknown nullability */ Option[Int]]("pid"),
        relid = row[/* unknown nullability */ Option[Long]]("relid"),
        receivedLsn = row[/* unknown nullability */ Option[/* pg_lsn */ String]]("received_lsn"),
        lastMsgSendTime = row[/* unknown nullability */ Option[LocalDateTime]]("last_msg_send_time"),
        lastMsgReceiptTime = row[/* unknown nullability */ Option[LocalDateTime]]("last_msg_receipt_time"),
        latestEndLsn = row[/* unknown nullability */ Option[/* pg_lsn */ String]]("latest_end_lsn"),
        latestEndTime = row[/* unknown nullability */ Option[LocalDateTime]]("latest_end_time")
      )
    )
  }

  
}