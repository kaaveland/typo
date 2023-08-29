/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_activity

import adventureworks.customtypes.TypoInet
import adventureworks.customtypes.TypoOffsetDateTime
import adventureworks.customtypes.TypoXid
import typo.dsl.SqlExpr.OptField

trait PgStatActivityViewFields[Row] {
  val datid: OptField[/* oid */ Long, Row]
  val datname: OptField[String, Row]
  val pid: OptField[Int, Row]
  val leaderPid: OptField[Int, Row]
  val usesysid: OptField[/* oid */ Long, Row]
  val usename: OptField[String, Row]
  val applicationName: OptField[String, Row]
  val clientAddr: OptField[TypoInet, Row]
  val clientHostname: OptField[String, Row]
  val clientPort: OptField[Int, Row]
  val backendStart: OptField[TypoOffsetDateTime, Row]
  val xactStart: OptField[TypoOffsetDateTime, Row]
  val queryStart: OptField[TypoOffsetDateTime, Row]
  val stateChange: OptField[TypoOffsetDateTime, Row]
  val waitEventType: OptField[String, Row]
  val waitEvent: OptField[String, Row]
  val state: OptField[String, Row]
  val backendXid: OptField[TypoXid, Row]
  val backendXmin: OptField[TypoXid, Row]
  val queryId: OptField[Long, Row]
  val query: OptField[String, Row]
  val backendType: OptField[String, Row]
}
object PgStatActivityViewFields extends PgStatActivityViewStructure[PgStatActivityViewRow](None, identity, (_, x) => x)

