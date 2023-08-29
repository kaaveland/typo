/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_ssl

import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgStatSslViewRow(
  pid: /* nullability unknown */ Option[Int],
  ssl: /* nullability unknown */ Option[Boolean],
  version: /* nullability unknown */ Option[String],
  cipher: /* nullability unknown */ Option[String],
  bits: /* nullability unknown */ Option[Int],
  clientDn: /* nullability unknown */ Option[String],
  clientSerial: /* nullability unknown */ Option[BigDecimal],
  issuerDn: /* nullability unknown */ Option[String]
)

object PgStatSslViewRow {
  implicit lazy val reads: Reads[PgStatSslViewRow] = Reads[PgStatSslViewRow](json => JsResult.fromTry(
      Try(
        PgStatSslViewRow(
          pid = json.\("pid").toOption.map(_.as(Reads.IntReads)),
          ssl = json.\("ssl").toOption.map(_.as(Reads.BooleanReads)),
          version = json.\("version").toOption.map(_.as(Reads.StringReads)),
          cipher = json.\("cipher").toOption.map(_.as(Reads.StringReads)),
          bits = json.\("bits").toOption.map(_.as(Reads.IntReads)),
          clientDn = json.\("client_dn").toOption.map(_.as(Reads.StringReads)),
          clientSerial = json.\("client_serial").toOption.map(_.as(Reads.bigDecReads)),
          issuerDn = json.\("issuer_dn").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatSslViewRow] = RowParser[PgStatSslViewRow] { row =>
    Success(
      PgStatSslViewRow(
        pid = row(idx + 0)(Column.columnToOption(Column.columnToInt)),
        ssl = row(idx + 1)(Column.columnToOption(Column.columnToBoolean)),
        version = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        cipher = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        bits = row(idx + 4)(Column.columnToOption(Column.columnToInt)),
        clientDn = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        clientSerial = row(idx + 6)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        issuerDn = row(idx + 7)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatSslViewRow] = OWrites[PgStatSslViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "pid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.pid),
      "ssl" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.ssl),
      "version" -> Writes.OptionWrites(Writes.StringWrites).writes(o.version),
      "cipher" -> Writes.OptionWrites(Writes.StringWrites).writes(o.cipher),
      "bits" -> Writes.OptionWrites(Writes.IntWrites).writes(o.bits),
      "client_dn" -> Writes.OptionWrites(Writes.StringWrites).writes(o.clientDn),
      "client_serial" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.clientSerial),
      "issuer_dn" -> Writes.OptionWrites(Writes.StringWrites).writes(o.issuerDn)
    ))
  )
}
