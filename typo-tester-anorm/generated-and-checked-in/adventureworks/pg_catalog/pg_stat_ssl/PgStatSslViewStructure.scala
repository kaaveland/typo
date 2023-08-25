/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_ssl

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class PgStatSslViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatSslViewRow, val merge: (Row, PgStatSslViewRow) => Row)
  extends Relation[PgStatSslViewFields, PgStatSslViewRow, Row]
    with PgStatSslViewFields[Row] { outer =>

  override val pid = new Field[Int, Row](prefix, "pid", None, Some("int4"))(x => extract(x).pid, (row, value) => merge(row, extract(row).copy(pid = value)))
  override val ssl = new Field[Boolean, Row](prefix, "ssl", None, None)(x => extract(x).ssl, (row, value) => merge(row, extract(row).copy(ssl = value)))
  override val version = new Field[String, Row](prefix, "version", None, None)(x => extract(x).version, (row, value) => merge(row, extract(row).copy(version = value)))
  override val cipher = new Field[String, Row](prefix, "cipher", None, None)(x => extract(x).cipher, (row, value) => merge(row, extract(row).copy(cipher = value)))
  override val bits = new Field[Int, Row](prefix, "bits", None, Some("int4"))(x => extract(x).bits, (row, value) => merge(row, extract(row).copy(bits = value)))
  override val clientDn = new Field[String, Row](prefix, "client_dn", None, None)(x => extract(x).clientDn, (row, value) => merge(row, extract(row).copy(clientDn = value)))
  override val clientSerial = new Field[BigDecimal, Row](prefix, "client_serial", None, Some("numeric"))(x => extract(x).clientSerial, (row, value) => merge(row, extract(row).copy(clientSerial = value)))
  override val issuerDn = new Field[String, Row](prefix, "issuer_dn", None, None)(x => extract(x).issuerDn, (row, value) => merge(row, extract(row).copy(issuerDn = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](pid, ssl, version, cipher, bits, clientDn, clientSerial, issuerDn)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatSslViewRow, merge: (NewRow, PgStatSslViewRow) => NewRow): PgStatSslViewStructure[NewRow] =
    new PgStatSslViewStructure(prefix, extract, merge)
}
